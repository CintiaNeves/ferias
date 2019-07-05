package br.com.cintia.ferias.facade;

import br.com.cintia.ferias.navigation.NavigationCase;
import br.com.cintia.ferias.util.EntidadeDominio;

public interface IFacade<T extends EntidadeDominio> {
	
	public void salvar(NavigationCase<T> navigationCase);

	public void consultar(NavigationCase<T> navigationCase);

	public void excluir(NavigationCase<T> navigationCase);

	public void alterar(NavigationCase<T> navigationCase);
	
	public void inicio(NavigationCase<T> navigationCase);
	
	public void findByID(NavigationCase<T> navigationCase);

	public void findByFilter(NavigationCase<T> navigationCase);

	public void excluirById(NavigationCase<T> navigationCase);

	
}
