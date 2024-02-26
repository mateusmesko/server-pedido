package br.com.maddytec.cliente.repository;

import br.com.maddytec.cliente.entity.Item_do_Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Item_do_PedidoRepository extends JpaRepository<Item_do_Pedido, Long> {
}

