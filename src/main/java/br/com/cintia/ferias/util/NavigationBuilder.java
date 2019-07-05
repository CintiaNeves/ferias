package br.com.cintia.ferias.util;

import br.com.cintia.ferias.navigation.Navigation;
import br.com.cintia.ferias.strategy.IStrategy;

public class NavigationBuilder<T extends EntidadeDominio> {

	private Navigation<T> navigation = new Navigation<>();
	
	public NavigationBuilder<T> next(IStrategy<T> strategy) {
		navigation.adicionarStrategy(strategy);
		return this;
	}
	
	public Navigation<T> build() {
		return navigation;
	}
}
