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

    @Query("SELECT SUM(d.precioVenta * d.unidadesVendidas) FROM Droga d")
    Double getVentasTotales();

    // Consulta para calcular las ganancias totales
    @Query("SELECT SUM((d.precioVenta - d.precioCompra) * d.unidadesVendidas) FROM Droga d")
    Double getGananciasTotales();

    @Query(value = "SELECT nombre, unidades_vendidas FROM droga ORDER BY unidades_vendidas DESC LIMIT 3", nativeQuery = true)
    List<Object[]> findTopByUnidadesVendidas();
}