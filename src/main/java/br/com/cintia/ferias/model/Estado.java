package br.com.cintia.ferias.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.cintia.ferias.util.EntidadeDominio;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = false)
public class Estado extends EntidadeDominio{
	
	private String nome;
	
	@OneToMany(mappedBy = "estado")
	private List<Cidade> cidades;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Pais pais;
	
}
