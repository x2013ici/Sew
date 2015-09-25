using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SewServiceRepository.DAL.ResponseModel
{
    public class ServiceResponse : BaseResponse
    {
        public virtual string ServiceName { get; set; }
        public virtual string Description { get; set; }

        public virtual string FolderName { get; set; }
        public virtual int ProviderId { get; set; }

        public virtual int CreatedBy { get; set; }
        public virtual int UpdatedBy { get; set; }

        public virtual ProviderResponse ProviderResponse { get; set; }

        public virtual List<ServiceDetailsResponse> ServiceDetailsResponseList { get; set; }
    }
}
