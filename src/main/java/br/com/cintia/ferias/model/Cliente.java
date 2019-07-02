package br.com.cintia.ferias.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.cintia.ferias.util.EntidadeDominio;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = false)
public class Cliente extends EntidadeDominio{
	
	private Boolean ativo;
	private Long codigo;
	private String nome;
	private LocalDate dataNascimento;
	private String cpf;
	private String email;
	
	@OneToOne
	private Usuario usuario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Genero genero;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Telefone telefone;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Endereco enderecoResidencial;
	
	@OneToMany(mappedBy = "cliente")
	private List<Endereco> enderecosCobranca;
	
	@OneToMany(mappedBy = "cliente")
	private List<Endereco> enderecosEntrega;
	
	@OneToMany(mappedBy = "cliente")
	private List<Compra> compras;
	
	@OneToMany(mappedBy = "cliente")
	private List<CartaoCredito> cartoes;
	
}
