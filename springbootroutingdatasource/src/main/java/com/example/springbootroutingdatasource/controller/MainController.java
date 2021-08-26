package com.example.springbootroutingdatasource.controller;

import com.example.springbootroutingdatasource.dao.DataDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private DataDAO dataDAO;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String home(Model model) {
        return "home";
    }

    @RequestMapping(value = {"/advertiser/list"}, method = RequestMethod.GET)
    public String advertiser(Model model) {
        List<String> list = dataDAO.queryAdvertiser();
        model.addAttribute("advertisers", list);

        return "advertiser";
    }

    @RequestMapping(value = {"/publisher/list"}, method = RequestMethod.GET)
    public String publisher(Model model) {
        List<String> list = dataDAO.queryPublisher();
        model.addAttribute("publishers", list);

        return "publisher";
    }
}
