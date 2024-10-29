package com.example.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.common.SMSException;
import com.example.model.Role;
import com.example.model.User;
import com.example.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Home controller.
 *
 * @author QQDDTT
 * @since 0.2
 */
@Controller
public class HomeController {

    private static Logger LOGGER = LogManager.getLogger(HomeController.class.getName());

    @Autowired
    private UserService userService;

    /**
     * Login page.
     * @return login page
     */
    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        return "/login";
    }

    /**
     * Login page.
     * @return login page
     * @param request
     * @param response
     */
    @PostMapping("/login")
    public String loginPost(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("Login request received");
        try {
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            Role role = userService.login(name, password);
            if (role != null) {
                LOGGER.info("Login successful");
                request.getSession().setAttribute("role", role);
                request.setAttribute("error", "");
                switch (role.getRole()) {
                    case "admin":
                        return "/admin/home";
                    case "user":
                        return "/user/home";
                    default:
                        return "/";
                }
            } else {
                LOGGER.info("Login failed");
                request.setAttribute("error", "Invalid username or password");
                return "login";
            }
        } catch (SMSException e) {
           LOGGER.error("Error during login", e);
           request.setAttribute("error", "An error occurred during login");
           return "login";
        }
    }
}
