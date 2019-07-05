package br.com.cintia.ferias.navigation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.cintia.ferias.strategy.IStrategy;
import br.com.cintia.ferias.util.EntidadeDominio;

/**
 * @author Cintia
 * 
 * <p>Classe contendo lista de strategies para cada entidade 
 * 					de dominio que necessitar de validação</p>
 *
 * @param <T> Entidade de dominio
 */
@Component
public class Navigation<T extends EntidadeDominio> {

	private List<IStrategy<T>> strategies = new ArrayList<>();
	
	public void adicionarStrategy(IStrategy<T> s) {
		this.strategies.add(s);
	}
	
	public List<IStrategy<T>> getStrategies() {
		return strategies;
	}
}
