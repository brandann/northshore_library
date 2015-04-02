using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NorthshoreLibrary
{
    public class Database
    {
        protected List<DatabaseItem> _databaseItems;
        public Database() { _databaseItems = new List<DatabaseItem>(); }
        public void AddItem(DatabaseItem item) { _databaseItems.Add(item); }
        public bool RemoveItem(DatabaseItem item) { return _databaseItems.Remove(item); }
        public List<DatabaseItem> GetItems() { return _databaseItems; }
        public int GetCount() { return _databaseItems.Count; }
        public void ClearItems() { _databaseItems.Clear(); }
        virtual public bool Replace(Detail det) { return false; }
    }
}
