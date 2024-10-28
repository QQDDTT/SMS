package com.example.service;

import com.example.common.SMSException;
import com.example.mapper.UserMapper;
import com.example.model.Role;
import com.example.model.User;

import org.apache.logging.log4j.Logger;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl
 *
 * @author QQDDTT
 * @since 0.2
 */
@Service
public class UserService {

    private static final Logger LOGGER = LogManager.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    public User getUserById(String id) throws SMSException {
        LOGGER.info("Get user by id : " + id);
        try {
            User user = userMapper.selectById(id);
            return user;
        } catch (Exception e) {
            LOGGER.error("Get user failed by id : " + id);
            throw new SMSException("Get user failed by id : " + id);
        }
    }

    public void createUser(User user) throws SMSException {
        LOGGER.info("Create user : " + user);
        try {
            userMapper.insert(user);
        } catch (Exception e) {
            LOGGER.error("Create user failed : " + user);
            throw new SMSException("Create user failed : " + user);
        }
    }

    public void updateUser(User user) throws SMSException {
        LOGGER.info("Update user : " + user);
        try {
            userMapper.update(user);
        } catch (Exception e) {
            LOGGER.error("Update user failed : " + user);
            throw new SMSException("Update user failed : " + user);
        }
    }

    public void deleteUser(String id) throws SMSException {
        LOGGER .info("Delete user by id : " + id);
        try {
            userMapper.delete(id);
        } catch (Exception e) {
            LOGGER.error("Delete user failed by id : " + id);
            throw new SMSException("Delete user failed by id : " + id);
        }
    }

    public User getUserByEmail(String email) throws SMSException {
        LOGGER.info("Get user by email : " + email);
        try {
            User user = userMapper.selectByEmail(email);
            return user;
        } catch (Exception e) {
            LOGGER.error("Get user failed by email : " + email);
            throw new SMSException("Get user failed by email : " + email);
        }
    }

    public List<User> getAllUsers() throws SMSException {
        LOGGER.info("Get all users");
        try {
            List<User> users = userMapper.selectAll();
            return users;
        } catch (Exception e) {
            LOGGER.error("Get all users failed");
            throw new SMSException("Get all users failed");
        }
    }

    public Role login(String name, String password) throws SMSException {
        LOGGER.info("Login with name : " + name + " and password : " + password);
        try {
            User user = userMapper.selectByName(name);
            if (user != null && user.getPassword().equals(password)) {
                return user.getRole();
            }
            throw new SMSException("Login failed with name : " + name + " and password : " + password);
        } catch (Exception e) {
            LOGGER.error("Login failed with name : " + name + " and password : " + password);
            throw new SMSException("Login failed with name : " + name + " and password : " + password);
        }
    }

}
