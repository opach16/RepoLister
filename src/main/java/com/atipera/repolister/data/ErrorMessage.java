package com.atipera.repolister.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ErrorMessage {
    @JsonProperty("status")
    private final int status;
    @JsonProperty("message")
    private final String message;
}
