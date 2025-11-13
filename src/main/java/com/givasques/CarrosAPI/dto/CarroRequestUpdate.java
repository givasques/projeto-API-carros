package com.givasques.CarrosAPI.dto;

import java.time.LocalDateTime;

import com.givasques.CarrosAPI.model.Carro;

public class CarroRequestUpdate {
    private double preco;

    public Carro toModel (Carro c) {
        c.setPreco(preco);
        c.setUpdatedAt(LocalDateTime.now());
        return c;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
