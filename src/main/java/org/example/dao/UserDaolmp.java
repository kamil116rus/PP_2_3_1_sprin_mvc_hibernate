package org.example.dao;

import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
@Repository
public class UserDaolmp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    //    public EntityManager getEntityManager() {
//        return entityManager;
//    }
    //@Autowired
//    public void setEntityManager(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }

    @Override
    public void add(User user) {
        // sessionFactory.getCurrentSession().save(user);
        entityManager.persist(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        // TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        Query query = entityManager.createQuery("select u from User u", User.class);
        //List<User> persons = (List<User>) query.getResultList();
        return query.getResultList();
    }

    public User getUser(int id) {
        //String hql = "FROM User user LEFT OUTER JOIN FETCH user.id WHERE user.id=:id" ;

        return entityManager.find(User.class, id);
    }
}
