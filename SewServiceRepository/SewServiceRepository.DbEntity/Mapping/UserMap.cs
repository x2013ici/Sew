using SewServiceRepository.DAL.Entities;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SewServiceRepository.DAL.Mapping
{
    public class UserMap : EntityTypeConfiguration<User>
    {

        public UserMap()
        {
            // Id,FirstName,LastName,UserName,Email,Password,DOB,ContactNumber,UploadPath,ProfilePicture,ProfilePictureThumbnail,Gender,
            // UserTypeId,CompanyId,AddressId,Status,CreatedOn,CreatedBy,UpdatedOn,UpdatedBy
            this.ToTable("User");
            HasKey(m => m.Id);
            Property(m => m.FirstName).IsRequired().HasMaxLength(50);
            Property(m => m.LastName).IsRequired().HasMaxLength(50);
            Property(m => m.UserName).IsRequired().HasMaxLength(20);

            Property(m => m.Email).IsRequired().HasMaxLength(50);
            Property(m =>m.Password).IsRequired();
            Property(m => m.DOB).IsRequired();

            Property(m => m.ContactNumber).IsRequired();
            Property(m => m.UploadPath).IsRequired();

            Property(m => m.ProfilePicture).IsOptional();
            Property(m => m.ProfilePictureThumbnail).IsOptional();

            Property(m => m.Gender).IsRequired();
            Property(m => m.UserTypeId).IsRequired();

            Property(m => m.ProviderId).IsRequired();
            Property(m => m.AddressId).IsRequired();

            Property(m => m.Status).IsRequired();
            Property(m => m.CreatedOn).IsRequired();
            Property(m => m.UpdatedOn).IsOptional();

            Property(m => m.CreatedBy).IsRequired();
            Property(m => m.UpdatedBy).IsOptional();

            this.HasRequired(p => p.UserType).WithMany().HasForeignKey(q => q.UserTypeId);
            this.HasRequired(p => p.Address).WithMany().HasForeignKey(q => q.AddressId);
            this.HasRequired(p => p.Provider).WithMany().HasForeignKey(q => q.ProviderId);

        }
    }
}
