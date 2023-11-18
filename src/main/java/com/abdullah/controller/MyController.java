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
import java.io.StringReader;

@RestController
public class MyController {

    @GetMapping(value = "/space", produces = {"application/json"})
    SpaceStation spaceStation() throws XMLStreamException, IOException {
        String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><spacestation><owner country=\"USA\" leader=\"trump\"/><count>3</count><spaceships><spaceship><name>Falcon</name><numberOfCrew>10</numberOfCrew><price currency=\"US\" validity=\"oneMonth\">1500.0</price></spaceship><spaceship><name>Strom</name><numberOfCrew>25</numberOfCrew><price currency=\"Euro\">1500.0</price></spaceship><spaceship><name>Serum</name><numberOfCrew>9</numberOfCrew><price currency=\"DKK\">1500.0</price></spaceship></spaceships></spacestation>";
//        InputStream xmlResource = MyController.class.getClassLoader().getResourceAsStream("station.xml");
        XMLInputFactory factory = XMLInputFactory.newFactory();
//        XMLStreamReader reader = factory.createXMLStreamReader(xmlResource);
        XMLStreamReader reader = factory.createXMLStreamReader(new StringReader(xmlString));

        XmlMapper mapper = new XmlMapper();
        SpaceStation spaceStation = mapper.readValue(reader, SpaceStation.class);

        return spaceStation;
    }
}
