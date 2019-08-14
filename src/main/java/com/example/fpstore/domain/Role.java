package com.example.fpstore.domain;


import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

public class Role implements GrantedAuthority{
    private String name;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public Role(String name, Set<User> users) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}

