using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NorthshoreLibrary
{
    public class Detail : DatabaseItem
    {
        private enum DETAIL_TOKEN{ID = 0, COMPANY = 1, JOB_NAME = 2, JOB_NUMBER = 3, SEARCHABLE = 4, DATE = 5, DESCRIPTION = 6, PDF = 7, DWG = 8, JPG = 9, TAGS = 10}
        private const char DETAIL_SPLIT = '$';
        //private const char[] TAG_SPLIT = { '>', '>' };
        private string _id, _company, _name, _number, _searchable, _date, _description, _pdf, _dwg, _jpg, _tags;
        private string _line;
        private bool _isDirty;

        public Detail(string inline)
        {
            _line = inline;
            string[] line = inline.Split(DETAIL_SPLIT);

            _id = line[(int)DETAIL_TOKEN.ID];
            _company = line[(int)DETAIL_TOKEN.COMPANY];
            _name = line[(int)DETAIL_TOKEN.JOB_NAME];
            _number = line[(int)DETAIL_TOKEN.JOB_NUMBER];
            _searchable = line[(int)DETAIL_TOKEN.SEARCHABLE];
            _date = line[(int)DETAIL_TOKEN.DATE];
            _description = line[(int)DETAIL_TOKEN.DESCRIPTION];
            _pdf = line[(int)DETAIL_TOKEN.PDF];
            _dwg = line[(int)DETAIL_TOKEN.DWG];
            _jpg = line[(int)DETAIL_TOKEN.JPG];
            _tags = line[(int)DETAIL_TOKEN.TAGS];
            _isDirty = false;
        }

        public Detail()
        {
            _line = "";

            _id = "";
            _company = "";
            _name = "";
            _number = "";
            _searchable = "";
            _date = "";
            _description = "";
            _pdf = "";
            _dwg = "";
            _jpg = "";
            _tags = "";
            _isDirty = false;
        }

        public override string GetString()
        {
            return _line;
        }

        public string ID
        {
            get
            {
                return _id;
            }
            set
            {
                if(value != _id)
                {
                    _id = value;
                    _isDirty = true;
                }
            }
        }

        public string Company
        {
            get
            {
                return _company;
            }
            set
            {
                if (value != _company)
                {
                    _company = value;
                    _isDirty = true;
                }
            }
        }

        public string Name
        {
            get
            {
                return _name;
            }
            set
            {
                if (value != _name)
                {
                    _name = value;
                    _isDirty = true;
                }
            }
        }

        public string Number
        {
            get
            {
                return _number;
            }
            set
            {
                if (value != _number)
                {
                    _number = value;
                    _isDirty = true;
                }
            }
        }

        public string Searchable
        {
            get
            {
                return _searchable;
            }
            set
            {
                if (value != _searchable)
                {
                    _searchable = value;
                    _isDirty = true;
                }
            }
        }

        public string Date
        {
            get
            {
                return _date;
            }
            set
            {
                if (value != _date)
                {
                    _date = value;
                    _isDirty = true;
                }
            }
        }

        public string Description
        {
            get
            {
                return _description;
            }
            set
            {
                if (value != _description)
                {
                    _description = value;
                    _isDirty = true;
                }
            }
        }

        public string Pdf
        {
            get
            {
                return _pdf;
            }
            set
            {
                if (value != _pdf)
                {
                    _pdf = value;
                    _isDirty = true;
                }
            }
        }

        public string Jpg
        {
            get
            {
                return _jpg;
            }
            set
            {
                if (value != _jpg)
                {
                    _jpg = value;
                    _isDirty = true;
                }
            }
        }

        public string Dwg
        {
            get
            {
                return _dwg;
            }
            set
            {
                if (value != _dwg)
                {
                    _dwg = value;
                    _isDirty = true;
                }
            }
        }

        public string Tags
        {
            get
            {
                return _tags;
            }
            set
            {
                if (value != _tags)
                {
                    _tags = value;
                    _isDirty = true;
                }
            }
        }        
    }
}
