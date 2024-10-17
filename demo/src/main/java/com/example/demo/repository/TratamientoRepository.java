package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Tratamiento;

@Repository
public interface TratamientoRepository extends JpaRepository<Tratamiento, Long>{
    public List<Tratamiento> findByMascotaId(Long clienteId);

    public List<Tratamiento> findByVeterinarioId(Long veterinarioId);

}