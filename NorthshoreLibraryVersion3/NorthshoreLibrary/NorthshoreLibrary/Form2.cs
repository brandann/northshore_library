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
    public partial class Form2 : Form
    {
        private Form _mainForm;
        private Detail _currentDetail;
        private LibraryManager _libraryManager;

        private const string dir = "C:\\Users\\brandan\\Desktop\\NSMLibraryFloating\\";
        //private const string dir = "";

        public Form2()
        {
            InitializeComponent();
        }

        private void Form2_Load(object sender, EventArgs e)
        {

        }

        public void SetLibrary(Form f, LibraryManager lm, Detail d)
        {
            _mainForm = f;
            _currentDetail = d;
            _libraryManager = lm;

            idtxt.Text = _currentDetail.ID;
            compcmb.SelectedItem = _currentDetail.Company;
            nametxt.Text = _currentDetail.Name;
            numbertxt.Text = _currentDetail.Number;

            includebool.Checked = (_currentDetail.Searchable == "1")? true:false;
            datetxt.Text = _currentDetail.Date;
            descriptiontxt.Text = _currentDetail.Description;
            jpgtxt.Text = _currentDetail.Jpg;
            dwgtxt.Text = _currentDetail.Dwg;
            pdftxt.Text = _currentDetail.Pdf;

            if(_currentDetail.Jpg != "")
            {
                detailpicture.Image = new Bitmap(dir + _currentDetail.Jpg);
            }
            SetCategory();
        }

        public void SetLibrary(Form f, LibraryManager lm)
        {
            Detail det = new Detail();
            det.ID = "-1";
            det.Company = "NORTHSHORE";
            det.Searchable = "1";
            det.Date = "2015";
            det.Description = "description";
            det.Jpg = "";

            SetLibrary(f, lm, det);
        }

        private void SetCategory()
        {
            List<string> tagcats = _libraryManager.Tags.GetTagCategories();
            tagcats.Sort();
            for (int i = 0; i < tagcats.Count; i++)
            {
                catcmb.Items.Add(tagcats[i]);
            }
        }

        private void SetTagList(string s)
        {
            taglist.Items.Clear();
            List<string> tagcats = _libraryManager.Tags.GetCatTags(s);
            tagcats.Sort();
            for (int i = 0; i < tagcats.Count; i++)
            {
                taglist.Items.Add(tagcats[i]);
            }
        }

        private void catcmb_SelectedIndexChanged(object sender, EventArgs e)
        {
            SetTagList(catcmb.SelectedItem as string);
        }

        private void taglist_DoubleClick(object sender, EventArgs e)
        {
            selectedtagslist.Items.Add(taglist.SelectedItem);
        }

        private void selectedtagslist_DoubleClick(object sender, EventArgs e)
        {
            selectedtagslist.Items.RemoveAt(selectedtagslist.SelectedIndex);
        }
    }
}
