package br.com.cintia.ferias.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.cintia.ferias.util.EntidadeDominio;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = false)
public class Usuario extends EntidadeDominio{
	
	private Boolean admin;
	private String login;
	private String senha;
	@Transient
	private String confirmaSenha;
}
