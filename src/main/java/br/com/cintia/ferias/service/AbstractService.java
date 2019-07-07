package br.com.cintia.ferias.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cintia.ferias.dao.IDAO;
import br.com.cintia.ferias.util.EntidadeDominio;
import br.com.cintia.ferias.util.Resultado;

public abstract class AbstractService<T extends EntidadeDominio> implements IService<T>{
	
	private String chave;
	
	@Autowired
	private Map<String, IDAO<T>> mapDAO;
	
	private IDAO<T> getDAO(EntidadeDominio entidadeDominio){
		String nome = entidadeDominio.getClass().getSimpleName().concat("DAO").toUpperCase();
		mapDAO.keySet().forEach(key -> {
			if(key.toUpperCase().equals(nome)) {
				chave = key;
			}
		});
		return mapDAO.get(chave);
	}
	
	
	@Override
	public Resultado salvar(T entidade) {
		IDAO<T> dao = getDAO(entidade);
		Resultado resultado = new Resultado();
		resultado.setEntidade(dao.salvar(entidade));
		return resultado;
	}

	@Override
	public Resultado excluir(T entidade) {
		IDAO<T> dao = getDAO(entidade);
		Resultado resultado = new Resultado();
		resultado.setEntidade(dao.excluir(entidade));
		return resultado;
	}

	@Override
	public Resultado alterar(T entidade) {
		IDAO<T> dao = getDAO(entidade);
		Resultado resultado = new Resultado();
		resultado.setEntidade(dao.alterar(entidade));
		return resultado;
	}

	@Override
	public Resultado findByID(T entidade) {
		IDAO<T> dao = getDAO(entidade);
		Resultado resultado = new Resultado();
		resultado.setEntidade(dao.findByID(entidade));
		return resultado;
	}
	

	@Override
	public Resultado findByFilter(T entidade) {
		IDAO<T> dao = getDAO(entidade);
		Resultado resultado = new Resultado();
		resultado.setEntidade(dao.findByFilter(entidade));
		return resultado;
	}

	@Override
	public Resultado excluirById(T entidade) {
		IDAO<T> dao = getDAO(entidade);
		Resultado resultado = new Resultado();
		resultado.setEntidade(dao.excluirById(entidade));
		return resultado;
	}

	@Override
	public Resultado findAll(T entidade) {
		IDAO<T> dao = getDAO(entidade);
		Resultado resultado = new Resultado();
		resultado.setEntidade(dao.findAll(entidade));
		return resultado;
	}
}
