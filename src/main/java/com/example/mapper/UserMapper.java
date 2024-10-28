package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.example.model.User;

/**
 * UserMapper.
 *
 * @author QQDDTT
 * @since 0.2
 */
@Mapper
public interface UserMapper {

    List<User> selectAll();

    User selectById(String id);

    User selectByEmail(String email);

    User selectByName(String name);

    List<User> selectByAuthority(String authorityId);

    boolean insert(User user);

    boolean update(User user);

    boolean delete(String id);
    
}