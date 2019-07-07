package br.com.cintia.ferias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cintia.ferias.dao.EditoraDAO;
import br.com.cintia.ferias.model.Editora;
import br.com.cintia.ferias.util.Resultado;

@Service
public class EditoraService implements IService<Editora>{
	
	@Autowired 
	private EditoraDAO dao;
	@Override
	public Resultado salvar(Editora entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado excluir(Editora entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado alterar(Editora entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado findByID(Editora entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado inicio(Editora entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado findByFilter(Editora entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado excluirById(Editora entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado findAll(Editora entidade) {
		
		return dao.findAll(entidade);
	}

}
