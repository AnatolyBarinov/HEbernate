package org.example.conroller;

import org.example.model.Person;
import org.example.repository.PersonRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/secure")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityPersonController {

    private PersonRepository personRepository;

    public SecurityPersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/readValues")
    public List<Person> readValues() {
        return personRepository.findAll(); // Здесь мы возвращаем все значения из репозитория
    }

    @PreAuthorize("hasAuthority('WRITE')")
    @PostMapping("/writeValue")
    public Person writeValue(@RequestBody Person person) {
        return personRepository.save(person); // Здесь мы сохраняем новое значение в репозиторий
    }

    @PreAuthorize("hasAnyAuthority('WRITE', 'DELETE')")
    @DeleteMapping("/deleteValue/{id}")
    public void deleteValue(@PathVariable Long id) {
        personRepository.deleteById(id); // Здесь мы удаляем значение по указанному id из репозитория
    }

    @PreAuthorize("#username == authentication.name")
    @GetMapping("/checkUsername")
    public Person checkUsername(@RequestParam String username) {
        // Возвращаем информацию о пользователе, если имя пользователя совпадает с именем аутентификации
        return personRepository.findByName(username);
    }
}