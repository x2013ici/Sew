using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SewServiceRepository.DAL.Entities
{
    public class Address : BaseEntity
    {
        //Id,Address,Street,CountryId,City,State,Zipcode,Status,CreatedOn,UpdatedOn

        public virtual string Street { get; set; }
        public virtual int CountryId { get; set; }

        public virtual string City { get; set; }
        public virtual string State { get; set; }
        public virtual string ZipCode { get; set; }

        public virtual Country Country { get; set; }
    }
}
