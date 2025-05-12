package me.dio.bradesco_cloud_native.controller;

import me.dio.bradesco_cloud_native.model.Promocao;
import me.dio.bradesco_cloud_native.repository.PromocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/promocoes")
public class PromocaoController {

    @Autowired
    private PromocaoRepository promocaoRepository;

    @GetMapping
    public List<Promocao> listarTodas() {
        return promocaoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Promocao> buscarPorId(@PathVariable Long id) {
        return promocaoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Promocao criar(@RequestBody Promocao promocao) {
        return promocaoRepository.save(promocao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Promocao> atualizar(@PathVariable Long id, @RequestBody Promocao promocaoAtualizada) {
        return promocaoRepository.findById(id)
                .map(promocao -> {
                    promocao.setCodigoPromocao(promocaoAtualizada.getCodigoPromocao());
                    Promocao atualizada = promocaoRepository.save(promocao);
                    return ResponseEntity.ok(atualizada);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return promocaoRepository.findById(id)
                .map(promocao -> {
                    promocaoRepository.delete(promocao);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
