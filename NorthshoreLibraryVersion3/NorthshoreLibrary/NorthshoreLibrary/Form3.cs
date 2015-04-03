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
    public partial class Form3 : Form
    {
        public Form3()
        {
            InitializeComponent();
        }

        public Form3(Form1 mf, LibraryManager lm)
        {
            _mainForm = mf;
            _libraryManager = lm;
            InitializeComponent();
        }

        private void OKbtn_Click(object sender, EventArgs e)
        {
            var details = _libraryManager.Details.GetItems();
            for (int i = 0; i < details.Count; i++ )
            {
                if(((Detail) details[i]).ID == idtxt.Text)
                {
                    Form2 form = new Form2();
                    form.Show();
                    form.SetLibrary(_mainForm, _libraryManager, (Detail)details[i]);
                    this.Close();
                }
            }
            MessageBox.Show("Sorry that detail was not found");
            this.Close();
        }

        Form1 _mainForm;
        LibraryManager _libraryManager;

        private void Cancelbtn_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
