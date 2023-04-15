package com.fatec.contracts.controller;

import com.fatec.contracts.controller.dto.response.ContractDetailsResponseDto;
import com.fatec.contracts.service.ContractService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@AllArgsConstructor
@Controller
@RequestMapping("/contract-details")
public class ContractDetailsController {

    private ContractService contractService;

    @GetMapping(path = "/{id}")
    public ModelAndView contractDetails(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("contract-details");
        mv.addObject("contractDto", ContractDetailsResponseDto.toContractDetailsResponseDto(contractService.findById(id)));
        return mv;
    }

}
