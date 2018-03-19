package com.mybankonline.userfront.dao;

import com.mybankonline.userfront.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Long>{

    User findByUsername(String username);
    User findByEmail(String email);
}
