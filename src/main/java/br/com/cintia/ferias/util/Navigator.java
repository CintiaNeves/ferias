package br.com.cintia.ferias.util;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cintia.ferias.navigation.Navigation;
import br.com.cintia.ferias.navigation.NavigationCase;
import br.com.cintia.ferias.strategy.IStrategy;

/**
 * 
 * @author Cintia
 *
 * <p>Classe que executa lista de strategies contida em <a href="Navigation.java">Navigation</a></p>
 * @param <T> Entidade de dominio
 */
@Component
public class Navigator<T extends EntidadeDominio> {

	@Autowired private Map<String, Navigation<T>> listNavigations;
	
	public void run (NavigationCase<T> navigation) {

		navigate(navigation);
	}
	
	private void navigate(NavigationCase<T> navigationCase) {
		if(navigationCase != null && navigationCase.getEntidade() != null) {
			Navigation<T> navigation = listNavigations.get(navigationCase.getNome());
			
			if(navigation != null && !navigationCase.getCancelado()) {
				
				List<IStrategy<T>> strategies = navigation.getStrategies();
				for(IStrategy<T> s : strategies) {
					
					s.processar(navigationCase);
					if(navigationCase.getCancelado())
						break;
				}
			}
		}
	}
}
