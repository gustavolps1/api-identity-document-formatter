package com.corporate.apiidentitydocumentformatter.domain;

import com.corporate.apiidentitydocumentformatter.utils.DocumentFormatterUtils;
import lombok.Data;

@Data
public class RG implements Document {

    private final int RG_LENGTH = 9;

    @Override
    public boolean shouldFormat(String documentNumber, String documentType) {
        return "RG".equalsIgnoreCase(documentType) && documentNumber.length() == RG_LENGTH;
    }

    @Override
    public String format(String document) {
        return DocumentFormatterUtils.rg(document);
    }
}
