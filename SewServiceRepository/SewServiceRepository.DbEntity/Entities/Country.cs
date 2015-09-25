using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SewServiceRepository.DAL.Entities
{
    public class Country : BaseEntity
    {
        // Id,Name,Code,Status,CreatedOn,UpdatedOn
        public virtual string Name { get; set; }
        public virtual string Code { get; set; }
    }
}
