package com.example.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * User controller.
 *
 * @author QQDDTT
 * @since 0.2
 */
@Controller
public class UserController {

    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

    @GetMapping("/user/home")
    public String userHome(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("User home page");
        return "user/home";
    }
}
