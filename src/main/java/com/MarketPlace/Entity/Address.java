package com.MarketPlace.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;

    @Size(min = 2, max = 5, message = "Entered street number is invalid")
    private String streetNo;

    @Size(min = 2, max = 20, message = "Entered building name is invalid")
    private String buildingName;

    @Size(min = 2, max = 20, message = "Entered city name is invalid")
    private String city;

    @Size(min = 2, max = 20, message = "Entered state name is invalid")
    private String state;

    @Size(min = 2, max = 20, message = "Entered country name is invalid")
    private String country;

    @Pattern(regexp = "^[1-9]{6}", message = "Entered pin code is invalid ")
    private String pinCode;




}
