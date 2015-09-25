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
    public class UserService : ModelService<User>
    {

        public SewDBContext dbContext;
        public UserService()
        {
            this.dbContext = (SewDBContext)ServiceBase.RepositoryBase.context;
        }

        public UserResponse ToModelResponse(User user)
        {

            Address address = null;

            if (user == null)
                return null;

            if(user.AddressId >0){
                address = new AddressServices().GetSingle(x => x.Id == user.AddressId);
            }

            var responseModel = new UserResponse()
            {
                AddressId = user.Id,
                AddressResponse = new AddressServices().ToModelResponse(address),
                ContactNumber = user.ContactNumber,
                CreatedBy = user.CreatedBy,
                CreatedOn = user.CreatedOn,
                DOB = user.DOB,
                Email = user.Email,
                FirstName = user.FirstName,
                Gender = user.Gender,
                Id = user.Id,
                LastName = user.LastName,
                Password = user.Password,
                ProfilePicture = user.ProfilePicture,
                ProfilePictureThumbnail = user.ProfilePictureThumbnail,
                ProviderId = user.ProviderId,
                Status = user.Status,
                UpdatedBy = user.UpdatedBy,
                UpdatedOn = user.UpdatedOn,
                UploadPath = user.UploadPath,
                UserName = user.UserName,
                UserTypeId = user.UserTypeId
            };

            return responseModel;

        }
    }
}
