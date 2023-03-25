package com.fatec.contracts.controller;

import com.fatec.contracts.controller.dto.response.ContractResponseDto;
import com.fatec.contracts.service.ContractService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping
public class HomeController {

    private ContractService contractService;

    @GetMapping
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("home");
        List<ContractResponseDto> contracts = ContractResponseDto.toContractResponseDto(contractService.findAll());
        mv.addObject("contractsResponseDto", contracts);
        return mv;
    }

}
