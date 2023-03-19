package com.fatec.contracts.controller;

import com.fatec.contracts.controller.dto.ContractDto;
import com.fatec.contracts.service.ContractService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@AllArgsConstructor
@Controller
@RequestMapping(path = "/contracts")
public class ContractController {

    private ContractService contractService;

    @GetMapping(path = "/form")
    public ModelAndView newContract(ContractDto contractDto) {
        return new ModelAndView("new-contract");
    }

    @PostMapping(path = "/new")
    public ModelAndView save(ContractDto contractDto) {
        contractService.save(contractDto);
        return new ModelAndView("home");
    }

}
