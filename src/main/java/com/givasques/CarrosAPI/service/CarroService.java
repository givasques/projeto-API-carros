package com.givasques.CarrosAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.givasques.CarrosAPI.dto.CarroRequestCreate;
import com.givasques.CarrosAPI.dto.CarroRequestUpdate;
import com.givasques.CarrosAPI.model.Carro;
import com.givasques.CarrosAPI.repository.CarroRepository;

@Service
public class CarroService {
    @Autowired
    private CarroRepository carroRepository;

    public Carro createCarro(CarroRequestCreate dto) {
        return carroRepository.save(dto.toModel());
    }

    public Optional<Carro> updateCarro(CarroRequestUpdate dto, Long id) {
        return carroRepository.findById(id)
        .map(c -> carroRepository.save(dto.toModel(c)));
    }

    public boolean deleteCarro (Long id) {
        if (carroRepository.findById(id).isPresent()) {
            carroRepository.deleteById(id);
            return true;
        }
        return false; 
    }

    public Optional<Carro> getCarroById (Long id) {
        return carroRepository.findById(id);
    }

    public List<Carro> getAll () {
        return carroRepository.findAll();
    }
}
