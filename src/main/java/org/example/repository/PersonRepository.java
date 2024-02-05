package org.example.repository;

import org.example.model.Person;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT p FROM Person p WHERE p.cityOfLiving = :city")
    List<Person> findByCityOfLiving(@Param("city") String city);

    @Query("SELECT p FROM Person p WHERE p.age < :age ORDER BY p.age ASC")
    List<Person> findByAgeLessThanOrdered(@Param("age") Integer age);

    @Query("SELECT p FROM Person p WHERE p.name = :name AND p.surname = :surname")
    Person findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);


    Person findByName(String username);
}