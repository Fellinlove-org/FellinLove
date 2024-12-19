package com.example.demo.repository;

import java.util.Calendar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Cliente;
import com.example.demo.model.Droga;
import com.example.demo.model.Mascota;
import com.example.demo.model.Tratamiento;
import com.example.demo.model.Veterinario;

@DataJpaTest
@RunWith(SpringRunner.class)
public class TratamientoRepositoryTest {
    
    @Autowired
    private TratamientoRepository tratamientoRepository;

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private DrogaRepository drogaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @BeforeEach
    public void setUp() {

        Calendar cal = Calendar.getInstance();

        Veterinario veterinario1 = new Veterinario("VET001", "Dr. Juan Pérez", "Cirugía", "juan.perez@mail.com", "password123", "foto1.jpg");
        Veterinario veterinario2 = new Veterinario("VET002", "Dra. Ana García", "Dermatología", "ana.garcia@mail.com", "password456", "foto2.jpg");
        Veterinario veterinario3 = new Veterinario("VET003", "Dr. Carlos Ramírez", "Cardiología", "carlos.ramirez@mail.com", "password789", "foto3.jpg");

        veterinarioRepository.save(veterinario1);
        veterinarioRepository.save(veterinario2);
        veterinarioRepository.save(veterinario3);


        Droga droga1 = new Droga("Antibiótico X", 50.0, 30.0, 100, 50);
        Droga droga2 = new Droga("Analgésico Y", 20.0, 10.0, 200, 75);
        Droga droga3 = new Droga("Antiinflamatorio Z", 35.0, 20.0, 150, 60);

        drogaRepository.save(droga1);
        drogaRepository.save(droga2);
        drogaRepository.save(droga3);


        Mascota mascota1 = new Mascota("Max", "Golden Retriever", 5, 30.5, "Displasia de cadera", "foto1.jpg", true);
        Mascota mascota2 = new Mascota("Luna", "Siamés", 3, 4.2, "Asma felina", "foto2.jpg", true);
        Mascota mascota3 = new Mascota("Rocky", "Bulldog Francés", 4, 12.0, "Alergia cutánea", "foto3.jpg", false);

        mascotaRepository.save(mascota1);
        mascotaRepository.save(mascota2);
        mascotaRepository.save(mascota3);


        Cliente cliente1 = new Cliente("1234567890", "María González", "maria.gonzalez@mail.com", "0987654321", "foto_cliente.jpg");

        clienteRepository.save(cliente1);

        mascota1.setCliente(cliente1);
        mascota2.setCliente(cliente1);
        mascota3.setCliente(cliente1);


        Tratamiento t1 = new Tratamiento();
        Tratamiento t2 = new Tratamiento();
        Tratamiento t3 = new Tratamiento();
        Tratamiento t4 = new Tratamiento();
        Tratamiento t5 = new Tratamiento();

        cal.set(2024, Calendar.JANUARY, 15);
        t1.setMascota(mascota1);
        t1.setVeterinario(veterinario1);
        t1.setDroga(droga1);
        t1.setFechaConsulta(cal.getTime());
        tratamientoRepository.save(t1);

        cal.set(2024, Calendar.FEBRUARY, 5);
        t2.setMascota(mascota2);
        t2.setVeterinario(veterinario2);
        t2.setDroga(droga2);
        t2.setFechaConsulta(cal.getTime());
        tratamientoRepository.save(t2);

        cal.set(2024, Calendar.MARCH, 22);
        t3.setMascota(mascota3);
        t3.setVeterinario(veterinario3);
        t3.setDroga(droga3);
        t3.setFechaConsulta(cal.getTime());
        tratamientoRepository.save(t3);

        cal.set(2024, Calendar.APRIL, 12);
        t4.setMascota(mascota1);
        t4.setVeterinario(veterinario1);
        t4.setDroga(droga2);
        t4.setFechaConsulta(cal.getTime());
        tratamientoRepository.save(t4);

        cal.set(2024, Calendar.MAY, 8);
        t5.setMascota(mascota2);
        t5.setVeterinario(veterinario2);
        t5.setDroga(droga3);
        t5.setFechaConsulta(cal.getTime());
        tratamientoRepository.save(t5);
    }


    //COUNT TRATAMIENTOS
    @Test
    public void TratamientoRepository_countTratamiento_Count() {

        //arrange
        Integer expected = 5;

        //act
        Integer count = tratamientoRepository.countTratamiento();

        //assert
        Assertions.assertThat(count).isNotNull();
        Assertions.assertThat(count).isGreaterThan(0);
        Assertions.assertThat(count).isEqualTo(expected);
    }


    //SUM TOTAL VENTAS
    @Test
    public void TratamientoRepository_sumTotalVentas_Sum() {

        //arrange
        Integer expected = 160;

        //act
        Integer total = tratamientoRepository.sumTotalVentas();

        //assert
        Assertions.assertThat(total).isNotNull();
        Assertions.assertThat(total).isGreaterThan(0);
        Assertions.assertThat(total).isEqualTo(expected);
    }


    //COUNT TRATAMIENTOS POR VETERINARIO
    @Test
    public void TratamientoRepository_countTratamientoPorVeterinario_Count() {

        //arrange
        long id = 1;
        Integer expected = 2;

        //act
        Integer count = tratamientoRepository.countByVeterinarioId(id);

        //assert
        Assertions.assertThat(count).isNotNull();
        Assertions.assertThat(count).isGreaterThan(0);
        Assertions.assertThat(count).isEqualTo(expected);
    }
}
