package com.fatec.contracts.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@AllArgsConstructor
@Service
public class SignatureService {

    @Value("${d4sign.api.token}")
    private final String TOKEN_API;
    @Value("${d4sign.api.baseUrl}")
    private final String BASE_URL;

    public void createSignatureList(String uuidDocument) {
        // Em fase de implementação
        String signerOne = new SignerBuilder()
                .email("email")
                .act(1)
                .foreign(1)
                .certificadoIcpBr(0)
                .assinaturaPresencial(0)
                .whatsappNumber("11912345678")
                .build();
        String signerTwo = new SignerBuilder()
                .email("email")
                .act(1)
                .foreign(1)
                .certificadoIcpBr(0)
                .assinaturaPresencial(0)
                .whatsappNumber("11912345678")
                .build();
        HttpRequest.BodyPublisher body = HttpRequest.BodyPublishers.ofString(
            "{\"signers\":[" + signerOne + ", " + signerTwo + "]}");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/documents/" + uuidDocument + "/createlist"))
                .header("accept", "application/json")
                .header("content-type", "application/json")
                .POST(body)
                .build();
        HttpResponse<String> response;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException("Não foi possível solicitar as assinaturas.");
        }
    }

    public HttpResponse<String> uploadDocument(String uuidSafe, String pathToFile) {
        try(InputStream stream = new FileInputStream(pathToFile)) {
            HttpRequest.BodyPublisher body = HttpRequest.BodyPublishers.ofInputStream(() -> stream);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/documents/" + uuidSafe + "/upload?tokenApi="+ TOKEN_API))
                    .headers("Content-Type", "multipart/form-data;",
                            "accept", "application/json")
                    .POST(body)
                    .build();
            return HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException("Não foi possível carregar o arquivo " + pathToFile + ": " + e);
        } catch (InterruptedException e) {
            throw new RuntimeException("Não foi possível realizar o upload do documento: " + e);
        }
    }

}
