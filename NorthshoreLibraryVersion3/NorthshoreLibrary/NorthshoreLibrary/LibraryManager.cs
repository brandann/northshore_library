using System;
using System.IO;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NorthshoreLibrary
{
    class LibraryManager
    {
        #region Private Members
        private const string TAG_FILE_LOCATION = "C:\\Users\\brandan\\Documents\\northshore_library\\NorthshoreLibraryVersion3\\tags.txt";
        private const string DETAIL_FILE_LOCATION = "C:\\Users\\brandan\\Documents\\northshore_library\\NorthshoreLibraryVersion3\\database.dat";
        private const string READ_ERROR_MESSAGE = "The file could not be read:";

        private TagDatabase _tagDatabase;
        private DetailDatabase _detailDatabase;
        #endregion

        #region Public Methods
        public TagDatabase Tags
        {
            get { return _tagDatabase; }
        }

        public DetailDatabase Details
        {
            get { return _detailDatabase; }
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
        private void Initilize()
        {
            LoadTags();
            LoadDetails();
        }

        private bool LoadTags()
        {
            _tagDatabase = new TagDatabase();
            try
            {
                string inline;
                StreamReader file = new StreamReader(TAG_FILE_LOCATION);
                while ((inline = file.ReadLine()) != null)
                {
                    _tagDatabase.AddItem(new Tag(inline));
                }
                return true;
            }
            catch (Exception e)
            {
                Console.WriteLine(READ_ERROR_MESSAGE);
                Console.WriteLine(e.Message);
            }
            return false;
        }

        private bool LoadDetails()
        {
            _detailDatabase = new DetailDatabase();
            try
            {
                string inline;
                StreamReader file = new StreamReader(DETAIL_FILE_LOCATION);
                while ((inline = file.ReadLine()) != null)
                {
                    _detailDatabase.AddItem(new Detail(inline));
                }
                return true;
            }
            catch (Exception e)
            {
                Console.WriteLine(READ_ERROR_MESSAGE);
                Console.WriteLine(e.Message);
            }
            return false;
        }
        #endregion
    }
}
