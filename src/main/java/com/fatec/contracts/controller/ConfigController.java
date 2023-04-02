package com.fatec.contracts.controller;

import com.fatec.contracts.controller.dto.request.ConfigRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/config")
public class ConfigController {

    @GetMapping(path = "/form")
    public ModelAndView newConfig(ConfigRequestDto configRequestDto) {
        return new ModelAndView("config");
    }

    @PostMapping(path = "/new")
    public String save(ConfigRequestDto configRequestDto) {
        System.out.println(configRequestDto);
        return "redirect:/";
    }

}
