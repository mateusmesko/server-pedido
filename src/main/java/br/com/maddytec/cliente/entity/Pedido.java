package br.com.maddytec.cliente.entity;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.lang.NonNull;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pedido;

    @NonNull
    private int quantidade;

    
    private Long id_item;
    private String nome_item;
    private Long valor;
    private Long sequencia;

    
    private Long id_customer;
    private String firstName;
    private String secondName;
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "id_customer", insertable = false, updatable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_item", insertable = false, updatable = false)
    private Item item;

    private Pedido() {
        super();
    }

    public Pedido(Long id_pedido, int quantidade, Long id_item, String nome_item, Long valor, Long sequencia,
            Long id_customer, String firstName, String secondName, String cpf) {
        super();
        this.id_pedido = id_pedido;
        this.quantidade = quantidade;
        this.id_item = id_item;
        this.nome_item = nome_item;
        this.valor = valor;
        this.sequencia = sequencia;
        this.id_customer = id_customer;
        this.firstName = firstName;
        this.secondName = secondName;
        this.cpf = cpf;
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

    public Optional<Item> getId_item() {
        return Optional.empty();
    }

    public void setId_item(Long id_item) {
        this.id_item = id_item;
    }

    public String getNome_item() {
        return nome_item;
    }

    public void setNome_item(String nome_item) {
        this.nome_item = nome_item;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public Long getSequencia() {
        return sequencia;
    }

    public void setSequencia(Long sequencia) {
        this.sequencia = sequencia;
    }

    public Long getid_customer() {
        return id_customer;
    }

    public void setId_customer(Long id_customer) {
        this.id_customer = id_customer;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

	public void setCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	public void setItem(Item item) {
		// TODO Auto-generated method stub
		
	}

	public Cliente getCliente() {
		// TODO Auto-generated method stub
		return null;
	}

	public Item getItem() {
		// TODO Auto-generated method stub
		return null;
	}

	



	
	}


