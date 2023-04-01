package com.fatec.contracts.service;

import com.fatec.contracts.model.Signer;
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
import java.util.List;

@AllArgsConstructor
@Service
public class SignatureService {

    @Value("${d4sign.api.token}")
    private final String TOKEN_API;
    @Value("${d4sign.api.baseUrl}")
    private final String BASE_URL;

    public HttpResponse<String> createSignatureList(String uuidDocument, List<Signer> signers) {
        String signerOne = new SignerBuilder()
                .email(signers.get(0).getEmail())
                .act(signers.get(0).getAct())
                .foreign(signers.get(0).getForeign())
                .certificadoIcpBr(signers.get(0).getCertificadoIcpBr())
                .assinaturaPresencial(signers.get(0).getAssinaturaPresencial())
                .whatsappNumber(signers.get(0).getWhatsappNumber())
                .build();
        String signerTwo = new SignerBuilder()
                .email(signers.get(1).getEmail())
                .act(signers.get(1).getAct())
                .foreign(signers.get(1).getCertificadoIcpBr())
                .certificadoIcpBr(signers.get(1).getCertificadoIcpBr())
                .assinaturaPresencial(signers.get(1).getAssinaturaPresencial())
                .whatsappNumber(signers.get(1).getWhatsappNumber())
                .build();
        try {
            HttpRequest.BodyPublisher body = HttpRequest.BodyPublishers.ofString(
                    "{\"signers\":[" + signerOne + ", " + signerTwo + "]}");
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/documents/" + uuidDocument + "/createlist"))
                    .header("accept", "application/json")
                    .header("content-type", "application/json")
                    .POST(body)
                    .build();
            return HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não foi possível adicionar os signatários: " + e);
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

    public HttpResponse<String> sendToSigners(String uuidDocument, String message) {
        try {
            HttpRequest.BodyPublisher body = HttpRequest.BodyPublishers.ofString(
                    "\"message\": \"" + message + "\"," +
                            "\"skip_email\": \"0\", " +
                            "\"workflow\": \"0\", " +
                            "\"tokenAPI\": \"" + TOKEN_API + "\"");
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/documents/" + uuidDocument + "/sendtosigner"))
                    .header("Content-Type", "application/json")
                    .POST(body)
                    .build();
            return HttpClient.newHttpClient().send(request,  HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não foi possível solicitar as assinaturas para o documento: " + e);
        }
    }

}
