package br.com.cintia.ferias.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cintia.ferias.model.Livro;
import br.com.cintia.ferias.navigation.NavigationCase;
import br.com.cintia.ferias.service.LivroService;

@Component
public class ExcluiLivroNulo implements IStrategy<Livro>{
	
	@Autowired
	private LivroService livroService;
	@Override
	public void processar(NavigationCase<Livro> navigationCase) {
		
		livroService.excluir(navigationCase.getEntidade());
		return;
	}

}
