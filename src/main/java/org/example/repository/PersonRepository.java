package org.example.repository;

import org.example.model.Person;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PersonRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Person save(Person person) {
        entityManager.persist(person);
        return person;
    }

    @Transactional
    public Person update(Person person) {
        return entityManager.merge(person);
    }

    @Transactional
    public void delete(Person person) {
        entityManager.remove(person);
    }

    public Optional<Person> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Person.class, id));
    }

    public List<Person> findAll() {
        return entityManager.createQuery("SELECT p FROM Person p", Person.class)
                .getResultList();
    }

    public List<Person> findByCityOfLiving(String city) {
        return entityManager.createQuery("SELECT p FROM Person p WHERE p.cityOfLiving = :city", Person.class)
                .setParameter("city", city)
                .getResultList();
    }

    public List<Person> findByAgeLessThanOrdered(Integer age) {
        return entityManager.createQuery("SELECT p FROM Person p WHERE p.age < :age ORDER BY p.age ASC", Person.class)
                .setParameter("age", age)
                .getResultList();
    }

    public Optional<Person> findByNameAndSurname(String name, String surname) {
        return Optional.ofNullable(entityManager.createQuery("SELECT p FROM Person p WHERE p.name = :name AND p.surname = :surname", Person.class)
                .setParameter("name", name)
                .setParameter("surname", surname)
                .getSingleResult());
    }
}