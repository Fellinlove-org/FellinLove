package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Tratamiento;

@Repository
public interface TratamientoRepository extends JpaRepository<Tratamiento, Long>{
    public List<Tratamiento> findByMascotaId(Long clienteId);

    public List<Tratamiento> findByVeterinarioId(Long veterinarioId);
    @Query(value = "select count(*) from tratamiento", nativeQuery = true)
    Integer countTratamiento();

    @Query(value = "SELECT SUM(d.precio_venta) AS total_precio_tratamientos FROM tratamiento t JOIN droga d ON t.droga_id = d.id", nativeQuery = true)
    Integer sumTotalVentas();

    @Query(value = "select count(veterinario_id) from tratamiento t where t.veterinario_id = ?1", nativeQuery = true)
    Integer countByVeterinarioId(Long id);
}