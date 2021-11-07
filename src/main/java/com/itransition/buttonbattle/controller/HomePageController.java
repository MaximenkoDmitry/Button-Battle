package com.itransition.buttonbattle.controller;

import com.itransition.buttonbattle.service.ButtonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @Autowired
    private ButtonService buttonService;

    @GetMapping
    public String getHomePage(final Model model) {
        model.addAttribute("broClicks", buttonService.getNumberOfBroClicks());
        model.addAttribute("sisClicks", buttonService.getNumberOfSisClicks());
        model.addAttribute("lastBroMessage", buttonService.getLastBroMessage());
        model.addAttribute("lastSisMessage", buttonService.getLastSisMessage());
        return "home";
    }

}
