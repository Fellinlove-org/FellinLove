package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Droga;
import com.example.demo.model.Mascota;
import com.example.demo.model.Tratamiento;
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
    public Tratamiento findById(Long id) {
        return tratamientoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Tratamiento> findAll() {
        return tratamientoRepository.findAll();
    }

    @Override
    public Tratamiento add(Tratamiento tratamiento, Long idveterinario, Long idmascota, Long iddroga) {
        Optional<Veterinario> vet = veterinarioRepository.findById(idveterinario);
        Optional<Droga> droga = drogaRepository.findById(iddroga);
        Optional<Mascota> mascota = mascotaRepository.findById(idmascota);
        if(vet.isPresent() && droga.isPresent() && mascota.isPresent() && droga.get().getUnidadesDisponibles() > 0){
            Mascota modifiedMascota = mascota.get();
            modifiedMascota.setEstado(true);
            mascotaRepository.save(modifiedMascota);
            tratamiento.setDroga(droga.get());
            tratamiento.setMascota(modifiedMascota);
            tratamiento.setVeterinario(vet.get());
            return tratamientoRepository.save(tratamiento);
        }else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        tratamientoRepository.deleteById(id);
    }

    @Override
    public void update(Tratamiento tratamiento) {
        if (tratamiento.getId() != null && tratamientoRepository.existsById(tratamiento.getId())) {
            tratamientoRepository.save(tratamiento);
        }
    }

    @Override
    public List<Tratamiento> findByMascotaId(Long mascotaId) {
        return tratamientoRepository.findByMascotaId(mascotaId);
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