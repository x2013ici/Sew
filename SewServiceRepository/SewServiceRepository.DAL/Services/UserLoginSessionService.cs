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
    public class UserLoginSessionService : ModelService<UserLoginSession>
    {

        public SewDBContext dbContext;
        public UserLoginSessionService()
        {
            this.dbContext = (SewDBContext)ServiceBase.RepositoryBase.context;
        }

        public UserLoginSessionResponse ToModelResponse(UserLoginSession userLoginSession)
        {
            if (userLoginSession == null)
                return null;

            var responseModel = new UserLoginSessionResponse()
            {
                CreatedOn = userLoginSession.CreatedOn,
                DeviceMacId = userLoginSession.DeviceMacId,
                Id = userLoginSession.Id,
                SessionToken = userLoginSession.SessionToken,
                Status = userLoginSession.Status,
                UpdatedOn = userLoginSession.UpdatedOn,
                UserId = userLoginSession.UserId
            };

            return responseModel;
        }
    }
}
