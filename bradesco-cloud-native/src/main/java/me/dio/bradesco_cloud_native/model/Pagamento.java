package me.dio.bradesco_cloud_native.model;

import jakarta.persistence.*;

@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Card card;

    public Pagamento() {
    }

    public Pagamento(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("Cartão não pode ser nulo.");
        }
        this.card = card;
    }

    public Long getId() {
        return id;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("Cartão não pode ser nulo.");
        }
        this.card = card;
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "id=" + id +
                ", card=" + card +
                '}';
    }
}
