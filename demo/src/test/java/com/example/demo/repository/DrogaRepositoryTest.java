package com.example.demo.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Droga;


@DataJpaTest
@RunWith(SpringRunner.class)
public class DrogaRepositoryTest {

    @Autowired
    private DrogaRepository drogaRepository;

    @BeforeEach
    public void setUp() {
        Droga droga = new Droga("Droga 1", 10.0, 5.0, 10, 0);
        Droga droga2 = new Droga("Droga 2", 20.0, 10.0, 2, 0);
        Droga droga3 = new Droga("Droga 3", 30.0, 15.0, 3, 0);
        Droga droga4 = new Droga("Droga 4", 40.0, 20.0, 4, 0);
        Droga droga5 = new Droga("Droga 5", 50.0, 25.0, 5, 0);
        Droga droga6 = new Droga("Droga 6", 60.0, 30.0, 6, 0);
        Droga droga7 = new Droga("Droga 7", 70.0, 35.0, 7, 0);
        Droga droga8 = new Droga("Droga 8", 80.0, 40.0, 8, 0);
        Droga droga9 = new Droga("Droga 9", 90.0, 45.0, 1, 0);


        drogaRepository.save(droga);
        drogaRepository.save(droga2);
        drogaRepository.save(droga3);
        drogaRepository.save(droga4);
        drogaRepository.save(droga5);
        drogaRepository.save(droga6);
        drogaRepository.save(droga7);
        drogaRepository.save(droga8);
        drogaRepository.save(droga9);
    }


    //Find drogas para comprar
    @Test
    public void DrogaRepository_findDrogasParaCompra_NotEmptyList() {

        //arrange
        Droga droga = new Droga("Droga 1", 10.0, 5.0, 1, 0);
        
        //act
        drogaRepository.save(droga);
        List<Droga> drogas = drogaRepository.findDrogasParaCompra();

        //assert
        Assertions.assertThat(drogas).isNotEmpty();
        Assertions.assertThat(drogas.size()).isGreaterThan(0);
        Assertions.assertThat(drogas.size()).isEqualTo(3);
        Assertions.assertThat(drogas).contains(droga);
        
    }
    
}
