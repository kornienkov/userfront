package com.mybankonline.userfront.service;

import com.mybankonline.userfront.domain.security.UserRole;
import com.mybankonline.userfront.domain.User;

import java.util.Set;

public interface UserService {

    User findByUsername(String username);

    User findByEmail(String email);

    boolean checkUserExists(String username, String email);
    boolean checkUsernameExists(String username);
    boolean checkEmailExists(String email);

    void save(User user);

    User createUser(User user, Set<UserRole> userRoles);

    void saveUser(User user);
}
