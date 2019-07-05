package br.com.cintia.ferias.strategy;

import br.com.cintia.ferias.navigation.NavigationCase;
import br.com.cintia.ferias.util.EntidadeDominio;

public interface IStrategy <T extends EntidadeDominio>{

	public void processar(NavigationCase<T> navigationCase);
}
