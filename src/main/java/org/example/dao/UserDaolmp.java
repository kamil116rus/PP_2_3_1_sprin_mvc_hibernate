package org.example.dao;

import org.example.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
@Component
public class UserDaolmp implements UserDao{
    private List<User> users;
    {
        users = new ArrayList<>();
        users.add(new User(1,"rick", "dalton", 26));
        users.add(new User(2,"Nick", "Tusday", 15));
        users.add(new User(3,"rex", "dino", 56));
        users.add(new User(4,"vitor", "chernii", 36));
        users.add(new User(5,"rock", "live", 45));
    }
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    public User getUser(int id) {
        String hql = "FROM User user LEFT OUTER JOIN FETCH user.id WHERE user.id=:id" ;//car.model=:model and user.car.series=:series";

        return sessionFactory.getCurrentSession().createQuery(hql, User.class).setParameter("id", id).uniqueResult();
    }
}
