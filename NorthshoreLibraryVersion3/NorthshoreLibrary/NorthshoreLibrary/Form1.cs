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
        private const string TAG_TERM = "Tags";
        private const string NAME_TERM = "Job Name";
        private const string NUMBER_TERM = "Job Number";
        private const string RESULT_LABEL = " Details Found";

        private LibraryManager _libraryManager;

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            _libraryManager = new LibraryManager();
            ResetForm();
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
            SearchTermList.Items.Clear();

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
            SearchTermList.Items.Clear();

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
            List<string> searchterms = new List<string>();
            List<string> searchResults = new List<string>();
            for (int i = 0; i < SearchTermList.Items.Count; i++ )
            {
                searchterms.Add(SearchTermList.Items[i] as string);
            }
            searchResults = _libraryManager.Search(searchterms);
            SearchResultLabel.Text = searchResults.Count + RESULT_LABEL;
        }
    }
}
