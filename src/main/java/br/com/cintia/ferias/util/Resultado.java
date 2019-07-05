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
	
	@SuppressWarnings("unchecked")
	public <T extends EntidadeDominio> List<T> getListEntidade() {
		return (List<T>) listaEntidade;
	}
	@SuppressWarnings("unchecked")
	public <T extends EntidadeDominio> T getEntidade() {
		return (T) listaEntidade.get(0);
	}
}
