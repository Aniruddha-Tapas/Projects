using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Security.Cryptography;

namespace MD5SHA1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            /* //MD5 16 byte long hashcode
             * 
            MD5CryptoServiceProvider md5 = new MD5CryptoServiceProvider();
            UTF8Encoding utf8 = new UTF8Encoding();
            MessageBox.Show(BitConverter.ToString(md5.ComputeHash(utf8.GetBytes(textBox1.Text))));
             */

            //SHA1 20 byte long hashcode

            SHA1CryptoServiceProvider sha1 = new SHA1CryptoServiceProvider();
            UTF8Encoding utf8 = new UTF8Encoding();
            MessageBox.Show(BitConverter.ToString(sha1.ComputeHash(utf8.GetBytes(textBox1.Text))));
        }
    }
}
