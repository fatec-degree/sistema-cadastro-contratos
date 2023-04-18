package com.fatec.contracts.api.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateStatusDocumentDto {

     private String uuid;
     private String type_post;
     private String message;
     private String email;

}
