package br.com.cintia.ferias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.cintia.ferias.model.Teste;
import br.com.cintia.ferias.repository.TesteRepository;

@Controller
public class TesteController {
	
	@Autowired private TesteRepository tr;
	
	@GetMapping("/teste")
	public String teste(@RequestParam(name = "name", required = false, defaultValue = "cintia")
						String name, Model model) {
		model.addAttribute("name", name);
		Teste t = new Teste();
		t.setName(name);
		//List<Teste> listTeste = tr.findByName(name);
		return "teste";
	}
}
