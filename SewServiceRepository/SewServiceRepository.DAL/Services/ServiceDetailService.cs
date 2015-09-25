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
    public class ServiceDetailService : ModelService<ServiceDetails>
    {

        public SewDBContext dbContext;
        public ServiceDetailService()
        {
            this.dbContext = (SewDBContext)ServiceBase.RepositoryBase.context;
        }

        public ServiceDetailsResponse ToModelResponse(ServiceDetails serviceDetails)
        {

            if (serviceDetails == null)
                return null;

            var responseModel = new ServiceDetailsResponse()
            {
                CreatedOn = serviceDetails.CreatedOn,
                Id = serviceDetails.Id,
                MimeType = serviceDetails.MimeType,
                ServiceFileName = serviceDetails.ServiceFileName,
                ServiceFileTypeId = serviceDetails.ServiceFileTypeId,
                ServiceId = serviceDetails.ServiceId,
                Status = serviceDetails.Status,
                UpdatedOn = serviceDetails.UpdatedOn,
                UploadedPath = serviceDetails.UploadedPath,
                WebURL = serviceDetails.WebURL
            };

            return responseModel;
        }
    }
}
