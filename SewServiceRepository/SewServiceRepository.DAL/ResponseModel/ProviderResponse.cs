using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SewServiceRepository.DAL.ResponseModel
{
    public class ProviderResponse : BaseResponse
    {
        public virtual string Name { get; set; }
        public virtual string Phone { get; set; }
        public virtual string Email { get; set; }

        public virtual string Fax { get; set; }
        public virtual int AddressId { get; set; }

        public virtual int CreatedBy { get; set; }
        public virtual int UpdatedBy { get; set; }
    }
}
