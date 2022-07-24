package com.corporate.apiidentitydocumentformatter.service;

import com.corporate.apiidentitydocumentformatter.controller.response.DocumentFormatterResponse;
import com.corporate.apiidentitydocumentformatter.domain.CPF;
import com.corporate.apiidentitydocumentformatter.domain.Document;
import com.corporate.apiidentitydocumentformatter.domain.RG;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentFormatterService {

    public DocumentFormatterResponse format(String documentNumber, String documentType) throws Exception {
        List<Document> documents = List.of(new CPF(), new RG());

        String formattedDocument = documents.stream()
                .filter(document -> document.shouldFormat(documentNumber, documentType))
                .map(document -> document.format(documentNumber))
                .collect(Collectors.joining());

        isValidResult(formattedDocument, documentNumber, documentType);

        return DocumentFormatterResponse.builder()
                .type(documentType.toUpperCase())
                .document(formattedDocument)
                .requestedAt(LocalDateTime.now().toString())
                .build();
    }

    private void isValidResult(String formattedDocument, String documentNumber, String documentType) throws Exception {
        if (formattedDocument.isEmpty()) {
            throw new Exception(String.format("Requested params documentNumber '%s' or documentType '%s' is not valid", documentNumber, documentType));
        }
    }
}
