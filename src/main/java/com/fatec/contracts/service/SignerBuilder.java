package com.fatec.contracts.service;

import java.util.List;

public class SignerBuilder {

    public static String buildSigners(List<String> emails) {
        StringBuilder signers = new StringBuilder();
        for(String email : emails) {
            signers.append("{\"email\": \"")
                    .append(email)
                    .append("\",")
                    .append("\"act\": \"1\",")
                    .append("\"foreign\": \"0\",")
                    .append("\"certificadoicpbr\": \"0\",")
                    .append("\"assinatura_presencial\": \"0\"},");
        }
        return signers.substring(0, signers.length() - 1);
    }

}
