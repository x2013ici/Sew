using SewServiceRepository.DAL.Base;
using SewServiceRepository.DAL.Entities;
using SewServiceRepository.DAL.ResponseModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SewServiceRepository.DAL.Services
{
    public class UserTypeService : ModelService<UserType>
    {
        public SewDBContext dbContext;
        public UserTypeService()
        {
            this.dbContext = (SewDBContext)ServiceBase.RepositoryBase.context;
        }

        public UserTypeResponse ToModelResponse(UserType userType)
        {

            if (userType == null)
                return null;

            var responseModel = new UserTypeResponse()
            {
                CreatedOn = userType.CreatedOn,
                Description = userType.Description,
                Id = userType.Id,
                Name = userType.Name,
                Status = userType.Status,
                UpdatedOn = userType.UpdatedOn
            };

            return responseModel;
        }
    }
}
