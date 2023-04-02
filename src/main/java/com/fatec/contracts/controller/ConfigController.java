package com.fatec.contracts.controller;

import com.fatec.contracts.controller.dto.request.ConfigRequestDto;
import com.fatec.contracts.service.ServiceProviderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@AllArgsConstructor
@Controller
@RequestMapping(path = "/config")
public class ConfigController {

    private ServiceProviderService serviceProviderService;

    @GetMapping(path = "/form")
    public ModelAndView newConfig(ConfigRequestDto configRequestDto) {
        return new ModelAndView("config");
    }

    @PostMapping(path = "/new")
    public String save(ConfigRequestDto configRequestDto) {
        this.serviceProviderService.save(configRequestDto.toServiceProvider());
        return "redirect:/";
    }

}
