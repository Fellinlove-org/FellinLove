package com.example.demo.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByCedula(String cedula);
}
