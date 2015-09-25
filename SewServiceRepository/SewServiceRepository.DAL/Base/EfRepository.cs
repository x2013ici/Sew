using SewServiceRepository.DAL.Entities;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.Validation;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Threading.Tasks;

namespace SewServiceRepository.DAL.Base
{
    public partial class EfRepository<T> where T: BaseEntity
    {
        public readonly IDbContext context;
        private IDbSet<T> entities;

        /// <summary>
        /// Ctor
        /// </summary>
        /// <param name="context">Object context</param>
        public EfRepository(IDbContext context)
        {
            this.context = context;
        }

        public T GetSingle(Expression<Func<T, bool>> whereCondition)
        {
            return this.Entities.Where(whereCondition).FirstOrDefault<T>();
        }

        public IList<T> GetAll()
        {
            return this.Entities.ToList<T>();
        }

        public IList<T> GetAll(Expression<Func<T, bool>> whereCondition)
        {
            return this.Entities.Where(whereCondition).ToList<T>();
        }

        public void Insert(T entity)
        {
            try
            {
                if (entity == null)
                    throw new ArgumentNullException("entity");

                //this._context.Entry<T>(entity).Reload();

                this.Entities.Add(entity);
                this.context.SaveChanges();
            }
            catch (DbEntityValidationException dbEx)
            {
                var msg = string.Empty;

                foreach (var validationErrors in dbEx.EntityValidationErrors)
                    foreach (var validationError in validationErrors.ValidationErrors)
                        msg += string.Format("Property: {0} Error: {1}", validationError.PropertyName, validationError.ErrorMessage) + Environment.NewLine;

                var fail = new Exception(msg, dbEx);

                //Debug.WriteLine(fail.Message, fail);
                throw fail;
            }

            //catch (OptimisticConcurrencyException)
            //{
            //    _context.Refresh(RefreshMode.ClientWins, db.Articles);
            //    _context.SaveChanges();
            //}

        }

        public void Update(T entity)
        {
            try
            {
                if (entity == null)
                    throw new ArgumentNullException("entity");

                var oldEntity = this.Entities.Find(entity.Id);

                if (oldEntity != null)
                    this.context.Entry(oldEntity).CurrentValues.SetValues(entity);
                else
                    this.Entities.Attach(entity);

                // Check and enable this line later
                this.context.Entry(oldEntity).State = System.Data.Entity.EntityState.Modified;
                this.context.SaveChanges();
            }
            catch (System.Data.Entity.Validation.DbEntityValidationException dbEx)
            {
                var msg = string.Empty;

                foreach (var validationErrors in dbEx.EntityValidationErrors)
                    foreach (var validationError in validationErrors.ValidationErrors)
                        msg += Environment.NewLine + string.Format("Property: {0} Error: {1}", validationError.PropertyName, validationError.ErrorMessage);

                var fail = new Exception(msg, dbEx);
                //Debug.WriteLine(fail.Message, fail);
                throw fail;
            }
        }

        public bool Delete(T entity)
        {
            try
            {
                if (entity == null)
                    throw new ArgumentNullException("entity");

                var oldEntity = this.Entities.Find(entity.Id);

                if (oldEntity != null)
                {
                    this.Entities.Remove(oldEntity);
                    this.context.SaveChanges();

                    return true;
                }
                return false;
            }
            catch (DbEntityValidationException dbEx)
            {
                var msg = string.Empty;

                foreach (var validationErrors in dbEx.EntityValidationErrors)
                    foreach (var validationError in validationErrors.ValidationErrors)
                        msg += Environment.NewLine + string.Format("Property: {0} Error: {1}", validationError.PropertyName, validationError.ErrorMessage);

                var fail = new Exception(msg, dbEx);
                //Debug.WriteLine(fail.Message, fail);
                throw fail;
            }

        }

        public long Count()
        {
            return this.Entities.LongCount();
        }

        public long Count(Expression<Func<T, bool>> whereCondition)
        {
            return this.Entities.Where(whereCondition).LongCount<T>();
        }

        public bool IsEntityExits(T entity)
        {
            throw new NotImplementedException();
        }

        public virtual IQueryable<T> Table
        {
            get
            {
                return this.Entities;
            }
        }

        private IDbSet<T> Entities
        {
            get
            {
                if (entities == null)
                    entities = context.Set<T>();
                return entities;
            }
        }

        public T GetLatestRecord(Expression<Func<T, bool>> whereCondition)
        {
            return this.Entities.Where(whereCondition).OrderByDescending(x => x.Id).FirstOrDefault();
        }

        public void Dispose()
        {
            Dispose(true);
            GC.SuppressFinalize(this);
        }

        protected virtual void Dispose(bool disposing)
        {
            if (disposing)
            {
                if (context != null)
                {
                    if (context is DbContext)
                    {
                        (context as DbContext).Dispose();
                    }
                }
            }
        }
    }
}
