package com.abdullah.controller;

import com.abdullah.spacestation.SpaceStation;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class MyController {

    @GetMapping(value = "/space", produces = {"application/json"})
    SpaceStation spaceStation() throws XMLStreamException, IOException {
        InputStream xmlResource = MyController.class.getClassLoader().getResourceAsStream("station.xml");
        XMLInputFactory factory = XMLInputFactory.newFactory();
        XMLStreamReader reader = factory.createXMLStreamReader(xmlResource);

        XmlMapper mapper = new XmlMapper();
        SpaceStation spaceStation = mapper.readValue(reader, SpaceStation.class);

        return spaceStation;
    }
}
