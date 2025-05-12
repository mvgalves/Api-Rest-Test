package me.dio.bradesco_cloud_native.controller;

import me.dio.bradesco_cloud_native.model.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CheckoutController {

    @GetMapping("/checkout")
    public Checkout getCheckout() {
        Envio envio = new Envio("Estrada Geral Bananal S/N, Laguna SC");
        Entrega entrega = new Entrega("Padrão - Grátis | 30-60 minutos");
        Card card = new Card("xxxx xxxx xxxx 0000");
        Pagamento pagamento = new Pagamento(card);
        Promocao promocao = new Promocao("1324564");

        Item pizza = new Item("Pizza", "", "Descrição", 1, 10.99);
        Item hamburguer = new Item("Hamburguer", "", "Descrição", 1, 8.99);

        return new Checkout(
                envio,
                entrega,
                pagamento,
                promocao,
                Arrays.asList(pizza, hamburguer),
                19.98,
                "Gratis",
                2.00,
                21.98
        );
    }

    @GetMapping("/itens")
    public List<Item> getItens() {
        Item pizza = new Item("Pizza", "", "Descrição", 1, 10.99);
        Item hamburguer = new Item("Hamburguer", "", "Descrição", 1, 8.99);
        return Arrays.asList(pizza, hamburguer);
    }

    @GetMapping("/envio")
    public Envio getEnvio() {
        return new Envio("Estrada Geral Bananal S/N, Laguna SC");
    }

    @GetMapping("/entrega")
    public Entrega getEntrega() {
        return new Entrega("Padrão - Grátis | 30-60 minutos"); 
    }

    @GetMapping("/pagamento")
    public Pagamento getPagamento() {
        Card card = new Card("xxxx xxxx xxxx 0000");
        return new Pagamento(card);
    }

    @GetMapping("/promocao")
    public Promocao getPromocao() {
        return new Promocao("1324564");
    }
}
