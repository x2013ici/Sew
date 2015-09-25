using SewServiceRepository.DAL.Entities;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SewServiceRepository.DAL.Mapping
{
    public class UserTypeMap : EntityTypeConfiguration<UserType>
    {

        // Id,Name,Description,Status,CreatedOn,UpdatedOn
        public UserTypeMap()
        {
            this.ToTable("UserType");
            HasKey(m => m.Id);
            Property(m => m.Name).IsRequired().HasMaxLength(50);
            Property(m => m.Description).IsOptional();

            Property(m => m.Status).IsRequired();
            Property(m => m.CreatedOn).IsRequired();
            Property(m => m.UpdatedOn).IsOptional();

        }
    }
}
