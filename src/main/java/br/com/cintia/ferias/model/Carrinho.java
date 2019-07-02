package br.com.cintia.ferias.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.cintia.ferias.util.EntidadeDominio;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = false)
public class Carrinho extends EntidadeDominio{

	private Integer quantidade;
	private Double valorTotal;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable
	private List<ItemCarrinho> itensCarrinho;
}
