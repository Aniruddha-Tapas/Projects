using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Drawing.Imaging;
using System.IO;
using System.Diagnostics;

namespace TimeSnap
{
    public partial class TimeSnap : Form
    {
        public TimeSnap()
        {
            InitializeComponent();
        }

        string SavePath, FileFormat;
        int SnapInterval, JPGCompress;
        bool AutoSnap, StartMinimized, recording;

        private void MainForm_Load(object sender, EventArgs e)
        {
            load_settings();
            if (AutoSnap) start_snap();
        }

        private void TimeSnap_Shown(object sender, EventArgs e)
        {
            if (StartMinimized)
            {
                this.Visible = false;
                this.WindowState = FormWindowState.Minimized;
            }
        }

        private void start_snap()
        {
            timer1.Start();
            recording = true;
            this.Text = "TimeSnap - Recording";
            notifyIcon1.Text = "TimeSnap - Recording";
        }

        private void load_settings()
        {
            System.Reflection.Assembly exe = System.Reflection.Assembly.GetEntryAssembly();
            string exePath = System.IO.Path.GetDirectoryName(exe.Location);
            IniFile ini = new IniFile(exePath + "\\settings.ini");

            AutoSnap = ini.IniReadValue("basic", "AutoSnap") == "1" ? true : false;
            StartMinimized = ini.IniReadValue("basic", "StartMinimized") == "1" ? true : false;
            SnapInterval = int.Parse(ini.IniReadValue("basic", "SnapInterval"));
            SavePath = ini.IniReadValue("basic", "SavePath");
            FileFormat = ini.IniReadValue("basic", "FileFormat");
            JPGCompress = int.Parse(ini.IniReadValue("basic", "JPGCompress"));

            checkBox_autosnap.Checked = AutoSnap;
            checkBox_startmin.Checked = StartMinimized;
            timer1.Interval = SnapInterval;
            numericUpDown_snapint.Value = SnapInterval;
            textBox_savepath.Text = SavePath;
            folderBrowserDialog1.SelectedPath = SavePath;
            comboBox_saveformat.SelectedItem = FileFormat;
            numericUpDown_jpgcomp.Value = JPGCompress;

            btn_apply.Enabled = false;
        }

        private static ImageCodecInfo GetEncoderInfo(String mimeType)
        {
            int j;
            ImageCodecInfo[] encoders;
            encoders = ImageCodecInfo.GetImageEncoders();
            for (j = 0; j < encoders.Length; ++j)
            {
                if (encoders[j].MimeType == mimeType)
                    return encoders[j];
            }
            return null;
        }

        private void SaveJPGWithCompressionSetting(Image image, string szFileName, long lCompression)
        {
            EncoderParameters eps = new EncoderParameters(1);
            eps.Param[0] = new EncoderParameter(System.Drawing.Imaging.Encoder.Quality, lCompression);
            ImageCodecInfo ici = GetEncoderInfo("image/jpeg");
            MemoryStream tmp = new MemoryStream();
            image.Save(tmp, ici, eps);
            FileStream file = new FileStream(szFileName, FileMode.Create, System.IO.FileAccess.Write);
            tmp.WriteTo(file);
            file.Close();
        }


        private void timer1_Tick(object sender, EventArgs e)
        {
            Bitmap myImage = new Bitmap(Screen.PrimaryScreen.Bounds.Width, Screen.PrimaryScreen.Bounds.Height);
            Graphics g = Graphics.FromImage(myImage);
            try
            {
                g.CopyFromScreen(new Point(0, 0), new Point(0, 0), new Size(Screen.PrimaryScreen.Bounds.Width, Screen.PrimaryScreen.Bounds.Height));
                IntPtr dc1 = g.GetHdc();
                g.ReleaseHdc(dc1);
                DateTime CurrTime = DateTime.Now;
                string path = SavePath + @"\" + CurrTime.ToString("yyyy-MM-dd") + @"\";
                try
                {
                    if (!Directory.Exists(path)) { DirectoryInfo di = Directory.CreateDirectory(path); }
                    return;
                }
                finally
                {
                    string filename = path + CurrTime.ToString("yyyy-MM-dd HH mm ss");
                    switch (FileFormat)
                    {
                        case "JPG":
                            filename += ".jpg";
                            SaveJPGWithCompressionSetting(myImage, filename, JPGCompress);
                            break;
                        case "PNG":
                            filename += ".png";
                            myImage.Save(filename, ImageFormat.Png);
                            break;
                        case "BMP":
                            filename += ".bmp";
                            myImage.Save(filename, ImageFormat.Bmp);
                            break;
                    }
                    pictureBox1.Image = myImage;
                    label_latestfile.Text = filename;

                    GC.Collect();
                }
            }
            catch { }
            
        }

        private void toolStripMenuItem2_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void toolStripMenuItem1_Click(object sender, EventArgs e)
        {
            if (recording == true)
            {
                timer1.Stop();
                recording = false;
                this.Text = "TimeSnap - Paused";
                notifyIcon1.Text = "TimeSnap - Paused";
                toolStripMenuItem1.Text = "&Record";
            }
            else if (recording == false)
            {
                timer1.Start();
                recording = true;
                this.Text = "TimeSnap - Recording";
                notifyIcon1.Text = "TimeSnap - Recording";
                toolStripMenuItem1.Text = "&Pause";
            }
        }

        private void notifyIcon1_MouseUp(object sender, MouseEventArgs e)
        {
            if (e.Button == MouseButtons.Left)
            {
                if (this.Visible == true)
                {
                    this.Visible = false;
                    this.WindowState = FormWindowState.Minimized;
                }
                else
                {
                    this.Visible = true;
                    this.WindowState = FormWindowState.Normal;
                }
            }
        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {
            if (label_latestfile.Text != "")
            {
                System.Diagnostics.ProcessStartInfo PSI = new System.Diagnostics.ProcessStartInfo();
                PSI.FileName = label_latestfile.Text;
                System.Diagnostics.Process.Start(PSI);
            }
        }

        private void btn_apply_Click(object sender, EventArgs e)
        {
            System.Reflection.Assembly exe = System.Reflection.Assembly.GetEntryAssembly();
            string exePath = System.IO.Path.GetDirectoryName(exe.Location);
            IniFile ini = new IniFile(exePath + "\\settings.ini");
            
            if (checkBox_autosnap.Checked) ini.IniWriteValue("basic", "AutoSnap", "1");
            else ini.IniWriteValue("basic", "AutoSnap", "0");
            if (checkBox_startmin.Checked) ini.IniWriteValue("basic", "StartMinimized", "1");
            else ini.IniWriteValue("basic", "StartMinimized", "0");
            ini.IniWriteValue("basic", "SnapInterval", numericUpDown_snapint.Value.ToString());
            ini.IniWriteValue("basic", "SavePath", textBox_savepath.Text);
            ini.IniWriteValue("basic", "FileFormat", comboBox_saveformat.SelectedItem.ToString());
            ini.IniWriteValue("basic", "JPGCompress", numericUpDown_jpgcomp.Value.ToString());

            load_settings();
        }

        private void btn_browse_Click(object sender, EventArgs e)
        {
            DialogResult result = folderBrowserDialog1.ShowDialog();
            if (result == System.Windows.Forms.DialogResult.OK)
            {
                textBox_savepath.Text = folderBrowserDialog1.SelectedPath;
            }
        }

        private void checkBox_autosnap_CheckedChanged(object sender, EventArgs e)
        {
            btn_apply.Enabled = true;
        }

        private void numericUpDown_snapint_ValueChanged(object sender, EventArgs e)
        {
            btn_apply.Enabled = true;
        }

        private void textBox_savepath_TextChanged(object sender, EventArgs e)
        {
            btn_apply.Enabled = true;
        }

        private void comboBox_saveformat_SelectedIndexChanged(object sender, EventArgs e)
        {
            btn_apply.Enabled = true;
        }

        private void numericUpDown_jpgcomp_ValueChanged(object sender, EventArgs e)
        {
            btn_apply.Enabled = true;
        }

        private void TimeSnap_Resize(object sender, EventArgs e)
        {
            if (this.WindowState == FormWindowState.Minimized) { this.Visible = false; }
        }

        private void checkBox_startmin_CheckedChanged(object sender, EventArgs e)
        {
            btn_apply.Enabled = true;
        }
    }
}
