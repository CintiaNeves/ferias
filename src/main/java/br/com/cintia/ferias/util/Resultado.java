package br.com.cintia.ferias.util;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Resultado {
	
	private boolean erro;
	private String mensagem;
	private List<EntidadeDominio> listaEntidade = new ArrayList<>();
	
	public void setEntidade(EntidadeDominio entidadeDominio) {
		listaEntidade.add(entidadeDominio);
	}
	public EntidadeDominio getEntidade() {
		return listaEntidade.get(0);
	}
}
