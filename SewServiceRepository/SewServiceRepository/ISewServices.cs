using SewServiceRepository.DAL.ResponseModel;
using SewServiceRepository.DAL.Services;
using SewServiceRepository.ResponseWrapper;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

namespace SewServiceRepository
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "ISewServices" in both code and config file together.
    [ServiceContract]
    public interface ISewServices
    {
        [OperationContract]
        [WebInvoke(Method = "GET", RequestFormat = WebMessageFormat.Json, ResponseFormat = WebMessageFormat.Json, BodyStyle = WebMessageBodyStyle.WrappedRequest, UriTemplate = "/")]
        QueryResult<string> DisplayMessage();

        [OperationContract]
        [WebInvoke(Method = "POST", RequestFormat = WebMessageFormat.Json, ResponseFormat = WebMessageFormat.Json, BodyStyle = WebMessageBodyStyle.WrappedRequest, UriTemplate = UriTemplates.Uris.Login)]
        QueryResult<UserResponse> Login(string userName, string password);

        [OperationContract]
        [WebInvoke(Method = "POST", RequestFormat = WebMessageFormat.Json, ResponseFormat = WebMessageFormat.Json, BodyStyle = WebMessageBodyStyle.WrappedRequest, UriTemplate = UriTemplates.Uris.Logout)]
        QueryResult<string> Logout(int userId, string st);

        [OperationContract]
        [WebInvoke(Method = "POST", RequestFormat = WebMessageFormat.Json, ResponseFormat = WebMessageFormat.Json, BodyStyle = WebMessageBodyStyle.WrappedRequest, UriTemplate = UriTemplates.Uris.GetServiceById)]
        QueryResult<ServiceResponse> GetServiceById(int serviceId, string st);

        [OperationContract]
        [WebInvoke(Method = "POST", RequestFormat = WebMessageFormat.Json, ResponseFormat = WebMessageFormat.Json, BodyStyle = WebMessageBodyStyle.WrappedRequest, UriTemplate = UriTemplates.Uris.GetAllServicesbyProviderId)]
        QueryResultSet<ServiceResponse> GetAllServicesByProviderId(int providerId, string st);

        [OperationContract]
        [WebInvoke(Method = "POST", RequestFormat = WebMessageFormat.Json, ResponseFormat = WebMessageFormat.Json, BodyStyle = WebMessageBodyStyle.WrappedRequest, UriTemplate = UriTemplates.Uris.GetAllServices)]
        QueryResultSet<ServiceResponse> GetAllServices(string st);

        

    }
}
