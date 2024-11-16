package com.example.model;

import java.util.List;

/**
 * Role.java
 *
 * @author QQDDTT
 * @since 0.2
 */
public class Role {

    private String roleId;
    private String roleName;
    private String roleDescription;
    private List<Authority> authorities;

    public String getRoleId() {
        return roleId;
    }
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public String getRoleDescription() {
        return roleDescription;
    }
    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
    public List<Authority> getAuthorities() {
        return authorities;
    }
    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "Role [roleId=" + roleId + 
                ", roleName=" + roleName +
                ", roleDescription=" + roleDescription +
                ", authorities=" + authorities + "]";
    }
}
