using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SewServiceRepository.DAL.ResponseModel
{
    public class UserLoginSessionResponse : BaseResponse
    {
        public virtual int UserId { get; set; }
        public virtual string SessionToken { get; set; }

        public virtual string DeviceMacId { get; set; }
    }
}
