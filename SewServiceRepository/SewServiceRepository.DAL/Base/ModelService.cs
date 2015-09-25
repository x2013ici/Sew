using SewServiceRepository.DAL.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SewServiceRepository.DAL.Base
{
    public class ModelService<T> : IModelService<T>, IDisposable where T : BaseEntity
    {
        ServiceBase<T> service;

        public ServiceBase<T> ServiceBase
        {
            get { return service; }
            set { service = value; }
        }

        public ModelService()
        {
            service = new ServiceBase<T>();
        }

        #region IModelService<Applicant> Members

        public T GetSingle(System.Linq.Expressions.Expression<Func<T, bool>> whereCondition)
        {
            return service.GetSingle(whereCondition);
        }

        public IList<T> GetAllById(int Id)
        {
            return service.GetAll(x => x.Id == Id);
        }

        public IList<T> GetAll()
        {
            return service.GetAll();
        }

        public IList<T> GetAll(System.Linq.Expressions.Expression<Func<T, bool>> whereCondition)
        {
            return service.GetAll(whereCondition);
        }

        public T Insert(T entity)
        {
            return service.Insert(entity);
        }

        public bool Delete(T entity)
        {
            return service.Delete(entity);
        }

        public T Update(T entity)
        {
            return service.Update(entity);
        }

        public IQueryable<T> Query()
        {
            throw new NotImplementedException();
        }

        public long CountById(int Id)
        {
            return service.Count(x => x.Id == Id);
        }

        public long Count()
        {
            return service.GetAll().Count;
        }

        public long Count(System.Linq.Expressions.Expression<Func<T, bool>> whereCondition)
        {
            return service.GetAll(whereCondition).Count;
        }

        public T GetLatestRecord(System.Linq.Expressions.Expression<Func<T, bool>> whereCondition)
        {
            return service.GetLatestRecord(whereCondition);
        }

        #endregion

        #region IDisposable Members

        public virtual void Dispose()
        {

        }

        #endregion
    }
}
