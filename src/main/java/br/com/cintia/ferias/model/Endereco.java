package br.com.cintia.ferias.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.cintia.ferias.util.EntidadeDominio;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = false)
public class Endereco extends EntidadeDominio{
	
	private String tipoLogradouro;
	private String logradouro;
	private Integer numero;
	private String tipoResidencia;
	private String cep;
	private String bairro;
	private String observacao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Cidade cidade;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
	
	@ManyToOne
	private TipoEndereco tipo;
	
}
