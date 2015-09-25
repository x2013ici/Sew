using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace SewServiceRepository.Common.Helper
{
    public enum EncryptionType
    {
        SIMPLE = 0x10,
        BASE64 = 0x100,
        REVERSE = 0x1000,
        HEX = 0x10000,
        ASCII = 0x100000,
        STRONG = SIMPLE | BASE64 | REVERSE | HEX
    }

    public class CrypterHelper
    {
        public CrypterHelper()
        {
        }

        public static string SingleEncrypt(string text, EncryptionType CryptType)
        {
            switch (CryptType)
            {
                case EncryptionType.BASE64:
                    return Base64Encode(text);
                //case EncryptionType.SIMPLE:
                //    return SimpleEncrypt(text);
                //case EncryptionType.HEX:
                //    return HexEncode(text);
                //case EncryptionType.REVERSE:
                //    return Strings.StrReverse(text);
                //case EncryptionType.ASCII:
                //    return ASCIIEncode(text);
                default:
                    return text;
            }
        }

        public static string SingleDecrypt(string text, EncryptionType CryptType)
        {
            switch (CryptType)
            {
                case EncryptionType.BASE64:
                    return Base64Decode(text);
                //case EncryptionType.SIMPLE:
                //    return SimpleDecrypt(text);
                //case EncryptionType.HEX:
                //    return HexDecode(text);
                //case EncryptionType.REVERSE:
                //    return Strings.StrReverse(text);
                //case EncryptionType.ASCII:
                //    return ASCIIDecode(text);
                default:
                    return text;
            }
        }
        public static string Base64Encode(string text)
        {
            string time = Convert.ToString(DateTime.Now.Ticks);
            string textToEncrypt = text + time;
            //return System.Convert.ToBase64String(System.Text.Encoding.Unicode.GetBytes(text));
            var modifiEdData = System.Convert.ToBase64String(System.Text.Encoding.Unicode.GetBytes(textToEncrypt));
            var firstThree = modifiEdData.Substring(0,3);
            var lastSaven = modifiEdData.Substring(modifiEdData.Length - 7, 7);
                      

            //return firstThree + lastSaven;
            return modifiEdData;
        }

        public static string Base64Decode(string text)
        {
            return System.Text.Encoding.Unicode.GetString(System.Convert.FromBase64String(text));
        }

        #region "Unused Code Block"
        public static string Encrypt(string text, EncryptionType CryptType)
        {

            string retVal = text;
            //if (CryptType & EncryptionType.SIMPLE) {
            //    retVal = SimpleEncrypt(retVal);
            //}

            //if (CryptType & EncryptionType.HEX) {
            //    retVal = HexEncode(retVal);
            //}

            //if (CryptType & EncryptionType.REVERSE) {
            //    retVal = Strings.StrReverse(retVal);
            //}

            //if (CryptType & EncryptionType.BASE64) {
            //    retVal = Base64Encode(retVal);
            //}

            //if (CryptType & EncryptionType.ASCII) {
            //    retVal = ASCIIEncode(retVal);
            //}

            return retVal;
        }

        public static string Decrypt(string text, EncryptionType CryptType)
        {
            string retVal = text;

            //if (CryptType & EncryptionType.ASCII) {
            //    retVal = ASCIIDecode(retVal);
            //}

            //if (CryptType & EncryptionType.BASE64) {
            //    retVal = Base64Decode(retVal);
            //}

            //if (CryptType & EncryptionType.REVERSE) {
            //    retVal = Strings.StrReverse(retVal);
            //}

            //if (CryptType & EncryptionType.HEX) {
            //    retVal = HexDecode(retVal);
            //}

            //if (CryptType & EncryptionType.SIMPLE) {
            //    retVal = SimpleDecrypt(retVal);
            //}

            return retVal;
        }



        //public static string HexEncode(string text, string prefix)
        //{
        //    int pos = 0;
        //    string Result = null;
        //    Result = "";
        //    for (pos = 1; pos <= Strings.Len(text); pos++) {
        //        string c = null;
        //        string e = null;
        //        c = Strings.Mid(text, pos, 1);
        //        e = Convert.ToString(Conversion.Hex(Strings.Asc(c)));
        //        if (Strings.Len(e) == 1) {
        //            e = "0" + e;
        //        }
        //        Result = Result + prefix + e;
        //    }
        //    return Result;
        //}

        //private static string HexDecode(string text, string prefix)
        //{
        //    int pos = 0;
        //    string Result = null;
        //    Result = "";
        //    for (pos = prefix.Length + 1; pos <= Strings.Len(text); pos += 2) {
        //        string c = null;
        //        string e = null;
        //        c = Strings.Mid(text, pos, 2);
        //        e = Strings.Chr(Convert.ToInt32("&H" + c));
        //        Result = Result + e;
        //    }
        //    return Result;
        //}

        //Public Shared Function Base64Encode(ByVal text As String) As String
        //    Return System.Convert.ToBase64String(System.Text.Encoding.ASCII.GetBytes(text))
        //End Function

        //Public Shared Function Base64Decode(ByVal text As String) As String
        //    Return System.Text.Encoding.ASCII.GetString(System.Convert.FromBase64String(text))
        //End Function



        //public static string SimpleEncrypt(string strText)
        //{
        //    long x = 0;
        //    string retVal = string.Empty;
        //    for (x = 1; x <= Strings.Len(strText); x++) {
        //        retVal = retVal + Strings.Chr(Strings.Asc(Strings.Mid(strText, x, 1)) + 27);
        //    }
        //    return retVal;
        //}

        //public static string SimpleDecrypt(string strText)
        //{
        //    long x = 0;
        //    string retVal = string.Empty;

        //    if (Strings.Len(Strings.Trim(strText)) > 0) {
        //        for (x = 1; x <= Strings.Len(strText); x++) {
        //            retVal = retVal + Strings.Chr(Strings.Asc(Strings.Mid(strText, x, 1)) - 27);
        //        }
        //    }
        //    return retVal;
        //}

        //public static string ASCIIEncode(string text, string prefix)
        //{
        //    int pos = 0;
        //    string Result = null;
        //    Result = "";
        //    for (pos = 1; pos <= Strings.Len(text); pos++) {
        //        string c = null;
        //        string e = null;
        //        c = Strings.Mid(text, pos, 1);
        //        e = Convert.ToString(Strings.Asc(c));
        //        if (Strings.Len(e) == 1) {
        //            e = "0" + e;
        //        }
        //        Result = Result + prefix + e;
        //    }
        //    return Result;
        //}

        //public static string ASCIIDecode(string text, string prefix)
        //{
        //    int pos = 0;
        //    string Result = null;
        //    Result = "";
        //    for (pos = prefix.Length + 1; pos <= Strings.Len(text); pos += 2) {
        //        string c = null;
        //        string e = null;
        //        c = Strings.Mid(text, pos, 2);
        //        e = Strings.Chr(Convert.ToInt32(c));
        //        Result = Result + e;
        //    }
        //    return Result;
        //}
        #endregion

    }
}