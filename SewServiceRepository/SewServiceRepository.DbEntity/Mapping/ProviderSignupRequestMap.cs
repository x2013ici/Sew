using SewServiceRepository.DAL.Entities;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SewServiceRepository.DAL.Mapping
{
    public class ProviderSignupRequestMap : EntityTypeConfiguration<ProviderSignupRequest>
    {

        public ProviderSignupRequestMap()
        {
            // Id,Name,Phone,Email,Fax,AddressId,Status,CreatedOn,UpdatedOn
            this.ToTable("ProviderSignupRequest");
            HasKey(m => m.Id);

            Property(m => m.Name).IsRequired().HasMaxLength(100);
            Property(m => m.Phone).IsRequired();
            Property(m => m.Email).IsRequired();

            Property(m => m.Fax).IsOptional();
            Property(m => m.AddressId).IsRequired();
            Property(m => m.Status).IsRequired();

            Property(m => m.CreatedOn).IsRequired();
            Property(m => m.UpdatedOn).IsOptional();

            this.HasRequired(p => p.Address).WithMany().HasForeignKey(q => q.AddressId);

        }
    }
}
