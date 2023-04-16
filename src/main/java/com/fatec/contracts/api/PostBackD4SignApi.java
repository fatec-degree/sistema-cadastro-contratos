package com.fatec.contracts.api;

import com.fatec.contracts.api.dto.request.UpdateStatusDocumentDto;
import com.fatec.contracts.model.ContractStatus;
import com.fatec.contracts.service.ContractService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/d4sign-webhook")
public class PostBackD4SignApi {

    private ContractService contractService;

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStatusDocument(@RequestBody UpdateStatusDocumentDto updateStatusDocumentDto) {
        if(updateStatusDocumentDto.getType_post().equals("1")) {
            contractService.updateStatusByUuid(updateStatusDocumentDto.getUuid(), ContractStatus.ATIVO);
        } else if(updateStatusDocumentDto.getType_post().equals("3")) {
            contractService.updateStatusByUuid(updateStatusDocumentDto.getUuid(), ContractStatus.CANCELADO);
        }
    }

}
