using SewServiceRepository.DAL.Entities;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SewServiceRepository.DAL.Mapping
{
    public class ServiceMap : EntityTypeConfiguration<Service>
    {

        public ServiceMap()
        {
            //Id,ServiceName,Description,FolderName,ProviderId,Status,UploadedOn,UploadedBy,UpdatedOn,UpdatedBy

            this.ToTable("Service");
            HasKey(m => m.Id);
            Property(m => m.ServiceName).IsRequired().HasMaxLength(50);
            Property(m => m.Description).IsOptional().HasMaxLength(500);
            Property(m => m.FolderName).IsRequired();
            Property(m => m.ProviderId).IsRequired();

            Property(m => m.Status).IsRequired();
            Property(m => m.CreatedOn).IsRequired();
            Property(m => m.UpdatedOn).IsOptional();

            Property(m => m.CreatedBy).IsRequired();
            Property(m => m.UpdatedBy).IsOptional();

            this.HasRequired(p => p.Provider).WithMany().HasForeignKey(q => q.ProviderId);

        }
    }
}
