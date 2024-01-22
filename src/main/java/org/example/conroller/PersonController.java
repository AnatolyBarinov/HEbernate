package org.example.conroller;

import org.example.model.Person;
import org.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @PostMapping("/person")
    public Person savePerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @PutMapping("/person")
    public Person updatePerson(@RequestBody Person person) {
        return personRepository.update(person);
    }

    @DeleteMapping("/person")
    public void deletePerson(@RequestBody Person person) {
        personRepository.delete(person);
    }

    @GetMapping("/person/{id}")
    public Optional<Person> findById(@PathVariable Long id) {
        return personRepository.findById(id);
    }

    @GetMapping("/persons")
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @GetMapping("/personsByCity")
    public List<Person> findByCityOfLiving(@RequestParam String city) {
        return personRepository.findByCityOfLiving(city);
    }

    @GetMapping("/personsByAge")
    public List<Person> findByAgeLessThanOrdered(@RequestParam Integer age) {
        return personRepository.findByAgeLessThanOrdered(age);
    }

    @GetMapping("/personsByNameSurname")
    public Optional<Person> findByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return personRepository.findByNameAndSurname(name, surname);
    }
}