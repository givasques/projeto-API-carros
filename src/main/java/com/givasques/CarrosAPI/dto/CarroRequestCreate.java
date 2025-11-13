package com.givasques.CarrosAPI.dto;

import java.time.LocalDateTime;

import com.givasques.CarrosAPI.model.Carro;

public class CarroRequestCreate {
    private String marca;
    private String modelo;
    private int ano;
    private double preco;

    public Carro toModel () {
        Carro carro = new Carro();
        carro.setMarca(marca);
        carro.setModelo(modelo);
        carro.setAno(ano);
        carro.setPreco(preco);
        carro.setCreatedAt(LocalDateTime.now());
        carro.setUpdatedAt(LocalDateTime.now());
        return carro;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
}
