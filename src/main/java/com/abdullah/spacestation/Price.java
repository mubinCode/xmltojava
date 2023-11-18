package com.abdullah.spacestation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Price {
    @JacksonXmlProperty(isAttribute = true)
    private String currency;
    @JacksonXmlProperty(isAttribute = true)
    private String validity;
    @JacksonXmlText
    private double value;
}
