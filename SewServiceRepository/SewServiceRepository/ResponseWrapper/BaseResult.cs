using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace SewServiceRepository.ResponseWrapper
{
    public class BaseResult
    {
        private bool operationSuccessful = false;
        public bool IsOperationSuccessful
        {
            get { return this.operationSuccessful; }
            set { this.operationSuccessful = value; }
        }

        private bool isresult = false;
        public bool IsResult
        {
            get { return this.isresult; }
            set { this.isresult = value; }
        }

        private List<Message> statusMessages;
        public List<Message> StatusMessages
        {
            get { return statusMessages; }
            set { statusMessages = value; }
        }

        private List<Message> errorMessages;
        public List<Message> ErrorMessages
        {
            get { return errorMessages; }
            set { errorMessages = value; }
        }

        private List<Message> infoMessages;
        public List<Message> InfoMessages
        {
            get { return infoMessages; }
            set { infoMessages = value; }
        }

        private List<Message> warnMessages;
        public List<Message> WarnMessages
        {
            get { return warnMessages; }
            set { warnMessages = value; }
        }

        public BaseResult()
        {
            statusMessages = new List<Message>();
            errorMessages = new List<Message>();
            infoMessages = new List<Message>();
            warnMessages = new List<Message>();
        }
    }
    public class Message
    {
        public int Code { get; set; }
        public string Text { get; set; }
    }
}