using SewServiceRepository.DAL.Base;
using SewServiceRepository.DAL.ResponseModel;
using SewServiceRepository.DAL;
using SewServiceRepository.DAL.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SewServiceRepository.DAL.Services
{
    public class AddressServices : ModelService<Address>
    {

        public SewDBContext dbContext;
        public AddressServices()
        {
            this.dbContext = (SewDBContext)ServiceBase.RepositoryBase.context;
        }

        public AddressResponse ToModelResponse(Address address)
        {
            
            if(address == null)
                return null;

            var responseModel = new AddressResponse()
            {
                City = address.City,
                CountryId = address.CountryId,
                CreatedOn = address.CreatedOn,
                Id = address.Id,
                State = address.State,
                Status = address.Status,
                Street = address.Street,
                UpdatedOn = address.UpdatedOn,
                ZipCode = address.ZipCode
            };

            return responseModel;
        }
    }
}
