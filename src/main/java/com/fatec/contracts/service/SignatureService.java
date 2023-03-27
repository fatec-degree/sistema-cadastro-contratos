package com.fatec.contracts.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class SignatureService {

    public void createSignatureList(String uuidDocument) {
        HttpRequest.BodyPublisher body = HttpRequest.BodyPublishers.ofString(
            "{\"signers\":[{" +
                    "\"email\":\"string\"," +
                    "\"act\":\"string\"," +
                    "\"foreign\":\"string\"," +
                    "\"certificadoicpbr\":\"string\"," +
                    "\"assinatura_presencial\":\"string\"," +
                    "\"whatsapp_number\":\"string\"" +
                "}]}");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://sandbox.d4sign.com.br/api/v1/documents/" + uuidDocument + "/createlist"))
                .header("accept", "application/json")
                .header("content-type", "application/json")
                .method("POST", body)
                .build();
        HttpResponse<String> response;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException("Não foi possível solicitar as assinaturas.");
        }
    }

    public void uploadDocument(String uuidSafe) {
        HttpRequest.BodyPublisher body = HttpRequest.BodyPublishers.ofString("\"file\":\"string\",\"uuid_folder\":\"string\"}");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://sandbox.d4sign.com.br/api/v1/documents/" + uuidSafe + "/upload"))
                .header("accept", "application/json")
                .header("content-type", "application/json")
                .method("POST", body)
                .build();
        HttpResponse<String> response;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException("Não foi possível realizar o upload do documento para solicitar as assinaturas.");
        }
    }

}
