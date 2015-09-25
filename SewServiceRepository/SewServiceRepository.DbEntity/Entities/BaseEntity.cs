using SewServiceRepository.DAL.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SewServiceRepository.DAL.Entities
{
    public class BaseEntity : IBaseEntity
    {
        public virtual int Id { get; set; }
        public virtual int Status { get; set; }

        public virtual DateTime CreatedOn { get; set; }
        public virtual DateTime? UpdatedOn { get; set; }

    }
}
