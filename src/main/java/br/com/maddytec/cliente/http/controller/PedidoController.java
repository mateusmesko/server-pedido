package br.com.maddytec.cliente.http.controller;

import br.com.maddytec.cliente.entity.Cliente;
import br.com.maddytec.cliente.entity.Item;
import br.com.maddytec.cliente.entity.Pedido;
import br.com.maddytec.cliente.service.ClienteService;
import br.com.maddytec.cliente.service.ItemService;
import br.com.maddytec.cliente.service.PedidoService;

import org.hibernate.ResourceClosedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RelationNotFoundException;
import javax.persistence.Tuple;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ItemService itemService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido salvar( @RequestBody Pedido pedido) {
        Optional<Cliente> clienteOptional = clienteService.buscarPorId(pedido.getid_customer());
        Optional<Item> itemOptional = itemService.buscarPorId(pedido.getId_item());

        if (clienteOptional.isEmpty() || itemOptional.isEmpty()) {
            throw new ResourceClosedException("Cliente ou Item não encontrado.");
        }

        Cliente cliente = clienteOptional.get();
        Item item = itemOptional.get();

      
        pedido.setId_customer(cliente.getId_customer());
        pedido.setId_item(item.getId_item());

        return pedidoService.salvar(pedido);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Pedido> listaPedidos() {
        return pedidoService.listaPedidos();
    }

    @GetMapping("/{id_pedido}")
    @ResponseStatus(HttpStatus.OK)
    public Pedido buscarPedidoPorId(@PathVariable("id_pedido") Long id_pedido) throws RelationNotFoundException {
        return pedidoService.buscarPorId(id_pedido)
                .orElseThrow(() -> new RelationNotFoundException("Pedido não encontrado."));
    }

    @DeleteMapping("/{id_pedido}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPedido(@PathVariable("id_pedido") Long id_pedido) {
        pedidoService.removerPorId(id_pedido);
    }

    @PutMapping("/{id_pedido}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarPedido(@PathVariable("id_pedido") Long id_pedido, @RequestBody Pedido pedido) throws RelationNotFoundException {
        Optional<Cliente> clienteOptional = clienteService.buscarPorId(pedido.getid_customer());
        Optional<Item> itemOptional = itemService.buscarPorId(pedido.getId_item());

        if (clienteOptional.isEmpty() || itemOptional.isEmpty()) {
            throw new RelationNotFoundException("Cliente ou Item não encontrado.");
        }

        Cliente cliente = clienteOptional.get();
        Item item = itemOptional.get();

        pedido.setCliente(cliente);
        pedido.setItem(item);

        pedidoService.buscarPorId(id_pedido)
                .map(pedidoBase -> {
                    pedidoBase.setQuantidade(pedido.getQuantidade());
                    pedidoBase.setCliente(pedido.getCliente());
                    pedidoBase.setItem(pedido.getItem());
                    pedidoService.salvar(pedidoBase);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new RelationNotFoundException("Pedido não encontrado."));
    }
}
       
    


