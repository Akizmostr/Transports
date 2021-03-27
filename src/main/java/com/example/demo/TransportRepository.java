package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TransportRepository extends CrudRepository<Transport,String> {

    @Query(
            value = "SELECT number || ': ' || x || ' ' || y FROM transports WHERE number = :number",
            nativeQuery = true
    )
    String getCoordinatesByNumber(@Param("number")String number);
}
