namespace TimeSnap
{
    partial class TimeSnap
    {
        /// <summary>
        /// 設計工具所需的變數。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 清除任何使用中的資源。
        /// </summary>
        /// <param name="disposing">如果應該處置 Managed 資源則為 true，否則為 false。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form 設計工具產生的程式碼

        /// <summary>
        /// 此為設計工具支援所需的方法 - 請勿使用程式碼編輯器修改這個方法的內容。
        ///
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(TimeSnap));
            this.timer1 = new System.Windows.Forms.Timer(this.components);
            this.notifyIcon1 = new System.Windows.Forms.NotifyIcon(this.components);
            this.contextMenuStrip1 = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.toolStripMenuItem1 = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripMenuItem2 = new System.Windows.Forms.ToolStripMenuItem();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.splitContainer1 = new System.Windows.Forms.SplitContainer();
            this.label_latestfile = new System.Windows.Forms.Label();
            this.checkBox_startmin = new System.Windows.Forms.CheckBox();
            this.label4 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.btn_browse = new System.Windows.Forms.Button();
            this.numericUpDown_snapint = new System.Windows.Forms.NumericUpDown();
            this.numericUpDown_jpgcomp = new System.Windows.Forms.NumericUpDown();
            this.comboBox_saveformat = new System.Windows.Forms.ComboBox();
            this.textBox_savepath = new System.Windows.Forms.TextBox();
            this.checkBox_autosnap = new System.Windows.Forms.CheckBox();
            this.btn_apply = new System.Windows.Forms.Button();
            this.folderBrowserDialog1 = new System.Windows.Forms.FolderBrowserDialog();
            this.contextMenuStrip1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.splitContainer1.Panel1.SuspendLayout();
            this.splitContainer1.Panel2.SuspendLayout();
            this.splitContainer1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown_snapint)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown_jpgcomp)).BeginInit();
            this.SuspendLayout();
            // 
            // timer1
            // 
            this.timer1.Interval = 2000;
            this.timer1.Tick += new System.EventHandler(this.timer1_Tick);
            // 
            // notifyIcon1
            // 
            this.notifyIcon1.ContextMenuStrip = this.contextMenuStrip1;
            this.notifyIcon1.Icon = ((System.Drawing.Icon)(resources.GetObject("notifyIcon1.Icon")));
            this.notifyIcon1.Text = "TimeSnap";
            this.notifyIcon1.Visible = true;
            this.notifyIcon1.MouseUp += new System.Windows.Forms.MouseEventHandler(this.notifyIcon1_MouseUp);
            // 
            // contextMenuStrip1
            // 
            this.contextMenuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolStripMenuItem1,
            this.toolStripMenuItem2});
            this.contextMenuStrip1.Name = "contextMenuStrip1";
            this.contextMenuStrip1.Size = new System.Drawing.Size(153, 70);
            this.contextMenuStrip1.Text = "123";
            // 
            // toolStripMenuItem1
            // 
            this.toolStripMenuItem1.Name = "toolStripMenuItem1";
            this.toolStripMenuItem1.Size = new System.Drawing.Size(152, 22);
            this.toolStripMenuItem1.Text = "&Pause";
            this.toolStripMenuItem1.Click += new System.EventHandler(this.toolStripMenuItem1_Click);
            // 
            // toolStripMenuItem2
            // 
            this.toolStripMenuItem2.Name = "toolStripMenuItem2";
            this.toolStripMenuItem2.Size = new System.Drawing.Size(152, 22);
            this.toolStripMenuItem2.Text = "&Exit";
            this.toolStripMenuItem2.Click += new System.EventHandler(this.toolStripMenuItem2_Click);
            // 
            // pictureBox1
            // 
            this.pictureBox1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.pictureBox1.Location = new System.Drawing.Point(0, 0);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(533, 560);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBox1.TabIndex = 1;
            this.pictureBox1.TabStop = false;
            this.pictureBox1.Click += new System.EventHandler(this.pictureBox1_Click);
            // 
            // splitContainer1
            // 
            this.splitContainer1.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.splitContainer1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.splitContainer1.FixedPanel = System.Windows.Forms.FixedPanel.Panel2;
            this.splitContainer1.Location = new System.Drawing.Point(0, 0);
            this.splitContainer1.Name = "splitContainer1";
            // 
            // splitContainer1.Panel1
            // 
            this.splitContainer1.Panel1.Controls.Add(this.label_latestfile);
            this.splitContainer1.Panel1.Controls.Add(this.pictureBox1);
            // 
            // splitContainer1.Panel2
            // 
            this.splitContainer1.Panel2.Controls.Add(this.checkBox_startmin);
            this.splitContainer1.Panel2.Controls.Add(this.label4);
            this.splitContainer1.Panel2.Controls.Add(this.label3);
            this.splitContainer1.Panel2.Controls.Add(this.label2);
            this.splitContainer1.Panel2.Controls.Add(this.label1);
            this.splitContainer1.Panel2.Controls.Add(this.btn_browse);
            this.splitContainer1.Panel2.Controls.Add(this.numericUpDown_snapint);
            this.splitContainer1.Panel2.Controls.Add(this.numericUpDown_jpgcomp);
            this.splitContainer1.Panel2.Controls.Add(this.comboBox_saveformat);
            this.splitContainer1.Panel2.Controls.Add(this.textBox_savepath);
            this.splitContainer1.Panel2.Controls.Add(this.checkBox_autosnap);
            this.splitContainer1.Panel2.Controls.Add(this.btn_apply);
            this.splitContainer1.Size = new System.Drawing.Size(784, 562);
            this.splitContainer1.SplitterDistance = 535;
            this.splitContainer1.TabIndex = 2;
            // 
            // label_latestfile
            // 
            this.label_latestfile.AutoSize = true;
            this.label_latestfile.Font = new System.Drawing.Font("微軟正黑體", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(136)));
            this.label_latestfile.Location = new System.Drawing.Point(3, 3);
            this.label_latestfile.Name = "label_latestfile";
            this.label_latestfile.Size = new System.Drawing.Size(0, 16);
            this.label_latestfile.TabIndex = 2;
            // 
            // checkBox_startmin
            // 
            this.checkBox_startmin.AutoSize = true;
            this.checkBox_startmin.Font = new System.Drawing.Font("微軟正黑體", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(136)));
            this.checkBox_startmin.Location = new System.Drawing.Point(3, 252);
            this.checkBox_startmin.Name = "checkBox_startmin";
            this.checkBox_startmin.Size = new System.Drawing.Size(116, 20);
            this.checkBox_startmin.TabIndex = 12;
            this.checkBox_startmin.Text = "Start Minimized";
            this.checkBox_startmin.UseVisualStyleBackColor = true;
            this.checkBox_startmin.CheckedChanged += new System.EventHandler(this.checkBox_startmin_CheckedChanged);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("微軟正黑體", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(136)));
            this.label4.Location = new System.Drawing.Point(3, 198);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(72, 16);
            this.label4.TabIndex = 11;
            this.label4.Text = "JPG Quality";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("微軟正黑體", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(136)));
            this.label3.Location = new System.Drawing.Point(3, 142);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(70, 16);
            this.label3.TabIndex = 10;
            this.label3.Text = "File Format";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("微軟正黑體", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(136)));
            this.label2.Location = new System.Drawing.Point(3, 78);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(87, 16);
            this.label2.TabIndex = 9;
            this.label2.Text = "Save Location";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("微軟正黑體", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(136)));
            this.label1.Location = new System.Drawing.Point(3, 35);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(108, 16);
            this.label1.TabIndex = 8;
            this.label1.Text = "Snap Interval (ms)";
            // 
            // btn_browse
            // 
            this.btn_browse.Font = new System.Drawing.Font("微軟正黑體", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(136)));
            this.btn_browse.Location = new System.Drawing.Point(167, 97);
            this.btn_browse.Name = "btn_browse";
            this.btn_browse.Size = new System.Drawing.Size(63, 23);
            this.btn_browse.TabIndex = 7;
            this.btn_browse.Text = "Browse";
            this.btn_browse.UseVisualStyleBackColor = true;
            this.btn_browse.Click += new System.EventHandler(this.btn_browse_Click);
            // 
            // numericUpDown_snapint
            // 
            this.numericUpDown_snapint.Font = new System.Drawing.Font("微軟正黑體", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(136)));
            this.numericUpDown_snapint.Increment = new decimal(new int[] {
            1000,
            0,
            0,
            0});
            this.numericUpDown_snapint.Location = new System.Drawing.Point(117, 33);
            this.numericUpDown_snapint.Maximum = new decimal(new int[] {
            86400000,
            0,
            0,
            0});
            this.numericUpDown_snapint.Minimum = new decimal(new int[] {
            100,
            0,
            0,
            0});
            this.numericUpDown_snapint.Name = "numericUpDown_snapint";
            this.numericUpDown_snapint.Size = new System.Drawing.Size(60, 23);
            this.numericUpDown_snapint.TabIndex = 6;
            this.numericUpDown_snapint.Value = new decimal(new int[] {
            60000,
            0,
            0,
            0});
            this.numericUpDown_snapint.ValueChanged += new System.EventHandler(this.numericUpDown_snapint_ValueChanged);
            // 
            // numericUpDown_jpgcomp
            // 
            this.numericUpDown_jpgcomp.Font = new System.Drawing.Font("微軟正黑體", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(136)));
            this.numericUpDown_jpgcomp.Location = new System.Drawing.Point(117, 196);
            this.numericUpDown_jpgcomp.Minimum = new decimal(new int[] {
            1,
            0,
            0,
            0});
            this.numericUpDown_jpgcomp.Name = "numericUpDown_jpgcomp";
            this.numericUpDown_jpgcomp.Size = new System.Drawing.Size(60, 23);
            this.numericUpDown_jpgcomp.TabIndex = 5;
            this.numericUpDown_jpgcomp.Value = new decimal(new int[] {
            90,
            0,
            0,
            0});
            this.numericUpDown_jpgcomp.ValueChanged += new System.EventHandler(this.numericUpDown_jpgcomp_ValueChanged);
            // 
            // comboBox_saveformat
            // 
            this.comboBox_saveformat.Font = new System.Drawing.Font("微軟正黑體", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(136)));
            this.comboBox_saveformat.FormattingEnabled = true;
            this.comboBox_saveformat.Items.AddRange(new object[] {
            "JPG",
            "PNG",
            "BMP"});
            this.comboBox_saveformat.Location = new System.Drawing.Point(117, 139);
            this.comboBox_saveformat.Name = "comboBox_saveformat";
            this.comboBox_saveformat.Size = new System.Drawing.Size(60, 24);
            this.comboBox_saveformat.TabIndex = 3;
            this.comboBox_saveformat.SelectedIndexChanged += new System.EventHandler(this.comboBox_saveformat_SelectedIndexChanged);
            // 
            // textBox_savepath
            // 
            this.textBox_savepath.Font = new System.Drawing.Font("微軟正黑體", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(136)));
            this.textBox_savepath.Location = new System.Drawing.Point(3, 97);
            this.textBox_savepath.Name = "textBox_savepath";
            this.textBox_savepath.Size = new System.Drawing.Size(158, 23);
            this.textBox_savepath.TabIndex = 2;
            this.textBox_savepath.TextChanged += new System.EventHandler(this.textBox_savepath_TextChanged);
            // 
            // checkBox_autosnap
            // 
            this.checkBox_autosnap.AutoSize = true;
            this.checkBox_autosnap.Font = new System.Drawing.Font("微軟正黑體", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(136)));
            this.checkBox_autosnap.Location = new System.Drawing.Point(3, 3);
            this.checkBox_autosnap.Name = "checkBox_autosnap";
            this.checkBox_autosnap.Size = new System.Drawing.Size(227, 20);
            this.checkBox_autosnap.TabIndex = 1;
            this.checkBox_autosnap.Text = "Start snapping when program starts";
            this.checkBox_autosnap.UseVisualStyleBackColor = true;
            this.checkBox_autosnap.CheckedChanged += new System.EventHandler(this.checkBox_autosnap_CheckedChanged);
            // 
            // btn_apply
            // 
            this.btn_apply.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
            this.btn_apply.Enabled = false;
            this.btn_apply.Font = new System.Drawing.Font("微軟正黑體", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(136)));
            this.btn_apply.Location = new System.Drawing.Point(165, 534);
            this.btn_apply.Name = "btn_apply";
            this.btn_apply.Size = new System.Drawing.Size(75, 23);
            this.btn_apply.TabIndex = 0;
            this.btn_apply.Text = "Apply";
            this.btn_apply.UseVisualStyleBackColor = true;
            this.btn_apply.Click += new System.EventHandler(this.btn_apply_Click);
            // 
            // TimeSnap
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(784, 562);
            this.Controls.Add(this.splitContainer1);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MinimumSize = new System.Drawing.Size(600, 400);
            this.Name = "TimeSnap";
            this.Text = "TimeSnap";
            this.Load += new System.EventHandler(this.MainForm_Load);
            this.Shown += new System.EventHandler(this.TimeSnap_Shown);
            this.Resize += new System.EventHandler(this.TimeSnap_Resize);
            this.contextMenuStrip1.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.splitContainer1.Panel1.ResumeLayout(false);
            this.splitContainer1.Panel1.PerformLayout();
            this.splitContainer1.Panel2.ResumeLayout(false);
            this.splitContainer1.Panel2.PerformLayout();
            this.splitContainer1.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown_snapint)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown_jpgcomp)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Timer timer1;
        private System.Windows.Forms.NotifyIcon notifyIcon1;
        private System.Windows.Forms.ContextMenuStrip contextMenuStrip1;
        private System.Windows.Forms.ToolStripMenuItem toolStripMenuItem1;
        private System.Windows.Forms.ToolStripMenuItem toolStripMenuItem2;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.SplitContainer splitContainer1;
        private System.Windows.Forms.Button btn_apply;
        private System.Windows.Forms.CheckBox checkBox_autosnap;
        private System.Windows.Forms.ComboBox comboBox_saveformat;
        private System.Windows.Forms.TextBox textBox_savepath;
        private System.Windows.Forms.NumericUpDown numericUpDown_snapint;
        private System.Windows.Forms.NumericUpDown numericUpDown_jpgcomp;
        private System.Windows.Forms.Button btn_browse;
        private System.Windows.Forms.FolderBrowserDialog folderBrowserDialog1;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label_latestfile;
        private System.Windows.Forms.CheckBox checkBox_startmin;
    }
}

