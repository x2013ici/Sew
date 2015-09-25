using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace SewServiceRepository.ResponseWrapper
{
    public class QueryResult<T> : BaseResult
    {
        private T result;
        public T Result
        {
            get { return result; }
            set { result = value; }
        }
        public QueryResult()
        {

        }
    }
}