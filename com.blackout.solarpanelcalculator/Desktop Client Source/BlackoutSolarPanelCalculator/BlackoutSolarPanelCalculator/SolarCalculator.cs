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

        public SolarCalculator() {
            InitializeComponent();

            Thread splashThread = new Thread(new ThreadStart(SplashForm));
            splashThread.Start();
            Thread.Sleep(2000);
            splashThread.Abort();

            LoadComboBoxes();          
        }

        private void SplashForm() {
            Application.Run(new SplashScreen());
        }

        private void LoadComboBoxes() {
            try {
                cboCity.Items.AddRange(ServerComm.GetCityList(appEngineUrl, 4000));
            } catch (Exception exc) {
                lblError.Text = "Could not communicate with server: " + appEngineUrl.ToString() + ". Error Code: " + exc.Message;
            }
            cboCity.SelectedIndex = cboCity.Items.IndexOf("Brisbane");

            cboRoofDirection.Items.AddRange(new String[] { "South West", "South East", "West", "North", "North West", "North East", "East" });
            cboRoofDirection.SelectedIndex = 0;

            cboRoofAngle.Items.AddRange(new String[] { "Optimal", "Very Flat", "Very Steep" });
            cboRoofAngle.SelectedIndex = 0;
        }

        private void DoValidate() {
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
                btnCalculate.Enabled = true;
            } else {
                btnCalculate.Enabled = false;
            }
        }

        private void GenerateChart(double[] monthVals) {
            chtMonthlyPowerGenerated.Visible = true;
            Series series = chtMonthlyPowerGenerated.Series.Add("Power Generated");
            for (int i = 0; i < 12; i++) {
                series.Points.AddY(monthVals[i]);
            }
        }

        private void GenerateResults(double[] monthVals) {
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

            lblResults.Text = "Avg. Daily Power Generated: " + (totalYearPower / 365.25).ToString("0.00") + "kW\n\n";
            lblResults.Text += "Avg. Monthly Power Generated: " + (totalYearPower / 12).ToString("0.00") + "kW\n\n";
            lblResults.Text += "Highest Month: " + CultureInfo.CurrentCulture.DateTimeFormat.GetMonthName(highPowerIndex + 1) + ", " + highPower.ToString("0.00") + "kW\n\n";
            lblResults.Text += "Lowest Month: " + CultureInfo.CurrentCulture.DateTimeFormat.GetMonthName(lowPowerIndex + 1) + ", " + lowPower.ToString("0.00") + "kW\n\n";
        }

        private void btnCalculate_Click(object sender, EventArgs e) {
            try {
                double[] cityVals = ServerComm.GetCity(appEngineUrl, cboCity.SelectedIndex);
                double[] monthIrradianceVals = new double[12];
                for (int i = 0; i < monthIrradianceVals.Length; i++) {
                    monthIrradianceVals[i] = cityVals[i + 6];
                }
                double[] monthlyPowerVals = ServerComm.GetSolarGeneFormulaForAllMonths(appEngineUrl, monthIrradianceVals, double.Parse(txtSystemSize.Text), double.Parse(txtRoofEff.Text), double.Parse(txtInverterEff.Text), double.Parse(txtWiringEff.Text), 0, double.Parse(txtAgeEff.Text));
                GenerateChart(monthlyPowerVals);
                GenerateResults(monthlyPowerVals);
            } catch (Exception exc) {
                lblError.Text = "Could not communicate with server: " + appEngineUrl.ToString() + ". Error Code: " + exc.Message;
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
            DoValidate();
        }

        private void cboRoofDirection_SelectedIndexChanged(object sender, EventArgs e) {
            try {
                txtRoofEff.Text = ServerComm.GetEfficiencyForAngleAndDirection(appEngineUrl, cboRoofDirection.SelectedIndex, cboRoofAngle.SelectedIndex).ToString();
            } catch (Exception exc) {
                lblError.Text = "Could not communicate with server: " + appEngineUrl.ToString() + ". Error Code: " + exc.Message;
            }
            DoValidate();
        }

        private void cboRoofAngle_SelectedIndexChanged(object sender, EventArgs e) {
            try {
                txtRoofEff.Text = ServerComm.GetEfficiencyForAngleAndDirection(appEngineUrl, cboRoofDirection.SelectedIndex, cboRoofAngle.SelectedIndex).ToString();
            } catch (Exception exc) {
                lblError.Text = "Could not communicate with server: " + appEngineUrl.ToString() + ". Error Code: " + exc.Message;
            }
            DoValidate();
        }

        private void txtSystemSize_TextChanged(object sender, EventArgs e) {
            DoValidate();
        }

        private void txtRoofEff_TextChanged(object sender, EventArgs e) {
            DoValidate();
        }

        private void txtInverterEff_TextChanged(object sender, EventArgs e) {
            DoValidate();
        }

        private void txtWiringEff_TextChanged(object sender, EventArgs e) {
            DoValidate();
        }

        private void txtPanelAge_TextChanged(object sender, EventArgs e) {
            DoValidate();
        }

        private void txtAgeEff_TextChanged(object sender, EventArgs e) {
            DoValidate();
        }

        private void btnReset_Click(object sender, EventArgs e) {

        }

        
    }
}
