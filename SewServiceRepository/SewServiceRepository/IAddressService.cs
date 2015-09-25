using SewServiceRepository.DAL.ResponseModel;
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
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "IAddressService" in both code and config file together.
    [ServiceContract]
    public interface IAddressService
    {
        [OperationContract]
        [WebInvoke(Method = "GET", RequestFormat = WebMessageFormat.Json, ResponseFormat = WebMessageFormat.Json, BodyStyle = WebMessageBodyStyle.WrappedRequest, UriTemplate = "/")]
        QueryResult<string> DisplayMessage();

        [OperationContract]
        [WebInvoke(Method = "POST", RequestFormat = WebMessageFormat.Json, ResponseFormat = WebMessageFormat.Json, BodyStyle = WebMessageBodyStyle.WrappedRequest, UriTemplate = UriTemplates.Uris.GetAddresses)]
        QueryResultSet<AddressResponse> GetAddresses();
    }
}
