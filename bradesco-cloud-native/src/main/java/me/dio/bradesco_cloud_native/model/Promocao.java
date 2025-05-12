package me.dio.bradesco_cloud_native.model;

import jakarta.persistence.*;

@Entity
public class Promocao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String codigoPromocao;

    public Promocao() {
    }

    public Promocao(String codigoPromocao) {
        if (codigoPromocao == null || codigoPromocao.isBlank()) {
            throw new IllegalArgumentException("Código de promoção não pode ser vazio.");
        }
        this.codigoPromocao = codigoPromocao;
    }

    public Long getId() {
        return id;
    }

    public String getCodigoPromocao() {
        return codigoPromocao;
    }

    public void setCodigoPromocao(String codigoPromocao) {
        if (codigoPromocao == null || codigoPromocao.isBlank()) {
            throw new IllegalArgumentException("Código de promoção não pode ser vazio.");
        }
        this.codigoPromocao = codigoPromocao;
    }

    @Override
    public String toString() {
        return "Promocao{" +
                "id=" + id +
                ", codigoPromocao='" + codigoPromocao + '\'' +
                '}';
    }
}
