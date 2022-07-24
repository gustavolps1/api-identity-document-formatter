package com.corporate.apiidentitydocumentformatter.domain;

public interface Document {
    boolean shouldFormat(String documentNumber, String documentType);
    String format(String documentNumber);
}
