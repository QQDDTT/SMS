package com.example.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.common.SMSException;
import com.example.model.Role;
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
public class LoginController {

    private static Logger LOGGER = LogManager.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    /**
     * Login page.
     * @return login page
     */
    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("Get login page");
        return "login";
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
                switch (role.getRoleId()) {
                    case "ADMIN":
                        LOGGER.info("loging as ADMIN");
                        return "admin/home";
                    case "STUD":
                        LOGGER.info("loging as STUD");
                        return "student/home";
                    default:
                        LOGGER.warn("Role is not found");
                        return "login";
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
