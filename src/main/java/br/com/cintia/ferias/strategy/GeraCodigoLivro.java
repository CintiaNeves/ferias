package br.com.cintia.ferias.strategy;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cintia.ferias.model.Livro;
import br.com.cintia.ferias.navigation.NavigationCase;
import br.com.cintia.ferias.service.LivroService;

@Component
public class GeraCodigoLivro implements IStrategy<Livro> {
	
	@Autowired
	private LivroService livroService;
	@Override
	public void processar(NavigationCase<Livro> navigationCase) {
		
		Livro livro = navigationCase.getEntidade();
		boolean possuiCodigo = livro.getCodigo() != null ? true : false;
		
		if(!possuiCodigo) {
			navigationCase.setResultado(livroService.inicio(livro));
			Calendar calendar = GregorianCalendar.getInstance();
			Integer ano = calendar.get(Calendar.YEAR);
			String codigo = ano.toString().concat(navigationCase.getResultado().getEntidade().getId().toString());

			livro.setCodigo(codigo);
			livroService.alterar(navigationCase.getEntidade());
			return;
		}
		navigationCase.getResultado().setMensagem("erro");
		navigationCase.setCancelado(true);
	}
}
