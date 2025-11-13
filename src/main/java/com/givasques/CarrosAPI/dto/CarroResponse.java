package com.givasques.CarrosAPI.dto;

import java.time.LocalDateTime;

import com.givasques.CarrosAPI.model.Carro;

public class CarroResponse {
    private Long id;
    private String marca;
    private String modelo;
    private int ano;
    private double preco;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CarroResponse toDto (Carro carro) {
        this.id = carro.getId();
        this.marca = carro.getMarca();
        this.modelo = carro.getModelo();
        this.ano = carro.getAno();
        this.preco = carro.getPreco();
        this.createdAt = carro.getCreatedAt();
        this.updatedAt = carro.getUpdatedAt();
        return this;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }  
}
