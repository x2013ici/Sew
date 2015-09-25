using SewServiceRepository.DAL.Entities;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SewServiceRepository.DAL.Mapping
{
    public class ProviderSignupRequesterMap : EntityTypeConfiguration<ProviderSignupRequester>
    {

        public ProviderSignupRequesterMap()
        {

            // Id,FirstName,LastName,UserName,Password,Phone,Email,DOB,Gender,AddressId,Status,CreatedOn,UpdatedOn
            this.ToTable("ProviderSignupRequester");
            HasKey(m => m.Id);
            Property(m => m.FirstName).IsRequired().HasMaxLength(50);
            Property(m => m.LastName).IsRequired().HasMaxLength(50);

            Property(m => m.UserName).IsRequired().HasMaxLength(20);
            Property(m => m.Password).IsRequired().HasMaxLength(12);

            Property(m => m.Phone).IsRequired();
            Property(m => m.Email).IsRequired();

            Property(m => m.DOB).IsRequired();
            Property(m => m.Gender).IsRequired();
            Property(m => m.AddressId).IsRequired();

            Property(m => m.Status).IsRequired();
            Property(m => m.CreatedOn).IsRequired();
            Property(m => m.UpdatedOn).IsOptional();

            this.HasRequired(p => p.Address).WithMany().HasForeignKey(q => q.AddressId);
        }
    }
}
