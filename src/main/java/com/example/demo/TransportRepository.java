package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransportRepository extends CrudRepository<Transport,String> {

    @Query(
            value = "SELECT number || ': ' || x || ' ' || y FROM transports WHERE number = :number",
            nativeQuery = true
    )
    String getCoordinatesByNumber(@Param("number")String number);

    @Query(
            value = "SELECT number || ': ' || x || ' ' || y FROM transports",
            nativeQuery = true
    )
    List<String> getAllCoordinates();
}
