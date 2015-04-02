using System;
using System.IO;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NorthshoreLibrary
{
    public class LibraryManager
    {
        #region Public

        public TagDatabase Tags
        {
            get { return _tagDatabase; }
        }

        public DetailDatabase Details
        {
            get { return _detailDatabase; }
        }

        public void Replace(Detail det)
        {
            Initilize();
            Details.Replace(det);
            SaveDatabase();
        }

        public void Add(Detail det)
        {
            Initilize();
            Details.AddItem(det);
            SaveDatabase();
        }

        public LibraryManager()
        {
            Initilize();
        }

        public List<string> Search(List<string> terms)
        {
            List<string> results = new List<string>();
            List<DatabaseItem> details = _detailDatabase.GetItems();
            bool good;
            Detail det;
            for (int i = 0; i < details.Count(); i++)
            {
                good = true;
                det = details[i] as Detail;
                for(int j = 0; j < terms.Count; j++)
                {
                    if(!det.GetString().Contains(terms[j]))
                    {
                        good = false;
                    }
                }
                if(good)
                {
                    results.Add(det.GetString());
                }
            }
            return results;
        }
        #endregion

        #region Private Methods

        #region Private Members
        private const string TAG_KEY = "<Tag>";
        private const string DETAIL_KEY = "<Detail>";
        private const string STANDARD_KEY = "<Standard>";
        private const string READ_ERROR_MESSAGE = "The file could not be read:";

        private TagDatabase _tagDatabase;
        private DetailDatabase _detailDatabase;
        private List<string> _database;
        #endregion

        private void Initilize()
        {
            LoadDatabase();
            LoadTags();
            LoadDetails();
        }

        private bool SaveDatabase()
        {
            try
            {
                List<DatabaseItem> details = Details.GetItems();
                List<DatabaseItem> tags = Tags.GetItems();
                StreamWriter file = new StreamWriter(Directory.Database);
                for(int i = 0; i < tags.Count; i++)
                {
                    Tag t = (Tag)tags[i];
                    file.WriteLine(TAG_KEY + t.GetCat() + "," + t.GetTag());
                }
                for (int j = 0; j < details.Count; j++)
                {
                    Detail d = (Detail)details[j];
                    file.WriteLine(DETAIL_KEY + d.ToString());
                }
                file.Close();
                return true;
            }
            catch (Exception e)
            {
                Console.WriteLine("WRITE ERROR");
                Console.WriteLine(e.Message);
                return false;
            }
        }

        private bool LoadDatabase()
        {
            _database = new List<string>();
            try
            {
                string inline;
                StreamReader file = new StreamReader(Directory.Database);
                while ((inline = file.ReadLine()) != null)
                {
                    _database.Add(inline);
                }
                file.Close();
                return true;
            }
            catch (Exception e)
            {
                Console.WriteLine(READ_ERROR_MESSAGE);
                Console.WriteLine(e.Message);
            }
            return false;
        }

        private bool LoadTags()
        {
            _tagDatabase = new TagDatabase();
            if(_database != null)
            {
                for (int i = 0; i < _database.Count; i++)
                {
                    if (_database[i].Contains(TAG_KEY))
                    {
                        _tagDatabase.AddItem(new Tag(_database[i].Replace(TAG_KEY, "")));
                    }
                }
                return true;
            }
            return false;
        }

        private bool LoadDetails()
        {
            _detailDatabase = new DetailDatabase();
            if (_database != null)
            {
                for (int i = 0; i < _database.Count; i++)
                {
                    if (_database[i].Contains(DETAIL_KEY))
                    {
                        _detailDatabase.AddItem(new Detail(_database[i].Replace(DETAIL_KEY, "")));
                    }
                }
                return true;
            }
            return false;
        }
        #endregion
    }
}
