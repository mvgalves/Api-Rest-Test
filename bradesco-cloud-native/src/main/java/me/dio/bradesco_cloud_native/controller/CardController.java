package me.dio.bradesco_cloud_native.controller;

import me.dio.bradesco_cloud_native.model.Card;
import me.dio.bradesco_cloud_native.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private CardRepository cardRepository;

    @GetMapping
    public List<Card> listarTodos() {
        return cardRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> buscarPorId(@PathVariable Long id) {
        return cardRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Card criar(@RequestBody Card card) {
        return cardRepository.save(card);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Card> atualizar(@PathVariable Long id, @RequestBody Card cardAtualizado) {
        return cardRepository.findById(id)
                .map(card -> {
                    card.setNumeroCartao(cardAtualizado.getNumeroCartao());
                    Card atualizado = cardRepository.save(card);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return cardRepository.findById(id)
                .map(card -> {
                    cardRepository.delete(card);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
