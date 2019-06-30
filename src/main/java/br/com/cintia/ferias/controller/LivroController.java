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
import br.com.cintia.ferias.model.Livro;
import br.com.cintia.ferias.util.Resultado;

@Controller
public class LivroController {
	
	@Autowired
	private IFacade<Livro> facade;
	
	@RequestMapping(method = RequestMethod.GET, value = "/cadastro")
	public ModelAndView inicio() {
		
		ModelAndView modelAndView = new ModelAndView("cadastro");
		modelAndView.addObject("livroobj", new Livro());		
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/salvar")
	public ModelAndView salvar(Livro livro) {

		Resultado resultado = facade.salvar(livro);
		ModelAndView andView = null;
		
		if(resultado.isErro()) {
			andView = new ModelAndView("erro");
		}else {
			andView = new ModelAndView("cadastro");
			andView.addObject("livros", resultado.getListaEntidade());
			andView.addObject("livroobj", new Livro());
		}
		return andView ;
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/livros")
	public ModelAndView consultar() {
		
		Resultado resultado = facade.consultar(new Livro());
		ModelAndView andView = null;
		
		if(resultado.isErro()) {
			andView = new ModelAndView("erro");
		}else {
			andView = new ModelAndView("cadastro");
			andView.addObject("livros", resultado.getListaEntidade());
			andView.addObject("livroobj", new Livro ());
		}
		
		return andView;
		
	}
	
	@GetMapping("/editar/{idlivro}")
	public ModelAndView editar(@PathVariable("idlivro") Long idlivro) {
		
		Livro livro = new Livro();
		livro.setId(idlivro);
		Resultado resultado = facade.findByID(livro);
		ModelAndView andView= null;
		
		if(resultado.isErro()) {
			andView = new ModelAndView("erro");
		}else {
			andView = new ModelAndView("cadastro");
			andView.addObject("livroobj", resultado.getEntidade());
		}
		
		return andView;
	}
	
	@GetMapping("/excluir/{idlivro}")
	public ModelAndView excluir(@PathVariable("idlivro") Long idlivro) {
		
		Livro livro = new Livro();
		livro.setId(idlivro);
		Resultado resultado = facade.excluir(livro);
		ModelAndView andView = null;
		
		if(resultado.isErro()) {
			andView = new ModelAndView("erro");
		}else {
			andView = new ModelAndView("cadastro");
			andView.addObject("livros", resultado.getListaEntidade());
			andView.addObject("livroobj", new Livro ());
		}
		
		return andView;
	}
	
	@PostMapping("/pesquisar")
	public ModelAndView pesquisar(@RequestParam("titulo") String titulo) {
		
		Livro livro = new Livro();
		livro.setTitulo(titulo);
		Resultado resultado = facade.findLivroByTitulo(livro);
		ModelAndView andView = null;
		
		if(resultado.isErro()) {
			andView = new ModelAndView("erro");
		}else {
			andView = new ModelAndView("cadastro");
			andView.addObject("livros", resultado.getListaEntidade());
			andView.addObject("livroobj", new Livro ());
		}
		
		return andView;
	}
}
