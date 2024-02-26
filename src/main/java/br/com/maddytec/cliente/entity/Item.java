package br.com.maddytec.cliente.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_item;

    @Column(name = "nome_item", nullable = false)
    private String nome_item;

    @Column(name = "valor")
    private Long valor;
    
    private Item () {
    	super ();
    }

	public Item(Long id_item, String nome_item, Long valor) {
		super();
		this.id_item = id_item;
		this.nome_item = nome_item;
		this.valor = valor;
	}

	public Long getId_item() {
		return id_item;
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

}
