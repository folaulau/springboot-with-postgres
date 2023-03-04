package com.folautech.springbootwithpostgres.dataloader;

import com.folautech.springbootwithpostgres.address.Address;
import com.folautech.springbootwithpostgres.address.AddressRepository;
import com.folautech.springbootwithpostgres.user.User;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import com.vividsolutions.jts.geom.Point;
import org.springframework.stereotype.Component;

import com.folautech.springbootwithpostgres.user.UserDAO;

import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;

import java.util.List;

@Slf4j
@Component
public class DataLoader implements ApplicationRunner {


    @Autowired
    private UserDAO userDAO;

    @Autowired
    private AddressRepository addressRepository;

    private Faker faker = new Faker();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // TODO Auto-generated method stub

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();

        GeometryFactory geometryFactory = new GeometryFactory();

        // #1 Lehi
        User user = User.builder()
                .id(1L)
                .firstName(firstName)
                .lastName(lastName)
                .address(Address.builder()
                        .id(1L)
                        .street("2211 N 1960 W")
                        .city("Lehi")
                        .state("UT")
                        .zipcode("84043")
                        .lat(40.414870)
                        .lon(-111.881200)
                        .coordinates(geometryFactory.createPoint(new Coordinate(40.414870, -111.881200)))
                        .build())
                .build();

        user = userDAO.save(user);

        log.info("saved user={}", user.toString());

        firstName = faker.name().firstName();
        lastName = faker.name().lastName();

        // #2 Draper
        user = User.builder()
                .id(2L)
                .firstName(firstName)
                .lastName(lastName)
                .address(Address.builder()
                        .id(2L)
                        .street("12151 S Andrew View Cir")
                        .city("Draper")
                        .state("UT")
                        .zipcode("84020")
                        .lat(40.529340)
                        .lon(-111.911950)
                        .coordinates(geometryFactory.createPoint(new Coordinate(40.529340, -111.911950)))
                        .build())
                .build();

        user = userDAO.save(user);

        firstName = faker.name().firstName();
        lastName = faker.name().lastName();

        // #3 Draper
        user = User.builder()
                .id(3L)
                .firstName(firstName)
                .lastName(lastName)
                .address(Address.builder()
                        .id(3L)
                        .street("14179 Flowerfield Cir")
                        .city("Draper")
                        .state("UT")
                        .zipcode("84020")
                        .lat(40.494400)
                        .lon(-111.886740)
                        .coordinates(geometryFactory.createPoint(new Coordinate(40.494400, -111.886740)))
                        .build())
                .build();

        user = userDAO.save(user);

        // #4 Herriman
        user = User.builder()
                .id(4L)
                .firstName(firstName)
                .lastName(lastName)
                .address(Address.builder()
                        .id(4L)
                        .street("13101 S Bilston Ln")
                        .city("Herriman")
                        .state("UT")
                        .zipcode("84096")
                        .lat(40.513680)
                        .lon(-112.014660)
                        .coordinates(geometryFactory.createPoint(new Coordinate(40.513680, -112.014660)))
                        .build())
                .build();

        user = userDAO.save(user);

        // #5 West Jordan
        user = User.builder()
                .id(5L)
                .firstName(firstName)
                .lastName(lastName)
                .address(Address.builder()
                        .id(5L)
                        .street("6644 S 3040 W")
                        .city("West Jordan")
                        .state("UT")
                        .zipcode("84084")
                        .lat(40.630480)
                        .lon(-111.964470)
                        .coordinates(geometryFactory.createPoint(new Coordinate(40.630480, -111.964470)))
                        .build())
                .build();

        user = userDAO.save(user);

        // #6 Taylors Ville
        user = User.builder()
                .id(6L)
                .firstName(firstName)
                .lastName(lastName)
                .address(Address.builder()
                        .id(6L)
                        .street("1885 W Bowling Ave")
                        .city("Taylorsville")
                        .state("UT")
                        .zipcode("84129")
                        .lat(40.630480)
                        .lon(-111.964470)
                        .coordinates(geometryFactory.createPoint(new Coordinate(40.630480, -111.964470)))
                        .build())
                .build();

        user = userDAO.save(user);

        // #7 Salt Lake
        user = User.builder()
                .id(7L)
                .firstName(firstName)
                .lastName(lastName)
                .address(Address.builder()
                        .id(7L)
                        .street("472 N 1465 W")
                        .city("Salt Lake City")
                        .state("UT")
                        .zipcode("84116")
                        .lat(40.630480)
                        .lon(-111.964470)
                        .coordinates(geometryFactory.createPoint(new Coordinate(40.630480, -111.964470)))
                        .build())
                .build();

        user = userDAO.save(user);

//        List<Address> addresses = addressRepository.findByCoordinatesNear(40.414870, -111.881200, 5.0);
//
//        for (Address addr : addresses) {
//            log.info("addr={}",addr.toString());
//        }
    }

}
