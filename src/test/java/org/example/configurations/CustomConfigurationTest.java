package org.example.configurations;

import org.example.Main;
import org.example.entities.GuitarEntity;
import org.example.services.GuitarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(classes = Main.class)
public class CustomConfigurationTest {

    @Autowired
    private  GuitarService guitarService;

    @Test
    public void successSaveTest() {
        // given
        var entity = new GuitarEntity();
        entity.setName("Telecaster");

        // when
        guitarService.saveGuitar(entity);

        // then
        assertThat(guitarService.getGuitarCount()).isEqualTo(1);
    }
}
