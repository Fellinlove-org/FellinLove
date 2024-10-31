package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Droga;
import com.example.demo.model.Mascota;
import com.example.demo.model.Tratamiento;
import com.example.demo.model.TratamientoDTO;
import com.example.demo.model.Veterinario;
import com.example.demo.repository.DrogaRepository;
import com.example.demo.repository.MascotaRepository;
import com.example.demo.repository.TratamientoRepository;
import com.example.demo.repository.VeterinarioRepository;

@Service
public class TratamientoServiceImpl implements TratamientoService {

    @Autowired
    private TratamientoRepository tratamientoRepository;

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @Autowired
    private DrogaRepository drogaRepository;

    @Autowired
    private MascotaRepository mascotaRepository;

    @Override
    public TratamientoDTO findById(Long id) {
        Tratamiento tratamiento = tratamientoRepository.findById(id).orElse(null);
        TratamientoDTO tratamientoDTO = new TratamientoDTO();
        if (tratamiento != null) {
            tratamientoDTO.setId(tratamiento.getId());
            tratamientoDTO.setNombreVeterinario(tratamiento.getVeterinario().getNombre());
            tratamientoDTO.setNombreMascota(tratamiento.getMascota().getNombre());
            tratamientoDTO.setNombreDroga(tratamiento.getDroga().getNombre());
            tratamientoDTO.setCantidad(tratamiento.getCantidad());
            tratamientoDTO.setFechaConsulta(tratamiento.getFechaConsulta());
            tratamientoDTO.setUnidadesDisponibles(tratamiento.getDroga().getUnidadesDisponibles());
            tratamientoDTO.setIdVeterinario(tratamiento.getVeterinario().getId());
            tratamientoDTO.setIdMascota(tratamiento.getMascota().getId());
            tratamientoDTO.setIdDroga(tratamiento.getDroga().getId());
            return tratamientoDTO;
        } else {
            return null;
        }
    }

    @Override
    public List<TratamientoDTO> findAll() {
        
        List<TratamientoDTO> tratamientosDTO = new ArrayList<TratamientoDTO>();

        for (Tratamiento tratamiento : tratamientoRepository.findAll()) {
            TratamientoDTO tratamientoDTO = new TratamientoDTO();
            tratamientoDTO.setId(tratamiento.getId());
            tratamientoDTO.setNombreVeterinario(tratamiento.getVeterinario().getNombre());
            tratamientoDTO.setNombreMascota(tratamiento.getMascota().getNombre());
            tratamientoDTO.setNombreDroga(tratamiento.getDroga().getNombre());
            tratamientoDTO.setCantidad(tratamiento.getCantidad());
            tratamientoDTO.setFechaConsulta(tratamiento.getFechaConsulta());
            tratamientoDTO.setUnidadesDisponibles(tratamiento.getDroga().getUnidadesDisponibles());
            tratamientoDTO.setIdVeterinario(tratamiento.getVeterinario().getId());
            tratamientoDTO.setIdMascota(tratamiento.getMascota().getId());
            tratamientoDTO.setIdDroga(tratamiento.getDroga().getId());
            tratamientosDTO.add(tratamientoDTO);
        }
        return tratamientosDTO;
    }

    @Override
    public TratamientoDTO add(TratamientoDTO tratamientoDTO) {
        Tratamiento tratamiento = new Tratamiento();
        Optional<Veterinario> vet = veterinarioRepository.findById(tratamientoDTO.getIdVeterinario());
        Optional<Droga> droga = drogaRepository.findById(tratamientoDTO.getIdDroga());
        Optional<Mascota> mascota = mascotaRepository.findById(tratamientoDTO.getIdMascota());
        if(vet.isPresent() && droga.isPresent() && mascota.isPresent() && droga.get().getUnidadesDisponibles() > 0){
            Mascota modifiedMascota = mascota.get();
            Droga modifiedDroga = droga.get();
            modifiedMascota.setEstado(true);
            mascotaRepository.save(modifiedMascota);
            tratamiento.setDroga(droga.get());
            tratamiento.setMascota(modifiedMascota);
            tratamiento.setVeterinario(vet.get());
            tratamiento.setCantidad(tratamientoDTO.getCantidad());
            tratamiento.setFechaConsulta(tratamientoDTO.getFechaConsulta());
            modifiedDroga.setUnidadesDisponibles(tratamientoDTO.getUnidadesDisponibles());
            modifiedDroga.setUnidadesVendidas(tratamientoDTO.getCantidad());
            drogaRepository.save(modifiedDroga);
            tratamientoRepository.save(tratamiento);
            return tratamientoDTO;
        }else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        tratamientoRepository.deleteById(id);
    }

    @Override
    public void updateTratamiento(TratamientoDTO tratamientoDTO) {
        Tratamiento tratamiento = new Tratamiento();
        Veterinario veterinario = veterinarioRepository.findById(tratamientoDTO.getIdVeterinario()).orElse(null);
        Droga droga = drogaRepository.findById(tratamientoDTO.getIdDroga()).orElse(null);
        Mascota mascota = mascotaRepository.findById(tratamientoDTO.getIdMascota()).orElse(null);
        if (veterinario != null && droga != null && mascota != null) {
            tratamiento.setVeterinario(veterinario);
            tratamiento.setDroga(droga);
            tratamiento.setMascota(mascota);
            tratamiento.setCantidad(tratamientoDTO.getCantidad());
            tratamiento.setFechaConsulta(tratamientoDTO.getFechaConsulta());
            droga.setUnidadesDisponibles(tratamientoDTO.getUnidadesDisponibles());
            droga.setUnidadesVendidas(tratamientoDTO.getCantidad());
            drogaRepository.save(droga);
        }
        tratamiento.setId(tratamientoDTO.getId());
        if (tratamiento.getId() != null && tratamientoRepository.existsById(tratamiento.getId())) {
            tratamientoRepository.save(tratamiento);
        }   
    }

    @Override
    public List<TratamientoDTO> findByMascotaId(Long mascotaId) {
        List<TratamientoDTO> tratamientosDTO = new ArrayList<TratamientoDTO>();

        for (Tratamiento tratamiento : tratamientoRepository.findAll()) {
            if (tratamiento.getMascota().getId().equals(mascotaId)) {
                TratamientoDTO tratamientoDTO = new TratamientoDTO();
                tratamientoDTO.setId(tratamiento.getId());
                tratamientoDTO.setNombreVeterinario(tratamiento.getVeterinario().getNombre());
                tratamientoDTO.setNombreMascota(tratamiento.getMascota().getNombre());
                tratamientoDTO.setNombreDroga(tratamiento.getDroga().getNombre());
                tratamientoDTO.setCantidad(tratamiento.getCantidad());
                tratamientoDTO.setFechaConsulta(tratamiento.getFechaConsulta());
                tratamientoDTO.setUnidadesDisponibles(tratamiento.getDroga().getUnidadesDisponibles());
                tratamientoDTO.setIdVeterinario(tratamiento.getVeterinario().getId());
                tratamientoDTO.setIdMascota(tratamiento.getMascota().getId());
                tratamientoDTO.setIdDroga(tratamiento.getDroga().getId());
                tratamientosDTO.add(tratamientoDTO);
            }
        }
        return tratamientosDTO;
    }

    @Override
    public List<Tratamiento> findByVeterinarioId(Long veterinarioId) {
        return tratamientoRepository.findByVeterinarioId(veterinarioId);
    }

    @Override
    public Integer countTratamiento() {
        return tratamientoRepository.countTratamiento();
    }

    @Override
    public Integer sumTotalVentas() {
        return tratamientoRepository.sumTotalVentas();
    }
    
}