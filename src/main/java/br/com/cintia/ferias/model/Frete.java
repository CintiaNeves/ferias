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
public class Frete extends EntidadeDominio{
	
	private Double valor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Cidade cidade;
}
