using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace SewServiceRepository.ResponseWrapper
{
    public class QueryResultSet<T> : BaseResult
    {
        private ICollection<T> resultSet;
        public ICollection<T> ResultSet
        {
            get { return this.resultSet; }
            set { this.resultSet = value; }
        }

        public QueryResultSet()
        {

        }
    }
}