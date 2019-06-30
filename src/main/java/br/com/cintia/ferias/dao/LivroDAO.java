package br.com.cintia.ferias.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cintia.ferias.model.Livro;
import br.com.cintia.ferias.repository.LivroRepository;
import br.com.cintia.ferias.util.Resultado;

@Repository
@Transactional
public class LivroDAO extends AbstractDAO<Livro>{
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Override
	public Resultado findByID(Livro entidade) {
		
		Resultado resultado = new Resultado();
		Optional<Livro> livro = livroRepository.findById(entidade.getId());
		resultado.setEntidade(livro.get()); 
		return resultado;
	}

	@Override
	public Resultado findLivroByTitulo(Livro entidade) {
		
		Resultado resultado = new Resultado();
		resultado.getListaEntidade().addAll(livroRepository.findLivroByTitulo(entidade.getTitulo()));
		return resultado;
	}

}