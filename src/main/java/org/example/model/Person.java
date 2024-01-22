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
    private String cityOfLiving;

    // Добавлено новое поле phoneNumber
    @Column(name = "phone_number")
    private String phoneNumber;

    // Пустой конструктор
    public Person() {
    }

    // Геттеры и сеттеры всех полей, включая геттер для cityOfLiving исправленный
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Дополнительные геттеры и сеттеры для surname, age, phoneNumber

    public String getCityOfLiving() {
        return cityOfLiving;
    }

    public void setCityOfLiving(String cityOfLiving) {
        this.cityOfLiving = cityOfLiving;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}


