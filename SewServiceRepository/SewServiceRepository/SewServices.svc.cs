using SewServiceRepository.Common.Helper;
using SewServiceRepository.DAL.Entities;
using SewServiceRepository.DAL.ResponseModel;
using SewServiceRepository.DAL.Services;
using SewServiceRepository.Helpers;
using SewServiceRepository.ResponseWrapper;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace SewServiceRepository
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "SewServices" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select SewServices.svc or SewServices.svc.cs at the Solution Explorer and start debugging.
    public class SewServices : ISewServices
    {
        
        public ResponseWrapper.QueryResult<string> DisplayMessage()
        {
            QueryResult<string> result = new QueryResult<string>();

            try
            {
                result.IsResult = true;
                result.IsOperationSuccessful = true;
                result.Result = "Sew Repository Related Webservices!!!";
            }
            catch (Exception ex)
            {
                result.IsOperationSuccessful = false;
                result.IsResult = false;

                var err = new List<Message>();
                err.Add(new Message { Code = Convert.ToInt32(Enums.MessageCode.ErrorMessage), Text = ex.Message });
                result.ErrorMessages = err;
            }

            return result;
        }


        public QueryResultSet<ServiceResponse> GetAllServices(string st)
        {
            int serviceStatus = -1;

            List<ServiceDetails> serviceDetailsList = null;

            List<ServiceResponse> serviceResponseList = new List<ServiceResponse>();
            QueryResultSet<ServiceResponse> resultSet = new QueryResultSet<ServiceResponse>();

            try
            {
                if (string.IsNullOrEmpty(st))
                {

                    var err = new List<Message>();
                    err.Add(new Message { Code = Convert.ToInt32(Enums.MessageCode.WarningMessage), Text = "Session Token is empty" });
                    resultSet.InfoMessages = err;

                    resultSet.IsOperationSuccessful = false;
                    resultSet.IsResult = false;
                    resultSet.ResultSet = null;
                    return resultSet;
                }

                if (!SessionHelper.IsValidSession(st))
                {
                    var err = new List<Message>();
                    err.Add(new Message { Code = Convert.ToInt32(Enums.MessageCode.WarningMessage), Text = "Invalid Session Token" });
                    resultSet.InfoMessages = err;

                    resultSet.IsOperationSuccessful = false;
                    resultSet.IsResult = false;
                    resultSet.ResultSet = null;
                    return resultSet;
                }

                using (var owlsService = new OwlsService())
                {

                    serviceStatus = Convert.ToInt32(Enums.ServiceStatus.Active);
                    var serviceItems = owlsService.dbContext.Service.Where(x => x.Status == serviceStatus).ToList();

                    if (serviceItems.Count > 0)
                    {
                        serviceDetailsList = new List<ServiceDetails>();
                        foreach(Service service in serviceItems)
                        {
                            serviceDetailsList = new ServiceDetailService().dbContext.ServiceDetails.Where(x =>x.ServiceId == service.Id && x.Status == serviceStatus).ToList();    
                            var serviceResponse = owlsService.ToModelResponse(service, serviceDetailsList);
                            if (serviceResponse != null)
                            {
                                serviceResponseList.Add(serviceResponse);
                            }
                        }

                        resultSet.IsResult = true;
                        resultSet.IsOperationSuccessful = true;
                        resultSet.ResultSet = serviceResponseList;
                    }
                    else
                    {
                        var err = new List<Message>();
                        err.Add(new Message { Code = Convert.ToInt32(Enums.MessageCode.WarningMessage), Text = "Service list is empty" });
                        resultSet.InfoMessages = err;

                        resultSet.IsResult = false;
                        resultSet.IsOperationSuccessful = true;
                        resultSet.ResultSet = null;
                    }


                }
            }
            catch(Exception ex)
            {
                var err = new List<Message>();
                err.Add(new Message { Code = Convert.ToInt32(Enums.MessageCode.ErrorMessage), Text = ex.Message });
                resultSet.ErrorMessages = err;

                resultSet.IsResult = false;
                resultSet.IsOperationSuccessful = true;
                resultSet.ResultSet = null;
            }

            return resultSet;

        }

        public QueryResultSet<ServiceResponse> GetAllServicesByProviderId(int providerId, string st)
        {
            int serviceStatus = -1;

            Provider provider = null;
            ProviderResponse providerResponse = null;

            List<ServiceDetails> serviceDetailsList = null;

            List<ServiceResponse> serviceResponseList = new List<ServiceResponse>();
            QueryResultSet<ServiceResponse> resultSet = new QueryResultSet<ServiceResponse>();

            try
            {
                if (string.IsNullOrEmpty(st))
                {

                    var err = new List<Message>();
                    err.Add(new Message { Code = Convert.ToInt32(Enums.MessageCode.WarningMessage), Text = "Session Token is empty" });
                    resultSet.InfoMessages = err;

                    resultSet.IsOperationSuccessful = false;
                    resultSet.IsResult = false;

                    resultSet.ResultSet = null;
                    return resultSet;
                }

                if (!SessionHelper.IsValidSession(st))
                {
                    var err = new List<Message>();
                    err.Add(new Message { Code = Convert.ToInt32(Enums.MessageCode.WarningMessage), Text = "Invalid Session Token" });
                    resultSet.InfoMessages = err;

                    resultSet.IsOperationSuccessful = false;
                    resultSet.IsResult = false;
                    resultSet.ResultSet = null;
                    return resultSet;
                }

                if(providerId <=0)
                {
                    var err = new List<Message>();
                    err.Add(new Message { Code = Convert.ToInt32(Enums.MessageCode.WarningMessage), Text = "Provider id should be greather than zero" });
                    resultSet.InfoMessages = err;

                    resultSet.IsOperationSuccessful = false;
                    resultSet.IsResult = false;

                    resultSet.ResultSet = null;
                    return resultSet;
                }

                using (var owlsService = new OwlsService())
                {

                    provider = new ProviderService().GetSingle(x => x.Id == providerId);
                    if (provider != null)
                    {
                        providerResponse = new ProviderService().ToModelResponse(provider);

                        serviceStatus = Convert.ToInt32(Enums.ServiceStatus.Active);
                        var serviceItems = owlsService.dbContext.Service.Where(x => x.ProviderId == providerId && x.Status == serviceStatus).ToList();

                        if (serviceItems.Count > 0)
                        {
                            serviceDetailsList = new List<ServiceDetails>();
                            foreach (Service service in serviceItems)
                            {
                                serviceDetailsList = new ServiceDetailService().dbContext.ServiceDetails.Where(x => x.ServiceId == service.Id && x.Status == serviceStatus).ToList();

                                var serviceResponse = owlsService.ToModelResponse(service, provider, serviceDetailsList);

                                if (serviceResponse != null)
                                {
                                    serviceResponseList.Add(serviceResponse);
                                }
                            }

                            resultSet.IsResult = true;
                            resultSet.IsOperationSuccessful = true;
                            resultSet.ResultSet = serviceResponseList;
                        }
                        else
                        {
                            var err = new List<Message>();
                            err.Add(new Message { Code = Convert.ToInt32(Enums.MessageCode.WarningMessage), Text = "Service list is empty" });
                            resultSet.InfoMessages = err;

                            resultSet.IsResult = false;
                            resultSet.IsOperationSuccessful = true;
                            resultSet.ResultSet = null;
                            }
                    }
                    else
                    {
                        var err = new List<Message>();
                        err.Add(new Message { Code = Convert.ToInt32(Enums.MessageCode.WarningMessage), Text = "Provider not found" });
                        resultSet.InfoMessages = err;

                        resultSet.IsResult = false;
                        resultSet.IsOperationSuccessful = true;

                        resultSet.ResultSet = null;
                        resultSet.ResultSet = null;
                    }
                }
            }
            catch (Exception ex)
            {
                var err = new List<Message>();
                err.Add(new Message { Code = Convert.ToInt32(Enums.MessageCode.ErrorMessage), Text = ex.Message });
                resultSet.ErrorMessages = err;

                resultSet.IsResult = false;
                resultSet.IsOperationSuccessful = true;
                resultSet.ResultSet = null;
            }

            return resultSet;
        }


        public QueryResult<ServiceResponse> GetServiceById(int serviceId, string st)
        {
            
            QueryResult<ServiceResponse> result = new QueryResult<ServiceResponse>();
            try
            {
                
                if (string.IsNullOrEmpty(st))
                {
                    var err = new List<Message>();
                    err.Add(new Message { Code = Convert.ToInt32(Enums.MessageCode.WarningMessage), Text = "Session Token is empty" });
                    result.InfoMessages = err;

                    result.IsOperationSuccessful = false;
                    result.IsResult = false;

                    result.Result = null;
                    return result;
                }

                if (!SessionHelper.IsValidSession(st))
                {
                    var err = new List<Message>();
                    err.Add(new Message { Code = Convert.ToInt32(Enums.MessageCode.WarningMessage), Text = "Invalid Session Token" });
                    result.InfoMessages = err;

                    result.IsOperationSuccessful = false;
                    result.IsResult = false;
                    result.Result = null;
                    return result;
                }

                if (serviceId <= 0)
                {
                    var err = new List<Message>();
                    err.Add(new Message { Code = Convert.ToInt32(Enums.MessageCode.WarningMessage), Text = "Provider id should be greather than zero" });
                    result.InfoMessages = err;

                    result.IsOperationSuccessful = false;
                    result.IsResult = false;

                    result.Result = null;
                    return result;
                }

                using (var owlsService = new OwlsService())
                {

                    Service service = owlsService.GetSingle(x => x.Id == serviceId);
                    if (service != null)
                    {
                        var response = owlsService.ToModelResponse(service);

                        if (response != null)
                        {
                            result.IsResult = true;
                            result.IsOperationSuccessful = true;
                            result.Result = response;
                        }
                        else
                        {
                            result.IsOperationSuccessful = true;
                            result.IsResult = false;
                            result.Result = null;

                            var err = new List<Message>();
                            err.Add(new Message { Code = Convert.ToInt32(Enums.MessageCode.WarningMessage), Text = "Failed to get service response model" });
                            result.InfoMessages = err;
                        }   
                    }
                    else
                    {
                        result.IsOperationSuccessful = false;
                        result.IsResult = false;
                        result.Result = null;

                        var err = new List<Message>();
                        err.Add(new Message { Code = Convert.ToInt32(Enums.MessageCode.WarningMessage), Text = "Service not found" });
                        result.InfoMessages = err;   
                    }

                }
            }
            catch(Exception ex)
            {
                var err = new List<Message>();
                err.Add(new Message { Code = Convert.ToInt32(Enums.MessageCode.ErrorMessage), Text = ex.Message });
                result.ErrorMessages = err;

                result.IsResult = false;
                result.IsOperationSuccessful = false;
                result.Result = null;
            }

            return result;
        }


        public QueryResult<UserResponse> Login(string userName, string password)
        {
            
            int userStatus = -1;
            QueryResult<UserResponse> result = new QueryResult<UserResponse>();

            try
            {
                if (string.IsNullOrEmpty(userName))
                {
                    var err = new List<Message>();
                    err.Add(new Message { Code = Convert.ToInt32(Enums.MessageCode.WarningMessage), Text = "User name is empty" });
                    result.InfoMessages = err;

                    result.IsOperationSuccessful = false;
                    result.IsResult = false;

                    result.Result = null;
                    return result;
                }

                if (string.IsNullOrEmpty(password))
                {
                    var err = new List<Message>();
                    err.Add(new Message { Code = Convert.ToInt32(Enums.MessageCode.WarningMessage), Text = "Password is empty" });
                    result.InfoMessages = err;

                    result.IsOperationSuccessful = false;
                    result.IsResult = false;

                    result.Result = null;
                    return result;
                }

                userStatus = Convert.ToInt32(Enums.UserStatus.Active);
                using(var userService = new UserService())
                {
                    var user = userService.GetSingle(x => x.Status == userStatus);
                    if(user !=null)
                    {
                        // Insert session token into UserLoginSession table

                        string sessionkey = CommonHelper.GetBase64EncodedString(user.Id.ToString());
                        
                        using (var userLoginService = new UserLoginSessionService())
                        {
                            var item = userLoginService.GetSingle(x => x.UserId == user.Id);

                            if (item != null)
                            {
                                item.SessionToken = sessionkey;
                                item.UpdatedOn = DateTime.Now;
                                userLoginService.Update(item);
                            }
                            else
                            {
                                UserLoginSession userLoginSession = new UserLoginSession()
                                {
                                    CreatedOn = DateTime.Now,
                                    DeviceMacId = sessionkey.Substring(0, 10),
                                    SessionToken = sessionkey,
                                    Status = Convert.ToInt32(Enums.UserLoginSessionStatus.Active),
                                    UserId = user.Id
                                };
                                new UserLoginSessionService().Insert(userLoginSession);
                            }
                        }

                        var userResponse = userService.ToModelResponse(user);
                        if(userResponse !=null)
                        {
                            userResponse.SessionToken = sessionkey;

                            result.IsOperationSuccessful = true;
                            result.IsResult = true;
                            result.Result = userResponse;
                        }
                        else
                        {
                            var err = new List<Message>();
                            err.Add(new Message { Code = Convert.ToInt32(Enums.MessageCode.ErrorMessage), Text = "Failed to get user respone model" });
                            result.ErrorMessages = err;

                            result.IsResult = false;
                            result.IsOperationSuccessful = true;
                            result.Result = null;
                        }
                    }
                    else
                    {
                        var err = new List<Message>();
                        err.Add(new Message { Code = Convert.ToInt32(Enums.MessageCode.ErrorMessage), Text = "User not found" });
                        result.ErrorMessages = err;

                        result.IsResult = false;
                        result.IsOperationSuccessful = true;
                        result.Result = null;
                    }
                }
            }
            catch(Exception ex)
            {
                var err = new List<Message>();
                err.Add(new Message { Code = Convert.ToInt32(Enums.MessageCode.ErrorMessage), Text = ex.Message });
                result.ErrorMessages = err;

                result.IsResult = false;
                result.IsOperationSuccessful = false;
                result.Result = null;
            }

            return result;
        }

        public QueryResult<string> Logout(int userId, string st)
        {

            QueryResult<string> result = new QueryResult<string>();
            try
            {
                if (userId <=0)
                {
                    var err = new List<Message>();
                    err.Add(new Message { Code = Convert.ToInt32(Enums.MessageCode.WarningMessage), Text = "User id should be greater than zero" });
                    result.InfoMessages = err;

                    result.IsOperationSuccessful = false;
                    result.IsResult = false;

                    result.Result = null;
                    return result;
                }

                if (string.IsNullOrEmpty(st))
                {
                    var err = new List<Message>();
                    err.Add(new Message { Code = Convert.ToInt32(Enums.MessageCode.WarningMessage), Text = "Session token is empty" });
                    result.InfoMessages = err;

                    result.IsOperationSuccessful = false;
                    result.IsResult = false;

                    result.Result = null;
                    return result;
                }

                if (!SessionHelper.IsValidSession(st))
                {
                    var err = new List<Message>();
                    err.Add(new Message { Code = Convert.ToInt32(Enums.MessageCode.WarningMessage), Text = "Invalid Session Token" });
                    result.InfoMessages = err;

                    result.IsOperationSuccessful = false;
                    result.IsResult = false;
                    result.Result = null;
                    return result;
                }

                using (var userLoginSessionService = new UserLoginSessionService())
                {
                    var item = userLoginSessionService.GetSingle(x => x.UserId == userId && x.SessionToken == st);
                    if(item !=null)
                    {
                        //item.SessionToken = null;
                        //item.UpdatedOn = DateTime.Now;

                        userLoginSessionService.Delete(item);

                        result.IsOperationSuccessful = false;
                        result.IsResult = false;
                        result.Result = "User logged out successfully";
                    }
                    else
                    {
                        
                        var err = new List<Message>();
                        err.Add(new Message { Code = Convert.ToInt32(Enums.MessageCode.WarningMessage), Text = "User login session object not found" });
                        result.InfoMessages = err;

                        result.IsOperationSuccessful = false;
                        result.IsResult = false;

                        result.Result = null;
                        return result;
                    }

                }
            }
            catch(Exception ex)
            {
                var err = new List<Message>();
                err.Add(new Message { Code = Convert.ToInt32(Enums.MessageCode.ErrorMessage), Text = ex.Message });
                result.ErrorMessages = err;

                result.IsResult = false;
                result.IsOperationSuccessful = false;
                result.Result = null;
            }

            return result;
        }
    }
}
