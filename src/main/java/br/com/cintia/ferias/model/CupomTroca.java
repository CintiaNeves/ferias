package br.com.cintia.ferias.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = false)
public class CupomTroca extends FormaPagamento{
	
	private LocalDate dataEmissao;
	private LocalDate dataValidade;
	private String codigo;
	
	
	
}
