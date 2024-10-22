package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Tratamiento;

@Service
public interface TratamientoService {

    public Tratamiento findById(Long id);

    public List<Tratamiento> findAll();

    public void add(Tratamiento consulta);

    public void deleteById(Long id);

    public void update(Tratamiento consulta);

    public List<Tratamiento> findByMascotaId(Long mascotaId);

    public List<Tratamiento> findByVeterinarioId(Long veterinarioId);

    public Integer countTratamiento();

    public Integer sumTotalVentas();
}


