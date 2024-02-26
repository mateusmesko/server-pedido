package br.com.maddytec.cliente.repository;

import br.com.maddytec.cliente.entity.Pedido;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import DTO.PedidoDTO;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
	 



	
}
