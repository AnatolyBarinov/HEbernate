package org.example.model;

import java.io.Serializable;

public class PersonId implements Serializable {
    private String name;
    private String surname;
    private int age;
    // Удалено поле city_of_living

    public PersonId() {
    }

    // Геттер для поля name
    public String getName() {
        return name;
    }

    // Сеттер для поля name
    public void setName(String name) {
        this.name = name;
    }

    // Геттер для поля surname
    public String getSurname() {
        return surname;
    }

    // Сеттер для поля surname
    public void setSurname(String surname) {
        this.surname = surname;
    }

    // Геттер для поля age
    public int getAge() {
        return age;
    }

    // Сеттер для поля age
    public void setAge(int age) {
        this.age = age;
    }
}