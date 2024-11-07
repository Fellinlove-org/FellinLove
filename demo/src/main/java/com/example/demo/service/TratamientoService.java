package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.DTOs.TratamientoDTO;
import com.example.demo.model.Tratamiento;

@Service
public interface TratamientoService {

    public TratamientoDTO findById(Long id);

    public List<TratamientoDTO> findAll();

    public TratamientoDTO add(TratamientoDTO tratamientoDTO);

    public void deleteById(Long id);

    public void updateTratamiento(TratamientoDTO tratamientoDTO);

    public List<TratamientoDTO> findByMascotaId(Long mascotaId);

    public List<Tratamiento> findByVeterinarioId(Long veterinarioId);

    public Integer countTratamiento();

    public Integer sumTotalVentas();
}


