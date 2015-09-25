using System;
using System.Data;
using System.Configuration;
using System.Linq;
using System.Web;
using System.Xml.Linq;
using System.Net.Mail;
using System.Collections.Generic;
using System.Net;
using System.IO;
using System.Collections;
using SewServiceRepository;
using System.Web.Hosting;
using SewServiceRepository.Common.Configuration;



namespace SewServiceRepository.Common.Helper
{
    public class MailerHelper
    {        

        #region Properties     
        
        private static bool AdminEmailUseDefaultCredentials
        {
            get
            {
                return false;
            }
        }

        /// <summary>
        /// Gets or sets a value that controls whether the SmtpClient uses Secure Sockets Layer (SSL) to encrypt the connection
        /// </summary>
        private static bool AdminEmailEnableSsl
        {
            get
            {
                return false;
            }
        }

       
        #endregion

        #region "Send Email Method"
        private static bool SendEmail(string Subject, string Body, string From, List<string> To, List<string> bcc, List<string> cc, List<string> attachments)
        {
            try
            {
                MailMessage message = new MailMessage();
                message.From = new MailAddress(From);

                foreach (string add in To)
                    message.To.Add(add);

                if (bcc != null)
                {
                    foreach (string add in bcc)
                        message.Bcc.Add(add);
                }

                if (cc != null)
                {
                    foreach (string add in cc)
                        message.CC.Add(add);
                }
                message.Subject = Subject;
                message.BodyEncoding = System.Text.Encoding.GetEncoding("utf-8");
                //message.Body = Body;
                //message.IsBodyHtml = true;

                System.Net.Mail.AlternateView plainView = System.Net.Mail.AlternateView.CreateAlternateViewFromString
                    (System.Text.RegularExpressions.Regex.Replace(Body, @"<(.|\n)*?>", string.Empty), null, "text/plain");
                System.Net.Mail.AlternateView htmlView = System.Net.Mail.AlternateView.CreateAlternateViewFromString(Body, null, "text/html");
                message.AlternateViews.Add(plainView);
                message.AlternateViews.Add(htmlView);

                SmtpClient smtpClient = new SmtpClient();

                smtpClient.UseDefaultCredentials = AdminEmailUseDefaultCredentials;
                smtpClient.Host = UIConfig.EmailHost;
                smtpClient.Port = UIConfig.SMTP;
                smtpClient.EnableSsl = AdminEmailEnableSsl;

                if (AdminEmailUseDefaultCredentials)
                    smtpClient.Credentials = CredentialCache.DefaultNetworkCredentials;
                else
                    smtpClient.Credentials = new NetworkCredential(UIConfig.EmailUser, UIConfig.EmailPassword);

                smtpClient.Send(message);

                return true;
            }
            catch (Exception ex)
            {
                return false;
            }

        }

        private static bool SendEmail(string Subject, string Body, string From, string To)
        {
            try
            {
                MailMessage message = new MailMessage();
                message.From = new MailAddress(From,"GroupConnect Support Team");
                message.To.Add(To);

                message.Subject = Subject;
                message.BodyEncoding = System.Text.Encoding.GetEncoding("utf-8");
                //message.Body = Body;
                //message.IsBodyHtml = true;

                System.Net.Mail.AlternateView plainView = System.Net.Mail.AlternateView.CreateAlternateViewFromString
                    (System.Text.RegularExpressions.Regex.Replace(Body, @"<(.|\n)*?>", string.Empty), null, "text/plain");
                System.Net.Mail.AlternateView htmlView = System.Net.Mail.AlternateView.CreateAlternateViewFromString(Body, null, "text/html");
                message.AlternateViews.Add(plainView);
                message.AlternateViews.Add(htmlView);

                SmtpClient smtpClient = new SmtpClient();

                smtpClient.UseDefaultCredentials = AdminEmailUseDefaultCredentials;
                smtpClient.Host = UIConfig.EmailHost;
                smtpClient.Port = UIConfig.SMTP;
                smtpClient.EnableSsl = AdminEmailEnableSsl;

                if (AdminEmailUseDefaultCredentials)
                    smtpClient.Credentials = CredentialCache.DefaultNetworkCredentials;
                else
                    smtpClient.Credentials = new NetworkCredential(UIConfig.EmailUser, UIConfig.EmailPassword);

                smtpClient.Send(message);

                return true;
            }
            catch (Exception ex)
            {
                return false;
            }

        }
        #endregion

        #region Public Method
        

        //public static bool SendRegistrationEmail(string recipient, string applicationName, string name, string userName, string password, int userType)
        //{
        //    Hashtable templateVars = new Hashtable();

        //    templateVars.Add("ApplicationName", applicationName);
        //    templateVars.Add("name", name);
        //    templateVars.Add("userName", userName);

        //    Parser parser = new Parser();

        //    if (userType == Convert.ToInt32(Enums.UserType.EmailUser))
        //    {
        //        templateVars.Add("userType", "email");
        //        templateVars.Add("password", password);
        //        parser = new Parser(HostingEnvironment.MapPath("~/" + Config.MailBodyFolderPath + "/UserRegistrationAsEmailUser.htm"), templateVars);
        //    }
        //    if (userType == Convert.ToInt32(Enums.UserType.FacebookUser))
        //    {
        //        templateVars.Add("userType", "facebook");
        //        templateVars.Add("login", "Facebook Login Id");
        //        parser = new Parser(HostingEnvironment.MapPath("~/" + Config.MailBodyFolderPath + "/UserRegistrationAsOtherUser.htm"), templateVars);
        //    }
        //    if (userType == Convert.ToInt32(Enums.UserType.Twitteruser))
        //    {
        //        templateVars.Add("userType", "twitter");
        //        templateVars.Add("login", "Twitter Login Id");
        //        parser = new Parser(HostingEnvironment.MapPath("~/" + Config.MailBodyFolderPath + "/UserRegistrationAsOtherUser.htm"), templateVars);
        //    }

        //    string mailBody = parser.Parse();
            
        //    //string mailBody = "You are Successfully Registered";

        //    string subject = "User Registration";

        //    string from = Config.MailAddressFrom;

        //    return SendEmail(subject, mailBody, from, recipient);            
        //}

        public static bool SendCompanyInvitationCode(string senderName, string recipient,string activationCode,string companyName)
        {
            string applicationName = ConfigurationManager.AppSettings["ApplicationName"];

            string siteurl = ConfigurationManager.AppSettings["gdsiteurl"];

            Hashtable templateVars = new Hashtable();
            templateVars.Add("ApplicationName", applicationName);
            templateVars.Add("email", recipient);
            templateVars.Add("companyName", companyName);
            templateVars.Add("activationCode", activationCode);
            templateVars.Add("senderName", senderName);
            

            Parser parser = new Parser();

            parser = new Parser(HostingEnvironment.MapPath("~/" + UIConfig.MailBodyFolderPath + "/CompanyInvitationCode.htm"), templateVars);

            string mailBody = parser.Parse();

            //string mailBody = "You are Successfully Registered";

            string subject = senderName + " invited you to join " + companyName + " on " + applicationName;

            string from = UIConfig.MailAddressFrom;

            return SendEmail(subject, mailBody, from, recipient);
        }

        public static bool SendCompanySignupRequestEmailToSuperAdmin(string emailAddress, string companyName, string address, string contactPerson, string contactEmail)
        {
            string applicationName = ConfigurationManager.AppSettings["ApplicationName"];

            Hashtable templateVars = new Hashtable();
            templateVars.Add("ApplicationName", applicationName);
            templateVars.Add("companyName", companyName);
            templateVars.Add("address", address);
            templateVars.Add("contactperson", contactPerson);
            templateVars.Add("emailaddress", contactEmail);


            Parser parser = new Parser();

            parser = new Parser(HostingEnvironment.MapPath("~/" + UIConfig.MailBodyFolderPath + "/CompanySignupRequestEmail.htm"), templateVars);

            string mailBody = parser.Parse();

            //string mailBody = "You are Successfully Registered";

            string subject = "New Company Signup Request!";

            string from = UIConfig.MailAddressFrom;

            return SendEmail(subject, mailBody, from, emailAddress);
        }

        public static bool RejectCompanySignupRequestEmail(string emailAddress)
        {
            string applicationName = ConfigurationManager.AppSettings["ApplicationName"];

            Hashtable templateVars = new Hashtable();
            templateVars.Add("ApplicationName", applicationName);

            Parser parser = new Parser();

            parser = new Parser(HostingEnvironment.MapPath("~/" + UIConfig.MailBodyFolderPath + "/RejectCompanySignupRequest.htm"), templateVars);

            string mailBody = parser.Parse();

            //string mailBody = "You are Successfully Registered";

            string subject = "Your Company Signup Request has been Rejected!";

            string from = UIConfig.MailAddressFrom;

            return SendEmail(subject, mailBody, from, emailAddress);
        }
        public static bool ConfirmCompanySignupRequestAcceptance(string emailAddress, string userName, string password)
        {
            string applicationName = ConfigurationManager.AppSettings["ApplicationName"];

            Hashtable templateVars = new Hashtable();
            templateVars.Add("ApplicationName", applicationName);
            templateVars.Add("userName", userName);
            templateVars.Add("password", password);

            Parser parser = new Parser();

            parser = new Parser(HostingEnvironment.MapPath("~/" + UIConfig.MailBodyFolderPath + "/ConfirmCompanyAcceptance.htm"), templateVars);

            string mailBody = parser.Parse();

            //string mailBody = "You are Successfully Registered";

            string subject = "Welcome to Group.Direct App Suite!";

            string from = UIConfig.MailAddressFrom;

            return SendEmail(subject, mailBody, from, emailAddress);
        }
        public static bool SendSignupRequestMail(string recipient, string name, string activatiCode)
        {
            string applicationName = ConfigurationManager.AppSettings["ApplicationName"];
            
            Hashtable templateVars = new Hashtable();            
            templateVars.Add("ApplicationName", applicationName);
            templateVars.Add("email", recipient);
            templateVars.Add("name", name);
            templateVars.Add("activationCode", activatiCode);

            Parser parser = new Parser();

            parser = new Parser(HostingEnvironment.MapPath("~/" + UIConfig.MailBodyFolderPath + "/SignupRequestMail.htm"), templateVars);

            string mailBody = parser.Parse();

            //string mailBody = "You are Successfully Registered";

            string subject = "Activate your GroupConnect Apps account";

            string from = UIConfig.MailAddressFrom;

            return SendEmail(subject, mailBody, from, recipient);
        }

        public static bool SendConnectionInvitationMail(string recipient, string name, string requesterName)
        {
            string applicationName = ConfigurationManager.AppSettings["ApplicationName"];

            string url = ConfigurationManager.AppSettings["GroupDirectSignupUrl"];



            Hashtable templateVars = new Hashtable();
            templateVars.Add("ApplicationName", applicationName);
            templateVars.Add("email", recipient);
            templateVars.Add("name", name);
            templateVars.Add("requester", requesterName);
            templateVars.Add("url", url);

            Parser parser = new Parser();

            parser = new Parser(HostingEnvironment.MapPath("~/" + UIConfig.MailBodyFolderPath + "/ConnectInvitationMail.htm"), templateVars);

            string mailBody = parser.Parse();

            //string mailBody = "You are Successfully Registered";

            string subject = requesterName + " invited you to connect on group.direct";

            string from = UIConfig.MailAddressFrom;

            return SendEmail(subject, mailBody, from, recipient);
        }

        public static bool SendPasswordResetTokenEmail(string recipient, string applicationName, string name, string token, string userName)
        {
            Hashtable templateVars = new Hashtable();

            templateVars.Add("ApplicationName", applicationName);
            templateVars.Add("name", name);
            templateVars.Add("token", token);
            templateVars.Add("userName", userName);

            Parser parser = new Parser();

            parser = new Parser(HostingEnvironment.MapPath("~/" + UIConfig.MailBodyFolderPath + "/PasswordResetTokenMail.htm"), templateVars);
            
            string mailBody = parser.Parse();

            //string mailBody = "You are Successfully Registered";

            string subject = "Group.Direct and GroupConnect Apps password reset";

            string from = UIConfig.MailAddressFrom;

            return SendEmail(subject, mailBody, from, recipient);
        }

        public static bool ConfirmingNewPasswordEmail(string recipient, string applicationName, string name, string newPassword)
        {
            Hashtable templateVars = new Hashtable();

            templateVars.Add("ApplicationName", applicationName);
            templateVars.Add("name", name);
            templateVars.Add("newPassword", newPassword);            

            Parser parser = new Parser();

            parser = new Parser(HostingEnvironment.MapPath("~/" + UIConfig.MailBodyFolderPath + "/ConfirmingNewPasswordMail.htm"), templateVars);

            string mailBody = parser.Parse();

            //string mailBody = "You are Successfully Registered";

            string subject = "New password for Group.Direct and GroupConnect";

            string from = UIConfig.MailAddressFrom;

            return SendEmail(subject, mailBody, from, recipient);
        }
        #endregion
    }
}
