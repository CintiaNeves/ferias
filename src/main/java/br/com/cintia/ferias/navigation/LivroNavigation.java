package br.com.cintia.ferias.navigation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.cintia.ferias.model.Livro;
import br.com.cintia.ferias.strategy.ExcluiLivroNulo;
import br.com.cintia.ferias.strategy.GeraCodigoLivro;
import br.com.cintia.ferias.strategy.ValidaPontoFlutuante;
import br.com.cintia.ferias.util.NavigationBuilder;

@Configuration
public class LivroNavigation {
	
	@Autowired ExcluiLivroNulo excluiLivroNulo;
	@Autowired GeraCodigoLivro geraCodigoLivro;
	@Autowired ValidaPontoFlutuante validaPontoFlutuante;
	
	@Bean(name = "SALVAR_LIVRO")
	public Navigation<Livro> salvarLivro() {
		return new NavigationBuilder<Livro>()
				.next(validaPontoFlutuante)
				.build();
	}
	
	@Bean(name = "INICIO_LIVRO")
	public Navigation<Livro> inicioLivro() {
		return new NavigationBuilder<Livro>()
				.next(geraCodigoLivro)
				.build();
	}
	
	@Bean(name = "CONSULTAR_LIVRO")
	public Navigation<Livro> consultarLivro() {
		return new NavigationBuilder<Livro>()
				.next(excluiLivroNulo)
				.build();
	}
}