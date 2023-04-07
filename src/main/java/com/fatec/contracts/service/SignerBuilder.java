package com.fatec.contracts.service;

public class SignerBuilder {

    private String signer = "{";

    public SignerBuilder email(String email) {
        signer += "\"email\":\"" + email + "\",";
        return this;
    }

    public SignerBuilder act(Integer act) {
        signer += "\"act\":\"" + act + "\",";
        return this;
    }

    public SignerBuilder foreign(Integer foreign) {
        signer += "\"foreign\":\"" + foreign + "\",";
        return this;
    }

    public SignerBuilder certificadoIcpBr(Integer certificadoIcpBr) {
        signer += "\"certificadoicpbr\":\"" + certificadoIcpBr + "\",";
        return this;
    }

    public SignerBuilder assinaturaPresencial(Integer assinaturaPresencial) {
        signer += "\"assinatura_presencial\":\"" + assinaturaPresencial + "\",";
        return this;
    }

    public SignerBuilder whatsappNumber(String whatsappNumber) {
        signer += "\"whatsapp_number\":\"" + whatsappNumber + "\",";
        return this;
    }

    public String build() {
        return signer.substring(0, signer.length() - 1) + "}";
    }

}
