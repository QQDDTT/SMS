package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.example.model.Role;

/**
 * RoleMapper.
 *
 * @author QQDDTT
 * @since 0.2
 */
@Mapper
public interface RoleMapper {

    List<Role> selectAllRoles();

    Role selectRoleById(String roleId);

    boolean insertRole(Role role);

    boolean updateRole(Role role);

    boolean deleteRole(String roleId);

    boolean assignAuthoritiesToRole(String roleId, List<String> authorityIds);
}
