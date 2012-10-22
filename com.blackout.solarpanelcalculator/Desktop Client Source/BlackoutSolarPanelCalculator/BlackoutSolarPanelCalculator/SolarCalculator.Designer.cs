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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(SolarCalculator));
            System.Windows.Forms.DataVisualization.Charting.ChartArea chartArea1 = new System.Windows.Forms.DataVisualization.Charting.ChartArea();
            System.Windows.Forms.DataVisualization.Charting.Series series1 = new System.Windows.Forms.DataVisualization.Charting.Series();
            System.Windows.Forms.DataVisualization.Charting.ChartArea chartArea2 = new System.Windows.Forms.DataVisualization.Charting.ChartArea();
            System.Windows.Forms.DataVisualization.Charting.Series series2 = new System.Windows.Forms.DataVisualization.Charting.Series();
            this.tabControl = new System.Windows.Forms.TabControl();
            this.tabGeneration = new System.Windows.Forms.TabPage();
            this.grpPGInstructions = new System.Windows.Forms.GroupBox();
            this.lblPGInstructions = new System.Windows.Forms.Label();
            this.grpPGResults = new System.Windows.Forms.GroupBox();
            this.lblPGResults = new System.Windows.Forms.Label();
            this.chtMonthlyPowerGenerated = new System.Windows.Forms.DataVisualization.Charting.Chart();
            this.grpPGInput = new System.Windows.Forms.GroupBox();
            this.lblPGError = new System.Windows.Forms.Label();
            this.txtPGAgingEff = new System.Windows.Forms.TextBox();
            this.txtWiringEff = new System.Windows.Forms.TextBox();
            this.txtInverterEff = new System.Windows.Forms.TextBox();
            this.txtRoofEff = new System.Windows.Forms.TextBox();
            this.lblPGAgingEff = new System.Windows.Forms.Label();
            this.lblWiringEff = new System.Windows.Forms.Label();
            this.lblInverterEff = new System.Windows.Forms.Label();
            this.lblRoofEff = new System.Windows.Forms.Label();
            this.txtSystemSize = new System.Windows.Forms.TextBox();
            this.cboRoofAngle = new System.Windows.Forms.ComboBox();
            this.cboRoofDirection = new System.Windows.Forms.ComboBox();
            this.lblSystemSize = new System.Windows.Forms.Label();
            this.lblRoofAngle = new System.Windows.Forms.Label();
            this.lblRoofDirection = new System.Windows.Forms.Label();
            this.lblPGCity = new System.Windows.Forms.Label();
            this.cboPGCity = new System.Windows.Forms.ComboBox();
            this.btnPGReset = new System.Windows.Forms.Button();
            this.btnPGCalculate = new System.Windows.Forms.Button();
            this.tabConsumption = new System.Windows.Forms.TabPage();
            this.grpPCInstructions = new System.Windows.Forms.GroupBox();
            this.lblPCInstructions = new System.Windows.Forms.Label();
            this.grpPCResults = new System.Windows.Forms.GroupBox();
            this.lblPCResults = new System.Windows.Forms.Label();
            this.grpPCInput = new System.Windows.Forms.GroupBox();
            this.lblPCError = new System.Windows.Forms.Label();
            this.txtHouseholdSize = new System.Windows.Forms.TextBox();
            this.lblHouseholdSize = new System.Windows.Forms.Label();
            this.lblUsageType = new System.Windows.Forms.Label();
            this.cboUsageType = new System.Windows.Forms.ComboBox();
            this.btnPCReset = new System.Windows.Forms.Button();
            this.btnPCCalculate = new System.Windows.Forms.Button();
            this.tabSavings = new System.Windows.Forms.TabPage();
            this.grpDSInstructions = new System.Windows.Forms.GroupBox();
            this.lblDSInstructions = new System.Windows.Forms.Label();
            this.grpDSResults = new System.Windows.Forms.GroupBox();
            this.lblDSResults = new System.Windows.Forms.Label();
            this.chtPayBack = new System.Windows.Forms.DataVisualization.Charting.Chart();
            this.grpDSInput = new System.Windows.Forms.GroupBox();
            this.txtReplacePercent = new System.Windows.Forms.TextBox();
            this.lblReplacePercent = new System.Windows.Forms.Label();
            this.txtDailyGeneration = new System.Windows.Forms.TextBox();
            this.lblDailyGeneration = new System.Windows.Forms.Label();
            this.txtSystemCost = new System.Windows.Forms.TextBox();
            this.lblSystemCost = new System.Windows.Forms.Label();
            this.lblDSError = new System.Windows.Forms.Label();
            this.txtLifeSpan = new System.Windows.Forms.TextBox();
            this.txtDSAgingEff = new System.Windows.Forms.TextBox();
            this.lblLifeSpan = new System.Windows.Forms.Label();
            this.lblDSAgingEff = new System.Windows.Forms.Label();
            this.txtDailyConsumption = new System.Windows.Forms.TextBox();
            this.lblDailyConsumption = new System.Windows.Forms.Label();
            this.lblDSCity = new System.Windows.Forms.Label();
            this.cboDSCity = new System.Windows.Forms.ComboBox();
            this.btnDSReset = new System.Windows.Forms.Button();
            this.btnDSCalculate = new System.Windows.Forms.Button();
            this.lblBanner = new System.Windows.Forms.Label();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.fileToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.serverStringToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.tabControl.SuspendLayout();
            this.tabGeneration.SuspendLayout();
            this.grpPGInstructions.SuspendLayout();
            this.grpPGResults.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.chtMonthlyPowerGenerated)).BeginInit();
            this.grpPGInput.SuspendLayout();
            this.tabConsumption.SuspendLayout();
            this.grpPCInstructions.SuspendLayout();
            this.grpPCResults.SuspendLayout();
            this.grpPCInput.SuspendLayout();
            this.tabSavings.SuspendLayout();
            this.grpDSInstructions.SuspendLayout();
            this.grpDSResults.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.chtPayBack)).BeginInit();
            this.grpDSInput.SuspendLayout();
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
            this.tabGeneration.Controls.Add(this.grpPGInstructions);
            this.tabGeneration.Controls.Add(this.grpPGResults);
            this.tabGeneration.Controls.Add(this.grpPGInput);
            this.tabGeneration.Location = new System.Drawing.Point(4, 22);
            this.tabGeneration.Name = "tabGeneration";
            this.tabGeneration.Padding = new System.Windows.Forms.Padding(3);
            this.tabGeneration.Size = new System.Drawing.Size(952, 462);
            this.tabGeneration.TabIndex = 0;
            this.tabGeneration.Text = "Power Generation";
            this.tabGeneration.UseVisualStyleBackColor = true;
            // 
            // grpPGInstructions
            // 
            this.grpPGInstructions.Controls.Add(this.lblPGInstructions);
            this.grpPGInstructions.Location = new System.Drawing.Point(612, 6);
            this.grpPGInstructions.Name = "grpPGInstructions";
            this.grpPGInstructions.Size = new System.Drawing.Size(334, 450);
            this.grpPGInstructions.TabIndex = 2;
            this.grpPGInstructions.TabStop = false;
            this.grpPGInstructions.Text = "Instructions";
            // 
            // lblPGInstructions
            // 
            this.lblPGInstructions.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblPGInstructions.Location = new System.Drawing.Point(3, 16);
            this.lblPGInstructions.Margin = new System.Windows.Forms.Padding(0);
            this.lblPGInstructions.Name = "lblPGInstructions";
            this.lblPGInstructions.Size = new System.Drawing.Size(328, 389);
            this.lblPGInstructions.TabIndex = 39;
            this.lblPGInstructions.Text = resources.GetString("lblPGInstructions.Text");
            // 
            // grpPGResults
            // 
            this.grpPGResults.Controls.Add(this.lblPGResults);
            this.grpPGResults.Controls.Add(this.chtMonthlyPowerGenerated);
            this.grpPGResults.Location = new System.Drawing.Point(6, 234);
            this.grpPGResults.Name = "grpPGResults";
            this.grpPGResults.Size = new System.Drawing.Size(600, 222);
            this.grpPGResults.TabIndex = 1;
            this.grpPGResults.TabStop = false;
            this.grpPGResults.Text = "Results";
            // 
            // lblPGResults
            // 
            this.lblPGResults.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblPGResults.Location = new System.Drawing.Point(6, 19);
            this.lblPGResults.Margin = new System.Windows.Forms.Padding(0);
            this.lblPGResults.Name = "lblPGResults";
            this.lblPGResults.Size = new System.Drawing.Size(277, 197);
            this.lblPGResults.TabIndex = 39;
            // 
            // chtMonthlyPowerGenerated
            // 
            chartArea1.Name = "ChartArea1";
            this.chtMonthlyPowerGenerated.ChartAreas.Add(chartArea1);
            this.chtMonthlyPowerGenerated.Location = new System.Drawing.Point(289, 19);
            this.chtMonthlyPowerGenerated.Name = "chtMonthlyPowerGenerated";
            series1.ChartArea = "ChartArea1";
            series1.Name = "srsMonthValues";
            this.chtMonthlyPowerGenerated.Series.Add(series1);
            this.chtMonthlyPowerGenerated.Size = new System.Drawing.Size(305, 197);
            this.chtMonthlyPowerGenerated.TabIndex = 0;
            this.chtMonthlyPowerGenerated.Visible = false;
            // 
            // grpPGInput
            // 
            this.grpPGInput.Controls.Add(this.lblPGError);
            this.grpPGInput.Controls.Add(this.txtPGAgingEff);
            this.grpPGInput.Controls.Add(this.txtWiringEff);
            this.grpPGInput.Controls.Add(this.txtInverterEff);
            this.grpPGInput.Controls.Add(this.txtRoofEff);
            this.grpPGInput.Controls.Add(this.lblPGAgingEff);
            this.grpPGInput.Controls.Add(this.lblWiringEff);
            this.grpPGInput.Controls.Add(this.lblInverterEff);
            this.grpPGInput.Controls.Add(this.lblRoofEff);
            this.grpPGInput.Controls.Add(this.txtSystemSize);
            this.grpPGInput.Controls.Add(this.cboRoofAngle);
            this.grpPGInput.Controls.Add(this.cboRoofDirection);
            this.grpPGInput.Controls.Add(this.lblSystemSize);
            this.grpPGInput.Controls.Add(this.lblRoofAngle);
            this.grpPGInput.Controls.Add(this.lblRoofDirection);
            this.grpPGInput.Controls.Add(this.lblPGCity);
            this.grpPGInput.Controls.Add(this.cboPGCity);
            this.grpPGInput.Controls.Add(this.btnPGReset);
            this.grpPGInput.Controls.Add(this.btnPGCalculate);
            this.grpPGInput.Location = new System.Drawing.Point(6, 6);
            this.grpPGInput.Name = "grpPGInput";
            this.grpPGInput.Size = new System.Drawing.Size(600, 222);
            this.grpPGInput.TabIndex = 0;
            this.grpPGInput.TabStop = false;
            this.grpPGInput.Text = "Input";
            // 
            // lblPGError
            // 
            this.lblPGError.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblPGError.ForeColor = System.Drawing.Color.Red;
            this.lblPGError.Location = new System.Drawing.Point(6, 169);
            this.lblPGError.Name = "lblPGError";
            this.lblPGError.Size = new System.Drawing.Size(588, 21);
            this.lblPGError.TabIndex = 17;
            // 
            // txtPGAgingEff
            // 
            this.txtPGAgingEff.Location = new System.Drawing.Point(377, 103);
            this.txtPGAgingEff.Name = "txtPGAgingEff";
            this.txtPGAgingEff.Size = new System.Drawing.Size(100, 20);
            this.txtPGAgingEff.TabIndex = 38;
            this.txtPGAgingEff.TextChanged += new System.EventHandler(this.txtPGAgingEff_TextChanged);
            // 
            // txtWiringEff
            // 
            this.txtWiringEff.Location = new System.Drawing.Point(377, 73);
            this.txtWiringEff.Name = "txtWiringEff";
            this.txtWiringEff.Size = new System.Drawing.Size(100, 20);
            this.txtWiringEff.TabIndex = 36;
            this.txtWiringEff.TextChanged += new System.EventHandler(this.txtWiringEff_TextChanged);
            // 
            // txtInverterEff
            // 
            this.txtInverterEff.Location = new System.Drawing.Point(377, 43);
            this.txtInverterEff.Name = "txtInverterEff";
            this.txtInverterEff.Size = new System.Drawing.Size(100, 20);
            this.txtInverterEff.TabIndex = 35;
            this.txtInverterEff.TextChanged += new System.EventHandler(this.txtInverterEff_TextChanged);
            // 
            // txtRoofEff
            // 
            this.txtRoofEff.Location = new System.Drawing.Point(377, 13);
            this.txtRoofEff.Name = "txtRoofEff";
            this.txtRoofEff.Size = new System.Drawing.Size(100, 20);
            this.txtRoofEff.TabIndex = 34;
            this.txtRoofEff.TextChanged += new System.EventHandler(this.txtRoofEff_TextChanged);
            // 
            // lblPGAgingEff
            // 
            this.lblPGAgingEff.Location = new System.Drawing.Point(254, 106);
            this.lblPGAgingEff.Margin = new System.Windows.Forms.Padding(0);
            this.lblPGAgingEff.Name = "lblPGAgingEff";
            this.lblPGAgingEff.Size = new System.Drawing.Size(120, 30);
            this.lblPGAgingEff.TabIndex = 33;
            this.lblPGAgingEff.Text = "Age Efficiency (%)";
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
            this.txtSystemSize.TextChanged += new System.EventHandler(this.txtSystemSize_TextChanged);
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
            this.lblSystemSize.Text = "System Size (W)";
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
            // lblPGCity
            // 
            this.lblPGCity.Location = new System.Drawing.Point(6, 16);
            this.lblPGCity.Margin = new System.Windows.Forms.Padding(0);
            this.lblPGCity.Name = "lblPGCity";
            this.lblPGCity.Size = new System.Drawing.Size(100, 30);
            this.lblPGCity.TabIndex = 22;
            this.lblPGCity.Text = "City";
            // 
            // cboPGCity
            // 
            this.cboPGCity.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cboPGCity.FormattingEnabled = true;
            this.cboPGCity.Location = new System.Drawing.Point(109, 13);
            this.cboPGCity.Name = "cboPGCity";
            this.cboPGCity.Size = new System.Drawing.Size(100, 21);
            this.cboPGCity.TabIndex = 20;
            this.cboPGCity.SelectedIndexChanged += new System.EventHandler(this.cboPGCity_SelectedIndexChanged);
            // 
            // btnPGReset
            // 
            this.btnPGReset.Location = new System.Drawing.Point(289, 193);
            this.btnPGReset.Name = "btnPGReset";
            this.btnPGReset.Size = new System.Drawing.Size(75, 23);
            this.btnPGReset.TabIndex = 16;
            this.btnPGReset.Text = "Reset";
            this.btnPGReset.UseVisualStyleBackColor = true;
            this.btnPGReset.Click += new System.EventHandler(this.btnPGReset_Click);
            // 
            // btnPGCalculate
            // 
            this.btnPGCalculate.Location = new System.Drawing.Point(208, 193);
            this.btnPGCalculate.Name = "btnPGCalculate";
            this.btnPGCalculate.Size = new System.Drawing.Size(75, 23);
            this.btnPGCalculate.TabIndex = 15;
            this.btnPGCalculate.Text = "Calculate";
            this.btnPGCalculate.UseVisualStyleBackColor = true;
            this.btnPGCalculate.Click += new System.EventHandler(this.btnPGCalculate_Click);
            // 
            // tabConsumption
            // 
            this.tabConsumption.Controls.Add(this.grpPCInstructions);
            this.tabConsumption.Controls.Add(this.grpPCResults);
            this.tabConsumption.Controls.Add(this.grpPCInput);
            this.tabConsumption.Location = new System.Drawing.Point(4, 22);
            this.tabConsumption.Name = "tabConsumption";
            this.tabConsumption.Padding = new System.Windows.Forms.Padding(3);
            this.tabConsumption.Size = new System.Drawing.Size(952, 462);
            this.tabConsumption.TabIndex = 1;
            this.tabConsumption.Text = "Power Consumption";
            this.tabConsumption.UseVisualStyleBackColor = true;
            // 
            // grpPCInstructions
            // 
            this.grpPCInstructions.Controls.Add(this.lblPCInstructions);
            this.grpPCInstructions.Location = new System.Drawing.Point(612, 6);
            this.grpPCInstructions.Name = "grpPCInstructions";
            this.grpPCInstructions.Size = new System.Drawing.Size(334, 450);
            this.grpPCInstructions.TabIndex = 5;
            this.grpPCInstructions.TabStop = false;
            this.grpPCInstructions.Text = "Instructions";
            // 
            // lblPCInstructions
            // 
            this.lblPCInstructions.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblPCInstructions.Location = new System.Drawing.Point(3, 16);
            this.lblPCInstructions.Margin = new System.Windows.Forms.Padding(0);
            this.lblPCInstructions.Name = "lblPCInstructions";
            this.lblPCInstructions.Size = new System.Drawing.Size(328, 389);
            this.lblPCInstructions.TabIndex = 39;
            this.lblPCInstructions.Text = resources.GetString("lblPCInstructions.Text");
            // 
            // grpPCResults
            // 
            this.grpPCResults.Controls.Add(this.lblPCResults);
            this.grpPCResults.Location = new System.Drawing.Point(6, 234);
            this.grpPCResults.Name = "grpPCResults";
            this.grpPCResults.Size = new System.Drawing.Size(600, 222);
            this.grpPCResults.TabIndex = 4;
            this.grpPCResults.TabStop = false;
            this.grpPCResults.Text = "Results";
            // 
            // lblPCResults
            // 
            this.lblPCResults.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblPCResults.Location = new System.Drawing.Point(6, 19);
            this.lblPCResults.Margin = new System.Windows.Forms.Padding(0);
            this.lblPCResults.Name = "lblPCResults";
            this.lblPCResults.Size = new System.Drawing.Size(588, 197);
            this.lblPCResults.TabIndex = 39;
            // 
            // grpPCInput
            // 
            this.grpPCInput.Controls.Add(this.lblPCError);
            this.grpPCInput.Controls.Add(this.txtHouseholdSize);
            this.grpPCInput.Controls.Add(this.lblHouseholdSize);
            this.grpPCInput.Controls.Add(this.lblUsageType);
            this.grpPCInput.Controls.Add(this.cboUsageType);
            this.grpPCInput.Controls.Add(this.btnPCReset);
            this.grpPCInput.Controls.Add(this.btnPCCalculate);
            this.grpPCInput.Location = new System.Drawing.Point(6, 6);
            this.grpPCInput.Name = "grpPCInput";
            this.grpPCInput.Size = new System.Drawing.Size(600, 222);
            this.grpPCInput.TabIndex = 3;
            this.grpPCInput.TabStop = false;
            this.grpPCInput.Text = "Input";
            // 
            // lblPCError
            // 
            this.lblPCError.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblPCError.ForeColor = System.Drawing.Color.Red;
            this.lblPCError.Location = new System.Drawing.Point(6, 169);
            this.lblPCError.Name = "lblPCError";
            this.lblPCError.Size = new System.Drawing.Size(588, 21);
            this.lblPCError.TabIndex = 17;
            // 
            // txtHouseholdSize
            // 
            this.txtHouseholdSize.Location = new System.Drawing.Point(109, 43);
            this.txtHouseholdSize.Name = "txtHouseholdSize";
            this.txtHouseholdSize.Size = new System.Drawing.Size(100, 20);
            this.txtHouseholdSize.TabIndex = 28;
            this.txtHouseholdSize.TextChanged += new System.EventHandler(this.txtHouseholdSize_TextChanged);
            // 
            // lblHouseholdSize
            // 
            this.lblHouseholdSize.Location = new System.Drawing.Point(6, 46);
            this.lblHouseholdSize.Margin = new System.Windows.Forms.Padding(0);
            this.lblHouseholdSize.Name = "lblHouseholdSize";
            this.lblHouseholdSize.Size = new System.Drawing.Size(100, 30);
            this.lblHouseholdSize.TabIndex = 25;
            this.lblHouseholdSize.Text = "Household Size";
            // 
            // lblUsageType
            // 
            this.lblUsageType.Location = new System.Drawing.Point(6, 16);
            this.lblUsageType.Margin = new System.Windows.Forms.Padding(0);
            this.lblUsageType.Name = "lblUsageType";
            this.lblUsageType.Size = new System.Drawing.Size(100, 30);
            this.lblUsageType.TabIndex = 22;
            this.lblUsageType.Text = "Usage Type";
            // 
            // cboUsageType
            // 
            this.cboUsageType.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cboUsageType.FormattingEnabled = true;
            this.cboUsageType.Location = new System.Drawing.Point(109, 13);
            this.cboUsageType.Name = "cboUsageType";
            this.cboUsageType.Size = new System.Drawing.Size(100, 21);
            this.cboUsageType.TabIndex = 20;
            // 
            // btnPCReset
            // 
            this.btnPCReset.Location = new System.Drawing.Point(289, 193);
            this.btnPCReset.Name = "btnPCReset";
            this.btnPCReset.Size = new System.Drawing.Size(75, 23);
            this.btnPCReset.TabIndex = 16;
            this.btnPCReset.Text = "Reset";
            this.btnPCReset.UseVisualStyleBackColor = true;
            this.btnPCReset.Click += new System.EventHandler(this.btnPCReset_Click);
            // 
            // btnPCCalculate
            // 
            this.btnPCCalculate.Location = new System.Drawing.Point(208, 193);
            this.btnPCCalculate.Name = "btnPCCalculate";
            this.btnPCCalculate.Size = new System.Drawing.Size(75, 23);
            this.btnPCCalculate.TabIndex = 15;
            this.btnPCCalculate.Text = "Calculate";
            this.btnPCCalculate.UseVisualStyleBackColor = true;
            this.btnPCCalculate.Click += new System.EventHandler(this.btnPCCalculate_Click);
            // 
            // tabSavings
            // 
            this.tabSavings.Controls.Add(this.grpDSInstructions);
            this.tabSavings.Controls.Add(this.grpDSResults);
            this.tabSavings.Controls.Add(this.grpDSInput);
            this.tabSavings.Location = new System.Drawing.Point(4, 22);
            this.tabSavings.Name = "tabSavings";
            this.tabSavings.Size = new System.Drawing.Size(952, 462);
            this.tabSavings.TabIndex = 2;
            this.tabSavings.Text = "Dollar Savings";
            this.tabSavings.UseVisualStyleBackColor = true;
            // 
            // grpDSInstructions
            // 
            this.grpDSInstructions.Controls.Add(this.lblDSInstructions);
            this.grpDSInstructions.Location = new System.Drawing.Point(612, 6);
            this.grpDSInstructions.Name = "grpDSInstructions";
            this.grpDSInstructions.Size = new System.Drawing.Size(334, 450);
            this.grpDSInstructions.TabIndex = 5;
            this.grpDSInstructions.TabStop = false;
            this.grpDSInstructions.Text = "Instructions";
            // 
            // lblDSInstructions
            // 
            this.lblDSInstructions.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblDSInstructions.Location = new System.Drawing.Point(3, 16);
            this.lblDSInstructions.Margin = new System.Windows.Forms.Padding(0);
            this.lblDSInstructions.Name = "lblDSInstructions";
            this.lblDSInstructions.Size = new System.Drawing.Size(328, 389);
            this.lblDSInstructions.TabIndex = 39;
            this.lblDSInstructions.Text = resources.GetString("lblDSInstructions.Text");
            // 
            // grpDSResults
            // 
            this.grpDSResults.Controls.Add(this.lblDSResults);
            this.grpDSResults.Controls.Add(this.chtPayBack);
            this.grpDSResults.Location = new System.Drawing.Point(6, 234);
            this.grpDSResults.Name = "grpDSResults";
            this.grpDSResults.Size = new System.Drawing.Size(600, 222);
            this.grpDSResults.TabIndex = 4;
            this.grpDSResults.TabStop = false;
            this.grpDSResults.Text = "Results";
            // 
            // lblDSResults
            // 
            this.lblDSResults.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblDSResults.Location = new System.Drawing.Point(6, 19);
            this.lblDSResults.Margin = new System.Windows.Forms.Padding(0);
            this.lblDSResults.Name = "lblDSResults";
            this.lblDSResults.Size = new System.Drawing.Size(277, 197);
            this.lblDSResults.TabIndex = 39;
            // 
            // chtPayBack
            // 
            chartArea2.Name = "ChartArea1";
            this.chtPayBack.ChartAreas.Add(chartArea2);
            this.chtPayBack.Location = new System.Drawing.Point(289, 19);
            this.chtPayBack.Name = "chtPayBack";
            series2.ChartArea = "ChartArea1";
            series2.Name = "srsMonthValues";
            this.chtPayBack.Series.Add(series2);
            this.chtPayBack.Size = new System.Drawing.Size(305, 197);
            this.chtPayBack.TabIndex = 0;
            this.chtPayBack.Visible = false;
            // 
            // grpDSInput
            // 
            this.grpDSInput.Controls.Add(this.txtReplacePercent);
            this.grpDSInput.Controls.Add(this.lblReplacePercent);
            this.grpDSInput.Controls.Add(this.txtDailyGeneration);
            this.grpDSInput.Controls.Add(this.lblDailyGeneration);
            this.grpDSInput.Controls.Add(this.txtSystemCost);
            this.grpDSInput.Controls.Add(this.lblSystemCost);
            this.grpDSInput.Controls.Add(this.lblDSError);
            this.grpDSInput.Controls.Add(this.txtLifeSpan);
            this.grpDSInput.Controls.Add(this.txtDSAgingEff);
            this.grpDSInput.Controls.Add(this.lblLifeSpan);
            this.grpDSInput.Controls.Add(this.lblDSAgingEff);
            this.grpDSInput.Controls.Add(this.txtDailyConsumption);
            this.grpDSInput.Controls.Add(this.lblDailyConsumption);
            this.grpDSInput.Controls.Add(this.lblDSCity);
            this.grpDSInput.Controls.Add(this.cboDSCity);
            this.grpDSInput.Controls.Add(this.btnDSReset);
            this.grpDSInput.Controls.Add(this.btnDSCalculate);
            this.grpDSInput.Location = new System.Drawing.Point(6, 6);
            this.grpDSInput.Name = "grpDSInput";
            this.grpDSInput.Size = new System.Drawing.Size(600, 222);
            this.grpDSInput.TabIndex = 3;
            this.grpDSInput.TabStop = false;
            this.grpDSInput.Text = "Input";
            // 
            // txtReplacePercent
            // 
            this.txtReplacePercent.Location = new System.Drawing.Point(377, 103);
            this.txtReplacePercent.Name = "txtReplacePercent";
            this.txtReplacePercent.Size = new System.Drawing.Size(100, 20);
            this.txtReplacePercent.TabIndex = 44;
            this.txtReplacePercent.TextChanged += new System.EventHandler(this.txtReplacePercent_TextChanged);
            // 
            // lblReplacePercent
            // 
            this.lblReplacePercent.Location = new System.Drawing.Point(254, 76);
            this.lblReplacePercent.Margin = new System.Windows.Forms.Padding(0);
            this.lblReplacePercent.Name = "lblReplacePercent";
            this.lblReplacePercent.Size = new System.Drawing.Size(223, 47);
            this.lblReplacePercent.TabIndex = 43;
            this.lblReplacePercent.Text = "Power Generated that is used back in the home (%)";
            // 
            // txtDailyGeneration
            // 
            this.txtDailyGeneration.Location = new System.Drawing.Point(141, 73);
            this.txtDailyGeneration.Name = "txtDailyGeneration";
            this.txtDailyGeneration.Size = new System.Drawing.Size(100, 20);
            this.txtDailyGeneration.TabIndex = 42;
            this.txtDailyGeneration.TextChanged += new System.EventHandler(this.txtDailyGeneration_TextChanged);
            // 
            // lblDailyGeneration
            // 
            this.lblDailyGeneration.Location = new System.Drawing.Point(6, 76);
            this.lblDailyGeneration.Margin = new System.Windows.Forms.Padding(0);
            this.lblDailyGeneration.Name = "lblDailyGeneration";
            this.lblDailyGeneration.Size = new System.Drawing.Size(132, 30);
            this.lblDailyGeneration.TabIndex = 41;
            this.lblDailyGeneration.Text = "Daily Generation (kWh)";
            // 
            // txtSystemCost
            // 
            this.txtSystemCost.Location = new System.Drawing.Point(141, 43);
            this.txtSystemCost.Name = "txtSystemCost";
            this.txtSystemCost.Size = new System.Drawing.Size(100, 20);
            this.txtSystemCost.TabIndex = 38;
            this.txtSystemCost.TextChanged += new System.EventHandler(this.txtSystemCost_TextChanged);
            // 
            // lblSystemCost
            // 
            this.lblSystemCost.Location = new System.Drawing.Point(6, 46);
            this.lblSystemCost.Margin = new System.Windows.Forms.Padding(0);
            this.lblSystemCost.Name = "lblSystemCost";
            this.lblSystemCost.Size = new System.Drawing.Size(132, 30);
            this.lblSystemCost.TabIndex = 37;
            this.lblSystemCost.Text = "System Cost ($)";
            // 
            // lblDSError
            // 
            this.lblDSError.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblDSError.ForeColor = System.Drawing.Color.Red;
            this.lblDSError.Location = new System.Drawing.Point(6, 169);
            this.lblDSError.Name = "lblDSError";
            this.lblDSError.Size = new System.Drawing.Size(588, 21);
            this.lblDSError.TabIndex = 17;
            // 
            // txtLifeSpan
            // 
            this.txtLifeSpan.Location = new System.Drawing.Point(377, 43);
            this.txtLifeSpan.Name = "txtLifeSpan";
            this.txtLifeSpan.Size = new System.Drawing.Size(100, 20);
            this.txtLifeSpan.TabIndex = 35;
            this.txtLifeSpan.TextChanged += new System.EventHandler(this.txtLifeSpan_TextChanged);
            // 
            // txtDSAgingEff
            // 
            this.txtDSAgingEff.Location = new System.Drawing.Point(377, 13);
            this.txtDSAgingEff.Name = "txtDSAgingEff";
            this.txtDSAgingEff.Size = new System.Drawing.Size(100, 20);
            this.txtDSAgingEff.TabIndex = 34;
            this.txtDSAgingEff.TextChanged += new System.EventHandler(this.txtDSAgingEff_TextChanged);
            // 
            // lblLifeSpan
            // 
            this.lblLifeSpan.Location = new System.Drawing.Point(254, 46);
            this.lblLifeSpan.Margin = new System.Windows.Forms.Padding(0);
            this.lblLifeSpan.Name = "lblLifeSpan";
            this.lblLifeSpan.Size = new System.Drawing.Size(120, 30);
            this.lblLifeSpan.TabIndex = 30;
            this.lblLifeSpan.Text = "Life Span (yrs)";
            // 
            // lblDSAgingEff
            // 
            this.lblDSAgingEff.Location = new System.Drawing.Point(254, 16);
            this.lblDSAgingEff.Margin = new System.Windows.Forms.Padding(0);
            this.lblDSAgingEff.Name = "lblDSAgingEff";
            this.lblDSAgingEff.Size = new System.Drawing.Size(120, 30);
            this.lblDSAgingEff.TabIndex = 29;
            this.lblDSAgingEff.Text = "Aging Efficiency (%)";
            // 
            // txtDailyConsumption
            // 
            this.txtDailyConsumption.Location = new System.Drawing.Point(141, 103);
            this.txtDailyConsumption.Name = "txtDailyConsumption";
            this.txtDailyConsumption.Size = new System.Drawing.Size(100, 20);
            this.txtDailyConsumption.TabIndex = 28;
            this.txtDailyConsumption.TextChanged += new System.EventHandler(this.txtDailyConsumption_TextChanged);
            // 
            // lblDailyConsumption
            // 
            this.lblDailyConsumption.Location = new System.Drawing.Point(6, 106);
            this.lblDailyConsumption.Margin = new System.Windows.Forms.Padding(0);
            this.lblDailyConsumption.Name = "lblDailyConsumption";
            this.lblDailyConsumption.Size = new System.Drawing.Size(132, 30);
            this.lblDailyConsumption.TabIndex = 25;
            this.lblDailyConsumption.Text = "Daily Consumption (kWh)";
            // 
            // lblDSCity
            // 
            this.lblDSCity.Location = new System.Drawing.Point(6, 16);
            this.lblDSCity.Margin = new System.Windows.Forms.Padding(0);
            this.lblDSCity.Name = "lblDSCity";
            this.lblDSCity.Size = new System.Drawing.Size(132, 30);
            this.lblDSCity.TabIndex = 22;
            this.lblDSCity.Text = "City";
            // 
            // cboDSCity
            // 
            this.cboDSCity.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cboDSCity.FormattingEnabled = true;
            this.cboDSCity.Location = new System.Drawing.Point(141, 13);
            this.cboDSCity.Name = "cboDSCity";
            this.cboDSCity.Size = new System.Drawing.Size(100, 21);
            this.cboDSCity.TabIndex = 20;
            this.cboDSCity.SelectedIndexChanged += new System.EventHandler(this.cboDSCity_SelectedIndexChanged);
            // 
            // btnDSReset
            // 
            this.btnDSReset.Location = new System.Drawing.Point(289, 193);
            this.btnDSReset.Name = "btnDSReset";
            this.btnDSReset.Size = new System.Drawing.Size(75, 23);
            this.btnDSReset.TabIndex = 16;
            this.btnDSReset.Text = "Reset";
            this.btnDSReset.UseVisualStyleBackColor = true;
            this.btnDSReset.Click += new System.EventHandler(this.btnDSReset_Click);
            // 
            // btnDSCalculate
            // 
            this.btnDSCalculate.Location = new System.Drawing.Point(208, 193);
            this.btnDSCalculate.Name = "btnDSCalculate";
            this.btnDSCalculate.Size = new System.Drawing.Size(75, 23);
            this.btnDSCalculate.TabIndex = 15;
            this.btnDSCalculate.Text = "Calculate";
            this.btnDSCalculate.UseVisualStyleBackColor = true;
            this.btnDSCalculate.Click += new System.EventHandler(this.btnDSCalculate_Click);
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
            this.grpPGInstructions.ResumeLayout(false);
            this.grpPGResults.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.chtMonthlyPowerGenerated)).EndInit();
            this.grpPGInput.ResumeLayout(false);
            this.grpPGInput.PerformLayout();
            this.tabConsumption.ResumeLayout(false);
            this.grpPCInstructions.ResumeLayout(false);
            this.grpPCResults.ResumeLayout(false);
            this.grpPCInput.ResumeLayout(false);
            this.grpPCInput.PerformLayout();
            this.tabSavings.ResumeLayout(false);
            this.grpDSInstructions.ResumeLayout(false);
            this.grpDSResults.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.chtPayBack)).EndInit();
            this.grpDSInput.ResumeLayout(false);
            this.grpDSInput.PerformLayout();
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
        private System.Windows.Forms.GroupBox grpPGInstructions;
        private System.Windows.Forms.GroupBox grpPGResults;
        private System.Windows.Forms.GroupBox grpPGInput;
        private System.Windows.Forms.Label lblPGError;
        private System.Windows.Forms.Button btnPGReset;
        private System.Windows.Forms.Button btnPGCalculate;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem fileToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem serverStringToolStripMenuItem;
        private System.Windows.Forms.TextBox txtPGAgingEff;
        private System.Windows.Forms.TextBox txtWiringEff;
        private System.Windows.Forms.TextBox txtInverterEff;
        private System.Windows.Forms.TextBox txtRoofEff;
        private System.Windows.Forms.Label lblPGAgingEff;
        private System.Windows.Forms.Label lblWiringEff;
        private System.Windows.Forms.Label lblInverterEff;
        private System.Windows.Forms.Label lblRoofEff;
        private System.Windows.Forms.TextBox txtSystemSize;
        private System.Windows.Forms.ComboBox cboRoofAngle;
        private System.Windows.Forms.ComboBox cboRoofDirection;
        private System.Windows.Forms.Label lblSystemSize;
        private System.Windows.Forms.Label lblRoofAngle;
        private System.Windows.Forms.Label lblRoofDirection;
        private System.Windows.Forms.Label lblPGCity;
        private System.Windows.Forms.ComboBox cboPGCity;
        private System.Windows.Forms.DataVisualization.Charting.Chart chtMonthlyPowerGenerated;
        private System.Windows.Forms.Label lblPGResults;
        private System.Windows.Forms.Label lblPGInstructions;
        private System.Windows.Forms.GroupBox grpPCInstructions;
        private System.Windows.Forms.Label lblPCInstructions;
        private System.Windows.Forms.GroupBox grpPCResults;
        private System.Windows.Forms.Label lblPCResults;
        private System.Windows.Forms.GroupBox grpPCInput;
        private System.Windows.Forms.Label lblPCError;
        private System.Windows.Forms.TextBox txtHouseholdSize;
        private System.Windows.Forms.Label lblHouseholdSize;
        private System.Windows.Forms.Label lblUsageType;
        private System.Windows.Forms.ComboBox cboUsageType;
        private System.Windows.Forms.Button btnPCReset;
        private System.Windows.Forms.Button btnPCCalculate;
        private System.Windows.Forms.GroupBox grpDSInstructions;
        private System.Windows.Forms.Label lblDSInstructions;
        private System.Windows.Forms.GroupBox grpDSResults;
        private System.Windows.Forms.Label lblDSResults;
        private System.Windows.Forms.DataVisualization.Charting.Chart chtPayBack;
        private System.Windows.Forms.GroupBox grpDSInput;
        private System.Windows.Forms.Label lblDSError;
        private System.Windows.Forms.TextBox txtLifeSpan;
        private System.Windows.Forms.TextBox txtDSAgingEff;
        private System.Windows.Forms.Label lblLifeSpan;
        private System.Windows.Forms.Label lblDSAgingEff;
        private System.Windows.Forms.TextBox txtDailyConsumption;
        private System.Windows.Forms.Label lblDailyConsumption;
        private System.Windows.Forms.Label lblDSCity;
        private System.Windows.Forms.ComboBox cboDSCity;
        private System.Windows.Forms.Button btnDSReset;
        private System.Windows.Forms.Button btnDSCalculate;
        private System.Windows.Forms.TextBox txtDailyGeneration;
        private System.Windows.Forms.Label lblDailyGeneration;
        private System.Windows.Forms.TextBox txtSystemCost;
        private System.Windows.Forms.Label lblSystemCost;
        private System.Windows.Forms.TextBox txtReplacePercent;
        private System.Windows.Forms.Label lblReplacePercent;
    }
}

