package com.fatec.contracts.controller;

import com.fatec.contracts.controller.dto.request.ConfigRequestDto;
import com.fatec.contracts.model.ServiceProvider;
import com.fatec.contracts.model.States;
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
        ModelAndView mv = new ModelAndView("config");
        try {
            ServiceProvider serviceProvider = serviceProviderService.findById(1L);
            mv.addObject("serviceProvider", new ConfigRequestDto(serviceProvider));
        } catch (RuntimeException e) {
            mv.addObject("serviceProvider", new ConfigRequestDto());
        }
        mv.addObject("states", States.values());
        return mv;
    }

    @PostMapping(path = "/new")
    public String save(ConfigRequestDto configRequestDto) {
        this.serviceProviderService.update(configRequestDto.toServiceProvider());
        return "redirect:/";
    }

}
