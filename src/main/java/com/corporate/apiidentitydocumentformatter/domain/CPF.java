package com.corporate.apiidentitydocumentformatter.domain;

import com.corporate.apiidentitydocumentformatter.utils.DocumentFormatterUtils;
import lombok.Data;

@Data
public class CPF implements Document {

    private final int CPF_LENGTH = 11;

    @Override
    public boolean shouldFormat(String documentNumber, String documentType) {
        return "CPF".equalsIgnoreCase(documentType) && documentNumber.length() == CPF_LENGTH;
    }

    @Override
    public String format(String document) {
      return DocumentFormatterUtils.cpf(document);
    }
}
