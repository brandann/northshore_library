using System;
using System.IO;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NorthshoreLibrary
{
    class DatabaseConvert
    {
        private const string DETAIL_FILE_LOCATION = "C:\\Users\\brandan\\Documents\\northshore_library\\NorthshoreLibraryVersion3\\tags.txt";
        private const string DETAIL_FILE_LOCATION_NEW = "C:\\Users\\brandan\\Documents\\northshore_library\\NorthshoreLibraryVersion3\\tagsnew.dat";

        public DatabaseConvert()
        {
            List<string> lines = new List<string>();
            try
            {
                string inline;
                StreamReader file = new StreamReader(DETAIL_FILE_LOCATION);
                while ((inline = file.ReadLine()) != null)
                {
                    lines.Add(inline);
                }
                file.Close();
            }
            catch (Exception e)
            {
                Console.WriteLine();
                Console.WriteLine(e.Message);
            }

            //------------------------------------------------------------------------

            try
            {
                StreamWriter file = new StreamWriter(DETAIL_FILE_LOCATION_NEW);
                for (int i = 0; i < lines.Count; i++ )
                {
                    file.WriteLine("<Tag>" + lines[i]);
                }
                    file.Close();
            }
            catch (Exception e)
            {
                Console.WriteLine();
                Console.WriteLine(e.Message);
            }
        }
    }
}
