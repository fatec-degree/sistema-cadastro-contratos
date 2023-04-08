package com.fatec.contracts.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import java.util.List;

@Service
public class SignatureService {

    @Value("${d4sign.api.token}")
    private String tokenApi;
    @Value("${d4sign.api.baseUrl}")
    private String baseUrl;
    @Value("${d4sign.api.safeContractsUuid}")
    private String safeContractsUuid;

    public HttpResponse<String> createSignatureList(String uuidDocument, List<String> emails) {
        String signers = SignerBuilder.buildSigners(emails);
        try {
            HttpRequest.BodyPublisher body = HttpRequest.BodyPublishers.ofString(
                    "{\"signers\":[" + signers + "]}");
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "/documents/" + uuidDocument + "/createlist?tokenAPI=" + tokenApi))
                    .header("accept", "application/json")
                    .header("content-type", "application/json")
                    .POST(body)
                    .build();
            return HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não foi possível adicionar os signatários: " + e);
        }
    }

    public HttpResponse<String> uploadDocument(byte[] file, String name) {
        try {
            String base64File = Base64.getEncoder().encodeToString(file);
            HttpRequest.BodyPublisher body = HttpRequest.BodyPublishers.ofString("{" +
                    "\"base64_binary_file\":\"" + base64File + "\"," +
                    "\"mime_type\": \"application/pdf\"," +
                    "\"name\":\"" + name + "\"}");
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "/documents/" + safeContractsUuid + "/uploadbinary?tokenAPI="+ tokenApi))
                    .headers("Content-Type", "application/json",
                            "accept", "application/json")
                    .POST(body)
                    .build();
            return HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException("Não foi possível realizar o upload do documento: " + e);
        }
    }

    public HttpResponse<String> sendToSigners(String uuidDocument, String message) {
        try {
            HttpRequest.BodyPublisher body = HttpRequest.BodyPublishers.ofString(
                    "\"message\": \"" + message + "\"," +
                            "\"skip_email\": \"0\", " +
                            "\"workflow\": \"0\"}");
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "/documents/" + uuidDocument + "/sendtosigner?tokenAPI=" + tokenApi))
                    .header("Content-Type", "application/json")
                    .POST(body)
                    .build();
            return HttpClient.newHttpClient().send(request,  HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não foi possível solicitar as assinaturas para o documento: " + e);
        }
    }

    public void execute(List<String> emails, byte[] file, String fileName, String message) {
        HttpResponse<String> uploadDocumentResponse = uploadDocument(file, fileName);
        if(uploadDocumentResponse.statusCode() == 200) {
            try {
                JsonNode json = new ObjectMapper().readTree(uploadDocumentResponse.body());
                String uuid = json.get("uuid").asText();
                HttpResponse<String> signatureListResponse = createSignatureList(uuid, emails);
                if(signatureListResponse.statusCode() == 200) {
                    sendToSigners(uuid, message);
                }
            } catch(JsonProcessingException e) {
                throw new RuntimeException("Não foi possível ler a resposta enviada pela API D4Sign.");
            }
        }
    }

}
