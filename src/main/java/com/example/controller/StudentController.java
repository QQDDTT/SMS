package com.example.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Student controller.
 *
 * @author QQDDTT
 * @since 0.2
 */
@Controller
public class StudentController {

    private static final Logger LOGGER = LogManager.getLogger(StudentController.class);

    @GetMapping("/student/home")
    public String userHome(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("student home page");
        return "student/home";
    }
}
