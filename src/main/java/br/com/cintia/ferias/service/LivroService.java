package br.com.cintia.ferias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cintia.ferias.dao.LivroDAO;
import br.com.cintia.ferias.model.Livro;
import br.com.cintia.ferias.util.Resultado;

@Service
public class LivroService implements IService<Livro>{
	
	@Autowired
	private LivroDAO dao;
	
	@Override
	public Resultado salvar(Livro entidade) {
		
		dao.salvar(entidade);
		return dao.findAll(entidade);
	}

	@Override
	public Resultado findAll(Livro entidade) {
		
		return dao.findAll(entidade);
	}

	@Override
	public Resultado excluir(Livro entidade) {
		
		return dao.excluirLivroNulo(entidade);
	}

	@Override
	public Resultado alterar(Livro entidade) {
		
		return dao.alterar(entidade);
	}

	@Override
	public Resultado findByID(Livro entidade) {
		
		return dao.findByID(entidade);
	}

	@Override
	public Resultado inicio(Livro entidade) {
		
		return dao.salvar(entidade);
	}

	@Override
	public Resultado findByFilter(Livro entidade) {
		return dao.findByFilter(entidade);
	}

	@Override
	public Resultado excluirById(Livro entidade) {
		
		dao.excluirById(entidade);
		return dao.findAll(entidade);
	}

	
}
