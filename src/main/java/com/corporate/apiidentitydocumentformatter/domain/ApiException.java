package com.corporate.apiidentitydocumentformatter.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiException {

    private int errorCode;

    private String message;

    private String details;

    private LocalDateTime timestamp;

    private List<String> errors;
}