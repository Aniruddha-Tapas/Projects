using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Net;
using System.Net.Mail;

namespace EmailSender
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            try
            {
                if(textBox4.Text.Contains("@gmail.com"))
                {
                    MessageBox.Show("Please enter a gmail address");
                    return;
                }
                button1.Enabled = false;
                MailMessage message = new MailMessage();
                message.From = new MailAddress(textBox4.Text);
                message.Subject = textBox2.Text;
                message.Body = textBox3.Text;
                foreach (string s in textBox1.Text.Split(';'))
                    message.To.Add(s);
                SmtpClient client = new SmtpClient();
                client.Credentials = new NetworkCredential(textBox4.Text, textBox5.Text);
                client.Host = "smtp.gmail.com";
                client.Port = 587;
                client.EnableSsl = true;
                client.Send(message);
            }
            catch { MessageBox.Show("There was an error sending the message", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error); }
            finally{ button1.Enabled = true; }
        }
    }
}
