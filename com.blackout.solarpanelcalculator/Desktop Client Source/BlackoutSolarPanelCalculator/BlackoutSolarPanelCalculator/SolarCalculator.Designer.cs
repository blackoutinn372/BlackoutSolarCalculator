namespace BlackoutSolarPanelCalculator
{
    partial class SolarCalculator
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.tabControl = new System.Windows.Forms.TabControl();
            this.tabGeneration = new System.Windows.Forms.TabPage();
            this.grpPowerGenerationInstruct = new System.Windows.Forms.GroupBox();
            this.grpPowerGenerationResult = new System.Windows.Forms.GroupBox();
            this.label2 = new System.Windows.Forms.Label();
            this.grpPowerGenerationInput = new System.Windows.Forms.GroupBox();
            this.txtAgeEff = new System.Windows.Forms.TextBox();
            this.txtPanelAge = new System.Windows.Forms.TextBox();
            this.txtWiringEff = new System.Windows.Forms.TextBox();
            this.txtInverterEff = new System.Windows.Forms.TextBox();
            this.txtRoofEff = new System.Windows.Forms.TextBox();
            this.lblAgeEff = new System.Windows.Forms.Label();
            this.lblPanelAge = new System.Windows.Forms.Label();
            this.lblWiringEff = new System.Windows.Forms.Label();
            this.lblInverterEff = new System.Windows.Forms.Label();
            this.lblRoofEff = new System.Windows.Forms.Label();
            this.txtSystemSize = new System.Windows.Forms.TextBox();
            this.cboRoofAngle = new System.Windows.Forms.ComboBox();
            this.cboRoofDirection = new System.Windows.Forms.ComboBox();
            this.lblSystemSize = new System.Windows.Forms.Label();
            this.lblRoofAngle = new System.Windows.Forms.Label();
            this.lblRoofDirection = new System.Windows.Forms.Label();
            this.lblCity = new System.Windows.Forms.Label();
            this.cboCity = new System.Windows.Forms.ComboBox();
            this.btnReset = new System.Windows.Forms.Button();
            this.btnCalculate = new System.Windows.Forms.Button();
            this.tabConsumption = new System.Windows.Forms.TabPage();
            this.tabSavings = new System.Windows.Forms.TabPage();
            this.lblBanner = new System.Windows.Forms.Label();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.fileToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.serverStringToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.tabControl.SuspendLayout();
            this.tabGeneration.SuspendLayout();
            this.grpPowerGenerationResult.SuspendLayout();
            this.grpPowerGenerationInput.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // tabControl
            // 
            this.tabControl.Controls.Add(this.tabGeneration);
            this.tabControl.Controls.Add(this.tabConsumption);
            this.tabControl.Controls.Add(this.tabSavings);
            this.tabControl.Location = new System.Drawing.Point(12, 81);
            this.tabControl.Name = "tabControl";
            this.tabControl.SelectedIndex = 0;
            this.tabControl.Size = new System.Drawing.Size(960, 488);
            this.tabControl.TabIndex = 0;
            // 
            // tabGeneration
            // 
            this.tabGeneration.Controls.Add(this.grpPowerGenerationInstruct);
            this.tabGeneration.Controls.Add(this.grpPowerGenerationResult);
            this.tabGeneration.Controls.Add(this.grpPowerGenerationInput);
            this.tabGeneration.Location = new System.Drawing.Point(4, 22);
            this.tabGeneration.Name = "tabGeneration";
            this.tabGeneration.Padding = new System.Windows.Forms.Padding(3);
            this.tabGeneration.Size = new System.Drawing.Size(952, 462);
            this.tabGeneration.TabIndex = 0;
            this.tabGeneration.Text = "Power Generation";
            this.tabGeneration.UseVisualStyleBackColor = true;
            // 
            // grpPowerGenerationInstruct
            // 
            this.grpPowerGenerationInstruct.Location = new System.Drawing.Point(612, 6);
            this.grpPowerGenerationInstruct.Name = "grpPowerGenerationInstruct";
            this.grpPowerGenerationInstruct.Size = new System.Drawing.Size(334, 450);
            this.grpPowerGenerationInstruct.TabIndex = 2;
            this.grpPowerGenerationInstruct.TabStop = false;
            this.grpPowerGenerationInstruct.Text = "Instructions";
            // 
            // grpPowerGenerationResult
            // 
            this.grpPowerGenerationResult.Controls.Add(this.label2);
            this.grpPowerGenerationResult.Location = new System.Drawing.Point(6, 234);
            this.grpPowerGenerationResult.Name = "grpPowerGenerationResult";
            this.grpPowerGenerationResult.Size = new System.Drawing.Size(600, 222);
            this.grpPowerGenerationResult.TabIndex = 1;
            this.grpPowerGenerationResult.TabStop = false;
            this.grpPowerGenerationResult.Text = "Results";
            // 
            // label2
            // 
            this.label2.Location = new System.Drawing.Point(87, 94);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(145, 21);
            this.label2.TabIndex = 17;
            this.label2.Text = "Answers and stuff go here";
            // 
            // grpPowerGenerationInput
            // 
            this.grpPowerGenerationInput.Controls.Add(this.txtAgeEff);
            this.grpPowerGenerationInput.Controls.Add(this.txtPanelAge);
            this.grpPowerGenerationInput.Controls.Add(this.txtWiringEff);
            this.grpPowerGenerationInput.Controls.Add(this.txtInverterEff);
            this.grpPowerGenerationInput.Controls.Add(this.txtRoofEff);
            this.grpPowerGenerationInput.Controls.Add(this.lblAgeEff);
            this.grpPowerGenerationInput.Controls.Add(this.lblPanelAge);
            this.grpPowerGenerationInput.Controls.Add(this.lblWiringEff);
            this.grpPowerGenerationInput.Controls.Add(this.lblInverterEff);
            this.grpPowerGenerationInput.Controls.Add(this.lblRoofEff);
            this.grpPowerGenerationInput.Controls.Add(this.txtSystemSize);
            this.grpPowerGenerationInput.Controls.Add(this.cboRoofAngle);
            this.grpPowerGenerationInput.Controls.Add(this.cboRoofDirection);
            this.grpPowerGenerationInput.Controls.Add(this.lblSystemSize);
            this.grpPowerGenerationInput.Controls.Add(this.lblRoofAngle);
            this.grpPowerGenerationInput.Controls.Add(this.lblRoofDirection);
            this.grpPowerGenerationInput.Controls.Add(this.lblCity);
            this.grpPowerGenerationInput.Controls.Add(this.cboCity);
            this.grpPowerGenerationInput.Controls.Add(this.btnReset);
            this.grpPowerGenerationInput.Controls.Add(this.btnCalculate);
            this.grpPowerGenerationInput.Location = new System.Drawing.Point(6, 6);
            this.grpPowerGenerationInput.Name = "grpPowerGenerationInput";
            this.grpPowerGenerationInput.Size = new System.Drawing.Size(600, 222);
            this.grpPowerGenerationInput.TabIndex = 0;
            this.grpPowerGenerationInput.TabStop = false;
            this.grpPowerGenerationInput.Text = "Input";
            // 
            // txtAgeEff
            // 
            this.txtAgeEff.Location = new System.Drawing.Point(377, 133);
            this.txtAgeEff.Name = "txtAgeEff";
            this.txtAgeEff.Size = new System.Drawing.Size(100, 20);
            this.txtAgeEff.TabIndex = 38;
            this.txtAgeEff.Text = "0.7";
            // 
            // txtPanelAge
            // 
            this.txtPanelAge.Location = new System.Drawing.Point(377, 103);
            this.txtPanelAge.Name = "txtPanelAge";
            this.txtPanelAge.Size = new System.Drawing.Size(100, 20);
            this.txtPanelAge.TabIndex = 37;
            this.txtPanelAge.Text = "25";
            // 
            // txtWiringEff
            // 
            this.txtWiringEff.Location = new System.Drawing.Point(377, 73);
            this.txtWiringEff.Name = "txtWiringEff";
            this.txtWiringEff.Size = new System.Drawing.Size(100, 20);
            this.txtWiringEff.TabIndex = 36;
            this.txtWiringEff.Text = "98";
            // 
            // txtInverterEff
            // 
            this.txtInverterEff.Location = new System.Drawing.Point(377, 43);
            this.txtInverterEff.Name = "txtInverterEff";
            this.txtInverterEff.Size = new System.Drawing.Size(100, 20);
            this.txtInverterEff.TabIndex = 35;
            this.txtInverterEff.Text = "96";
            // 
            // txtRoofEff
            // 
            this.txtRoofEff.Location = new System.Drawing.Point(377, 13);
            this.txtRoofEff.Name = "txtRoofEff";
            this.txtRoofEff.Size = new System.Drawing.Size(100, 20);
            this.txtRoofEff.TabIndex = 34;
            this.txtRoofEff.Text = "88.5";
            // 
            // lblAgeEff
            // 
            this.lblAgeEff.Location = new System.Drawing.Point(254, 136);
            this.lblAgeEff.Margin = new System.Windows.Forms.Padding(0);
            this.lblAgeEff.Name = "lblAgeEff";
            this.lblAgeEff.Size = new System.Drawing.Size(120, 30);
            this.lblAgeEff.TabIndex = 33;
            this.lblAgeEff.Text = "Age Efficiency (%)";
            // 
            // lblPanelAge
            // 
            this.lblPanelAge.Location = new System.Drawing.Point(254, 106);
            this.lblPanelAge.Margin = new System.Windows.Forms.Padding(0);
            this.lblPanelAge.Name = "lblPanelAge";
            this.lblPanelAge.Size = new System.Drawing.Size(120, 30);
            this.lblPanelAge.TabIndex = 32;
            this.lblPanelAge.Text = "Panel Age (yrs)";
            // 
            // lblWiringEff
            // 
            this.lblWiringEff.Location = new System.Drawing.Point(254, 76);
            this.lblWiringEff.Margin = new System.Windows.Forms.Padding(0);
            this.lblWiringEff.Name = "lblWiringEff";
            this.lblWiringEff.Size = new System.Drawing.Size(120, 30);
            this.lblWiringEff.TabIndex = 31;
            this.lblWiringEff.Text = "Wiring Efficiency (%)";
            // 
            // lblInverterEff
            // 
            this.lblInverterEff.Location = new System.Drawing.Point(254, 46);
            this.lblInverterEff.Margin = new System.Windows.Forms.Padding(0);
            this.lblInverterEff.Name = "lblInverterEff";
            this.lblInverterEff.Size = new System.Drawing.Size(120, 30);
            this.lblInverterEff.TabIndex = 30;
            this.lblInverterEff.Text = "Inverter Efficiency (%)";
            // 
            // lblRoofEff
            // 
            this.lblRoofEff.Location = new System.Drawing.Point(254, 16);
            this.lblRoofEff.Margin = new System.Windows.Forms.Padding(0);
            this.lblRoofEff.Name = "lblRoofEff";
            this.lblRoofEff.Size = new System.Drawing.Size(120, 30);
            this.lblRoofEff.TabIndex = 29;
            this.lblRoofEff.Text = "Roof Efficiency (%)";
            // 
            // txtSystemSize
            // 
            this.txtSystemSize.Location = new System.Drawing.Point(109, 103);
            this.txtSystemSize.Name = "txtSystemSize";
            this.txtSystemSize.Size = new System.Drawing.Size(100, 20);
            this.txtSystemSize.TabIndex = 28;
            this.txtSystemSize.Text = "4950";
            // 
            // cboRoofAngle
            // 
            this.cboRoofAngle.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cboRoofAngle.FormattingEnabled = true;
            this.cboRoofAngle.Location = new System.Drawing.Point(109, 73);
            this.cboRoofAngle.Name = "cboRoofAngle";
            this.cboRoofAngle.Size = new System.Drawing.Size(100, 21);
            this.cboRoofAngle.TabIndex = 27;
            this.cboRoofAngle.SelectedIndexChanged += new System.EventHandler(this.cboRoofAngle_SelectedIndexChanged);
            // 
            // cboRoofDirection
            // 
            this.cboRoofDirection.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cboRoofDirection.FormattingEnabled = true;
            this.cboRoofDirection.Location = new System.Drawing.Point(109, 43);
            this.cboRoofDirection.Name = "cboRoofDirection";
            this.cboRoofDirection.Size = new System.Drawing.Size(100, 21);
            this.cboRoofDirection.TabIndex = 26;
            this.cboRoofDirection.SelectedIndexChanged += new System.EventHandler(this.cboRoofDirection_SelectedIndexChanged);
            // 
            // lblSystemSize
            // 
            this.lblSystemSize.Location = new System.Drawing.Point(6, 106);
            this.lblSystemSize.Margin = new System.Windows.Forms.Padding(0);
            this.lblSystemSize.Name = "lblSystemSize";
            this.lblSystemSize.Size = new System.Drawing.Size(100, 30);
            this.lblSystemSize.TabIndex = 25;
            this.lblSystemSize.Text = "System Size (kW)";
            // 
            // lblRoofAngle
            // 
            this.lblRoofAngle.Location = new System.Drawing.Point(6, 76);
            this.lblRoofAngle.Margin = new System.Windows.Forms.Padding(0);
            this.lblRoofAngle.Name = "lblRoofAngle";
            this.lblRoofAngle.Size = new System.Drawing.Size(100, 30);
            this.lblRoofAngle.TabIndex = 24;
            this.lblRoofAngle.Text = "Roof Angle";
            // 
            // lblRoofDirection
            // 
            this.lblRoofDirection.Location = new System.Drawing.Point(6, 46);
            this.lblRoofDirection.Margin = new System.Windows.Forms.Padding(0);
            this.lblRoofDirection.Name = "lblRoofDirection";
            this.lblRoofDirection.Size = new System.Drawing.Size(100, 30);
            this.lblRoofDirection.TabIndex = 23;
            this.lblRoofDirection.Text = "Roof Direction";
            // 
            // lblCity
            // 
            this.lblCity.Location = new System.Drawing.Point(6, 16);
            this.lblCity.Margin = new System.Windows.Forms.Padding(0);
            this.lblCity.Name = "lblCity";
            this.lblCity.Size = new System.Drawing.Size(100, 30);
            this.lblCity.TabIndex = 22;
            this.lblCity.Text = "City";
            // 
            // cboCity
            // 
            this.cboCity.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cboCity.FormattingEnabled = true;
            this.cboCity.Location = new System.Drawing.Point(109, 13);
            this.cboCity.Name = "cboCity";
            this.cboCity.Size = new System.Drawing.Size(100, 21);
            this.cboCity.TabIndex = 20;
            // 
            // btnReset
            // 
            this.btnReset.Location = new System.Drawing.Point(289, 193);
            this.btnReset.Name = "btnReset";
            this.btnReset.Size = new System.Drawing.Size(75, 23);
            this.btnReset.TabIndex = 16;
            this.btnReset.Text = "Reset";
            this.btnReset.UseVisualStyleBackColor = true;
            // 
            // btnCalculate
            // 
            this.btnCalculate.Location = new System.Drawing.Point(208, 193);
            this.btnCalculate.Name = "btnCalculate";
            this.btnCalculate.Size = new System.Drawing.Size(75, 23);
            this.btnCalculate.TabIndex = 15;
            this.btnCalculate.Text = "Calculate";
            this.btnCalculate.UseVisualStyleBackColor = true;
            this.btnCalculate.Click += new System.EventHandler(this.btnCalculate_Click);
            // 
            // tabConsumption
            // 
            this.tabConsumption.Location = new System.Drawing.Point(4, 22);
            this.tabConsumption.Name = "tabConsumption";
            this.tabConsumption.Padding = new System.Windows.Forms.Padding(3);
            this.tabConsumption.Size = new System.Drawing.Size(952, 462);
            this.tabConsumption.TabIndex = 1;
            this.tabConsumption.Text = "Power Consumption";
            this.tabConsumption.UseVisualStyleBackColor = true;
            // 
            // tabSavings
            // 
            this.tabSavings.Location = new System.Drawing.Point(4, 22);
            this.tabSavings.Name = "tabSavings";
            this.tabSavings.Size = new System.Drawing.Size(952, 462);
            this.tabSavings.TabIndex = 2;
            this.tabSavings.Text = "Dollar Savings";
            this.tabSavings.UseVisualStyleBackColor = true;
            // 
            // lblBanner
            // 
            this.lblBanner.BackColor = System.Drawing.Color.Black;
            this.lblBanner.Font = new System.Drawing.Font("Segoe UI", 24F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblBanner.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(136)))), ((int)(((byte)(0)))));
            this.lblBanner.Location = new System.Drawing.Point(9, 28);
            this.lblBanner.Margin = new System.Windows.Forms.Padding(0);
            this.lblBanner.Name = "lblBanner";
            this.lblBanner.Size = new System.Drawing.Size(245, 50);
            this.lblBanner.TabIndex = 1;
            this.lblBanner.Tag = "";
            this.lblBanner.Text = "Solar Calculator";
            // 
            // pictureBox1
            // 
            this.pictureBox1.Image = global::BlackoutSolarPanelCalculator.Properties.Resources.BlackoutSymbol;
            this.pictureBox1.Location = new System.Drawing.Point(866, 28);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(106, 69);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBox1.TabIndex = 2;
            this.pictureBox1.TabStop = false;
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.fileToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(984, 24);
            this.menuStrip1.TabIndex = 3;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // fileToolStripMenuItem
            // 
            this.fileToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.serverStringToolStripMenuItem});
            this.fileToolStripMenuItem.Name = "fileToolStripMenuItem";
            this.fileToolStripMenuItem.Size = new System.Drawing.Size(37, 20);
            this.fileToolStripMenuItem.Text = "File";
            // 
            // serverStringToolStripMenuItem
            // 
            this.serverStringToolStripMenuItem.Name = "serverStringToolStripMenuItem";
            this.serverStringToolStripMenuItem.Size = new System.Drawing.Size(140, 22);
            this.serverStringToolStripMenuItem.Text = "Server String";
            this.serverStringToolStripMenuItem.Click += new System.EventHandler(this.serverStringToolStripMenuItem_Click);
            // 
            // SolarCalculator
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Black;
            this.ClientSize = new System.Drawing.Size(984, 581);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.lblBanner);
            this.Controls.Add(this.tabControl);
            this.Controls.Add(this.menuStrip1);
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "SolarCalculator";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Solar Calculator";
            this.tabControl.ResumeLayout(false);
            this.tabGeneration.ResumeLayout(false);
            this.grpPowerGenerationResult.ResumeLayout(false);
            this.grpPowerGenerationInput.ResumeLayout(false);
            this.grpPowerGenerationInput.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TabControl tabControl;
        private System.Windows.Forms.TabPage tabGeneration;
        private System.Windows.Forms.TabPage tabConsumption;
        private System.Windows.Forms.TabPage tabSavings;
        private System.Windows.Forms.Label lblBanner;
        private System.Windows.Forms.GroupBox grpPowerGenerationInstruct;
        private System.Windows.Forms.GroupBox grpPowerGenerationResult;
        private System.Windows.Forms.GroupBox grpPowerGenerationInput;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button btnReset;
        private System.Windows.Forms.Button btnCalculate;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem fileToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem serverStringToolStripMenuItem;
        private System.Windows.Forms.TextBox txtAgeEff;
        private System.Windows.Forms.TextBox txtPanelAge;
        private System.Windows.Forms.TextBox txtWiringEff;
        private System.Windows.Forms.TextBox txtInverterEff;
        private System.Windows.Forms.TextBox txtRoofEff;
        private System.Windows.Forms.Label lblAgeEff;
        private System.Windows.Forms.Label lblPanelAge;
        private System.Windows.Forms.Label lblWiringEff;
        private System.Windows.Forms.Label lblInverterEff;
        private System.Windows.Forms.Label lblRoofEff;
        private System.Windows.Forms.TextBox txtSystemSize;
        private System.Windows.Forms.ComboBox cboRoofAngle;
        private System.Windows.Forms.ComboBox cboRoofDirection;
        private System.Windows.Forms.Label lblSystemSize;
        private System.Windows.Forms.Label lblRoofAngle;
        private System.Windows.Forms.Label lblRoofDirection;
        private System.Windows.Forms.Label lblCity;
        private System.Windows.Forms.ComboBox cboCity;
    }
}

