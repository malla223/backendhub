package com.odkmali.backendHub.enumeration;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Genre {
    @JsonProperty("Homme")
    Homme,
    @JsonProperty("Femme")
    Femme
}
