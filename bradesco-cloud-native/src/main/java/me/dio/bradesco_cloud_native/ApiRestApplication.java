package me.dio.bradesco_cloud_native;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import me.dio.bradesco_cloud_native.model.Card;
import me.dio.bradesco_cloud_native.model.Checkout;
import me.dio.bradesco_cloud_native.model.Entrega;
import me.dio.bradesco_cloud_native.model.Envio;
import me.dio.bradesco_cloud_native.model.Item;
import me.dio.bradesco_cloud_native.model.Pagamento;
import me.dio.bradesco_cloud_native.model.Promocao;

@SpringBootApplication
public class ApiRestApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ApiRestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Envio envio = new Envio("Estrada Geral Bananal S/N, Laguna SC");
        Entrega entrega = new Entrega("Padrão - Grátis | 30-60 minutos");
        Card card = new Card("xxxx xxxx xxxx 0000");
        Pagamento pagamento = new Pagamento(card);
        Promocao promocao = new Promocao("1324564");

        Item pizza = new Item("Pizza", "", "Descrição", 1, 10.99);
        Item hamburguer = new Item("Hamburguer", "", "Descrição", 1, 8.99);

        Checkout checkout = new Checkout(
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

        checkout.fazerPedido();
    }
}
