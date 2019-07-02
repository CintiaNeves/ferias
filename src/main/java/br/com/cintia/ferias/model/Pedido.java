package br.com.cintia.ferias.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.cintia.ferias.util.EntidadeDominio;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = false)
public class Pedido extends EntidadeDominio{
	
	private Integer quantidade;
	private Double valorTotal;
	private Long numero;
	
	@OneToOne
	private Carrinho carrinho;
	
	@OneToMany(mappedBy = "pedido")
	private List<ItemPedido> itensPedido;
	
}
