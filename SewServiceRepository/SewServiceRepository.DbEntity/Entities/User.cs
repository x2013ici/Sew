using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SewServiceRepository.DAL.Entities
{
    public class User : BaseEntity
    {
        // Id,FirstName,LastName,UserName,Email,Password,DOB,ContactNumber,UploadPath,ProfilePicture,ProfilePictureThumbnail,Gender,UserTypeId,
        // CompanyId,AddressId,Status,CreatedOn,CreatedBy,UpdatedOn,UpdatedBy

        public virtual string FirstName { get; set; }
        public virtual string LastName { get; set; }

        public virtual string UserName { get; set; }
        public virtual string Email { get; set; }

        public virtual string Password { get; set; }
        public virtual string DOB { get; set; }
        public virtual string ContactNumber { get; set; }

        public virtual string UploadPath { get; set; }
        public virtual string ProfilePicture { get; set; }
        public virtual string ProfilePictureThumbnail { get; set; }

        public virtual string Gender { get; set; }
        public virtual int UserTypeId { get; set; }

        public virtual int ProviderId { get; set; }
        public virtual int AddressId { get; set; }

        public virtual int CreatedBy { get; set; }
        public virtual int UpdatedBy { get; set; }

        public virtual UserType UserType { get; set; }
        public virtual Address Address { get; set; }
        public virtual Provider Provider { get; set; }

    }
}
