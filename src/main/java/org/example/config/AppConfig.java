package org.example.config;
import org.example.repository.PersonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
@EnableJpaRepositories(basePackages = "org.example.repository")
public class AppConfig {

    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public EntityManager entityManager() {
        return entityManager;
    }
}