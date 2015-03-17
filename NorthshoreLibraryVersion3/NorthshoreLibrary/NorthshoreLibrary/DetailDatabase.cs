using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NorthshoreLibrary
{
    public class DetailDatabase : Database
    {
        public List<string> GetJobNames()
        {
            List<string> results = new List<string>();
            for (int i = 0; i < _databaseItems.Count; i++ )
            {
                Detail det = _databaseItems[i] as Detail;
                if(!results.Contains(det.Name))
                {
                    results.Add(det.Name);
                }
            }
            return results;
        }

        public List<string> GetJobNumbers()
        {
            List<string> results = new List<string>();
            for (int i = 0; i < _databaseItems.Count; i++)
            {
                Detail det = _databaseItems[i] as Detail;
                if (!results.Contains(det.Number))
                {
                    results.Add(det.Number);
                }
            }
            return results;
        }
    }
}
