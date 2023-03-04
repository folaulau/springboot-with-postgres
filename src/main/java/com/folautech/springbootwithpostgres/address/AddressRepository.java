package com.folautech.springbootwithpostgres.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query("SELECT addr FROM Address addr WHERE ST_Distance_Sphere(addr.coordinates, ST_Point(:longitude, :latitude)) <= :distance")
    List<Address> findByCoordinatesNear(@Param("latitude") double latitude,
            @Param("longitude") double longitude,
            @Param("distance") double distance);
}
