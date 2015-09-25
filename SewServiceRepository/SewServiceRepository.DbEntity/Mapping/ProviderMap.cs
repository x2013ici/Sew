using SewServiceRepository.DAL.Entities;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SewServiceRepository.DAL.Mapping
{
    public class ProviderMap : EntityTypeConfiguration<Provider>
    {
        // Id,Name,Phone,Email,Fax,AddressId,Status,CreatedOn,CreatedBy,UpdatedOn,UpdatedBy

        public ProviderMap()
        {
            this.ToTable("Provider");
            HasKey(m => m.Id);

            Property(m => m.Name).IsRequired();
            Property(m => m.Email).IsRequired();

            Property(m => m.Phone).IsRequired();
            Property(m => m.Fax).IsOptional();

            Property(m => m.AddressId).IsRequired();
            Property(m => m.Status).IsRequired();

            Property(m => m.CreatedOn).IsRequired();
            Property(m => m.CreatedBy).IsRequired();

            Property(m => m.UpdatedOn).IsOptional();
            Property(m => m.UpdatedBy).IsOptional();

            this.HasRequired(p => p.Address).WithMany().HasForeignKey(q => q.AddressId);
        }
    }
}
