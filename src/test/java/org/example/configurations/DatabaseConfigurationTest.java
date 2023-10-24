package org.example.configurations;

import org.example.Main;
import org.example.entities.GuitarEntity;
import org.example.repositories.GuitarRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest(classes = Main.class)
@ActiveProfiles("dev")
public class DatabaseConfigurationTest {

    @Autowired
    private GuitarRepository entityRepository;

    @Test
    public void addEntitySuccess() {
        // given
        var entity = new GuitarEntity();
        entity.setName("Telecaster");

        // when
        entityRepository.save(entity);

        // then
        assertThat(entityRepository.count()).isEqualTo(1);
    }
}
