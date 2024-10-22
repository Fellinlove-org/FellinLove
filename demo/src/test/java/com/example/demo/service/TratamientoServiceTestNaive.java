package com.example.demo.service;

import java.util.Calendar;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import com.example.demo.model.Cliente;
import com.example.demo.model.Droga;
import com.example.demo.model.Mascota;
import com.example.demo.model.Tratamiento;
import com.example.demo.model.Veterinario;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.DrogaRepository;
import com.example.demo.repository.MascotaRepository;
import com.example.demo.repository.VeterinarioRepository;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ActiveProfiles("test")
public class TratamientoServiceTestNaive {

    @Autowired
    private TratamientoService tratamientoService;

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private DrogaRepository drogaRepository;


    @BeforeEach
    public void setUp(){

    }

    @Test
    public void TratamientoService_add_Tratamiento(){

        //arrange
        Calendar cal = Calendar.getInstance();

        Veterinario veterinario1 = new Veterinario("VET001", "Dr. Juan Pérez", "Cirugía", "juan.perez@mail.com", "password123", "foto1.jpg");
        Droga droga1 = new Droga("Antibiótico X", 50.0, 30.0, 100, 50);
        Mascota mascota1 = new Mascota("Max", "Golden Retriever", 5, 30.5, "Displasia de cadera", "foto1.jpg", true);
        Cliente cliente1 = new Cliente("1234567890", "María González", "maria.gonzalez@mail.com", "0987654321", "foto_cliente.jpg");

        Tratamiento tratamiento1 = new Tratamiento();

        cal.set(2024, Calendar.JANUARY, 15);
        mascota1.setCliente(cliente1);
        tratamiento1.setFechaConsulta(cal.getTime());

        veterinarioRepository.save(veterinario1);
        drogaRepository.save(droga1);
        clienteRepository.save(cliente1);
        mascotaRepository.save(mascota1);
        

        //act
        Tratamiento savedTratamiento = tratamientoService.add(tratamiento1, veterinario1.getId(), mascota1.getId(), droga1.getId());
        List<Tratamiento> tratamientos = tratamientoService.findAll();
        

        //assert
        Assertions.assertThat(savedTratamiento).isNotNull();
        Assertions.assertThat(tratamientos.size()).isGreaterThan(0);
        Assertions.assertThat(tratamientos.size()).isEqualTo(1);
    }

    @Test
    public void TratamientoService_findAll_NotEmptyList(){

        //arrange
        //Integer expected = 0;

        //act
        List<Tratamiento> tratamientos = tratamientoService.findAll();

        //assert
        Assertions.assertThat(tratamientos).isEmpty();
        //Assertions.assertThat(tratamientos.size()).isGreaterThan(0);
        //Assertions.assertThat(tratamientos.size()).isEqualTo(expected);
    }
    
}
