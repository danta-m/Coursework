package com.RoleGame.DAO;

import com.RoleGame.database.Init;
import com.RoleGame.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;

public class UserDAOImpl implements UserDAO{
    @Override
    public User create(User user) {
        Session session = Init.getSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public User readById (long id) {
        Session session = Init.getSession();
        session.beginTransaction();
        Query<User> query = session.createQuery("select user from User user where user.id=:id");
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public User update (User user) {
        Session session = Init.getSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public User delete (long id) {
        Session session = Init.getSession();
        session.beginTransaction();
        User user = session.load(User.class, new Long(id));
        if (user!=null) {
            session.delete(user);
        }
        session.getTransaction().commit();
        session.close();
        return user;
    }
}
