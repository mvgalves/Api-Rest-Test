package me.dio.bradesco_cloud_native.model;

import jakarta.persistence.*;

@Entity
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tipoEntrega;

    public Entrega() {
    }

    public Entrega(String tipoEntrega) {
        if (tipoEntrega == null || tipoEntrega.isBlank()) {
            throw new IllegalArgumentException("Tipo de entrega não pode ser vazio.");
        }
        this.tipoEntrega = tipoEntrega;
    }

    public Long getId() {
        return id;
    }

    public String getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(String tipoEntrega) {
        if (tipoEntrega == null || tipoEntrega.isBlank()) {
            throw new IllegalArgumentException("Tipo de entrega não pode ser vazio.");
        }
        this.tipoEntrega = tipoEntrega;
    }

    @Override
    public String toString() {
        return "Entrega{" +
                "id=" + id +
                ", tipoEntrega='" + tipoEntrega + '\'' +
                '}';
    }
}
