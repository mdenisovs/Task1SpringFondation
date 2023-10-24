package org.example.configurations;

import org.example.repositories.GuitarRepository;
import org.example.services.GuitarService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
    Custom configuration witch creates GuitarService bean.
 */
@Configuration
public class CustomConfiguration {

    @Configuration
    @ConditionalOnClass(GuitarService.class)
    static class OnMissingConfiguration {

        @Bean
        @ConditionalOnMissingBean
        public GuitarService guitarService(GuitarRepository repository) {
            return new GuitarService(repository);
        }
    }
}
