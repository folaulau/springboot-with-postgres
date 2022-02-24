package com.folautech.springbootwithpostgres.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class UserDAOImp implements UserDAO {

    @Autowired
    private JdbcTemplate   jdbcTemplate;

    @Autowired
    private UserRepository userRepository;

}
