package org.example.repository;

import org.example.model.Person;
import java.util.List;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCityOfLiving(String city_of_living) {
        return entityManager.createQuery("SELECT p FROM Person p WHERE p.city_of_living = :city", Person.class)
                .setParameter("city", city_of_living)
                .getResultList();
    }
}
