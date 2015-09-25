using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SewServiceRepository.DAL.Entities
{
    public class ProviderSignupRequester : BaseEntity
    {
        // Id,FirstName,LastName,UserName,Password,Phone,Email,DOB,Gender,AddressId,Status,CreatedOn,UpdatedOn

        public virtual string FirstName { get; set; }
        public virtual string LastName { get; set; }

        public virtual string UserName {get;set;}
        public virtual string Password {get;set;}

        public virtual string Phone { get; set;}
        public virtual string Email {get;set;}

        public virtual DateTime DOB {get;set;}
        public virtual string Gender {get;set;}

        public virtual int AddressId {get;set;}

        public virtual Address Address { get; set; }

    }
}
