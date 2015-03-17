using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NorthshoreLibrary
{
    class Detail : DatabaseItem
    {
        private string _line;
        private string _name;
        private string _number;

        public Detail(string inline)
        {
            _line = inline;
            string[] line = inline.Split('$');

            _name = line[2];
            _number = line[3];
        }

        public override string GetString()
        {
            return _line;
        }

        public string GetName()
        {
            return _name;
        }

        public string GetNumber()
        {
            return _number;
        }
    }
}
