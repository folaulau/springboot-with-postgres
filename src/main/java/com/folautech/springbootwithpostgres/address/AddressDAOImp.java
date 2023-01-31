package com.folautech.springbootwithpostgres.address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class AddressDAOImp implements AddressDAO {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private JdbcTemplate      jdbcTemplate;

    @Override
    public List<Address> getSurroundingHomesByLatLong(int radius, double lat, double lon) {
        // TODO Auto-generated method stub
        return null;
    }

}
