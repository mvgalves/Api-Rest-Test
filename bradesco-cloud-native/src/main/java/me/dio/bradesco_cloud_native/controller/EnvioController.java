package me.dio.bradesco_cloud_native.controller;

import me.dio.bradesco_cloud_native.model.Envio;
import me.dio.bradesco_cloud_native.repository.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/envios")
public class EnvioController {

    @Autowired
    private EnvioRepository envioRepository;

    @GetMapping
    public List<Envio> listarTodos() {
        return envioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Envio> buscarPorId(@PathVariable Long id) {
        return envioRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Envio criar(@RequestBody Envio envio) {
        return envioRepository.save(envio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Envio> atualizar(@PathVariable Long id, @RequestBody Envio envioAtualizado) {
        return envioRepository.findById(id)
                .map(envio -> {
                    envio.setEndereco(envioAtualizado.getEndereco());
                    Envio atualizado = envioRepository.save(envio);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return envioRepository.findById(id)
                .map(envio -> {
                    envioRepository.delete(envio);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
