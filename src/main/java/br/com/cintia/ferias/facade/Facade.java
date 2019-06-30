package br.com.cintia.ferias.facade;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cintia.ferias.service.IService;
import br.com.cintia.ferias.util.EntidadeDominio;
import br.com.cintia.ferias.util.Resultado;

@Component
public class Facade<T extends EntidadeDominio> implements IFacade<T>{

	String chave;

	@Autowired
	private Map<String, IService<T>> mapService;
	
	
	private IService<T> getService(T entidade) {
		
		String nome = entidade.getClass().getSimpleName().concat("Service").toUpperCase();
		
		mapService.keySet().forEach(key -> {
			if(key.toUpperCase().equals(nome)) {
				chave = key;
			}
		});
		return mapService.get(chave);
	}
	
	@Override
	public Resultado salvar(T entidade) {
		
		return getService(entidade).salvar(entidade);
	}

	@Override
	public Resultado consultar(T entidade) {
		
		return getService(entidade).consultar(entidade);
	}

	@Override
	public Resultado excluir(T entidade) {
		
		return getService(entidade).excluir(entidade);
	}

	@Override
	public Resultado alterar(T entidade) {
		return getService(entidade).alterar(entidade);
	}

	@Override
	public Resultado findByID(T entidade) {
		
		return getService(entidade).findByID(entidade);
	}

	@Override
	public Resultado findLivroByTitulo(T entidade) {
		
		return getService(entidade).findLivroByTitulo(entidade);
	}

	

}
