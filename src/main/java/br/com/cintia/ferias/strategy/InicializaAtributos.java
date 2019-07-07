package br.com.cintia.ferias.strategy;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cintia.ferias.model.Categoria;
import br.com.cintia.ferias.model.Editora;
import br.com.cintia.ferias.model.GrupoPrecificacao;
import br.com.cintia.ferias.model.Livro;
import br.com.cintia.ferias.navigation.NavigationCase;
import br.com.cintia.ferias.service.CategoriaService;
import br.com.cintia.ferias.service.EditoraService;
import br.com.cintia.ferias.service.GrupoPrecificacaoService;
import br.com.cintia.ferias.service.LivroService;
import br.com.cintia.ferias.util.EntidadeDominio;

@Component
public class InicializaAtributos implements IStrategy<Livro> {
	
	private static final String CATEGORIA = Categoria.class.getName();
	private static final String EDITORA = Editora.class.getName();
	private static final String GRUPO = GrupoPrecificacao.class.getName();
	
	@Autowired
	private LivroService livroService;
	
	@Autowired private CategoriaService categoriaService;
	@Autowired private GrupoPrecificacaoService grupoPrecificacaoService;
	@Autowired private EditoraService editoraService;
	
	@Override
	public void processar(NavigationCase<Livro> navigationCase) {
		
		Livro livro = navigationCase.getEntidade();
		boolean possuiCodigo = livro.getCodigo() != null ? true : false;
		
		if(!possuiCodigo) {
			navigationCase.setResultado(livroService.inicio(livro));
			Calendar calendar = GregorianCalendar.getInstance();
			Integer ano = calendar.get(Calendar.YEAR);
			String codigo = ano.toString().concat(((EntidadeDominio) navigationCase.getResultado().getEntidade()).getId().toString());

			livro.setCodigo(codigo);
			livroService.alterar(navigationCase.getEntidade());
			
			navigationCase.getResultado().setEntidade(CATEGORIA, categoriaService.findAll(new Categoria()).getEntidade(CATEGORIA));
			navigationCase.getResultado().setEntidade(GRUPO, grupoPrecificacaoService.findAll(new GrupoPrecificacao()).getEntidade(GRUPO));
			navigationCase.getResultado().setEntidade(EDITORA, editoraService.findAll(new Editora()).getEntidade(EDITORA));
			
			return;
		}
		navigationCase.getResultado().setMensagem("erro");
		navigationCase.setCancelado(true);
	}
}
