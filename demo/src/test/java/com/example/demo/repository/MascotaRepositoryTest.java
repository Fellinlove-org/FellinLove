package com.example.demo.repository;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Mascota;


@DataJpaTest
@RunWith(SpringRunner.class)
public class MascotaRepositoryTest {
    
    @Autowired
    private MascotaRepository mascotaRepository;

    @BeforeEach
    public void setUp() {
        Mascota mascota = new Mascota("Misu", "Persa", 3, 4.2, "Asma", "https://static.nationalgeographicla.com/files/styles/image_3200/public/nationalgeographic_1468962.jpg?w=1900&h=1400", true);
        Mascota mascota2 = new Mascota("Gatito", "Siamés", 2, 3.8, "Alergia", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR7Rsfl6dIGPbojoNrUPdja0WjgGk8ESACRZg&s", false);
        Mascota mascota3 = new Mascota("Nube", "Maine Coon", 4, 5.5, "Obesidad", "https://static.nationalgeographic.es/files/styles/image_3200/public/75552.ngsversion.1422285553360.jpg?w=1900&h=1267", true);
        Mascota mascota4 = new Mascota("Luna", "Bengala", 1, 3.0, "Conjuntivitis", "https://es.mypet.com/wp-content/uploads/sites/23/2021/03/GettyImages-623368750-e1582816063521-1.jpg", false);

        mascotaRepository.save(mascota);
        mascotaRepository.save(mascota2);
        mascotaRepository.save(mascota3);
        mascotaRepository.save(mascota4);
    }


    //COUNT ACTIVE
    @Test
    public void MascotaRepository_countActive_Count() {

        //arrange
        Mascota mascota = new Mascota("hannah", "husky", 4, 14.2, "vacio", "urlhannah", true);

        //act
        mascotaRepository.save(mascota);
        Integer count = mascotaRepository.countActive();

        //assert
        Assertions.assertThat(count).isNotNull();
        Assertions.assertThat(count).isGreaterThan(0);
        Assertions.assertThat(count).isEqualTo(3);
    }
}
