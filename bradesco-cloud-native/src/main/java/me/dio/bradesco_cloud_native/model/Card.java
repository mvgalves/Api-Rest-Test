package me.dio.bradesco_cloud_native.model;

import jakarta.persistence.*;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numeroCartao;

    public Card() {
    }

    public Card(String numeroCartao) {
        if (numeroCartao == null || numeroCartao.isBlank()) {
            throw new IllegalArgumentException("Número do cartão não pode ser vazio.");
        }
        this.numeroCartao = numeroCartao;
    }

    public Long getId() {
        return id;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        if (numeroCartao == null || numeroCartao.isBlank()) {
            throw new IllegalArgumentException("Número do cartão não pode ser vazio.");
        }
        this.numeroCartao = numeroCartao;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", numeroCartao='" + numeroCartao + '\'' +
                '}';
    }
}
