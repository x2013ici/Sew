using SewServiceRepository.DAL.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SewServiceRepository.DAL
{
    public class SewDBInitializer : System.Data.Entity.DropCreateDatabaseIfModelChanges<SewDBContext>
    {
        protected override void Seed(SewDBContext context)
        {
            //Id,Name,Code,Status,CreatedOn,UpdatedOn
            var countries = new List<Country>
            {
                new Country{Id=1,Name="Bangladesh",Code="BD",Status=1,CreatedOn=DateTime.Now,UpdatedOn=DateTime.Now},
                new Country{Id=2,Name="Canada",Code="CA",Status =1,CreatedOn=DateTime.Now,UpdatedOn=DateTime.Now},
                new Country{Id=3,Name="USA",Code="US",Status =1,CreatedOn=DateTime.Now,UpdatedOn=DateTime.Now}
            };

            countries.ForEach(s => context.Country.Add(s));
            context.SaveChanges();


            //Id,Address,Street,CountryId,City,State,Zipcode,Status,CreatedOn,UpdatedOn
            var addresses = new List<Address>
            {
                new Address {Id=1,Street="Road-9,House-15,Shekertech",CountryId=1,City="Dhaka",State="DH",ZipCode="1207",Status=1,CreatedOn=DateTime.Now,UpdatedOn=DateTime.Now},
                new Address {Id=2,Street="12 Maclellan Street",CountryId=2,City="Antigonish",State="NS",ZipCode="B2G1V5",Status=1,CreatedOn=DateTime.Now,UpdatedOn=DateTime.Now},
                new Address {Id=3,Street="15 James Street",CountryId=3,City="MiddlesBorough",State="WDC",ZipCode="B2Z1V5",Status=1,CreatedOn=DateTime.Now,UpdatedOn=DateTime.Now},
            };

            addresses.ForEach(s => context.Address.Add(s));
            context.SaveChanges();


            //Id,Name,Description,Status,CreatedOn,UpdatedOn
            var userTypes = new List<UserType>
            {
                new UserType {Id=1,Name="Super Admin",Description="Will be added later",Status=1,CreatedOn=DateTime.Now,UpdatedOn=DateTime.Now},
                new UserType {Id=1,Name="Company Admin",Description="Will be added later",Status=1,CreatedOn=DateTime.Now,UpdatedOn=DateTime.Now},
                new UserType {Id=1,Name="Company User",Description="Will be added later",Status=1,CreatedOn=DateTime.Now,UpdatedOn=DateTime.Now},
                new UserType {Id=1,Name="Individual User",Description="Will be added later",Status=1,CreatedOn=DateTime.Now,UpdatedOn=DateTime.Now}
            };

            userTypes.ForEach(s => context.UserType.Add(s));
            context.SaveChanges();
        }
    }
}
