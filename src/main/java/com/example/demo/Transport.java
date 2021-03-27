package com.example.demo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "transports")
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
public class Transport {

    @Id
    @JacksonXmlProperty(localName = "ObjectId")
    private String objectId;

    @JacksonXmlProperty(localName = "Number")
    private String number;

    @JacksonXmlProperty(localName = "VectorSpeed")
    private int vectorSpeed;

    @JacksonXmlProperty(localName = "VectorAngle")
    private short vectorAngle;

    @JacksonXmlProperty(localName = "X")
    private double x;

    @JacksonXmlProperty(localName = "Y")
    private double y;

    @JacksonXmlProperty(localName = "Country")
    private String country;

    @JacksonXmlProperty(localName = "GpsTime_UTC")
    private String gpsTimeUtc;

    @JacksonXmlProperty(localName = "GpsTime")
    private String gpsTime;

    @JacksonXmlProperty(localName = "TimeStamp_UTC")
    private String timeStampUtc;

    @JacksonXmlProperty(localName = "TimeStamp")
    private String timeStamp;

    @JacksonXmlProperty(localName = "Ignition")
    private byte ignition;

    @JacksonXmlProperty(localName = "Odometer")
    private double odometer;

    @JacksonXmlProperty(localName = "FuelConsumption")
    private double fuelConsumption;

    @JacksonXmlProperty(localName = "FuelLevel")
    private double fuelLevel;

    @JacksonXmlProperty(localName = "FuelTank")
    private double fuelTank;

    @JacksonXmlProperty(localName = "ExternalVoltage")
    private float externalVoltage;

    @JacksonXmlProperty(localName = "FirstDriverCardId")
    private String firstDriverCardId;

    @JacksonXmlProperty(localName = "SecondDriverCardId")
    private String secondDriverCardId;

    @JacksonXmlProperty(localName = "FirstDriverName")
    private String firstDriverName;

    @JacksonXmlProperty(localName = "SecondDriverName")
    private String secondDriverName;
}
