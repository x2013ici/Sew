using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SewServiceRepository.DAL.Entities
{
    public class ProviderSignupRequest : BaseEntity
    {
        // Id,Name,Phone,Email,Fax,AddressId,Status,RequestedOn,UpdatedOn

        public virtual string Name { get; set; }
        public virtual string Phone { get; set; }
        public virtual string Email { get; set; }

        public virtual string Fax { get; set; }
        public virtual int AddressId { get; set; }

        public virtual Address Address { get; set; }
    }
}
