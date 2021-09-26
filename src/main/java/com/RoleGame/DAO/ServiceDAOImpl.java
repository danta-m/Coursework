package com.RoleGame.DAO;

import com.RoleGame.database.Init;
import com.RoleGame.entity.Service;
import org.hibernate.Query;
import org.hibernate.Session;

public class ServiceDAOImpl implements ServiceDAO {
    @Override
    public Service create(Service service) {
        Session session = Init.getSession();
        session.beginTransaction();
        session.save(service);
        session.getTransaction().commit();
        session.close();
        return service;
    }
    @Override
    public Service readById (long id) {
        Session session = Init.getSession();
        session.beginTransaction();
        Query<Service> query = session.createQuery("select service from Service service where service.id=:id");
        query.setParameter("id", id);
        return query.getSingleResult();
    }
    @Override
    public Service update (Service service) {
        Session session = Init.getSession();
        session.beginTransaction();
        session.update(service);
        session.getTransaction().commit();
        session.close();
        return service;
    }
    @Override
    public Service delete (long id) {
        Session session = Init.getSession();
        session.beginTransaction();
        Service service = session.load(Service.class, new Long(id));
        if (service!=null) {
            session.delete(service);
        }
        session.getTransaction().commit();
        session.close();
        return service;
    }
}
