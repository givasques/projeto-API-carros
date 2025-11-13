package com.givasques.CarrosAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.givasques.CarrosAPI.model.Carro;

public interface CarroRepository extends JpaRepository <Carro, Long>{

}
