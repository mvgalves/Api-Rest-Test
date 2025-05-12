package me.dio.bradesco_cloud_native.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Checkout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Envio envio;

    @OneToOne(cascade = CascadeType.ALL)
    private Entrega entrega;

    @OneToOne(cascade = CascadeType.ALL)
    private Pagamento pagamento;

    @OneToOne(cascade = CascadeType.ALL)
    private Promocao promocao;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> itens;

    @Column(nullable = false)
    private Double subtotal;

    @Column(nullable = false)
    private String taxaEntrega;

    @Column(nullable = false)
    private Double desconto;

    @Column(nullable = false)
    private Double total;

    public Checkout() {}

    public Checkout(Envio envio, Entrega entrega, Pagamento pagamento, Promocao promocao,
                    List<Item> itens, Double subtotal, String taxaEntrega, Double desconto, Double total) {
        this.envio = envio;
        this.entrega = entrega;
        this.pagamento = pagamento;
        this.promocao = promocao;
        this.itens = itens;
        this.subtotal = subtotal;
        this.taxaEntrega = taxaEntrega;
        this.desconto = desconto;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public Envio getEnvio() {
        return envio;
    }

    public void setEnvio(Envio envio) {
        this.envio = envio;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Promocao getPromocao() {
        return promocao;
    }

    public void setPromocao(Promocao promocao) {
        this.promocao = promocao;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public String getTaxaEntrega() {
        return taxaEntrega;
    }

    public void setTaxaEntrega(String taxaEntrega) {
        this.taxaEntrega = taxaEntrega;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void fazerPedido() {
        System.out.println("Pedido realizado com sucesso!");
    }
}

