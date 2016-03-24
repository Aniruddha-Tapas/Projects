using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Security.Cryptography;
using System.IO;

namespace CaptchaGenerator
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        List<string> Strings = new List<string>();

        private void button2_Click(object sender, EventArgs e)
        {
            Image[] images = GenerateCaptchas(Convert.ToInt32(textBox1.Text));
            int g = 0;
            foreach (Image image in images)
            {
                image.Save(label1.Text + "\\" + Strings[g] + ".png");
                g++;
            }
        }

        Image[] GenerateCaptchas(int amount)
        {
            Image[] images = new Image[amount];
            Random ran = new Random();
            for (int z = 0; z < amount; z++)
            {
                Bitmap bitmap = new Bitmap(panel1.Width, panel1.Height);
                Graphics g = Graphics.FromImage(bitmap);
                //Graphics g = panel1.CreateGraphics();
                g.Clear(panel1.BackColor);
                SolidBrush b = new SolidBrush(Color.FromArgb(0xFF, ran.Next(0, 255), ran.Next(0, 255), ran.Next(0, 255)));
                Pen p = new Pen(Color.FromArgb(0xFF, ran.Next(0, 255), ran.Next(0, 255), ran.Next(0, 255)));
                char[] chars = "qwertyuiopasdfghjklzxcvbnm1234567890".ToCharArray();
                string randomString = "";
                for (int i = 0; i < 6; i++)
                {
                    randomString += chars[ran.Next(0, 35)];
                }

                byte[] buffer = new byte[randomString.Length];
                int y = 0;
                foreach (char c in randomString.ToCharArray())
                {
                    buffer[y] = (byte)c;
                    y++;
                }
                MD5CryptoServiceProvider md5 = new MD5CryptoServiceProvider();
                string md5string = BitConverter.ToString(md5.ComputeHash(buffer)).Replace("-", "");
                Strings.Add(md5string);

                FontFamily ff = new FontFamily("Arial");
                Font f = new System.Drawing.Font(ff, 14);
                g.DrawString(randomString, f, b, 30, 60);
                for (int i = 0; i < 6; i++)
                {
                    int j = ran.Next(0, 2);
                    if (j == 0)
                        g.DrawRectangle(p, ran.Next(0, 111), ran.Next(0, 60), ran.Next(0, 111), ran.Next(0, 60));
                    else if (j == 1)
                        g.DrawEllipse(p, ran.Next(0, 111), ran.Next(0, 60), ran.Next(0, 111), ran.Next(0, 60));
                    p.Color = Color.FromArgb(0xFF, ran.Next(0, 255), ran.Next(0, 255), ran.Next(0, 255));
                }
                panel1.BackgroundImage = bitmap;
                images[z] = bitmap;
            }
            return images;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            FolderBrowserDialog fbd = new FolderBrowserDialog();
            if (fbd.ShowDialog() == System.Windows.Forms.DialogResult.OK)
            {
                label1.Text = fbd.SelectedPath;
            }
        }

        string md5HashesName = "";

        private void button4_Click(object sender, EventArgs e)
        {
            OpenFileDialog ofd = new OpenFileDialog();
            if (ofd.ShowDialog() == System.Windows.Forms.DialogResult.OK)
            {
                pictureBox1.ImageLocation = ofd.FileName;
                md5HashesName = Path.GetFileNameWithoutExtension(ofd.FileName);
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            MD5CryptoServiceProvider md5 = new MD5CryptoServiceProvider();
            int y = 0;
            byte[] buffer = new byte[textBox2.Text.Length];
            foreach (char c in textBox2.Text.ToCharArray())
            {
                buffer[y] = (byte)c;
                y++;
            }
            string blah = BitConverter.ToString(md5.ComputeHash(buffer)).Replace("-", "");
            if (blah != md5HashesName)
            {
                MessageBox.Show("You got it wrong");
            }
            else
            {
                MessageBox.Show("You got it right");
            }
        }
    }
}
