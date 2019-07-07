package br.com.cintia.ferias.util;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class Resultado {
	
	private final static String KEY = "entidade";
	private boolean erro;
	private String mensagem;
	private Map<String, Object> mapEntidade;
	
	public Resultado () {
		mapEntidade = new HashMap<>();
	}
	
	public void setEntidade(Object entidade) {
		mapEntidade.put(KEY, entidade);
	}
	
	public void setEntidade(String key, Object entidade) {
		mapEntidade.put(key, entidade);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getEntidade() {
		return (T) mapEntidade.get(KEY);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getEntidade(String key) {
		return (T) mapEntidade.get(key);
	}
}
