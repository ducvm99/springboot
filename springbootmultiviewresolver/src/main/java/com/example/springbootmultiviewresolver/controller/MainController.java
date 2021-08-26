package com.example.springbootmultiviewresolver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    @RequestMapping(value = {"/testJsp"}, method = RequestMethod.GET)
    public String testJspView() {
        return "testJsp";
    }

    @RequestMapping(value = {"/testThymeleaf"}, method = RequestMethod.GET)
    public String testThymeleaf() {
        return "th_page1";
    }

    @RequestMapping(value = {"/testFreeMarker"}, method = RequestMethod.GET)
    public String testFreeMarker() {
        return "testFreeMarker";
    }
}
