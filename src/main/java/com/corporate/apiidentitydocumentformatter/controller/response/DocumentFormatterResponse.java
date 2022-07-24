package com.corporate.apiidentitydocumentformatter.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DocumentFormatterResponse {

    private String type;

    private String document;

    @JsonProperty("requested_at")
    private String requestedAt;
}
