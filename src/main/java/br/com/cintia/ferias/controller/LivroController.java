package br.com.cintia.ferias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.cintia.ferias.facade.IFacade;
import br.com.cintia.ferias.model.Categoria;
import br.com.cintia.ferias.model.Editora;
import br.com.cintia.ferias.model.GrupoPrecificacao;
import br.com.cintia.ferias.model.Livro;
import br.com.cintia.ferias.navigation.NavigationCase;

@Controller
public class LivroController {

	@Autowired
	private IFacade<Livro> facade;

	@RequestMapping(method = RequestMethod.GET, value = "/cadastro-livro")
	public ModelAndView inicio() {

		Livro livro = new Livro();
		NavigationCase<Livro> navigationCase = new NavigationCase<Livro>("INICIO_LIVRO", livro);

		facade.inicio(navigationCase);

		ModelAndView andView = null;

		if (navigationCase.getResultado().isErro()) {
			andView = new ModelAndView("erro");
		} else {
			andView = new ModelAndView("cadastro-livro");
			andView.addObject("livroobj", navigationCase.getResultado().getEntidade());
			andView.addObject("categorias", navigationCase.getResultado().getEntidade(Categoria.class.getName()));
			andView.addObject("grupos", navigationCase.getResultado().getEntidade(GrupoPrecificacao.class.getName()));
			andView.addObject("editoras", navigationCase.getResultado().getEntidade(Editora.class.getName()));
		}
		return andView;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/salvar")
	public ModelAndView salvar(Livro livro) {

		NavigationCase<Livro> navigationCase = new NavigationCase<Livro>("SALVAR_LIVRO", livro);

		facade.salvar(navigationCase);

		ModelAndView andView = null;

		if (navigationCase.getResultado().isErro()) {
			andView = new ModelAndView("erro");
		} else {
			andView = new ModelAndView("consulta-livro");
			andView.addObject("livros", navigationCase.getResultado().getEntidade(Livro.class.getName()));
		}
		return andView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/consultar")
	public ModelAndView consultar() {

		Livro livro = new Livro();
		NavigationCase<Livro> navigationCase = new NavigationCase<Livro>("CONSULTAR_LIVRO", livro);
		navigationCase.getResultado().setEntidade(livro);
		facade.findAll(navigationCase);

		ModelAndView andView = null;

		if (navigationCase.getResultado().isErro()) {
			andView = new ModelAndView("erro");
		} else {
			andView = new ModelAndView("consulta-livro");
			andView.addObject("livros", navigationCase.getResultado().getEntidade(Livro.class.getName()));

		}

		return andView;
	}

	@GetMapping("/editar/{idlivro}")
	public ModelAndView editar(@PathVariable("idlivro") Long idlivro) {

		Livro livro = new Livro();
		livro.setId(idlivro);
		NavigationCase<Livro> navigationCase = new NavigationCase<Livro>("CONSULTAR_LIVRO", livro);
		navigationCase.getResultado().setEntidade(livro);
		
		facade.findByID(navigationCase);

		ModelAndView andView = null;

		if (navigationCase.getResultado().isErro()) {
			andView = new ModelAndView("erro");
		} else {
			andView = new ModelAndView("cadastro-livro");
			andView.addObject("livroobj", navigationCase.getResultado().getEntidade());
		}

		return andView;
	}

	@GetMapping("/excluir/{idlivro}")
	public ModelAndView excluir(@PathVariable("idlivro") Long idlivro) {

		Livro livro = new Livro();
		livro.setId(idlivro);
		NavigationCase<Livro> navigationCase = new NavigationCase<Livro>("CONSULTAR_LIVRO", livro);
		navigationCase.getResultado().setEntidade(livro);
		
		facade.excluirById(navigationCase);
		ModelAndView andView = null;

		if (navigationCase.getResultado().isErro()) {
			andView = new ModelAndView("erro");
		} else {
			andView = new ModelAndView("consulta-livro");
			andView.addObject("livros", navigationCase.getResultado().getEntidade(Livro.class.getName()));
		}

		return andView;
	}
		
		
		@PostMapping("/pesquisar")
		public ModelAndView pesquisar(@RequestParam("titulo") String titulo) {

			Livro livro = new Livro();
			livro.setTitulo(titulo);
			NavigationCase<Livro> navigationCase = new NavigationCase<Livro>("CONSULTAR_LIVRO", livro);
			navigationCase.getResultado().setEntidade(livro);
			
			facade.findByFilter(navigationCase);
			ModelAndView andView = null;

			if (navigationCase.getResultado().isErro()) {
				andView = new ModelAndView("erro");
			} else {
				andView = new ModelAndView("consulta-livro");
				andView.addObject("livros", navigationCase.getResultado().getEntidade());
			}

			return andView;
		}

}
