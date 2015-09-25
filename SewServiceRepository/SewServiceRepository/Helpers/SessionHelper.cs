using SewServiceRepository.DAL.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace SewServiceRepository.Helpers
{
    public class SessionHelper
    {
        public static bool IsValidSession(string st)
        {
            bool isValid = false;
            try
            {
                if (!string.IsNullOrEmpty(st))
                {
                    var item = new UserLoginSessionService().GetSingle(x => x.SessionToken == st);
                    if(item !=null)
                    {
                        isValid = true;
                    }
                }
            }
            catch(Exception ex)
            {
                isValid = false;
            }

            return isValid;
        }
    }
}