package br.com.maddytec.cliente.http.controller;

import br.com.maddytec.cliente.entity.Item;
import br.com.maddytec.cliente.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Item salvar(@RequestBody Item item) {
        return itemService.salvar(item);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Item> listaItens() {
        return itemService.listaItens();
    }

    @GetMapping("/{id_item}")
    @ResponseStatus(HttpStatus.OK)
    public Item buscarItemPorId(@PathVariable("id_item") Long id_item) {
        return itemService.buscarPorId(id_item)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado."));
    }

    @DeleteMapping("/{id_item}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerItem(@PathVariable("id_item") Long id_item) {
        itemService.buscarPorId(id_item)
                .map(item -> {
                    itemService.removerPorId(item.getId_item());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado."));
    }

    @PutMapping("/{id_item}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarItem(@PathVariable("id_item") Long id_item, @RequestBody Item item) {
        itemService.buscarPorId(id_item)
                .map(itemBase -> {
                    itemBase.setNome_item(item.getNome_item());
                    itemBase.setValor(item.getValor());
                    itemService.salvar(itemBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado."));
    }
}
