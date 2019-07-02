package br.com.cintia.ferias.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.cintia.ferias.util.EntidadeDominio;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = false)
public class ItemPedido extends EntidadeDominio{
	
	private Boolean status;
	private Integer quantidade;
	private Double valorTotal;
	
	@OneToOne
	private CupomTroca cupomTroca;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Pedido pedido;
}
