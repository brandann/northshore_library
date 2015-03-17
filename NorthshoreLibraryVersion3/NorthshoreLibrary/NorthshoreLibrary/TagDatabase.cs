using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NorthshoreLibrary
{
    public class TagDatabase : Database
    {

        public List<string> GetTagCategories()
        {
            List<string> cats = new List<string>();

            for(int i = 0; i < _databaseItems.Count; i++)
            {
                Tag tag = _databaseItems[i] as Tag;
                if(!cats.Contains(tag.GetCat()))
                {
                    cats.Add(tag.GetCat());
                }
            }

            return cats;
        }

        public List<string> GetCatTags(string cat)
        {
            List<string> results = new List<string>();

            for (int i = 0; i < _databaseItems.Count; i++ )
            {
                Tag tag = _databaseItems[i] as Tag;
                if(tag.GetCat() == cat)
                {
                    results.Add(tag.GetTag());
                }
            }

            return results;
        }
    }
}
