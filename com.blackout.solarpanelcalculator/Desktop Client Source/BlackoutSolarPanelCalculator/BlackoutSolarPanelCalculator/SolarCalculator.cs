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
        public SolarCalculator()
        {
            InitializeComponent();

            Thread splashThread = new Thread(new ThreadStart(SplashForm));
            splashThread.Start();
            Thread.Sleep(2000);
            splashThread.Abort();
        }

        private void SplashForm()
        {
            Application.Run(new SplashScreen());
        }
    }
}
