using SewServiceRepository.DAL.Entities;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SewServiceRepository.DAL.Mapping
{
    public class CountryMap : EntityTypeConfiguration<Country>
    {

        // Id,Name,Code,Status,CreatedOn,UpdatedOn
        public CountryMap()
        {
            this.ToTable("Country");
            HasKey(m => m.Id);
            Property(m => m.Name).IsRequired().HasMaxLength(100);
            Property(m => m.Code).IsRequired().HasMaxLength(10);
            Property(m => m.Status).IsRequired();

            Property(m => m.CreatedOn).IsRequired();
            Property(m => m.UpdatedOn).IsOptional();
        }
    }
}
