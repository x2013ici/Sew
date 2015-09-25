using SewServiceRepository.DAL.Base;
using SewServiceRepository.DAL.Entities;
using SewServiceRepository.DAL.Mapping;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Data.Entity.ModelConfiguration.Conventions;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SewServiceRepository.DAL
{
    public class SewDBContext : DbContext, IDbContext
    {
        public DbSet<UserType> UserType { get; set; }
        public DbSet<Address> Address { get; set; }
        public DbSet<Country> Country { get; set; }

        public DbSet<Provider> Provider { get; set; }
        public DbSet<ProviderSignupRequest> ProviderSignupRequest { get; set; }
        public DbSet<ProviderSignupRequester> ProviderSignupRequester { get; set; }

        public DbSet<Service> Service { get; set; }
        public DbSet<ServiceDetails> ServiceDetails { get; set; }

        public DbSet<User> User { get; set; }
        public DbSet<UserLoginSession> UserLoginSession {get;set;}

        public DbSet<UserSignupRequest> UserSignupRequest { get; set; }

        public SewDBContext() 
            : base("SewDBContext")
        {

        }

        public SewDBContext(string nameOrConnectionString)
            : base(nameOrConnectionString)
        {

        }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);

            Database.SetInitializer<SewDBContext>(null);
            this.Configuration.ValidateOnSaveEnabled = false;

            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();
            modelBuilder.Conventions.Remove<OneToManyCascadeDeleteConvention>();
            
            modelBuilder.Configurations.Add(new CountryMap());
            modelBuilder.Configurations.Add(new AddressMap());
            modelBuilder.Configurations.Add(new ProviderSignupRequestMap());
            modelBuilder.Configurations.Add(new ProviderSignupRequesterMap());
            modelBuilder.Configurations.Add(new ProviderMap());

            modelBuilder.Configurations.Add(new UserSignupRequestMap());
            modelBuilder.Configurations.Add(new UserTypeMap());
            modelBuilder.Configurations.Add(new UserMap());
            modelBuilder.Configurations.Add(new UserLoginSessionMap());
            modelBuilder.Configurations.Add(new ServiceMap());
            modelBuilder.Configurations.Add(new ServiceDetailsMap());

        }

        #region IDbContext Members

        public new IDbSet<TEntity> Set<TEntity>() where TEntity : BaseEntity
        {
            return base.Set<TEntity>();
        }

        public new DbEntityEntry<TEntity> Entry<TEntity>(TEntity entity) where TEntity : BaseEntity
        {
            return base.Entry<TEntity>(entity);
        }

        public IList<TEntity> ExecuteStoredProcedureList<TEntity>(string commandText, params object[] parameters) where TEntity : BaseEntity, new()
        {
            throw new NotImplementedException();
        }

        public IEnumerable<TElement> SqlQuery<TElement>(string sql, params object[] parameters)
        {
            throw new NotImplementedException();
        }

        public int ExecuteSqlCommand(string sql, int? timeout = null, params object[] parameters)
        {
            int? previousTimeout = null;
            if (timeout.HasValue)
            {
                //store previous timeout
                previousTimeout = ((IObjectContextAdapter)this).ObjectContext.CommandTimeout;
                ((IObjectContextAdapter)this).ObjectContext.CommandTimeout = timeout;
            }

            var result = this.Database.ExecuteSqlCommand(sql, parameters);

            if (timeout.HasValue)
            {
                //Set previous timeout back
                ((IObjectContextAdapter)this).ObjectContext.CommandTimeout = previousTimeout;
            }

            //return result
            return result;
        }

        #endregion

        public virtual void Commit()
        {
            base.SaveChanges();
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                base.Dispose();
            }
        }
    }
}
