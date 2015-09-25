using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace SewServiceRepository.UriTemplates
{
    public class Uris
    {

        public const string Login = "login";
        public const string Logout = "logout";

        public const string DoProviderSignupRequest = "doprovidersignuprequest";
        public const string ActivateProviderSignupRequest = "activateprovidersignuprequest";

        public const string DoUserSignupRequest = "dousersignuprequest";
        public const string ActiveUserSignupRequest = "activeusersignuprequest";

        public const string GetAddresses = "getaddresses";

        public const string GetServiceById = "getservicebyid";
        public const string GetAllServicesbyProviderId = "getallservicesbyproviderid";
        public const string GetAllServices = "getallservices";
    }
}