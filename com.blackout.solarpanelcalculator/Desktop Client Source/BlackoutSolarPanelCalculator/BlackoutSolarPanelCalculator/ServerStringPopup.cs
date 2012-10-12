using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace BlackoutSolarPanelCalculator {
    public partial class ServerStringPopup : Form {

        public string Url {
            get { return txtServerString.Text; }
            set { txtServerString.Text = value; }
        }

        public ServerStringPopup(string url) {
            InitializeComponent();
            Url = url;
        }
    }
}
