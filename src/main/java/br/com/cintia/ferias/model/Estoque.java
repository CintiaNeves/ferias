package br.com.cintia.ferias.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.cintia.ferias.util.EntidadeDominio;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = false)
public class Estoque extends EntidadeDominio{
	
	@OneToMany(mappedBy = "estoque")
	private List<ItemEstoque> itensEstoque;
}
