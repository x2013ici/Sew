using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SewServiceRepository.DAL.Entities
{
    public class ServiceDetails : BaseEntity
    {
        //Id,ServiceId,ServiceFileName,MimeType,WebURL,UploadedPath,ServiceFileTypeId,Status, CreatedOn, UpdatedOn

        public virtual int ServiceId { get; set; }
        public virtual string ServiceFileName { get; set; }

        public virtual string MimeType { get; set; }
        public virtual string WebURL { get; set; }

        public virtual string UploadedPath { get; set; }
        public virtual int ServiceFileTypeId { get; set; }

        public virtual Service Service { get; set; }

    }
}
