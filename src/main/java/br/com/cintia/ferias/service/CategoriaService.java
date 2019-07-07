package br.com.cintia.ferias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cintia.ferias.dao.CategoriaDAO;
import br.com.cintia.ferias.model.Categoria;
import br.com.cintia.ferias.util.Resultado;

@Service
public class CategoriaService implements IService<Categoria>{
	
	@Autowired
	private CategoriaDAO dao;
	
	@Override
	public Resultado salvar(Categoria entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado findAll(Categoria entidade) {
		return dao.findAll(entidade);
	}

	@Override
	public Resultado excluir(Categoria entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado alterar(Categoria entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado findByID(Categoria entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado inicio(Categoria entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado findByFilter(Categoria entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado excluirById(Categoria entidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
