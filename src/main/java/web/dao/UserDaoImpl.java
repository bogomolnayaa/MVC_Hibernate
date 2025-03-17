package web.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import jakarta.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    //private EntityManagerFactory entityManagerFactory;
    private SessionFactory sessionFactory;

    @Autowired
    UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> getAllUsers(){
        Query query = sessionFactory.openSession().createQuery("from User");
        List<User> users = query.getResultList();
        return users;
    }

    @Override
    public User getUser(int id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);

    }

    @Override
    public void removeUser(int id) {
        sessionFactory.getCurrentSession().delete(getUser(id));

    }
}
