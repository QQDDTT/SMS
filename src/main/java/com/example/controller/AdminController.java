package com.example.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.common.SMSException;
import com.example.service.AuthorityService;
import com.example.service.RoleService;
import com.example.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Admin controller.
 *
 * @author QQDDTT
 * @since 0.2
 */
@Controller
public class AdminController {

    private static Logger LOGGER = LogManager.getLogger(AdminController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private AuthorityService authorityService;

    @GetMapping("/admin/home")
    public String adminHome (HttpServletRequest request, HttpServletResponse response) {
        return "admin/Home";
    }
    
    @GetMapping("/admin/user/list")
    public String getUserList(Model model) {
        LOGGER.info("User list");
        try {
            model.addAttribute("users", userService.getAllUsers());
        } catch (SMSException e) {
            LOGGER.error("Error getting user list :{}", e.getMessage());
            model.addAttribute("error", e.getMessage());
            return "error";
        }
        return "admin/user_list";
    }

    @GetMapping("/admin/role/list")
    public String getRoleList(Model model) {
        LOGGER.info("Role list");
        try {
            model.addAttribute("roles", roleService.getAllRoles());
        } catch (SMSException e) {
            LOGGER.error("Error getting role list :{}", e.getMessage());
            model.addAttribute("error", e.getMessage());
            return "error";
        }
        return "admin/role_list";
    }

    @GetMapping("/admin/authority/list")
    public String getAuthorityList(Model model) {
        LOGGER.info("Authority list");
        try {
            model.addAttribute("authorities", authorityService.getAllAuthorities());
        } catch (SMSException e) {
            LOGGER.error("Error getting authority list :{}", e.getMessage());
            model.addAttribute("error", e.getMessage());
            return "error";
        }
        return "admin/authority_list";
    }
    
}
