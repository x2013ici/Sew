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
    public class OwlsService : ModelService<Service>
    {

        public SewDBContext dbContext;
        public OwlsService()
        {
            this.dbContext = (SewDBContext)ServiceBase.RepositoryBase.context;
        }

        public ServiceResponse ToModelResponse(Service service)
        {

            if (service == null)
                return null;

            var responseModel = new ServiceResponse()
            {
                CreatedBy = service.CreatedBy,
                CreatedOn = service.CreatedOn,
                Description = service.Description,
                FolderName = service.FolderName,
                Id = service.Id,
                ProviderId = service.ProviderId,
                ServiceName = service.ServiceName,
                Status = service.Status,
                UpdatedBy = Convert.ToInt32(service.UpdatedBy),
                UpdatedOn = service.UpdatedOn
            };

            return responseModel;
        }

        public ServiceResponse ToModelResponse(Service service, List<ServiceDetails> serviceDetailsList)
        {

            List<ServiceDetailsResponse> serviceDetailsResponseList = new List<ServiceDetailsResponse>();

            if (service == null)
                return null;

            if(serviceDetailsList.Count >0)
            {
                foreach (ServiceDetails servicedetails in serviceDetailsList)
                {
                    var response = new ServiceDetailService().ToModelResponse(servicedetails);
                    serviceDetailsResponseList.Add(response);

                }
            }

            var responseModel = new ServiceResponse()
            {
                CreatedBy = service.CreatedBy,
                CreatedOn = service.CreatedOn,
                Description = service.Description,
                FolderName = service.FolderName,
                Id = service.Id,
                ProviderId = service.ProviderId,
                ServiceName = service.ServiceName,
                Status = service.Status,
                UpdatedBy = Convert.ToInt32(service.UpdatedBy),
                UpdatedOn = service.UpdatedOn,
                ServiceDetailsResponseList = serviceDetailsResponseList
            };

            return responseModel;
        }

        public ServiceResponse ToModelResponse(Service service, Provider provider, List<ServiceDetails> serviceDetailsList)
        {

            ProviderResponse providerResponse = null;
            List<ServiceDetailsResponse> serviceDetailsResponseList = new List<ServiceDetailsResponse>();

            if (service == null)
                return null;

            if (provider !=null)
            {
                providerResponse = new ProviderService().ToModelResponse(provider);
            }
            if (serviceDetailsList.Count > 0)
            {
                foreach (ServiceDetails servicedetails in serviceDetailsList)
                {
                    var response = new ServiceDetailService().ToModelResponse(servicedetails);
                    serviceDetailsResponseList.Add(response);

                }
            }

            var responseModel = new ServiceResponse()
            {
                CreatedBy = service.CreatedBy,
                CreatedOn = service.CreatedOn,
                Description = service.Description,
                FolderName = service.FolderName,
                Id = service.Id,
                ProviderId = service.ProviderId,
                ServiceName = service.ServiceName,
                Status = service.Status,
                UpdatedBy = Convert.ToInt32(service.UpdatedBy),
                UpdatedOn = service.UpdatedOn,
                ProviderResponse = providerResponse,
                ServiceDetailsResponseList = serviceDetailsResponseList
            };

            return responseModel;
        }
    }
}
