using SewServiceRepository.DAL.Entities;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SewServiceRepository.DAL.Mapping
{
    public class ServiceDetailsMap : EntityTypeConfiguration<ServiceDetails>
    {
        // Id,ServiceId,ServiceFileName,MimeType,WebURL,UploadedPath,ServiceFileTypeId,Status,CreatedOn,UpdatedOn

        public ServiceDetailsMap()
        {
            this.ToTable("ServiceDetails");
            HasKey(m => m.Id);
            Property(m => m.ServiceId).IsRequired();
            Property(m => m.ServiceFileName).IsRequired().HasMaxLength(50);

            Property(m => m.MimeType).IsRequired();
            Property(m => m.WebURL).IsOptional();
            Property(m => m.UploadedPath).IsRequired();

            Property(m => m.ServiceFileTypeId).IsRequired();
            Property(m => m.Status).IsRequired();
            Property(m => m.CreatedOn).IsRequired();
            Property(m => m.UpdatedOn).IsOptional();

            this.HasRequired(p => p.Service).WithMany().HasForeignKey(q => q.ServiceId);
        }
    }
}
