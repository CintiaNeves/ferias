package br.com.cintia.ferias.strategy;

import org.springframework.stereotype.Component;

import br.com.cintia.ferias.model.Livro;
import br.com.cintia.ferias.navigation.NavigationCase;
import br.com.cintia.ferias.util.Resultado;

@Component
public class ValidaPontoFlutuante implements IStrategy<Livro>{
	
	@Override
	public void processar(NavigationCase<Livro> navigationCase) {
		
		Livro livro = navigationCase.getEntidade();
		Resultado resultado = new Resultado();
		
		String altura = livro.getDimensoes().getAltura().toString();
		String largura = livro.getDimensoes().getLargura().toString();
		String peso = livro.getDimensoes().getPeso().toString();
		String profundidade = livro.getDimensoes().getProfundidade().toString();
		
		altura = altura.replace(",",".");
		largura = largura.replace(",",".");
		peso = peso.replace(",",".");
		profundidade = profundidade.replace(",",".");
		
		livro.getDimensoes().setAltura(Double.parseDouble(altura));
		livro.getDimensoes().setLargura(Double.parseDouble(largura));
		livro.getDimensoes().setPeso(Double.parseDouble(peso));
		livro.getDimensoes().setProfundidade(Double.parseDouble(profundidade));
		
		resultado.setEntidade(livro);
		navigationCase.setResultado(resultado);
	}

}
