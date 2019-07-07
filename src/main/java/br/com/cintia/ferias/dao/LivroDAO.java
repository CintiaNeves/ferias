package br.com.cintia.ferias.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cintia.ferias.model.Livro;
import br.com.cintia.ferias.util.Resultado;

@Repository
@Transactional
public class LivroDAO extends AbstractDAO<Livro>{
	
	// @Autowired private LivroRepository livroRepository;
	
	@Override
	public Resultado findByFilter(Livro entidade) {
		
		boolean possuiTitulo = entidade.getTitulo() != null ? true : false;
		boolean possuiPaginas = entidade.getQtdPaginas() != null ? true : false;
		
		String sql = "from ".concat(Livro.class.getName().toString()).concat(" l where 1=1");
		
		if(possuiTitulo) 
			sql = sql.concat(" and titulo like :titulo");
		
		if(possuiPaginas) 
			sql = sql.concat(" and qtdPaginas = :qtdPaginas");			
		
		TypedQuery<Livro> query = em.createQuery(sql, Livro.class);
		
		if(possuiTitulo)
			query.setParameter("titulo", "%".concat(entidade.getTitulo()).concat("%"));

		if(possuiPaginas)
			query.setParameter("qtdPaginas", entidade.getQtdPaginas());

		List<Livro> l = query.getResultList();
		Resultado resultado = new Resultado();
		resultado.setEntidade(l);
		return resultado;
	}
	
	public Resultado excluirLivroNulo(Livro entidade) {
		
		Query query = em.createQuery("DELETE FROM Livro l WHERE l.titulo = null");
		query.executeUpdate();
		Resultado resultado = new Resultado();
		return resultado;
	}
}