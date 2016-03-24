using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Multipledocumentinterface
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.IsMdiContainer = true;
            Form2 f = new Form2();
            f.MdiParent = this;
            f.Show();
            Form3 f1 = new Form3();
            f1.MdiParent = this;
            f1.Show();
            Form4 f2 = new Form4();
            f2.MdiParent = this;
            f2.Show();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            //this.LayoutMdi(MdiLayout.ArrangeIcons);
            this.LayoutMdi(MdiLayout.Cascade);
            //this.LayoutMdi(MdiLayout.TileHorizontal);
            //this.LayoutMdi(MdiLayout.TileVertical);
        }
    }
}
