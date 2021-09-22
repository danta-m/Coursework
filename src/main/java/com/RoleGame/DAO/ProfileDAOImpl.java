package com.RoleGame.DAO;

import com.RoleGame.database.Init;
import com.RoleGame.entity.Profile;
import org.hibernate.Query;
import org.hibernate.Session;

public class ProfileDAOImpl implements ProfileDAO {
    @Override
    public Profile create(Profile profile) {
        Session session = Init.getSession();
        session.beginTransaction();
        session.save(profile);
        session.getTransaction().commit();
        session.close();
        return profile;
    }
    @Override
    public Profile readById (long id) {
        Session session = Init.getSession();
        session.beginTransaction();
        Query<Profile> query = session.createQuery("select profile from Profile profile where profile.id=:id");
        query.setParameter("id", id);
        return query.getSingleResult();
    }
    @Override
    public Profile update (Profile profile) {
        Session session = Init.getSession();
        session.beginTransaction();
        session.update(profile);
        session.getTransaction().commit();
        session.close();
        return profile;
    }
    @Override
    public Profile delete (long id) {
        Session session = Init.getSession();
        session.beginTransaction();
        Profile profile = session.load(Profile.class, new Long(id));
        if (profile!=null) {
            session.delete(profile);
        }
        session.getTransaction().commit();
        session.close();
        return profile;
    }
}
