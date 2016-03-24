using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.IO;
using System.Xml;

namespace AddressBok
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        List<Person> people = new List<Person>();

        private void Form1_Load(object sender, EventArgs e)
        {
            string path = Environment.GetFolderPath(Environment.SpecialFolder.ApplicationData);
            if(!Directory.Exists(path+ "\\Address Book -Ani"))
                Directory.CreateDirectory(path+ "\\Address Book -Ani");
            if (!File.Exists(path + "\\Address Book -Ani\\settings.xml"))
            {
                XmlTextWriter xw = new XmlTextWriter(path + "\\Address Book -Ani\\settings.xml",Encoding.UTF8);
                //File.Create(path + "\\Address Book -Ani\\settings.xml");
                xw.WriteStartElement("People");
                xw.WriteEndElement();
                xw.Close();
            }
            XmlDocument xdoc = new XmlDocument();
            xdoc.Load(path + "\\Address Book -Ani\\settings.xml");
            foreach (XmlNode xNode in xdoc.SelectNodes("People/Person"))
            {
                Person p = new Person();
                p.Name = xNode.SelectSingleNode("Name").InnerText;
                p.Email= xNode.SelectSingleNode("Email").InnerText;
                p.StreetAddress = xNode.SelectSingleNode("Address").InnerText;
                p.AdditionalNotes= xNode.SelectSingleNode("Notes").InnerText;
                p.Birthday= DateTime.FromFileTime(Convert.ToInt64(xNode.SelectSingleNode("Birthday").InnerText));
                people.Add(p);
                listView1.Items.Add(p.Name);
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Person p = new Person();
            p.Name = textBox1.Text;
            p.Email = textBox2.Text;
            p.StreetAddress = textBox3.Text;
            p.Birthday = dateTimePicker1.Value;
            p.AdditionalNotes = textBox4.Text;
            people.Add(p);
            listView1.Items.Add(p.Name);
            textBox1.Text = "";
            textBox2.Text = "";
            textBox3.Text = "";
            textBox4.Text = "";
            dateTimePicker1.Value = DateTime.Now;
        }

        private void listView1_SelectedIndexChanged(object sender, EventArgs e)
        {
            textBox1.Text = people[listView1.SelectedItems[0].Index].Name;
            textBox2.Text = people[listView1.SelectedItems[0].Index].Email;
            textBox3.Text = people[listView1.SelectedItems[0].Index].StreetAddress;
            textBox4.Text = people[listView1.SelectedItems[0].Index].AdditionalNotes;
            dateTimePicker1.Value = people[listView1.SelectedItems[0].Index].Birthday;
        }

        private void button3_Click(object sender, EventArgs e)
        {
            Remove();
        }

        public void Remove()
        {
            try
            {
                listView1.Items.Remove(listView1.SelectedItems[0]);
                people.RemoveAt(listView1.SelectedItems[0].Index);
            }
            catch { }
        }
        private void removeToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Remove();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            people[listView1.SelectedItems[0].Index].Name = textBox1.Text;
            people[listView1.SelectedItems[0].Index].Email = textBox2.Text;
            people[listView1.SelectedItems[0].Index].StreetAddress = textBox3.Text;
            people[listView1.SelectedItems[0].Index].AdditionalNotes = textBox4.Text ;
            people[listView1.SelectedItems[0].Index].Birthday = dateTimePicker1.Value;
            listView1.SelectedItems[0].Text = textBox1.Text;
        }

        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            XmlDocument xDoc = new XmlDocument();
            string path = Environment.GetFolderPath(Environment.SpecialFolder.ApplicationData);
            xDoc.Load(path + "\\Address Book -Ani\\settings.xml");
            XmlNode xnode = xDoc.SelectSingleNode("People");
            xnode.RemoveAll();
            foreach (Person p in people)
            {
                XmlNode xtop = xDoc.CreateElement("Person");
                XmlNode xName = xDoc.CreateElement("Name");
                XmlNode xEmail = xDoc.CreateElement("Email");
                XmlNode xAddress = xDoc.CreateElement("Address"); ;
                XmlNode xNotes = xDoc.CreateElement("Notes");
                XmlNode xBirthday = xDoc.CreateElement("Birthday");
                xName.InnerText = p.Name;
                xEmail.InnerText = p.Email;
                xAddress.InnerText = p.StreetAddress;
                xNotes.InnerText = p.AdditionalNotes;
                xBirthday.InnerText = p.Birthday.ToFileTime().ToString();
                xtop.AppendChild(xName);
                xtop.AppendChild(xEmail);
                xtop.AppendChild(xAddress);
                xtop.AppendChild(xNotes);
                xtop.AppendChild(xBirthday);
                xDoc.DocumentElement.AppendChild(xtop);
             }
            xDoc.Save(path + "\\Address Book -Ani\\settings.xml");
        }
    }

    class Person 
    {
        public string Name
        {
            get;
            set;
        }
        public string Email
        {
            get;
            set;
        }
        public string StreetAddress
        {
            get;
            set;
        }
        public string AdditionalNotes
        {
            get;
            set;
        }
        public DateTime Birthday
        {
            get;
            set;
        }
    }
}
