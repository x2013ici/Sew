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
    public class ProviderService : ModelService<Provider>
    {
        public SewDBContext dbContext;
        public ProviderService()
        {
            this.dbContext = (SewDBContext)ServiceBase.RepositoryBase.context;
        }

        public ProviderResponse ToModelResponse (Provider provider)
        {
            if (provider == null)
                return null;

            var responseModel = new ProviderResponse()
            {
                AddressId = provider.AddressId,
                CreatedBy = provider.CreatedBy,
                CreatedOn = provider.CreatedOn,
                Email = provider.Email,
                Fax = provider.Fax,
                Id = provider.Id,
                Name = provider.Name,
                Phone = provider.Phone,
                Status = provider.Status,
                UpdatedBy = Convert.ToInt32(provider.UpdatedBy),
                UpdatedOn = provider.UpdatedOn
            };

            return responseModel;
        }
    }
}
