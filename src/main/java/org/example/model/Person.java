package org.example.model;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name = "person")
@IdClass(PersonId.class)
public class Person {
    @Id
    @Column(name = "name")
    private String name;

    @Id
    @Column(name = "surname")
    private String surname;

    @Id
    @Column(name = "age")
    private int age;

    @Id
    @Column(name = "city_of_living")
    private String city_of_living;

    public String getCityOfLiving() {
        return this.name;
    }

}