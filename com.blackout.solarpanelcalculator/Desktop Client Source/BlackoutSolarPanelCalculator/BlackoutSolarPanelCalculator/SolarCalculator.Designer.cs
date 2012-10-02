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
            this.grpPowerGenerationInput = new System.Windows.Forms.GroupBox();
            this.lblSystemSize = new System.Windows.Forms.Label();
            this.txtSystemSize = new System.Windows.Forms.TextBox();
            this.tabConsumption = new System.Windows.Forms.TabPage();
            this.tabSavings = new System.Windows.Forms.TabPage();
            this.lblBanner = new System.Windows.Forms.Label();
            this.lblRoofEfficiency = new System.Windows.Forms.Label();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.lblInverterEfficiency = new System.Windows.Forms.Label();
            this.textBox2 = new System.Windows.Forms.TextBox();
            this.lblWiringEfficiency = new System.Windows.Forms.Label();
            this.textBox3 = new System.Windows.Forms.TextBox();
            this.lblPanelAge = new System.Windows.Forms.Label();
            this.textBox4 = new System.Windows.Forms.TextBox();
            this.lblAgeEfficiency = new System.Windows.Forms.Label();
            this.textBox5 = new System.Windows.Forms.TextBox();
            this.lblSolarIrradiance = new System.Windows.Forms.Label();
            this.textBox6 = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.btnCalculate = new System.Windows.Forms.Button();
            this.btnReset = new System.Windows.Forms.Button();
            this.button1 = new System.Windows.Forms.Button();
            this.button2 = new System.Windows.Forms.Button();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.tabControl.SuspendLayout();
            this.tabGeneration.SuspendLayout();
            this.grpPowerGenerationInstruct.SuspendLayout();
            this.grpPowerGenerationResult.SuspendLayout();
            this.grpPowerGenerationInput.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.SuspendLayout();
            // 
            // tabControl
            // 
            this.tabControl.Controls.Add(this.tabGeneration);
            this.tabControl.Controls.Add(this.tabConsumption);
            this.tabControl.Controls.Add(this.tabSavings);
            this.tabControl.Location = new System.Drawing.Point(12, 62);
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
            this.grpPowerGenerationInstruct.Controls.Add(this.label3);
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
            // grpPowerGenerationInput
            // 
            this.grpPowerGenerationInput.Controls.Add(this.button2);
            this.grpPowerGenerationInput.Controls.Add(this.button1);
            this.grpPowerGenerationInput.Controls.Add(this.btnReset);
            this.grpPowerGenerationInput.Controls.Add(this.btnCalculate);
            this.grpPowerGenerationInput.Controls.Add(this.label1);
            this.grpPowerGenerationInput.Controls.Add(this.lblSolarIrradiance);
            this.grpPowerGenerationInput.Controls.Add(this.textBox6);
            this.grpPowerGenerationInput.Controls.Add(this.lblAgeEfficiency);
            this.grpPowerGenerationInput.Controls.Add(this.textBox5);
            this.grpPowerGenerationInput.Controls.Add(this.lblPanelAge);
            this.grpPowerGenerationInput.Controls.Add(this.textBox4);
            this.grpPowerGenerationInput.Controls.Add(this.lblWiringEfficiency);
            this.grpPowerGenerationInput.Controls.Add(this.textBox3);
            this.grpPowerGenerationInput.Controls.Add(this.lblInverterEfficiency);
            this.grpPowerGenerationInput.Controls.Add(this.textBox2);
            this.grpPowerGenerationInput.Controls.Add(this.lblRoofEfficiency);
            this.grpPowerGenerationInput.Controls.Add(this.textBox1);
            this.grpPowerGenerationInput.Controls.Add(this.lblSystemSize);
            this.grpPowerGenerationInput.Controls.Add(this.txtSystemSize);
            this.grpPowerGenerationInput.Location = new System.Drawing.Point(6, 6);
            this.grpPowerGenerationInput.Name = "grpPowerGenerationInput";
            this.grpPowerGenerationInput.Size = new System.Drawing.Size(600, 222);
            this.grpPowerGenerationInput.TabIndex = 0;
            this.grpPowerGenerationInput.TabStop = false;
            this.grpPowerGenerationInput.Text = "Input";
            // 
            // lblSystemSize
            // 
            this.lblSystemSize.Location = new System.Drawing.Point(6, 16);
            this.lblSystemSize.Name = "lblSystemSize";
            this.lblSystemSize.Size = new System.Drawing.Size(120, 20);
            this.lblSystemSize.TabIndex = 1;
            this.lblSystemSize.Text = "System Size (W):";
            // 
            // txtSystemSize
            // 
            this.txtSystemSize.Location = new System.Drawing.Point(132, 16);
            this.txtSystemSize.Name = "txtSystemSize";
            this.txtSystemSize.Size = new System.Drawing.Size(100, 20);
            this.txtSystemSize.TabIndex = 0;
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
            this.lblBanner.Location = new System.Drawing.Point(9, 9);
            this.lblBanner.Margin = new System.Windows.Forms.Padding(0);
            this.lblBanner.Name = "lblBanner";
            this.lblBanner.Size = new System.Drawing.Size(245, 50);
            this.lblBanner.TabIndex = 1;
            this.lblBanner.Tag = "";
            this.lblBanner.Text = "Solar Calculator";
            // 
            // lblRoofEfficiency
            // 
            this.lblRoofEfficiency.Location = new System.Drawing.Point(6, 42);
            this.lblRoofEfficiency.Name = "lblRoofEfficiency";
            this.lblRoofEfficiency.Size = new System.Drawing.Size(120, 20);
            this.lblRoofEfficiency.TabIndex = 3;
            this.lblRoofEfficiency.Text = "Roof Efficiency (%):";
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(132, 42);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(100, 20);
            this.textBox1.TabIndex = 2;
            // 
            // lblInverterEfficiency
            // 
            this.lblInverterEfficiency.Location = new System.Drawing.Point(6, 68);
            this.lblInverterEfficiency.Name = "lblInverterEfficiency";
            this.lblInverterEfficiency.Size = new System.Drawing.Size(120, 20);
            this.lblInverterEfficiency.TabIndex = 5;
            this.lblInverterEfficiency.Text = "Inverter Efficiency (%):";
            // 
            // textBox2
            // 
            this.textBox2.Location = new System.Drawing.Point(132, 68);
            this.textBox2.Name = "textBox2";
            this.textBox2.Size = new System.Drawing.Size(100, 20);
            this.textBox2.TabIndex = 4;
            // 
            // lblWiringEfficiency
            // 
            this.lblWiringEfficiency.Location = new System.Drawing.Point(6, 94);
            this.lblWiringEfficiency.Name = "lblWiringEfficiency";
            this.lblWiringEfficiency.Size = new System.Drawing.Size(120, 20);
            this.lblWiringEfficiency.TabIndex = 7;
            this.lblWiringEfficiency.Text = "Wiring Efficiency (%):";
            // 
            // textBox3
            // 
            this.textBox3.Location = new System.Drawing.Point(132, 94);
            this.textBox3.Name = "textBox3";
            this.textBox3.Size = new System.Drawing.Size(100, 20);
            this.textBox3.TabIndex = 6;
            // 
            // lblPanelAge
            // 
            this.lblPanelAge.Location = new System.Drawing.Point(6, 120);
            this.lblPanelAge.Name = "lblPanelAge";
            this.lblPanelAge.Size = new System.Drawing.Size(120, 20);
            this.lblPanelAge.TabIndex = 9;
            this.lblPanelAge.Text = "Panel Age (yrs):";
            // 
            // textBox4
            // 
            this.textBox4.Location = new System.Drawing.Point(132, 120);
            this.textBox4.Name = "textBox4";
            this.textBox4.Size = new System.Drawing.Size(100, 20);
            this.textBox4.TabIndex = 8;
            // 
            // lblAgeEfficiency
            // 
            this.lblAgeEfficiency.Location = new System.Drawing.Point(6, 146);
            this.lblAgeEfficiency.Name = "lblAgeEfficiency";
            this.lblAgeEfficiency.Size = new System.Drawing.Size(120, 20);
            this.lblAgeEfficiency.TabIndex = 11;
            this.lblAgeEfficiency.Text = "Aging Efficiency (%):";
            // 
            // textBox5
            // 
            this.textBox5.Location = new System.Drawing.Point(132, 146);
            this.textBox5.Name = "textBox5";
            this.textBox5.Size = new System.Drawing.Size(100, 20);
            this.textBox5.TabIndex = 10;
            // 
            // lblSolarIrradiance
            // 
            this.lblSolarIrradiance.Location = new System.Drawing.Point(6, 172);
            this.lblSolarIrradiance.Name = "lblSolarIrradiance";
            this.lblSolarIrradiance.Size = new System.Drawing.Size(120, 20);
            this.lblSolarIrradiance.TabIndex = 13;
            this.lblSolarIrradiance.Text = "Solar Irradiance:";
            // 
            // textBox6
            // 
            this.textBox6.Location = new System.Drawing.Point(132, 172);
            this.textBox6.Name = "textBox6";
            this.textBox6.Size = new System.Drawing.Size(100, 20);
            this.textBox6.TabIndex = 12;
            // 
            // label1
            // 
            this.label1.Location = new System.Drawing.Point(388, 68);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(130, 56);
            this.label1.TabIndex = 14;
            this.label1.Text = "Componenet calculations can go here!";
            // 
            // btnCalculate
            // 
            this.btnCalculate.Location = new System.Drawing.Point(208, 193);
            this.btnCalculate.Name = "btnCalculate";
            this.btnCalculate.Size = new System.Drawing.Size(75, 23);
            this.btnCalculate.TabIndex = 15;
            this.btnCalculate.Text = "Calculate";
            this.btnCalculate.UseVisualStyleBackColor = true;
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
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(208, 193);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 23);
            this.button1.TabIndex = 15;
            this.button1.Text = "Calculate";
            this.button1.UseVisualStyleBackColor = true;
            // 
            // button2
            // 
            this.button2.Location = new System.Drawing.Point(289, 193);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(75, 23);
            this.button2.TabIndex = 16;
            this.button2.Text = "Reset";
            this.button2.UseVisualStyleBackColor = true;
            // 
            // label2
            // 
            this.label2.Location = new System.Drawing.Point(87, 94);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(145, 21);
            this.label2.TabIndex = 17;
            this.label2.Text = "Answers and stuff go here";
            // 
            // label3
            // 
            this.label3.Location = new System.Drawing.Point(6, 19);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(322, 43);
            this.label3.TabIndex = 18;
            this.label3.Text = "Obviously instructions and stuff go here. Perhaps component calculations go here " +
                "too?";
            // 
            // pictureBox1
            // 
            this.pictureBox1.Image = global::BlackoutSolarPanelCalculator.Properties.Resources.BlackoutSymbol;
            this.pictureBox1.Location = new System.Drawing.Point(866, 9);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(106, 69);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBox1.TabIndex = 2;
            this.pictureBox1.TabStop = false;
            // 
            // SolarCalculator
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Black;
            this.ClientSize = new System.Drawing.Size(984, 562);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.lblBanner);
            this.Controls.Add(this.tabControl);
            this.Name = "SolarCalculator";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Solar Calculator";
            this.tabControl.ResumeLayout(false);
            this.tabGeneration.ResumeLayout(false);
            this.grpPowerGenerationInstruct.ResumeLayout(false);
            this.grpPowerGenerationResult.ResumeLayout(false);
            this.grpPowerGenerationInput.ResumeLayout(false);
            this.grpPowerGenerationInput.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);

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
        private System.Windows.Forms.Label lblSystemSize;
        private System.Windows.Forms.TextBox txtSystemSize;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label lblSolarIrradiance;
        private System.Windows.Forms.TextBox textBox6;
        private System.Windows.Forms.Label lblAgeEfficiency;
        private System.Windows.Forms.TextBox textBox5;
        private System.Windows.Forms.Label lblPanelAge;
        private System.Windows.Forms.TextBox textBox4;
        private System.Windows.Forms.Label lblWiringEfficiency;
        private System.Windows.Forms.TextBox textBox3;
        private System.Windows.Forms.Label lblInverterEfficiency;
        private System.Windows.Forms.TextBox textBox2;
        private System.Windows.Forms.Label lblRoofEfficiency;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Button btnReset;
        private System.Windows.Forms.Button btnCalculate;
        private System.Windows.Forms.PictureBox pictureBox1;
    }
}

