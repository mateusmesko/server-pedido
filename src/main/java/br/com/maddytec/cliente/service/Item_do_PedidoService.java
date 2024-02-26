package br.com.maddytec.cliente.service;

import br.com.maddytec.cliente.entity.Item_do_Pedido;
import br.com.maddytec.cliente.repository.Item_do_PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Item_do_PedidoService {

    @Autowired
    private Item_do_PedidoRepository item_do_PedidoRepository;

    public Item_do_Pedido salvar(Item_do_Pedido item_do_Pedido) {
        return item_do_PedidoRepository.save(item_do_Pedido);
    }

    public List<Item_do_Pedido> listaItens_do_Pedido() {
        return item_do_PedidoRepository.findAll();
    }

    public Optional<Item_do_Pedido> buscarPorId(Long id) {
        return item_do_PedidoRepository.findById(id);
    }

    public void removerPorId(Long id) {
        item_do_PedidoRepository.deleteById(id);
    }
}

