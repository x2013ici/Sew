using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;
using System.Security.Cryptography;
using System.Text.RegularExpressions;

namespace SewServiceRepository.Common.Helper
{
    public static class CommonHelper
    {
        static string CODE = "uWckTqGzhPd";
        public static readonly Char[] EncDecArray = CODE.ToCharArray();

        public static void CreateDirectory(string path)
        {
            try
            {
                if (!Directory.Exists(path))
                {
                    Directory.CreateDirectory(path);
                }
            }
            catch (Exception) { }
        }

        public static string MD5(string PlainText)
        {
            MD5CryptoServiceProvider md5Provider = new MD5CryptoServiceProvider();
            byte[] buffer = Encoding.ASCII.GetBytes(PlainText);
            return BitConverter.ToString(md5Provider.ComputeHash(buffer));
        }

        public static bool IsValidEmail(string Email)
        {
            bool result = false;
            if (String.IsNullOrEmpty(Email))
                return result;
            Email = Email.Trim();
            result = Regex.IsMatch(Email, @"^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$");
            return result;
        }

        public static byte[] ConvertToByteArray(Stream input)
        {
            byte[] buffer = new byte[16 * 1024];
            using (MemoryStream ms = new MemoryStream())
            {
                int read;
                while ((read = input.Read(buffer, 0, buffer.Length)) > 0)
                {
                    ms.Write(buffer, 0, read);
                }
                return ms.ToArray();
            }
        }

        public static string GenerateRandomDigitCode(int Length)
        {
            var random = new Random();
            string s = "";
            for (int i = 0; i < Length; i++)
                s = String.Concat(s, random.Next(10).ToString());
            return s;
        }

        public static bool DeleteFromLocalSystem(string path)
        {
            try
            {
                if (Directory.Exists(path))
                    Directory.Delete(path, true);

                else if (File.Exists(path))
                    File.Delete(path);

                return true;
            }
            catch (Exception)
            {
            }
            return false;
        }

        public static string GetParentFolderPath(string Path)
        {
            int lastIndex = Path.LastIndexOf('\\');

            if (lastIndex > 0)
                return Path.Substring(0, lastIndex);
            return "";

        }

        public static bool IsSystemFolder(string SourcePath)
        {
            if (Directory.Exists(SourcePath))
            {
                //if (SourcePath.ToLower().Contains(ConfigThick.Instance.CacheDirectoryName.ToLower()))
                //{
                //    return true;
                //}

                DirectoryInfo dirInfo = new DirectoryInfo(SourcePath);
                if (
                    (dirInfo.Attributes == (FileAttributes.System | FileAttributes.Hidden | FileAttributes.Directory)) ||
                    (dirInfo.Attributes == (FileAttributes.System | FileAttributes.Hidden | FileAttributes.Directory | FileAttributes.NotContentIndexed)) ||
                    (dirInfo.Attributes == (FileAttributes.System | FileAttributes.Directory))
                        )
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }

            return true;
        }

        public static bool IsSystemFile(string SourcePath)
        {
            if (File.Exists(SourcePath))
            {
                FileInfo fi = new FileInfo(SourcePath);
                if (
                    (fi.Attributes == (FileAttributes.System | FileAttributes.Hidden | FileAttributes.Archive)) ||
                    (fi.Attributes == (FileAttributes.System | FileAttributes.Archive)) ||
                    (fi.Attributes == (FileAttributes.Hidden | FileAttributes.System | FileAttributes.Archive | FileAttributes.NotContentIndexed))
                     )
                {
                    return true;
                }
                else
                {
                    return false;
                }

            }

            return true;
        }

        public static void CreateCacheDirectory(string Path)
        {
            if (!Directory.Exists(Path))
            {
                CommonHelper.CreateDirectory(Path);
                DirectoryInfo diCacheDirectory = new DirectoryInfo(Path);
                diCacheDirectory.Attributes = FileAttributes.Hidden;
            }
        }

        public static byte[] ReadBinaryFile(string fileName)
        {
            if (File.Exists(fileName))
            {
                try
                {
                    ///Open and read a file。
                    FileStream fileStream = File.OpenRead(fileName);
                    int b1;
                    System.IO.MemoryStream tempStream = new System.IO.MemoryStream();
                    while ((b1 = fileStream.ReadByte()) != -1)
                    {
                        tempStream.WriteByte(((byte)b1));
                    }
                    return tempStream.ToArray();
                }
                catch (Exception ex)
                {
                    return new byte[0];
                }
            }
            else
            {
                return new byte[0];
            }
        }

        public static string ReplaceSpecialCharacter(string value)
        {
            return value.Replace("/", "-").Replace(":", "-").Replace(" ", "_");
        }

        public static string Encrypt(string source, int length)
        {
            byte[] bytes = Encoding.UTF8.GetBytes(source);

            StringBuilder buffer = new StringBuilder(length);
            buffer.Append(System.Convert.ToBase64String(bytes));
            while (buffer.Length < length)
            {
                buffer.Append('=');
            }
            return buffer.ToString();
        }

        public static string Decrypt(string encoded)
        {
            int index = encoded.IndexOf('=');
            if (index > 0)
            {
                encoded = encoded.Substring(0, ((index + 3) / 4) * 4);
            }
            byte[] bytes = System.Convert.FromBase64String(encoded);
            return System.Text.Encoding.UTF8.GetString(bytes);
        }

        public static string CustomEncrypt(string encryptText)
        {
            var encryptArray = encryptText.ToArray();
            string result = string.Empty;

            for (int i = 0; i < encryptArray.Length; i++)
            {
                result += EncDecArray[Convert.ToInt32(encryptArray[i].ToString())];
            }

            return result;
        }

        public static string CustomDecrypt(string decryptText)
        {
            var decryptArray = decryptText.ToArray();
            string result = string.Empty;
            for (int i = 0; i < decryptArray.Length; i++)
            {
                for (int j = 0; j < EncDecArray.Length; j++)
                {
                    if (EncDecArray[j] == decryptArray[i])
                    {
                        result += j;
                    }
                }
            }

            return result;
        }

        public static string GetBase64EncodedString(string Login)
        {
            string EncodedValue = string.Empty;
            if ((Login != null) && !(string.IsNullOrEmpty(Login)))
                EncodedValue = CrypterHelper.Base64Encode(Login);

            return EncodedValue;
        }

        public static string GetBase64DecodedString(string Encodedvalue)
        {
            string DecodedValue = string.Empty;
            if ((Encodedvalue != null) && !(string.IsNullOrEmpty(Encodedvalue)))
                DecodedValue = CrypterHelper.Base64Decode(Encodedvalue);

            return DecodedValue;
        }

        public static double GetDistance(double lat1, double lon1, double lat2, double lon2)
        {
            double theta = lon1 - lon2;
            double dist = Math.Sin(deg2rad(lat1)) * Math.Sin(deg2rad(lat2)) + Math.Cos(deg2rad(lat1)) * Math.Cos(deg2rad(lat2)) * Math.Cos(deg2rad(theta));
            dist = Math.Acos(dist);
            dist = rad2deg(dist);
            dist = (dist * 60 * 1.1515) / 0.6213711922;          //miles to kms
            return (dist);
        }

        public static double deg2rad(double deg)
        {
            return (deg * Math.PI / 180.0);
        }

        public static double rad2deg(double rad)
        {
            return (rad * 180.0 / Math.PI);
        }

        public static string GenerateCode()
        {
            Random r = new Random();
            var ran = r.Next(100);
            var code = Guid.NewGuid().ToString();
            code = code.Replace("-", "");
            code = code.Substring(0, 7);
            code = code + ran;

            return code;
        }


    }
}
