using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NorthshoreLibrary
{
    class KeyGen
    {
        public string GenerateCode(string k)
        {
            string code = "";
            string key = k.ToUpper().Replace("@", "").Replace(".COM", "");
            foreach (char c in key) { code = code + gen(c, key.Length + DateTime.Now.Year + DateTime.Now.Month); }
            return code;
        }

        private string gen(char c, int l)
        {
            int index = (((int) c) + l) % 21;
            return hex(index);
        }
        
        private string hex(int index)
        {
            if(index < 10) { return "" + index; }
            else if (index >= 10) { return "" + ((char)(index + 65)); }
            return "0";
        }
    }
}
