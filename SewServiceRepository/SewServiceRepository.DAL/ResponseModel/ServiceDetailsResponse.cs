using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SewServiceRepository.DAL.ResponseModel
{
    public class ServiceDetailsResponse : BaseResponse
    {
        public virtual int ServiceId { get; set; }
        public virtual string ServiceFileName { get; set; }

        public virtual string MimeType { get; set; }
        public virtual string WebURL { get; set; }

        public virtual string UploadedPath { get; set; }
        public virtual int ServiceFileTypeId { get; set; }
    }
}
