package br.com.cintia.ferias.dao;

import java.util.List;

import javax.persistence.TypedQuery;

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
	public Resultado findByFilter(Livro entidade) {
		
		String sql = "from livro l where 1=1";
		
		boolean possuiTitulo = entidade.getTitulo() != null ? false : true;
		boolean possuiPaginas = entidade.getQtdPaginas() != null ? false : true;
		
		if(possuiTitulo) {
			sql += " and titulo = :titulo";
		}
		if(possuiPaginas) {
			sql += " and qtdPaginas = :qtdPaginas";			
		}
		TypedQuery<Livro> query = em.createQuery(sql, Livro.class);
		if(possuiTitulo) {
			query.setParameter("titulo", entidade.getTitulo());
		}
		if(possuiPaginas) {
			query.setParameter("qtdPaginas", entidade.getQtdPaginas());
		}
		List<Livro> l = query.getResultList();
		Resultado resultado = new Resultado();
		resultado.getListaEntidade().addAll(l);
		return resultado;
	}
	
	
	
	@Override
	public Resultado findLivroByTitulo(Livro entidade) {
		
		Resultado resultado = new Resultado();
		resultado.getListaEntidade().addAll(livroRepository.findLivroByTitulo(entidade.getTitulo()));
		return resultado;
	}

}