package com.mybankonline.userfront.dao;

import com.mybankonline.userfront.domain.security.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleDao extends CrudRepository<Role, Integer> {
    Role findByName(String name);
}
