using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SewServiceRepository.DAL.Entities
{
    public class UserLoginSession : BaseEntity
    {
        // Id,UserId,SessionToken,DeviceMacId,Status,CreatedOn,UpdatedOn

        public virtual int UserId { get; set; }
        public virtual string SessionToken { get; set; }

        public virtual string DeviceMacId { get; set; }

        public virtual User User { get; set; }
    }
}
