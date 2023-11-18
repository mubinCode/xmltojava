package com.abdullah.spacestation;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class Owner {
    @JacksonXmlProperty(isAttribute = true)
    private String country;
    @JacksonXmlProperty(isAttribute = true)
    private String leader;
}
