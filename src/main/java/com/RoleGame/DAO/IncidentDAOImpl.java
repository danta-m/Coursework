package com.RoleGame.DAO;

import com.RoleGame.database.Init;
import com.RoleGame.entity.Incident;
import org.hibernate.Query;
import org.hibernate.Session;

public class IncidentDAOImpl implements IncidentDAO {
    @Override
    public Incident create(Incident incident) {
        Session session = Init.getSession();
        session.beginTransaction();
        session.save(incident);
        session.getTransaction().commit();
        session.close();
        return incident;
    }
    @Override
    public Incident readById (long id) {
        Session session = Init.getSession();
        session.beginTransaction();
        Query<Incident> query = session.createQuery("select incident from Incident incident where incident.id=:id");
        query.setParameter("id", id);
        return query.getSingleResult();
    }
    @Override
    public Incident update (Incident incident) {
        Session session = Init.getSession();
        session.beginTransaction();
        session.update(incident);
        session.getTransaction().commit();
        session.close();
        return incident;
    }
    @Override
    public Incident delete (long id) {
        Session session = Init.getSession();
        session.beginTransaction();
        Incident incident = session.load(Incident.class, new Long(id));
        if (incident!=null) {
            session.delete(incident);
        }
        session.getTransaction().commit();
        session.close();
        return incident;
    }
}
