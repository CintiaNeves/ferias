package br.com.cintia.ferias.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
public class Compra extends EntidadeDominio{
	
	private String Status;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable
	private List<FormaPagamento> formasPagamento;
	
	@OneToOne
	private Pedido pedido;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Frete frete;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
}
