﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Threading.Tasks;

namespace SewServiceRepository.DAL.Base
{
    public interface IModelService<T>
    {
        /// <summary>
        /// Get a selected extiry by the object primary key ID
        /// </summary>
        /// <param name="id">Primary key ID</param>
        T GetSingle(Expression<Func<T, bool>> whereCondition);

        /// <summary> 
        /// Load the entities using a linq expression filter
        /// </summary> 
        /// <typeparam name="E">the entity type to load</typeparam> 
        /// <param name="where">where condition</param> 
        /// <returns>the loaded entity</returns> 
        IList<T> GetAllById(int Id);

        /// <summary>
        /// Get all the element of this repository
        /// </summary>
        /// <returns></returns>
        IList<T> GetAll();

        /// <summary>
        /// Get all the element of this repository
        /// </summary>
        /// <returns></returns>
        IList<T> GetAll(Expression<Func<T, bool>> whereCondition);

        /// <summary> 
        /// Add entity to the repository 
        /// </summary> 
        /// <param name="entity">the entity to add</param> 
        /// <returns>The added entity</returns> 
        T Insert(T entity);

        /// <summary> 
        /// Updates entity within the the repository 
        /// </summary> 
        /// <param name="entity">the entity to update</param> 
        /// <returns>The updates entity</returns> 
        T Update(T entity);

        /// <summary> 
        /// Mark entity to be deleted within the repository 
        /// </summary> 
        /// <param name="entity">The entity to delete</param> 
        bool Delete(T entity);

        /// <summary> 
        /// Query entities from the repository that match the linq expression selection criteria
        /// </summary> 
        /// <typeparam name="E">the entity type to load</typeparam> 
        /// <param name="where">where condition</param> 
        /// <returns>the loaded entity</returns> 
        IQueryable<T> Query();

        /// <summary>
        /// Count using a filer
        /// </summary>
        long CountById(int Id);

        /// <summary>
        /// All item count
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <returns></returns>
        long Count();

        /// <summary>
        /// All item count
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <returns></returns>
        long Count(Expression<Func<T, bool>> whereCondition);


        /// <summary>
        /// Get Latest Record
        /// </summary>
        /// <param name="whereCondition"></param>
        /// <param name="orderCondition"></param>
        /// <returns></returns>
        T GetLatestRecord(Expression<Func<T, bool>> whereCondition);
    }
}
