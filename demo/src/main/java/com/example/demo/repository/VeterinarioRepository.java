package com.example.demo.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Veterinario;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {
    Optional<Veterinario> findByCedula(String cedula);
    Optional<Veterinario> findByNombre(String nombre);

    @Query(value = "SELECT v.id, v.user_id, v.cedula, v.correo, v.especialidad, v.foto, v.nombre FROM veterinario v JOIN tratamiento t ON v.id = t.veterinario_id GROUP BY v.id, v.nombre, v.foto ORDER BY COUNT(t.veterinario_id) DESC LIMIT 1;", nativeQuery = true)
    Veterinario getEmpleadoMes();
}




