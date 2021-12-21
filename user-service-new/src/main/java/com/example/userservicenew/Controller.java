package com.example.userservicenew;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class Controller {
    @GetMapping("/health_check")
    public String status(HttpServletRequest request) {
        return String.format("It's Working in User Service");
    }
}
