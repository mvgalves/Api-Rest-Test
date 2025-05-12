package me.dio.bradesco_cloud_native.controller;

import me.dio.bradesco_cloud_native.model.Entrega;
import me.dio.bradesco_cloud_native.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    @Autowired
    private EntregaRepository entregaRepository;

    @GetMapping
    public List<Entrega> listarTodas() {
        return entregaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrega> buscarPorId(@PathVariable Long id) {
        return entregaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Entrega criar(@RequestBody Entrega entrega) {
        return entregaRepository.save(entrega);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entrega> atualizar(@PathVariable Long id, @RequestBody Entrega entregaAtualizada) {
        return entregaRepository.findById(id)
                .map(entrega -> {
                    entrega.setTipoEntrega(entregaAtualizada.getTipoEntrega());
                    Entrega atualizada = entregaRepository.save(entrega);
                    return ResponseEntity.ok(atualizada);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return entregaRepository.findById(id)
                .map(entrega -> {
                    entregaRepository.delete(entrega);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
