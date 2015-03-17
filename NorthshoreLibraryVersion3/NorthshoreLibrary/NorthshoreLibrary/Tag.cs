using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NorthshoreLibrary
{
    class Tag : DatabaseItem
    {
        private string _cat;
        private string _tag;
        public Tag(string inline)
        {
            string[] line = inline.Split(',');
            _cat = line[0];
            _tag = line[1];
        }

        public string GetCat()
        {
            return _cat;
        }

        public string GetTag()
        {
            return _tag;
        }

        public override string GetString()
        {
            return _cat + "," + _tag;
        }
    }
}
