using SewServiceRepository.DAL.Entities;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SewServiceRepository.DAL.Mapping
{
    public class UserSignupRequestMap : EntityTypeConfiguration<UserSignupRequest>
    {

        // Id,FirstName,LastName,UserName,Password,EmailAddress,DOB,Phone,ActivationCode,Gender,Status,CreatedOn,CreatedBy,UpdatedOn,UpdatedBy
        public UserSignupRequestMap()
        {
            this.ToTable("UserSignupRequest");
            HasKey(m => m.Id);
            Property(m => m.FirstName).IsRequired().HasMaxLength(50);
            Property(m => m.LastName).IsRequired().HasMaxLength(50);
            Property(m => m.UserName).IsRequired().HasMaxLength(20);

            Property(m => m.EmailAddress).IsRequired().HasMaxLength(50);
            Property(m => m.Password).IsRequired();
            Property(m => m.DOB).IsRequired();

            Property(m => m.Phone).IsRequired();

            Property(m => m.Gender).IsRequired();
            Property(m => m.ActivationCode).IsOptional();

            Property(m => m.Status).IsRequired();
            Property(m => m.CreatedOn).IsRequired();
            Property(m => m.UpdatedOn).IsOptional();

            Property(m => m.CreatedBy).IsRequired();
            Property(m => m.UpdatedBy).IsOptional();
        }
    }
}
