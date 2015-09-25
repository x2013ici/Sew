using SewServiceRepository.DAL.Entities;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SewServiceRepository.DAL.Mapping
{
    public class AddressMap : EntityTypeConfiguration<Address>
    {

        // Id,Street,CountryId,City,State,Zipcode,Status,CreatedOn,UpdatedOn
        public AddressMap()
        {
            this.ToTable("Address");
            HasKey(m => m.Id);
            Property(m => m.Street).IsRequired().HasMaxLength(100);
            Property(m => m.CountryId).IsRequired();
            Property(m => m.City).IsRequired();

            Property(m => m.State).IsRequired();
            Property(m => m.Status).IsRequired();

            Property(m => m.ZipCode).IsRequired();
            Property(m => m.CreatedOn).IsRequired();
            Property(m => m.UpdatedOn).IsOptional();
     
            this.HasRequired(p => p.Country).WithMany().HasForeignKey(q => q.CountryId);
        }
    }
}
