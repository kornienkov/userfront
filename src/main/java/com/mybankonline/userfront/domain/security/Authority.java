package com.mybankonline.userfront.domain.security;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {

    private final String authtrity;

    public Authority(String auththority) {
        this.authtrity = auththority;
    }

    public String getAuthority() {
        return authtrity;
    }
}
