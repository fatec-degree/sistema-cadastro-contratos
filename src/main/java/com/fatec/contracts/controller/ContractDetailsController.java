package com.fatec.contracts.controller;

import com.fatec.contracts.controller.dto.response.ContractDetailsResponseDto;
import com.fatec.contracts.model.Contract;
import com.fatec.contracts.model.ContractStatus;
import com.fatec.contracts.service.ContractService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

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

    @PostMapping(path = "/upload/{id}")
    public String uploadContract(@PathVariable Long id, @RequestParam("file") MultipartFile file) throws IOException {
        byte[] fileData = file.getBytes();
        contractService.updateFile(id, fileData);
        return "redirect:/contract-details/" + id;
    }

    @GetMapping(path = "/download/{id}")
    public void downloadContract(@PathVariable Long id, HttpServletResponse response) {
        Contract contract = contractService.findById(id);
        byte[] contractPdf = contract.getFileData();

        // Configuração da resposta HTTP para o download do arquivo
        response.setContentType("application/pdf");
        String documentName = "contrato-prestacao-servico-" + contract.getResponsible().getName() + "-" + contract.getResponsible().getCpf();
        response.setHeader("Content-Disposition", "attachment; filename=\"" + documentName + "\"");
        response.setContentLength(contractPdf.length);
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);

        // Escrita do conteúdo do documento na resposta HTTP
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            outputStream.write(contractPdf);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(path = "/cancel/{id}")
    public String cancelContract(@PathVariable Long id) {
        contractService.updateStatus(id, ContractStatus.CANCELADO);
        return "redirect:/contract-details/" + id;
    }

    @GetMapping(path = "/activate/{id}")
    public String activateContract(@PathVariable Long id) {
        contractService.updateStatus(id, ContractStatus.ATIVO);
        return "redirect:/contract-details/" + id;
    }

}
