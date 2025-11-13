package com.givasques.CarrosAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.givasques.CarrosAPI.dto.CarroRequestCreate;
import com.givasques.CarrosAPI.dto.CarroRequestUpdate;
import com.givasques.CarrosAPI.dto.CarroResponse;
import com.givasques.CarrosAPI.service.CarroService;

@RestController
@RequestMapping ("carros")
public class CarroController {
    @Autowired
    private CarroService carroService;

    @PostMapping
    public ResponseEntity<CarroResponse> createCarro(@RequestBody CarroRequestCreate dto){
        return ResponseEntity.status(201).body(new CarroResponse().toDto(carroService.createCarro(dto)));
    }

    @PutMapping ("{id}")
    public ResponseEntity<CarroResponse> updateCarro(@PathVariable Long id, @RequestBody CarroRequestUpdate dto) {
        return carroService.updateCarro(dto, id)
        .map(c -> new CarroResponse().toDto(c))
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping ("{id}")
    public ResponseEntity<Void> deleteCarro (@PathVariable Long id) {
        if (carroService.deleteCarro(id)) {
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping ("{id}")
    public ResponseEntity<CarroResponse> getCarroById (@PathVariable Long id) {
        return carroService.getCarroById(id)
        .map(c -> new CarroResponse().toDto(c))
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<CarroResponse>> getAll() {
        List<CarroResponse> carros = carroService.getAll()
                            .stream()
                            .map(c -> new CarroResponse().toDto(c))
                            .toList();
        return ResponseEntity.ok().body(carros);
    }
}
