package br.com.cintia.ferias.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.cintia.ferias.util.EntidadeDominio;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = false)
public class Fornecedor extends EntidadeDominio{
	
	private String nome;
	private String cnpj;
}
