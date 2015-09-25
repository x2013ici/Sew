using System;
using System.Collections.Generic;
using System.Configuration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SewServiceRepository.Common.Configuration
{
    public abstract class MailConfiguration
    {
        #region Mail

        public static string EmailHost
        {
            get { return ConfigurationManager.AppSettings["EmailHost"]; }
        }

        public static int SMTP
        {
            get { try { return Int32.Parse(ConfigurationManager.AppSettings["SMTP"]); } catch (Exception ex) { } return 25; }
        }

        public static string EmailUser
        {
            get { return ConfigurationManager.AppSettings["EmailUser"]; }
        }

        public static string EmailPassword
        {
            get { return ConfigurationManager.AppSettings["EmailPassword"]; }
        }

        public static string MailAddressFrom
        {
            get { return ConfigurationManager.AppSettings["MailAddressFrom"]; }
        }
        public static string MailBodyFolderPath
        {
            get { return ConfigurationManager.AppSettings["MailBodyFolderPath"]; }
        }
        #endregion
    }
}
