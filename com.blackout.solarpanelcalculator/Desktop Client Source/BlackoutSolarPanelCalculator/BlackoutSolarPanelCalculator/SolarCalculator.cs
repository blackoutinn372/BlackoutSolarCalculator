using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Threading;

namespace BlackoutSolarPanelCalculator
{
    public partial class SolarCalculator : Form
    {
        private string appEngineUrl = "http://127.0.0.1:8888/";
        //private string appEngineUrl = "http://blackoutsolarcalculator.appspot.com/";

        public SolarCalculator()
        {
            InitializeComponent();

            Thread splashThread = new Thread(new ThreadStart(SplashForm));
            splashThread.Start();
            Thread.Sleep(2000);
            splashThread.Abort();

            cboRoofDirection.Items.AddRange(new String[] {"South West", "South East", "West", "North", "North West", "North East", "East"});
            cboRoofDirection.SelectedIndex = 0;

            cboRoofAngle.Items.AddRange(new String[] {"Optimal", "Very Flat", "Very Steep" });
            cboRoofAngle.SelectedIndex = 0;
        }

        private void SplashForm()
        {
            Application.Run(new SplashScreen());
        }

        private void btnCalculate_Click(object sender, EventArgs e) {
            try {
                label2.Text = ServerComm.GetSolarGeneFormulaForAllMonths(appEngineUrl, new double[] { 6.19, 5.39, 4.95, 3.98, 3.23, 3.02, 3.22, 4.04, 5.12, 5.52, 6.07, 6.35 }, 4950, 88.5, 96, 98, 0, 0.7).ToString();
            } catch (Exception exc) {
                label2.Text = "Could not communicate with server: " + appEngineUrl.ToString() + ". Error Code: " + exc.Message;
            }
        }

        private void serverStringToolStripMenuItem_Click(object sender, EventArgs e) {
            ServerStringPopup popup = new ServerStringPopup(appEngineUrl);
            DialogResult dialog = popup.ShowDialog(this);
            if (dialog == DialogResult.OK) {
                appEngineUrl = popup.Url;
            }
        }

        private void cboRoofDirection_SelectedIndexChanged(object sender, EventArgs e) {
            try {
                txtRoofEff.Text = ServerComm.GetEfficiencyForAngleAndDirection(appEngineUrl, cboRoofDirection.SelectedIndex, cboRoofAngle.SelectedIndex).ToString();
            } catch (Exception exc) {
                label2.Text = "Could not communicate with server: " + appEngineUrl.ToString() + ". Error Code: " + exc.Message;
            }
        }

        private void cboRoofAngle_SelectedIndexChanged(object sender, EventArgs e) {
            try {
                txtRoofEff.Text = ServerComm.GetEfficiencyForAngleAndDirection(appEngineUrl, cboRoofDirection.SelectedIndex, cboRoofAngle.SelectedIndex).ToString();
            } catch (Exception exc) {
                label2.Text = "Could not communicate with server: " + appEngineUrl.ToString() + ". Error Code: " + exc.Message;
            }
        }
    }
}
