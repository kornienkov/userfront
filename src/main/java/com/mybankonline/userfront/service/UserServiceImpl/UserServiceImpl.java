package com.mybankonline.userfront.service.UserServiceImpl;

import com.mybankonline.userfront.dao.UserDao;
import com.mybankonline.userfront.domain.User;
import com.mybankonline.userfront.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    public void save(User user){
        userDao.save(user);
    }

    public User findByUsername(String username){
        return userDao.findByUsername(username);
    }

    public User findByEmail(String email){
        return userDao.findByEmail(email);
    }

    public boolean checkUserExists(String username, String email){
        if(checkUsernameExists(username) || checkEmailExists(email)) return true;
        else return false;
    }

    public boolean checkUsernameExists(String username){
        return (findByUsername(username) != null);
    }

    public boolean checkEmailExists(String email){
        return (findByEmail(email) != null);
    }

}
