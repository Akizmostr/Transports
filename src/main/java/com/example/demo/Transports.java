package com.example.demo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.util.List;

@JacksonXmlRootElement(localName = "Objects")
@Data
public class Transports {

    @JacksonXmlProperty(localName = "Object")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Transport> transports;
}
