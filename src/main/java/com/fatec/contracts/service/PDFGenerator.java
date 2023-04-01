package com.fatec.contracts.service;

import com.fatec.contracts.exceptions.FillFieldOnPDFException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Service
public class PDFGenerator {

    private PDDocument document;
    private PDAcroForm pdfForm;
    private final ResourceLoader resourceLoader;

    public PDFGenerator(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public void loadDocument() {
        Resource resource = resourceLoader.getResource("classpath:base_contract.pdf");
        try(InputStream stream = resource.getInputStream()) {
            this.document = PDDocument.load(stream);
        } catch (IOException e) {
            throw new IllegalArgumentException("O arquivo não foi encontrado.");
        }
        this.pdfForm = document.getDocumentCatalog().getAcroForm();
    }

    public void fillFields(Map<String, String> fieldValues) {
        fieldValues.forEach((field, value) -> {
            PDTextField fieldObject = (PDTextField) this.pdfForm.getField(field);
            try {
                System.out.println(field + ": " + value);
                fieldObject.setValue(value);
            } catch (IOException ex) {
                throw new FillFieldOnPDFException("Não foi possível atribuir o valor " + value + " ao campo " + field + " do formulário");
            }
        });
    }

    public byte[] saveDocument() throws IOException {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        document.save(bytes);
        return bytes.toByteArray();
    }

    public void closeDocument() {
        try {
            document.close();
        } catch (IOException e) {
            throw new RuntimeException("Não foi possível fechar o documento: " + e);
        }
    }

    public PDDocument getDocument() {
        return document;
    }

}
