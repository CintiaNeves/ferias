package br.com.cintia.ferias.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.cintia.ferias.model.Livro;
import br.com.cintia.ferias.repository.LivroRepository;

@Controller
public class LivroController {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@RequestMapping(method = RequestMethod.GET, value = "/cadastro")
	public ModelAndView inicio() {
		
		ModelAndView modelAndView = new ModelAndView("cadastro");
		modelAndView.addObject("livroobj", new Livro());		
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/salvar")
	public ModelAndView salvar(Livro livro) {
		
		livroRepository.save(livro);
		
		ModelAndView andView = new ModelAndView("cadastro");
		Iterable<Livro> livrosIt = livroRepository.findAll();
		andView.addObject("livros", livrosIt);
		andView.addObject("livroobj", new Livro());
		
		return andView ;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/livros")
	public ModelAndView livros() {
		
		ModelAndView andView = new ModelAndView("cadastro");
		Iterable<Livro> livrosIt = livroRepository.findAll();
		andView.addObject("livros", livrosIt);
		andView.addObject("livroobj", new Livro());
		return andView;
		
	}
	
	@GetMapping("/editar/{idlivro}")
	public ModelAndView editar(@PathVariable("idlivro") Long idlivro) {
		
		Optional<Livro> livro = livroRepository.findById(idlivro);
		
		ModelAndView modelAndView = new ModelAndView("cadastro");
		modelAndView.addObject("livroobj", livro.get());
		return modelAndView;
	}
	
	@GetMapping("/excluir/{idlivro}")
	public ModelAndView excluir(@PathVariable("idlivro") Long idlivro) {
		
		livroRepository.deleteById(idlivro);
		
		ModelAndView modelAndView = new ModelAndView("cadastro");
		modelAndView.addObject("livros", livroRepository.findAll());
		modelAndView.addObject("livroobj", new Livro());
		return modelAndView;
	}
	
	@PostMapping("/pesquisar")
	public ModelAndView pesquisar(@RequestParam("titulo") String titulo) {
	
		ModelAndView modelAndView = new ModelAndView("cadastro");
		modelAndView.addObject("livros", livroRepository.findLivroByTitulo(titulo));
		modelAndView.addObject("livroobj", new Livro());
		return modelAndView;
	}
}
