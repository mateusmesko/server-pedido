package br.com.maddytec.cliente.service;

import br.com.maddytec.cliente.entity.Pedido;
import br.com.maddytec.cliente.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DTO.PedidoDTO;

import java.util.List;
import java.util.Optional;

import javax.persistence.Tuple;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido salvar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listaPedidos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> buscarPorId(Long id_customer) {
        return pedidoRepository.findById(id_customer);
    }

    public void removerPorId(Long id_pedido) {
        pedidoRepository.deleteById(id_pedido);
    }
    

    
}
