package br.com.cintia.ferias.facade;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cintia.ferias.navigation.NavigationCase;
import br.com.cintia.ferias.service.IService;
import br.com.cintia.ferias.util.EntidadeDominio;
import br.com.cintia.ferias.util.Navigator;
import br.com.cintia.ferias.util.Resultado;

@Component
public class Facade<T extends EntidadeDominio> implements IFacade<T>{

	String chave;

	@Autowired private Navigator<T> navigator;
	@Autowired private Map<String, IService<T>> mapService;
	
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
	public void salvar(NavigationCase<T> navigationCase) {
		navigator.run(navigationCase);
		if(!navigationCase.getCancelado()) {
			IService<T> s = getService(navigationCase.getEntidade());
			Resultado r = s.salvar(navigationCase.getResultado().getEntidade());
			navigationCase.setResultado(r);			
		}
	}

	@Override
	public void consultar(NavigationCase<T> navigationCase) {
		navigator.run(navigationCase);
		if(!navigationCase.getCancelado()) {
			IService<T> s = getService(navigationCase.getEntidade());
			Resultado r = s.consultar(navigationCase.getResultado().getEntidade());
			navigationCase.setResultado(r);			
		}
	}

	@Override
	public void excluir(NavigationCase<T> navigationCase) {
		navigator.run(navigationCase);
		if(!navigationCase.getCancelado()) {
			IService<T> s = getService(navigationCase.getEntidade());
			Resultado r = s.excluir(navigationCase.getResultado().getEntidade());
			navigationCase.setResultado(r);			
		}
	}

	@Override
	public void alterar(NavigationCase<T> navigationCase) {
		navigator.run(navigationCase);
		if(!navigationCase.getCancelado()) {
			IService<T> s = getService(navigationCase.getEntidade());
			Resultado r = s.alterar(navigationCase.getResultado().getEntidade());
			navigationCase.setResultado(r);			
		}
	}

	@Override
	public void findByID(NavigationCase<T> navigationCase) {
		navigator.run(navigationCase);
		if(!navigationCase.getCancelado()) {
			IService<T> s = getService(navigationCase.getEntidade());
			Resultado r = s.findByID(navigationCase.getResultado().getEntidade());
			navigationCase.setResultado(r);			
		}
	}

	@Override
	public void inicio(NavigationCase<T> navigationCase) {
		navigator.run(navigationCase);
	}
	/**
	 * valida apenas a existencia da entidade 
	 * antes de realizar a consuta pelo filtro da entidade
	 */
	@Override
	public void findByFilter(NavigationCase<T> navigationCase) {
		navigator.run(navigationCase);
		if(!navigationCase.getCancelado()) {
			IService<T> s = getService(navigationCase.getEntidade());
			Resultado r = s.findByFilter(navigationCase.getResultado().getEntidade());
			navigationCase.setResultado(r);
		}
	}

	@Override
	public void excluirById(NavigationCase<T> navigationCase) {
		navigator.run(navigationCase);
		if(!navigationCase.getCancelado()) {
			IService<T> s = getService(navigationCase.getEntidade());
			Resultado r = s.excluirById(navigationCase.getResultado().getEntidade());
			navigationCase.setResultado(r);			
		}
	}

	
		
}
