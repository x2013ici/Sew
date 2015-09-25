using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SewServiceRepository.DAL.Entities
{
    public class UserSignupRequest : BaseEntity
    {
        // Id,FirstName,LastName,UserName,Password,EmailAddress,DOB,Phone,ActivationCode,Gender,Status,CreatedOn,CreatedBy,UpdatedOn,UpdatedBy

        public virtual string FirstName { get; set; }
        public virtual string LastName { get; set; }

        public virtual string UserName { get; set; }
        public virtual string Password { get; set; }

        public virtual string EmailAddress { get; set; }
        public virtual DateTime DOB { get; set; }

        public virtual string Phone { get; set; }
        public virtual string ActivationCode { get; set; }

        public virtual string Gender { get; set; }
        public virtual int CreatedBy { get; set; }
        public virtual int? UpdatedBy { get; set; }
    }
}
