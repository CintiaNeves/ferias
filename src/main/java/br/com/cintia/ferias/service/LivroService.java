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
		return dao.consultar(entidade);
	}

	@Override
	public Resultado consultar(Livro entidade) {
		
		return dao.consultar(entidade);
	}

	@Override
	public Resultado excluir(Livro entidade) {
		
		dao.excluir(entidade);
		return dao.consultar(entidade);
	}

	@Override
	public Resultado alterar(Livro entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado findByID(Livro entidade) {
		
		return dao.findByID(entidade);
	}

	@Override
	public Resultado findLivroByTitulo(Livro entidade) {
		
		return dao.findLivroByTitulo(entidade);
	}

}
