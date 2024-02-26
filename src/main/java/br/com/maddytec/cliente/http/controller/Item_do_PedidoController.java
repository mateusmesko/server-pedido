package br.com.maddytec.cliente.http.controller;

import br.com.maddytec.cliente.entity.Item_do_Pedido;
import br.com.maddytec.cliente.service.Item_do_PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/item_do_pedido")
public class Item_do_PedidoController {

    @Autowired
    private Item_do_PedidoService item_do_PedidoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Item_do_Pedido salvar(@RequestBody Item_do_Pedido item_do_Pedido) {
        return item_do_PedidoService.salvar(item_do_Pedido);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Item_do_Pedido> listaItens_do_Pedido() {
        return item_do_PedidoService.listaItens_do_Pedido();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Item_do_Pedido buscarItem_do_PedidoPorId(@PathVariable("id") Long id) {
        return item_do_PedidoService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item do Pedido não encontrado."));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerItem_do_Pedido(@PathVariable("id") Long id) {
        item_do_PedidoService.buscarPorId(id)
                .map(item_do_Pedido -> {
                    item_do_PedidoService.removerPorId(item_do_Pedido.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item do Pedido não encontrado."));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarItem_do_Pedido(@PathVariable("id") Long id, @RequestBody Item_do_Pedido item_do_Pedido) {
        item_do_PedidoService.buscarPorId(id)
                .map(item_do_PedidoBase -> {
                    item_do_PedidoBase.setPedido(item_do_Pedido.getPedido());
                    item_do_PedidoBase.setItem(item_do_Pedido.getItem());
                    item_do_PedidoBase.setQuantidade(item_do_Pedido.getQuantidade());
                    item_do_PedidoService.salvar(item_do_PedidoBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item do Pedido não encontrado."));
    }
}

