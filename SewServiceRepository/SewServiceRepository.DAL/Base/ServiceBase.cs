using SewServiceRepository.DAL;
using SewServiceRepository.DAL.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SewServiceRepository.DAL.Base
{
    public class ServiceBase<T>: IService<T> where T: BaseEntity
    {
        public EfRepository<T> RepositoryBase;

        internal ServiceBase()
        {
            IDbContext dbContext = new SewDBContext("SewDBContext");
            if (dbContext != null)
                RepositoryBase = new EfRepository<T>(dbContext);

            //AutoMapperExtensions.Initialize();

        }

        public virtual T GetSingle(System.Linq.Expressions.Expression<Func<T, bool>> whereCondition)
        {
            return RepositoryBase.GetSingle(whereCondition);
        }

        public virtual T Insert(T entity)
        {
            RepositoryBase.Insert(entity);
            return entity;
        }

        public virtual bool Delete(T entity)
        {
            return RepositoryBase.Delete(entity);
        }

        public virtual T Update(T entity)
        {
            RepositoryBase.Update(entity);
            return entity;
        }

        public virtual IList<T> GetAll(System.Linq.Expressions.Expression<Func<T, bool>> whereCondition)
        {
            return RepositoryBase.GetAll(whereCondition);
        }

        public virtual IList<T> GetAll()
        {
            return RepositoryBase.GetAll();
        }

        public virtual IQueryable<T> Table
        {
            get
            {
                return RepositoryBase.Table;
            }
        }

        public virtual long Count(System.Linq.Expressions.Expression<Func<T, bool>> whereCondition)
        {
            return RepositoryBase.Count(whereCondition);
        }

        public virtual long Count()
        {
            return RepositoryBase.Count();
        }

        public virtual T GetLatestRecord(System.Linq.Expressions.Expression<Func<T, bool>> whereCondition)
        {
            return RepositoryBase.GetLatestRecord(whereCondition);
        }
    }
}
