package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Droga;

@Repository
public interface DrogaRepository extends JpaRepository<Droga, Long> {
    
    @Query(value = "SELECT * FROM DROGA WHERE UNIDADES_DISPONIBLES < 3", nativeQuery = true)
    List<Droga> findDrogasParaCompra();
}