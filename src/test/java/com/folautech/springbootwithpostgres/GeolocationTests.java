package com.folautech.springbootwithpostgres;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.folautech.springbootwithpostgres.address.Address;
import com.folautech.springbootwithpostgres.address.AddressRepository;
import com.folautech.springbootwithpostgres.user.User;
import com.folautech.springbootwithpostgres.user.UserRepository;
import com.folautech.springbootwithpostgres.user.UserServiceImp;
import com.folautech.springbootwithpostgres.utils.ObjectUtils;
import com.folautech.springbootwithpostgres.utils.RandomGeneratorUtils;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class GeolocationTests {

    @Autowired
    private UserRepository    userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Test
    void getLocationsByRadius() {
        /*
         * 1. given 2. when 3. verification
         */

        User user = new User();
        user.setFirstName(RandomGeneratorUtils.getRandomFirstname());
        user.setLastName(RandomGeneratorUtils.getRandomLastname());
        user.setEmail(user.getFirstName() + user.getLastName() + "@gmail.com");

        user = userRepository.saveAndFlush(user);

        log.info("user={}", ObjectUtils.toJson(user));

        Address address = new Address(23.2, 12.5);
        address.setUser(user);

        address = addressRepository.saveAndFlush(address);

        log.info("address={}", ObjectUtils.toJson(address));

    }

}
