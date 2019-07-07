package br.com.cintia.ferias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cintia.ferias.dao.GrupoPrecificacaoDAO;
import br.com.cintia.ferias.model.GrupoPrecificacao;
import br.com.cintia.ferias.util.Resultado;

@Service
public class GrupoPrecificacaoService implements IService<GrupoPrecificacao>{
	
	@Autowired 
	private GrupoPrecificacaoDAO dao;

	@Override
	public Resultado salvar(GrupoPrecificacao entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado excluir(GrupoPrecificacao entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado alterar(GrupoPrecificacao entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado findByID(GrupoPrecificacao entidade) {
		return null;
	}

	@Override
	public Resultado inicio(GrupoPrecificacao entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado findByFilter(GrupoPrecificacao entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado excluirById(GrupoPrecificacao entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado findAll(GrupoPrecificacao entidade) {
		
		return dao.findAll(entidade);
	}

}
