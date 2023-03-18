package com.fatec.contracts.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@AllArgsConstructor
@Controller
@RequestMapping(path = "/contracts")
public class ContractController {

    @GetMapping(path = "/form")
    public ModelAndView newContract() {
        return new ModelAndView("new-contract");
    }

}
