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
    public List<Person> findByCityOfLiving(String city) {
        return entityManager.createQuery("SELECT p FROM Person p WHERE p.cityOfLiving = :city", Person.class)
                .setParameter("city", city)
                .getResultList();
    }
}
