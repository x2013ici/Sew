using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SewServiceRepository.DAL.ResponseModel
{
    public class AddressResponse : BaseResponse
    {
        public virtual string Street { get; set; }
        public virtual int CountryId { get; set; }

        public virtual string City { get; set; }
        public virtual string State { get; set; }
        public virtual string ZipCode { get; set; }

        public virtual CountryResponse CountryResponse { get; set; }
    }
}
