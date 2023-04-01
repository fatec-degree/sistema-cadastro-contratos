package com.fatec.contracts.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Signer {

    private String email;
    private Integer act;
    private Integer foreign;
    private Integer certificadoIcpBr;
    private Integer assinaturaPresencial;
    private String whatsappNumber;

    public Signer(Person person, Integer act, Integer foreign, Integer certificadoIcpBr, Integer assinaturaPresencial) {
        this.email = person.getEmail();
        this.act = act;
        this.foreign = foreign;
        this.certificadoIcpBr = certificadoIcpBr;
        this.assinaturaPresencial = assinaturaPresencial;
        this.whatsappNumber = person.getMainContact();
    }

}
