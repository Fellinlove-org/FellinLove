package com.example.demo.service;

import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import com.example.demo.model.Droga;
import com.example.demo.model.Mascota;
import com.example.demo.model.Tratamiento;
import com.example.demo.model.Veterinario;
import com.example.demo.repository.DrogaRepository;
import com.example.demo.repository.MascotaRepository;
import com.example.demo.repository.TratamientoRepository;
import com.example.demo.repository.VeterinarioRepository;


@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class TratamientoServiceTestMock{

    @InjectMocks
    private TratamientoServiceImpl tratamientoService;

    @Mock
    private TratamientoRepository tratamientoRepository;

    @Mock
    private MascotaRepository mascotaRepository;

    @Mock
    private VeterinarioRepository veterinarioRepository;

    @Mock
    private DrogaRepository drogaRepository;


    @BeforeEach
    public void setUp(){

    }

    /*
    @Test
    public void TratamientoService_add_NullTratamiento(){

        //arrange
        Calendar cal = Calendar.getInstance();

        Tratamiento tratamiento1 = new Tratamiento();
        tratamiento1.setFechaConsulta(cal.getTime());
        
        when(tratamientoService.add(tratamiento1, null, null, null )).thenReturn(
            null
        );

        //act
        Tratamiento savedTratamiento = tratamientoService.add(tratamiento1, null, null, null);
        //List<Tratamiento> tratamientos = tratamientoService.findAll();
        

        //assert
        Assertions.assertThat(savedTratamiento).isNull();
        //Assertions.assertThat(tratamientos).isEmpty();
    }

    @Test
    public void TratamientoService_findAll_NotEmptyList(){

        //arrange
        Integer expected = 2;
        when(tratamientoRepository.findAll()).thenReturn(
            List.of(
                new Tratamiento(),
                new Tratamiento()
            )
        );

        //act
        //List<Tratamiento> tratamientos = tratamientoService.findAll();

        //assert
        //Assertions.assertThat(tratamientos).isNotEmpty();
        //Assertions.assertThat(tratamientos.size()).isGreaterThan(0);
        //Assertions.assertThat(tratamientos.size()).isEqualTo(expected);
    }
    

    @Test
    public void TratamientoService_addTratamiento_NotNullTratamiento(){
        
        //arrange
        Calendar cal = Calendar.getInstance();
        Tratamiento tratamiento1 = new Tratamiento(cal.getTime());

        when(veterinarioRepository.findById(1L)).thenReturn(
            Optional.of(new Veterinario(1L, "2223", "Dra. Mariana Castillo", "Reproducción", "mariana.castillo@mail.com", "0020", "https://images.stockcake.com/public/6/7/6/67625ce5-d76e-4582-adf0-82f2f2e80fb3_large/veterinarian-examining-cat-stockcake.jpg"))
        );

        when(mascotaRepository.findById(1L)).thenReturn(
            Optional.of(new Mascota(1L, "Paws", "Persa", 4, 4.1, "Problemas dentales", "https://blog.laika.com.co/wp-content/uploads/2022/04/kabo-p6yH8VmGqxo-unsplash.jpg", false))
        );

        when(drogaRepository.findById(1L)).thenReturn(
            Optional.of(new Droga(1L, "Droga 1", 10.0, 5.0, 10, 0))
        );

        when(tratamientoRepository.save(tratamiento1)).thenReturn(
            tratamiento1
        );

        //act
        Tratamiento savedTratamiento = tratamientoService.add(tratamiento1, 1L, 1L, 1L);

        //assert
        Assertions.assertThat(savedTratamiento).isNotNull();

    }

    @Test
    public void TratamientoService_countTratamiento_NotNull(){
        
        //arrange
        Integer expected = 1;
        when(tratamientoRepository.countTratamiento()).thenReturn(
            1
        );

        //act
        Integer count = tratamientoService.countTratamiento();

        //assert
        Assertions.assertThat(count).isNotNull();
        Assertions.assertThat(count).isGreaterThan(0);
        Assertions.assertThat(count).isEqualTo(expected);
    }

    @Test
    public void TratamientoService_sumTotalVentas_NotNull(){

        //arrange
        Integer expected = 10;
        when(tratamientoRepository.sumTotalVentas()).thenReturn(
            10
        );

        //act
        Integer total = tratamientoService.sumTotalVentas();

        //assert
        Assertions.assertThat(total).isNotNull();
        Assertions.assertThat(total).isGreaterThan(0);
        Assertions.assertThat(total).isEqualTo(expected);
    }
         */
}
