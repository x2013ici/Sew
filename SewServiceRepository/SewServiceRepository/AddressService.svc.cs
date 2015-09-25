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
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "AddressService" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select AddressService.svc or AddressService.svc.cs at the Solution Explorer and start debugging.
    public class AddressService : IAddressService
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
                err.Add(new Message { Code = Convert.ToInt32(Enums.MessageCode.WarningMessage), Text = ex.Message });
                result.ErrorMessages = err;
            }

            return result;
        }


        public QueryResultSet<DAL.ResponseModel.AddressResponse> GetAddresses()
        {

            List<AddressResponse> addressResponseList = new List<AddressResponse>();
            QueryResultSet<AddressResponse> resultSet = new QueryResultSet<AddressResponse>();
            
            try
            {
                int addressStatus = Convert.ToInt32(Enums.AddressStatus.Active);
                var items = new AddressServices().dbContext.Address.Where(x => x.Status == addressStatus).ToList();

                if(items.Count >0)
                {
                    foreach(var item in items)
                    {
                        var itemResponse = new AddressServices().ToModelResponse(item);
                        addressResponseList.Add(itemResponse);
                    }

                    resultSet.IsResult = true;
                    resultSet.IsOperationSuccessful = true;
                    resultSet.ResultSet = addressResponseList;
                }
                else
                {
                    resultSet.IsOperationSuccessful = true;
                    resultSet.IsResult = false;
                    resultSet.ResultSet = null;
                }
            }
            catch(Exception ex)
            {
                resultSet.IsOperationSuccessful = false;
                resultSet.IsResult = false;
                resultSet.ResultSet = null;
            }

            return resultSet;
        }
    }
}
