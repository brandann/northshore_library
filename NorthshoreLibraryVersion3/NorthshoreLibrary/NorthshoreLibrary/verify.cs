using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace NorthshoreLibrary
{
    public partial class verify : Form
    {
        private string message = "&body=Please send me an activation code using this email address. Thank you!";
        private string subject = "?subject=Library Activation Request";

        public verify()
        {
            if(Properties.Settings.Default.active)
            {
                // do nothing for now
                //Application.Run(new Form1());
                //this.Close();
            }
            InitializeComponent();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            string email = emailtxt.Text;
            string activate = activatetxt.Text;

            KeyGen kg = new KeyGen();
            string code = kg.GenerateCode(email);
            activatetxt.Text = code;
        }

        private void send(string add)
        {
            string html = "mailto:" + add + subject + message;
            System.Diagnostics.Process.Start(html);
        }

        private void button3_Click_1(object sender, EventArgs e)
        {
            if(emailtxt.Text == "")
            {
                MessageBox.Show("Please Enter Your Email Address");
                return;
            }

            send("brandan@northshoresheetmetal.com");
        }
    }
}
