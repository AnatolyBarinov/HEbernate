package org.example.model;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name = "person")
public class Person {

    @Id
    private String name;

    private String surname;

    private int age;

    private String phone_number;

    @Column(name = "city_of_living")
    private String city_of_living;

    public String getCityOfLiving() {
        return this.name;
    }

}