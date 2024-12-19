package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Cliente;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ClienteRepositoryTest {
    
    @Autowired
    private ClienteRepository clienteRepository;

    @BeforeEach
    public void setUp() {
        Cliente cliente = new Cliente("101599", "daniel", "teragod@gmail.com", "1234567890", "url fotos");
        Cliente cliente2 = new Cliente("123435", "alejandro", "smoke@gmail.com", "0987654321", "Url fotos");
        Cliente cliente3 = new Cliente("823764", "esteban", "bandido@gmail.com", "24655464", "Url esteban");
        Cliente cliente4 = new Cliente("982347", "juan", "chikiman@gmail.com", "782348", "Url juan");

        clienteRepository.save(cliente);
        clienteRepository.save(cliente2);
        clienteRepository.save(cliente3);
        clienteRepository.save(cliente4);
    }


    //FIND

    //Find all
    @Test
    public void ClienteRepository_findAll_NotEmptyList() {
        
        //arrange
        Cliente cliente = new Cliente("101599", "daniel", "teragod@gmail.com", "1234567890", "url fotos");
        Cliente cliente2 = new Cliente("123435", "alejandro", "smoke@gmail.com", "0987654321", "Url fotos");

        //act
        clienteRepository.save(cliente);
        clienteRepository.save(cliente2);
        List<Cliente> clientes = clienteRepository.findAll();

        //assert
        Assertions.assertThat(clientes).isNotEmpty();
        Assertions.assertThat(clientes.size()).isEqualTo(6);
        Assertions.assertThat(clientes.size()).isGreaterThan(0);
        Assertions.assertThat(clientes).contains(cliente, cliente2);
    }

    //Find by id
    @Test
    public void ClienteRepository_findById_Cliente() {
        
        //arrange
        Cliente cliente = new Cliente("101599", "daniel", "teragod@gmail.com", "1234567890", "url fotos");

        //act
        Cliente savedCliente = clienteRepository.save(cliente);
        Optional<Cliente> cliente2 = clienteRepository.findById(savedCliente.getId());

        //assert
        Assertions.assertThat(savedCliente).isNotNull();
        Assertions.assertThat(cliente2).isNotEmpty();
        Assertions.assertThat(cliente2.get()).isEqualTo(cliente);
    }

    //Find by wrong id
    @Test
    public void ClienteRepository_findById_FindWrongIndex() {
        
        //arrange
        Long id = -1L;

        //act
        Optional<Cliente> cliente = clienteRepository.findById(id);

        //assert
        Assertions.assertThat(cliente).isEmpty();
    }

    //Find by cedula
    @Test
    public void ClienteRepository_findByCedula_Cliente() {
        
        //arrange
        String cedula = "101599";

        //act
        Optional<Cliente> cliente = clienteRepository.findByCedula(cedula);


        //assert
        Assertions.assertThat(cliente).isNotEmpty();
    }



    //SAVE
    @Test
    public void ClienteRepository_save_Cliente() {

        // 1. Arrange
        // 2. Act
        // 3. Assert

        // arrange
        Cliente cliente = new Cliente("101599", "daniel", "teragod@gmail.com", "1234567890", "urlfotoDaniel");

        // act
        Cliente savedCliente = clienteRepository.save(cliente);

        // assert
        Assertions.assertThat(savedCliente).isNotNull();
    }



    //UPDATE
    @Test
    public void ClienteRepository_update_Cliente() {
        
        // arrange
        String cedula = "101599";

        // act
        Cliente cliente = clienteRepository.findByCedula(cedula).get();
        cliente.setCedula(cedula);
        Cliente updatedCliente = clienteRepository.save(cliente);

        // assert
        Assertions.assertThat(updatedCliente).isNotNull();
        Assertions.assertThat(updatedCliente.getCedula()).isEqualTo(cedula);
    }



    //DELETE
    @Test
    public void ClienteRepository_delete_Cliente() {
        
        // arrange
        Long id = 1L;

        // act
        clienteRepository.deleteById(id);
        Optional<Cliente> cliente = clienteRepository.findById(id);

        // assert
        Assertions.assertThat(cliente).isEmpty();
    }



}
