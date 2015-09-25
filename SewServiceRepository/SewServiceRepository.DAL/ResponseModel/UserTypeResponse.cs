using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SewServiceRepository.DAL.ResponseModel
{
    public class UserTypeResponse : BaseResponse
    {
        public virtual string Name { get; set; }
        public virtual string Description { get; set; }
    }
}
