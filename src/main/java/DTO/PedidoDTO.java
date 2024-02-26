package DTO;

public class PedidoDTO {
    private Long id_pedido;
    private int quantidade;
    private Long id_customer; // id do cliente
    private Long id_item; // id do item

    public PedidoDTO(Long id_pedido, int quantidade, Long id_customer, Long id_item) {
        this.id_pedido = id_pedido;
        this.quantidade = quantidade;
        this.id_customer = id_customer;
        this.id_item = id_item;
    }

	public Long getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(Long id_pedido) {
		this.id_pedido = id_pedido;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Long getId_customer() {
		return id_customer;
	}

	public void setId_customer(Long id_customer) {
		this.id_customer = id_customer;
	}

	public Long getId_item() {
		return id_item;
	}

	public void setId_item(Long id_item) {
		this.id_item = id_item;
	}

	

   
}
