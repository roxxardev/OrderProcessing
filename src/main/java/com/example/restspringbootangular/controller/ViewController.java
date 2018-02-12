package com.example.restspringbootangular.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping({"/home", "/home/dashboard", "/home/dashboard/orders", "/home/dashboard/products",
            "/home/customers", "/home/employees", "/home/orders", "/home/products", "/logout", "/login"})
    public String index() {
        return "forward:/";
    }
}
