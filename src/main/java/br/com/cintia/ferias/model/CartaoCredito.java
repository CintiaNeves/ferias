package br.com.cintia.ferias.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = false)
public class CartaoCredito extends FormaPagamento{
	
	private String numero;
	private String nomeImpresso;
	private String codSeguranca;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Bandeira bandeira;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
}
