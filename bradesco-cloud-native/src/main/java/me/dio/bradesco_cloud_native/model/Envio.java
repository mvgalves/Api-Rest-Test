package me.dio.bradesco_cloud_native.model;

import jakarta.persistence.*;

@Entity
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String endereco;

    public Envio() {
    }

    public Envio(String endereco) {
        if (endereco == null || endereco.isBlank()) {
            throw new IllegalArgumentException("Endereço não pode ser vazio.");
        }
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if (endereco == null || endereco.isBlank()) {
            throw new IllegalArgumentException("Endereço não pode ser vazio.");
        }
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Envio{" +
                "id=" + id +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
