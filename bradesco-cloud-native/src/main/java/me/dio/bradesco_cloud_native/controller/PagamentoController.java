package me.dio.bradesco_cloud_native.controller;

import me.dio.bradesco_cloud_native.model.Pagamento;
import me.dio.bradesco_cloud_native.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @GetMapping
    public List<Pagamento> listarTodos() {
        return pagamentoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> buscarPorId(@PathVariable Long id) {
        return pagamentoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pagamento criar(@RequestBody Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pagamento> atualizar(@PathVariable Long id, @RequestBody Pagamento pagamentoAtualizado) {
        return pagamentoRepository.findById(id)
                .map(pagamento -> {
                    pagamento.setCard(pagamentoAtualizado.getCard());
                    Pagamento atualizado = pagamentoRepository.save(pagamento);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return pagamentoRepository.findById(id)
                .map(pagamento -> {
                    pagamentoRepository.delete(pagamento);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
