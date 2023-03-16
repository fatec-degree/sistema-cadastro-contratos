package com.fatec.contracts.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@AllArgsConstructor
@Controller
@RequestMapping
public class HomeController {

    @GetMapping
    public ModelAndView home() {
        return new ModelAndView("home");
    }

}
