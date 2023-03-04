package com.folautech.springbootwithpostgres.address;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.*;

import lombok.Builder;
//import net.postgis.jdbc.geometry.Point;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.folautech.springbootwithpostgres.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.vividsolutions.jts.geom.Point;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = Include.NON_NULL)
@DynamicUpdate
@Entity
@SQLDelete(sql = "UPDATE addresses SET deleted = 'T' WHERE id = ?", check = ResultCheckStyle.NONE)
@Where(clause = "deleted = 'F'")
@Table(name = "addresses")
public class Address implements Serializable {
    /**
    * 
    */
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private Long             id;

    @Column(name = "street")
    private String           street;

    @Column(name = "city")
    private String           city;

    @Column(name = "state")
    private String           state;

    @Column(name = "zipcode")
    private String           zipcode;

    @Column(name = "lon")
    private Double           lon;

    @Column(name = "lat")
    private Double           lat;

    //CREATE EXTENSION IF NOT EXISTS plpgsql;
    //CREATE EXTENSION postgis;
    @Column(name = "coordinates")
    private Point coordinates;

    @Column(name = "deleted", nullable = false)
    private boolean          deleted;

    public Address(Double lon, Double lat) {
        this.lon = lon;
        this.lat = lat;
    }

}
