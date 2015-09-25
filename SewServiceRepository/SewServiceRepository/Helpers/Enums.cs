using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace SewServiceRepository.Helpers
{
    public class Enums
    {
        
        public enum UserStatus
        {
            Active =1,
            Inactive =0
        }

        public enum UserLoginSessionStatus
        {
            Active =1,
            Inactive =0
        }

        public enum ServiceStatus
        {
            Active = 1,
            Inactive = 0
        }
        public enum AddressStatus
        {
            Active=1,
            Inactive=0
        }
        public enum UserSingupRequest
        {
            Requested =1,
            Accepted =2,
            Denied =3,
            Deleted =4
        }

        public enum MessageCode
        {
            WarningMessage =1,
            ErrorMessage = 2
        }
    }
}