package br.com.cintia.ferias.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity // hibernate reconhece como entidade do banco
@Table // spring identifica como tabela do banco
@Data // lombok cria getters e setters
public class Teste {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
}
