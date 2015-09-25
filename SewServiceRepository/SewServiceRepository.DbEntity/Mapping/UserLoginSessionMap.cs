using SewServiceRepository.DAL.Entities;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SewServiceRepository.DAL.Mapping
{
    public class UserLoginSessionMap : EntityTypeConfiguration<UserLoginSession>
    {

        // Id,UserId,SessionToken,DeviceMacId,Status,CreatedOn,UpdatedOn
        public UserLoginSessionMap()
        {
            this.ToTable("UserLoginSession");
            HasKey(m => m.Id);
            Property(m => m.UserId).IsRequired();
            Property(m => m.SessionToken).IsRequired();

            Property(m => m.DeviceMacId).IsOptional();
            Property(m => m.Status).IsRequired();
            Property(m => m.CreatedOn).IsRequired();
            Property(m => m.UpdatedOn).IsOptional();

            this.HasRequired(p => p.User).WithMany().HasForeignKey(q => q.UserId);
        }
    }
}
