package org.example.servise;

import org.example.dao.UserDao;
import org.example.dao.UserDaolmp;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
//@Transactional
//@Component
//@Repository
public class UserServiselmp implements UserServise{
@Autowired
private UserDao userDao = new UserDaolmp();
//    {
//        userDao.add(new User(1,"rick", "dalton", 26));
//        userDao.add(new User(2,"Nick", "Tusday", 15));
//        userDao.add(new User(3,"rex", "dino", 56));
//        userDao.add(new User(4,"vitor", "chernii", 36));
//        userDao.add(new User(5,"rock", "live", 45));
//    }
public UserDao getUserDao() {
    return userDao;
}


//    public UserServiselmp(UserDao userDao) {
//        this.userDao = userDao;
//    }
//    @Autowired
//    public void setUserDao(UserDaolmp UserDao) {
//        this.userDao = userDao;
//    }

    // private  List<User> users = new ArrayList<>();
//    {
//        userDao.add(new User(1,"rick", "dalton", 26));
//        userDao.add(new User(2,"Nick", "Tusday", 15));
//        userDao.add(new User(3,"rex", "dino", 56));
//        userDao.add(new User(4,"vitor", "chernii", 36));
//        userDao.add(new User(5,"rock", "live", 45));
//    }
    @Override
    @Transactional
    public List<User> index(Integer count) {
        if(count>=5) {
            return  getUserDao().listUsers();
        } else {
            return getUserDao().listUsers().stream().limit(count).toList();
        }
    }
    @Override
    @Transactional(readOnly = true)
    public User show(Integer id) {
        return userDao.getUser(id);
       // return userDao.listUsers().stream().filter(User->User.getId() == id).findAny().orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public void add(User user) {
        getUserDao().add(user);
    }
}
