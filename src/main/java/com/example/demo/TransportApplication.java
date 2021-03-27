package com.example.demo;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TransportApplication {


    private static final Logger log = LoggerFactory.getLogger(TransportApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TransportApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate ,TransportRepository repo) throws Exception {
        return args -> {
            ResponseEntity<String> response = restTemplate.getForEntity("https://avl2.telematika.lt/xml/p8tpzv3yqnza7pa28wx4p8rn2pyk3gwx.php", String.class);

            XmlMapper xmlMapper = XmlMapper.xmlBuilder().build();
            String xmlData = response.getBody();
            Transports transports = xmlMapper.readValue(xmlData, Transports.class);

            for (Transport transport: transports.getTransports()){
                repo.save(transport);
                log.info(transport.getNumber() + " " + transport.getX() + " " + transport.getY());
            }

            log.info(repo.getCoordinatesByNumber("JFN 187"));

            for (String coord :
                    repo.getAllCoordinates()) {
                log.info(coord);
            }
        };
    }
}
