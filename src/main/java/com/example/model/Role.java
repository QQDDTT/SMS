package com.example.model;

import java.util.List;

/**
 * Role.java
 *
 * @author QQDDTT
 * @since 0.2
 */
public class Role {

    private int id;
    private String role;
    private String description;
    private List<Authority> authorities;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Authority> getAuthorities() {
        return authorities;
    }
    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
}
