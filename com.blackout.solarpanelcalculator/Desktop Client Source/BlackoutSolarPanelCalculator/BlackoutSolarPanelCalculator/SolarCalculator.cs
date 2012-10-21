using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Windows.Forms.DataVisualization.Charting;
using System.Threading;

namespace BlackoutSolarPanelCalculator {
    public partial class SolarCalculator : Form {
        //private string appEngineUrl = "http://127.0.0.1:8888/";
        private string appEngineUrl = "http://blackoutsolarcalculator.appspot.com/";

        private const string defaultSystemSize = "4950";
        private const string defaultInverterEff = "96";
        private const string defaultWiringEff = "98";
        private const string defaultAgeEff = "0.7";
        private const string defaultHouseholdSize = "2";

        public SolarCalculator() {
            InitializeComponent();

            Thread splashThread = new Thread(new ThreadStart(SplashForm));
            splashThread.Start();
            Thread.Sleep(2000);
            splashThread.Abort();

            LoadComboBoxes();
            ResetValues();
        }

        private void SplashForm() {
            Application.Run(new SplashScreen());
        }

        private void ResetValues() {
            txtSystemSize.Text = defaultSystemSize;
            txtInverterEff.Text = defaultInverterEff;
            txtWiringEff.Text = defaultWiringEff;
            txtAgeEff.Text = defaultAgeEff;
            txtHouseholdSize.Text = defaultHouseholdSize;

            cboCity.SelectedIndex = cboCity.Items.IndexOf("Brisbane");
            cboRoofDirection.SelectedIndex = 0;
            cboRoofAngle.SelectedIndex = 0;
            cboUsageType.SelectedIndex = 0;
        }

        private void LoadComboBoxes() {
            try {
                cboCity.Items.AddRange(ServerComm.GetCityList(appEngineUrl, 4000));
            } catch (Exception exc) {
                lblPGError.Text = "Could not communicate with server: " + appEngineUrl.ToString() + ". Error Code: " + exc.Message;
            }
            cboRoofDirection.Items.AddRange(new String[] { "South West", "South East", "West", "North", "North West", "North East", "East" });
            cboRoofAngle.Items.AddRange(new String[] { "Optimal", "Very Flat", "Very Steep" });
            cboUsageType.Items.AddRange(new String[] { "Heavy", "Medium", "Light" });
        }

        private void DoPGValidate() {
            bool validFlag = true;

            if (cboCity.SelectedItem == null) {
                validFlag = false;
            }
            if (cboRoofDirection.SelectedItem == null) {
                validFlag = false;
            }
            if (cboRoofAngle.SelectedItem == null) {
                validFlag = false;
            }
            double trash;
            if (!double.TryParse(txtSystemSize.Text, out trash)) {
                validFlag = false;
            }
            if (!double.TryParse(txtRoofEff.Text, out trash)) {
                validFlag = false;
            }
            if (!double.TryParse(txtInverterEff.Text, out trash)) {
                validFlag = false;
            }
            if (!double.TryParse(txtWiringEff.Text, out trash)) {
                validFlag = false;
            }
            if (!double.TryParse(txtAgeEff.Text, out trash)) {
                validFlag = false;
            }

            if (validFlag) {
                btnPGCalculate.Enabled = true;
            } else {
                btnPGCalculate.Enabled = false;
            }
        }

        private void DoPCValidate() {
            bool validFlag = true;

            int trash;
            if (!int.TryParse(txtHouseholdSize.Text, out trash)) {
                validFlag = false;
            }

            if (validFlag) {
                btnPCCalculate.Enabled = true;
            } else {
                btnPCCalculate.Enabled = false;
            }
        }

        private void GeneratePGChart(double[] monthVals) {
            chtMonthlyPowerGenerated.Visible = true;
            chtMonthlyPowerGenerated.Series.Clear();
            Series series = chtMonthlyPowerGenerated.Series.Add("Power Generated");
            for (int i = 0; i < 12; i++) {
                series.Points.AddY(monthVals[i]);
            }
        }

        private void GeneratePGResults(double[] monthVals) {
            double totalYearPower = 0;
            double highPower = 0;
            double lowPower = 9999;
            int highPowerIndex = 0;
            int lowPowerIndex = 0;

            for (int i = 0; i < monthVals.Length; i++) {
                totalYearPower += monthVals[i];
                if (monthVals[i] > highPower) {
                    highPower = monthVals[i];
                    highPowerIndex = i;
                }
                if (monthVals[i] < lowPower) {
                    lowPower = monthVals[i];
                    lowPowerIndex = i;
                }
            }

            lblPGResults.Text = "Avg. Daily Power Generated: " + (totalYearPower / 365.25).ToString("0.00") + "kW\n\n";
            lblPGResults.Text += "Avg. Monthly Power Generated: " + (totalYearPower / 12).ToString("0.00") + "kW\n\n";
            lblPGResults.Text += "Highest Month: " + CultureInfo.CurrentCulture.DateTimeFormat.GetMonthName(highPowerIndex + 1) + ", " + highPower.ToString("0.00") + "kW\n\n";
            lblPGResults.Text += "Lowest Month: " + CultureInfo.CurrentCulture.DateTimeFormat.GetMonthName(lowPowerIndex + 1) + ", " + lowPower.ToString("0.00") + "kW\n\n";
        }

        private void btnPGCalculate_Click(object sender, EventArgs e) {
            try {
                double[] cityVals = ServerComm.GetCity(appEngineUrl, cboCity.SelectedIndex);
                double[] monthIrradianceVals = new double[12];
                for (int i = 0; i < monthIrradianceVals.Length; i++) {
                    monthIrradianceVals[i] = cityVals[i + 6];
                }
                double[] monthlyPowerVals = ServerComm.GetSolarGeneFormulaForAllMonths(appEngineUrl, monthIrradianceVals, double.Parse(txtSystemSize.Text), double.Parse(txtRoofEff.Text), double.Parse(txtInverterEff.Text), double.Parse(txtWiringEff.Text), 0, double.Parse(txtAgeEff.Text));
                GeneratePGChart(monthlyPowerVals);
                GeneratePGResults(monthlyPowerVals);
            } catch (Exception exc) {
                lblPGError.Text = "Could not communicate with server: " + appEngineUrl.ToString() + ". Error Code: " + exc.Message;
            }
        }

        private void serverStringToolStripMenuItem_Click(object sender, EventArgs e) {
            ServerStringPopup popup = new ServerStringPopup(appEngineUrl);
            DialogResult dialog = popup.ShowDialog(this);
            if (dialog == DialogResult.OK) {
                appEngineUrl = popup.Url;
            }
        }

        private void cboCity_SelectedIndexChanged(object sender, EventArgs e) {
            DoPGValidate();
        }

        private void cboRoofDirection_SelectedIndexChanged(object sender, EventArgs e) {
            try {
                txtRoofEff.Text = ServerComm.GetEfficiencyForAngleAndDirection(appEngineUrl, cboRoofDirection.SelectedIndex, cboRoofAngle.SelectedIndex).ToString();
            } catch (Exception exc) {
                lblPGError.Text = "Could not communicate with server: " + appEngineUrl.ToString() + ". Error Code: " + exc.Message;
            }
            DoPGValidate();
        }

        private void cboRoofAngle_SelectedIndexChanged(object sender, EventArgs e) {
            try {
                txtRoofEff.Text = ServerComm.GetEfficiencyForAngleAndDirection(appEngineUrl, cboRoofDirection.SelectedIndex, cboRoofAngle.SelectedIndex).ToString();
            } catch (Exception exc) {
                lblPGError.Text = "Could not communicate with server: " + appEngineUrl.ToString() + ". Error Code: " + exc.Message;
            }
            DoPGValidate();
        }

        private void txtSystemSize_TextChanged(object sender, EventArgs e) {
            DoPGValidate();
        }

        private void txtRoofEff_TextChanged(object sender, EventArgs e) {
            DoPGValidate();
        }

        private void txtInverterEff_TextChanged(object sender, EventArgs e) {
            DoPGValidate();
        }

        private void txtWiringEff_TextChanged(object sender, EventArgs e) {
            DoPGValidate();
        }

        private void txtPanelAge_TextChanged(object sender, EventArgs e) {
            DoPGValidate();
        }

        private void txtAgeEff_TextChanged(object sender, EventArgs e) {
            DoPGValidate();
        }

        private void btnPGReset_Click(object sender, EventArgs e) {
            ResetValues();
            chtMonthlyPowerGenerated.Visible = false;
            lblPGResults.Visible = false;
        }

        private void txtHouseholdSize_TextChanged(object sender, EventArgs e) {
            DoPCValidate();
        }

        private void btnPCCalculate_Click(object sender, EventArgs e) {
            try {
                double powerConsumption = ServerComm.GetPowerConsumption(appEngineUrl, cboUsageType.SelectedValue.ToString(), int.Parse(txtHouseholdSize.Text));
                GeneratePCResults(powerConsumption);
            } catch (Exception exc) {
                lblPCError.Text = "Could not communicate with server: " + appEngineUrl.ToString() + ". Error Code: " + exc.Message;
            }
        }

        private void GeneratePCResults(double powerConsumption) {
            lblPCResults.Text = "Estimated Avgerage Daily Power Consumed: " + powerConsumption.ToString("0.00") + "kW\n\n";
        }
        
    }
}
