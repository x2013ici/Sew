using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SewServiceRepository.DAL.Utility
{
    public static class Common
    {

        public static string ConvertDateTimeToEpochTimestamp(DateTime dateToConvert)
        {
            DateTime epoch = new DateTime(1970, 1, 1);
            return Convert.ToString(dateToConvert.Subtract(epoch).TotalMilliseconds);
        }

        public static DateTime ConvertEpochTimestampToDateTime(string unixTimeStamp)
        {
            return new DateTime(1970, 1, 1, 0, 0, 0).AddMilliseconds(Convert.ToDouble(unixTimeStamp));
        }

        public static DateTime? ConvertEpochTimestampToNullableDateTime(string unixTimeStamp)
        {
            try
            {
                return new DateTime(1970, 1, 1, 0, 0, 0).AddMilliseconds(Convert.ToDouble(unixTimeStamp));
            }
            catch (Exception ex) { }
            return null;
        }

        public static DateTime? ConvertStringToNullableDateTime(string date)
        {
            try
            {
                return Convert.ToDateTime(date);
            }
            catch (Exception ex) { }
            return null;
        }

    }
}
