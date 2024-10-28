package com.example.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.common.SMSException;
import com.example.mapper.RoleMapper;
import com.example.model.Role;

/**
 * Role service implementation.
 *
 * @author QQDDTT
 * @since 0.2
 */
@Service
public class RoleService {

    private static Logger LOGGER = LogManager.getLogger(RoleService.class);

    @Autowired
    private RoleMapper roleMapper;

    public Role getRoleById(String id) throws SMSException {
        LOGGER.info("Get role by id : " + id);
        try {
            return roleMapper.selectRoleById(id);
        } catch (Exception e) {
            LOGGER.error("Get role failed by id : " + id);
            throw new SMSException("Get role failed by id : " + id);
        }
        
    }

    public void createRole(Role role) throws SMSException {
        LOGGER.info("Create role : " + role);
        try {
            roleMapper.insertRole(role);
        } catch (Exception e) {
            LOGGER.error("Create role failed : " + role);
            throw new SMSException("Create role failed : " + role);
        }
    }

    public void updateRole(Role role) throws SMSException {
        LOGGER.info("Update role : " + role);
        try {
            roleMapper.updateRole(role);
        } catch (Exception e) {
            LOGGER.error("Update role failed : " + role);
            throw new SMSException("Update role failed : " + role);
        }
    }

    public void deleteRole(String id) throws SMSException {
        LOGGER.info("Delete role by id : " + id);
        try {
            roleMapper.deleteRole(id);
        } catch (Exception e) {
            LOGGER.error("Delete role failed by id : " + id);
            throw new SMSException("Delete role failed by id : " + id);
        }
    }

    public List<Role> getAllRoles() throws SMSException {
        LOGGER.info("Get all roles");
        try {
            return roleMapper.selectAllRoles();
        } catch (Exception e) {
            LOGGER.error("Get all roles failed");
            throw new SMSException("Get all roles failed");
        }
    }

    public void assignAuthoritiesToRole(String roleId, List<String> authorityIds) throws SMSException {
        LOGGER.info("Assign authorities to role : " + roleId);
        try {
            roleMapper.assignAuthoritiesToRole(roleId, authorityIds);
        } catch (Exception e) {
            LOGGER.error("Assign authorities to role failed : " + roleId);
            throw new SMSException("Assign authorities to role failed : " + roleId);
        }
    }

}
