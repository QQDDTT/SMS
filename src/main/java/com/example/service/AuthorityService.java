package com.example.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.common.SMSException;
import com.example.mapper.AuthorityMapper;
import com.example.model.Authority;
import com.example.service.AuthorityService;

/**
 * Authority Service Implementation
 *
 * @author QQDDTT
 * @since 0.2
 */
@Service
public class AuthorityService {

    private static Logger LOGGER = LogManager.getLogger(AuthorityService.class);

    @Autowired
    private AuthorityMapper authorityMapper;

    public Authority getAuthorityById(String id) throws SMSException {
        LOGGER.info("Get authority by id : " + id);
        try {
            Authority authority = authorityMapper.selectAuthorityById(id);
            return authority;
        } catch (Exception e) {
            LOGGER.error("Get authority failed by id : " + id);
            throw new SMSException("Get authority failed by id : " + id);
        }
    }

    public void createAuthority(Authority authority) throws SMSException {
        LOGGER.info("Create authority : " + authority);
        try {
            authorityMapper.insertAuthority(authority);
        } catch (Exception e) {
            LOGGER.error("Create authority failed : " + authority);
            throw new SMSException("Create authority failed : " + authority);
        }
    }

    public void updateAuthority(Authority authority) throws SMSException {
        LOGGER.info("Update authority : " + authority);
        try {
            authorityMapper.updateAuthority(authority);
        } catch (Exception e) {
            LOGGER.error("Update authority failed : " + authority);
            throw new SMSException("Update authority failed : " + authority);
        }
    }

    public void deleteAuthority(String id) throws SMSException {
        LOGGER.info("Delete authority by id : " + id);
        try {
            authorityMapper.deleteAuthorityById(id);
        } catch (Exception e) {
            LOGGER.error("Delete authority failed by id : " + id);
            throw new SMSException("Delete authority failed by id : " + id);
        }
    }

    public List<Authority> getAllAuthorities() throws SMSException {
        LOGGER.info("Get all authorities");
        try {
            return authorityMapper.selectAllAuthorities();
        } catch (Exception e) {
            LOGGER.error("Get all authorities failed");
            throw new SMSException("Get all authorities failed");
        }
    }

}
