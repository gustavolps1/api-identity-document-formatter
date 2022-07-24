package com.corporate.apiidentitydocumentformatter.controller;

import com.corporate.apiidentitydocumentformatter.controller.response.DocumentFormatterResponse;
import com.corporate.apiidentitydocumentformatter.service.DocumentFormatterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DocumentFormatterController {

    private final DocumentFormatterService documentFormatterService;

    public DocumentFormatterController(DocumentFormatterService documentFormatterService) {
        this.documentFormatterService = documentFormatterService;
    }

    @GetMapping("{documentType}/{documentNumber}")
    public DocumentFormatterResponse get(@RequestParam(name = "documentNumber") String documentNumber, @RequestParam(name = "documentType") String documentType) throws Exception {
        return documentFormatterService.format(documentNumber, documentType);
    }

}
