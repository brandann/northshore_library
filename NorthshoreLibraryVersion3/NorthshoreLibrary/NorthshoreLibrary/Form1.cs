using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace NorthshoreLibrary
{
    public partial class Form1 : Form
    {
        private LibraryManager _libraryManager;

        #region SEARCH
        private const string TAG_TERM = "Tags";
        private const string NAME_TERM = "Job Name";
        private const string NUMBER_TERM = "Job Number";
        private const string RESULT_LABEL = " Details Found";
        private const string dir = "C:\\Users\\brandan\\Desktop\\NSMLibraryFloating\\";
        //private const string dir = "";

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            _libraryManager = new LibraryManager();
            //DatabaseConvert dc = new DatabaseConvert();
            ResetForm();
            Search();
        }

        private void ResetForm()
        {
            //set categories
            SearchTerm1.Items.Clear();
            SearchTerm1.Items.Add("Tags");
            SearchTerm1.Items.Add("Job Name");
            SearchTerm1.Items.Add("Job Number");

            SearchTerm2.Items.Clear();
            SearchBox.Clear();
            SearchResultList.Items.Clear();
            SearchTermList.Items.Clear();

            SearchResultLabel.Text = _libraryManager.Details.GetCount() + RESULT_LABEL;
        }

        private void SearchTerm1_SelectedIndexChanged(object sender, EventArgs e)
        {
            string selectedItem = SearchTerm1.SelectedItem as string;
            SearchTerm2.Items.Clear();
            SearchTerm2.Enabled = false;
            SearchBox.Clear();
            SearchResultList.Items.Clear();
            //SearchTermList.Items.Clear();

            if (selectedItem == TAG_TERM)
            {
                SearchTerm2.Enabled = true;
                List<string> tagcats = _libraryManager.Tags.GetTagCategories();
                tagcats.Sort();
                for(int i = 0; i < tagcats.Count; i++)
                {
                    SearchTerm2.Items.Add(tagcats[i]);
                }
            }
            else if (selectedItem == NAME_TERM)
            {
                List<string> jobnames = _libraryManager.Details.GetJobNames();
                jobnames.Sort();
                for (int i = 0; i < jobnames.Count; i++)
                {
                    SearchResultList.Items.Add(jobnames[i]);
                }
            }
            else if (selectedItem == NUMBER_TERM)
            {
                List<string> jobnumbers = _libraryManager.Details.GetJobNumbers();
                jobnumbers.Sort();
                for (int i = jobnumbers.Count - 1; i >= 0; i--)
                {
                    SearchResultList.Items.Add(jobnumbers[i]);
                }
            }
        }

        private void SearchTerm2_SelectedIndexChanged(object sender, EventArgs e)
        {
            string term1selecteditem = SearchTerm1.SelectedItem as string;
            string selectedItem = SearchTerm2.SelectedItem as string;
            SearchBox.Clear();
            SearchResultList.Items.Clear();
            //SearchTermList.Items.Clear();

            if (term1selecteditem == TAG_TERM)
            {
                List<string> tagcats = _libraryManager.Tags.GetCatTags(selectedItem);
                for (int i = 0; i < tagcats.Count; i++)
                {
                    SearchResultList.Items.Add(tagcats[i]);
                }
            }
            else if (term1selecteditem == NAME_TERM)
            {
                
            }
            else if (term1selecteditem == NUMBER_TERM)
            {

            }
        }

        private void SearchAddButton_Click(object sender, EventArgs e)
        {
            AddTerm();
        }

        private void SearchResultList_DoubleClick(object sender, EventArgs e)
        {
            AddTerm();
        }

        private void AddTerm()
        {
            if(SearchResultList.SelectedItem != null)
            {
                SearchTermList.Items.Add(SearchResultList.SelectedItem);
            }

            Search();
        }

        private void SearchTermList_DoubleClick(object sender, EventArgs e)
        {
            RemoveTerm();
        }

        private void RemoveTerm()
        {
            if (SearchResultList.SelectedItem != null)
            {
                SearchTermList.Items.RemoveAt(SearchTermList.SelectedIndex);
            }

            Search();
        }

        private void Search()
        {
            List<string> searchResults = new List<string>();
            List<string> searchterms = new List<string>();
            for (int i = 0; i < SearchTermList.Items.Count; i++ )
            {
                searchterms.Add(SearchTermList.Items[i] as string);
            }
            searchResults = _libraryManager.Search(searchterms);
            SearchResultLabel.Text = searchResults.Count + RESULT_LABEL;
            SetResults(searchResults);
        }
        #endregion

        #region RESULT
        List<Detail> _details;

        private void SetResults(List<string> results)
        {
            ResetResults();

            // get details from string list
            _details = new List<Detail>();
            results.Sort();
            for (int i = results.Count - 1; i >= 0 ; i--)
            {
                Detail det = new Detail(results[i]);
                _details.Add(det);

                // set detail list
                ResultList.Items.Add(det.Number + " - " + det.Description);
            }
        }

        private void ResetResults()
        {
            ResultList.Items.Clear();
            ResultPicture.Image = null;
        }
        #endregion

        private void ResultPrev_Click(object sender, EventArgs e)
        {
            if(ResultList.SelectedIndex > 0)
            {
                ResultList.SelectedIndex -= 1;
            }
        }

        private void ResultNext_Click(object sender, EventArgs e)
        {
            if(ResultList.SelectedIndex < (ResultList.Items.Count - 1))
            {
                ResultList.SelectedIndex += 1;
            }
        }

        private void ResultList_SelectedIndexChanged(object sender, EventArgs e)
        {
            LoadDetail(ResultList.SelectedIndex);
        }

        private void LoadDetail(int index)
        {
            if(index == -1)
            {
                ResetResults();
            }
            if (index < 0 || index >= _details.Count)
            {
                ResetResults();
            }
            else
            {
                Detail det =_details[index];
                string pdffile = det.Pdf;
                string jpgfile = det.Jpg;
                string dwgfile = det.Dwg;

                Console.WriteLine(dir + jpgfile);
                ResultPicture.Image = new Bitmap(dir + jpgfile);
                
            }
        }

        private void ClearTermsButton_Click(object sender, EventArgs e)
        {
            SearchTermList.Items.Clear();
            Search();
        }

        private void ResultEdit_Click(object sender, EventArgs e)
        {
            if(ResultList.SelectedIndex != -1)
            {
                Form2 form = new Form2();
                form.Show();
                form.SetLibrary(this, _libraryManager, _details[ResultList.SelectedIndex]);
            }
        }

        private void AddDetailButton_Click(object sender, EventArgs e)
        {
            Form2 form = new Form2();
            form.Show();
            form.SetLibrary(this, _libraryManager);
        }

        private void ResultAutocad_Click(object sender, EventArgs e)
        {
            Detail det = _details[ResultList.SelectedIndex];
            CopyFile(det.Dwg, det.Description);
        }

        private void ResultPDF_Click(object sender, EventArgs e)
        {
            Detail det = _details[ResultList.SelectedIndex];
            CopyFile(det.Pdf, det.Description);
        }
        
        private void CopyFile(string file, string des)
        {
            string copiedfilepath = CopyFileHelper(file, des);
            if (copiedfilepath != "")
            {
                MessageBox.Show("File saved to: " + copiedfilepath, "File Saved");
            }
            else
            {
                MessageBox.Show("File Copy Error: " + file, "Error");
            }
        }

        private string CopyFileHelper(string file, string des)
        {
            if (ResultList.SelectedIndex != -1)
            {
                string path = file;
                int m = DateTime.Now.Minute;
                int s = DateTime.Now.Second;
                try
                {

                    string filename = path.Replace("files\\", "");
                    var desktopFolder = Environment.GetFolderPath(Environment.SpecialFolder.DesktopDirectory);
                    var fullfilename = Path.Combine(desktopFolder, filename);

                    File.Copy(dir + path, fullfilename);

                    return fullfilename;
                }
                catch(Exception e)
                {
                    string type = (path.Contains(".pdf")) ? ".pdf" : ".dwg";
                    string filename = "" + m + s + " - " + des + type;
                    var desktopFolder = Environment.GetFolderPath(Environment.SpecialFolder.DesktopDirectory);
                    var fullfilename = Path.Combine(desktopFolder, filename);

                    File.Copy(dir + path, fullfilename);

                    return fullfilename;
                }
            }
            return "";
        }

        private void SearchSearchButton_Click(object sender, EventArgs e)
        {
            Tabs.SelectedIndex += 1;
            if(ResultList.Items.Count > 0)
            {
                ResultList.SelectedIndex = 0;
            }
        }

        private void SearchRemoveButton_Click(object sender, EventArgs e)
        {
            int index = SearchTermList.SelectedIndex;
            if (SearchTermList.Items.Count == 0)
            {
                return;
            }
            else if (index > -1)
            {
                SearchTermList.Items.RemoveAt(index);
            }
            else if (index == -1)
            {
                SearchTermList.Items.RemoveAt(0);
            }
            Search();
        }
    }
}
