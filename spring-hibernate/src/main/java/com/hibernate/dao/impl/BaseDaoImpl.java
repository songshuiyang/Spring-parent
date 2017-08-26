package com.hibernate.dao.impl;

import com.hibernate.dao.IBaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author songshuiyang
 * @title:
 * @description:
 * @date 2017/8/26 20:25
 */
@Repository
public class BaseDaoImpl<T, PK extends Serializable> implements IBaseDao<T, PK> {


    private Class<T> entityClass;
    protected SessionFactory sessionFactory;

    public BaseDaoImpl() {
        this.entityClass = null;
        Class<?> c = getClass();
        Type type = c.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
            this.entityClass = (Class<T>) parameterizedType[0];
        }
    }

    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public T get(PK id) {
        Assert.notNull(id, "id is required");
        return (T) getSession().get(entityClass, id);
    }

    public PK save(T entity) {
        Assert.notNull(entity, "entity is required");
        return (PK) getSession().save(entity);
    }


}
