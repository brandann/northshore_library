using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;

namespace NorthshoreLibrary
{
    public partial class Form2 : Form
    {
        

        #region Constructor
        public Form2()
        {
            InitializeComponent();
        }
        #endregion
        
        #region Private
        
        #region Members
        private Form _mainForm;
        private Detail _currentDetail;
        private LibraryManager _libraryManager;
        #endregion

        private bool verifyData()
        {
            if (nametxt.Text == "") { MessageBox.Show("Please Provide A Job Name"); return false; }
            if (numbertxt.Text == "") { MessageBox.Show("Please Provide A Job Number"); return false; }
            if (jpgtxt.Text == "") { MessageBox.Show("Please Provide A Detial image"); return false; }
            if (dwgtxt.Text == "") { MessageBox.Show("Please Provide A Detail Drawing"); return false; }
            if (pdftxt.Text == "") { MessageBox.Show("Please Provide A Detail PDF"); return false; }
            if (selectedtagslist.Items.Count == 0) { MessageBox.Show("Please Provide At Least 1 Tag"); return false; }
            return true;
        }

        private void SaveDetail()
        {
            if (!verifyData())
            {
                return;
            }

            detailpicture.Image.Dispose();
            detailpicture.Image = null;

            Detail det = new Detail();

            det.ID = idtxt.Text;
            det.Company = (string) compcmb.SelectedItem;
            det.Name = nametxt.Text;
            det.Number = numbertxt.Text;
            det.Searchable = (includebool.Checked == true) ? "1" : "0";
            det.Date = datetxt.Text;
            det.Description = descriptiontxt.Text;
            det.Jpg = jpgtxt.Text = MoveFile(jpgtxt.Text, det.ID + ".jpg");
            det.Dwg = dwgtxt.Text = MoveFile(dwgtxt.Text, det.ID + ".dwg");
            det.Pdf = pdftxt.Text = MoveFile(pdftxt.Text, det.ID + ".pdf");

            string s = "";
            selectedtagslist.SelectedIndex = 0;
            for (int i = 0; i < selectedtagslist.Items.Count; i++)
            {
                s += (string)selectedtagslist.SelectedItem + Detail.TAG_SPLIT_TOKEN;

                if ((selectedtagslist.SelectedIndex + 1) < selectedtagslist.Items.Count)
                {
                    selectedtagslist.SelectedIndex += 1;
                }
            }

            det.Tags = s;

            var dets = _libraryManager.Details.GetItems();
            bool found = false;
            foreach (Detail d in dets)
            {
                if (d.ID == det.ID)
                {
                    found = true;
                    break;
                }
            }

            if (found)
            {
                _libraryManager.Replace(det);
                this.Close();
            }
            else
            {
                _libraryManager.Add(det);
                SetLibrary(_mainForm, _libraryManager);
                nametxt.Text = det.Name;
                numbertxt.Text = det.Number;
                compcmb.SelectedItem = det.Company.ToUpper();
                selectedtagslist.Items.Clear();
            }
            
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

        private string MoveFile(string path, string ext)
        {
            string newpath = Directory.Location + "files\\" + ext;

            if(File.Exists(path))
            {
                File.Copy(path, newpath, true);
                if(File.Exists(newpath))
                {
                    File.Delete(path);
                    return "files\\" + ext;
                }
            }
            else if (File.Exists(Directory.Location + path))
            {
                return path;
            }
            return "none";
        }
        #endregion
        
        #region Public
        
        #region Members

        #endregion
        
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
                detailpicture.Image = new Bitmap(Directory.Location + _currentDetail.Jpg);
            }

            string tags = d.Tags;
            string[] taglist = tags.Split(new string[] {">>"}, StringSplitOptions.RemoveEmptyEntries);
            if(taglist.Length > 0)
            {
                for (int i  = 0; i < taglist.Length; i++)
                {
                    selectedtagslist.Items.Add(taglist[i]);
                }
            }

            SetCategory();
        }

        public void SetLibrary(Form f, LibraryManager lm)
        {
            Detail det = new Detail();

            var dets = lm.Details.GetItems();
            var lastdet = (Detail)dets[dets.Count - 1];
            int lastindex = int.Parse(lastdet.ID);
            lastindex++;
            det.ID = "" + lastindex;

            det.Company = "NORTHSHORE";
            det.Searchable = "1";
            det.Date = "2015";
            det.Description = "description";
            det.Jpg = "";

            SetLibrary(f, lm, det);

            selectedtagslist.Items.Add("item");
        }
        #endregion
        
        #region Events
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

        private void button1_Click(object sender, EventArgs e)
        {
            //MessageBox.Show("Editing Detail Feature Not Working Yet", "Sorry");
            SaveDetail();
        }
        #endregion

        private void button3_Click(object sender, EventArgs e)
        {
            //jpg
            jpgtxt.Text = GetFile("jpg");
            detailpicture.Image = new Bitmap(jpgtxt.Text);
        }

        private void button4_Click(object sender, EventArgs e)
        {
            //dwg
            dwgtxt.Text = GetFile("dwg");
        }

        private void button5_Click(object sender, EventArgs e)
        {
            //pdf
            pdftxt.Text = GetFile("pdf");
        }

        private string GetFile(string ext)
        {
            string name = "";
            OpenFileDialog openFileDialog1 = new OpenFileDialog();
            openFileDialog1.InitialDirectory = "c:\\";
            openFileDialog1.Filter = ext + " files (*." + ext + ")|*." + ext;
            openFileDialog1.FilterIndex = 2;
            openFileDialog1.RestoreDirectory = true;

            if (openFileDialog1.ShowDialog() == DialogResult.OK)
            {
                try
                {
                    if ((name = openFileDialog1.FileName) != null)
                    {
                        return name;
                    }
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Error: Could not read file from disk. Original error: " + ex.Message);
                }
            }
            return name;
        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void Form2_FormClosing(object sender, FormClosingEventArgs e)
        {

        }
    }
}
