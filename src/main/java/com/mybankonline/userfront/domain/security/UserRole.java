package com.mybankonline.userfront.domain.security;

import com.mybankonline.userfront.domain.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userRoleId;

    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;


    public UserRole() {}

}
