package br.com.cintia.ferias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import br.com.cintia.ferias.model.Livro;

public interface LivroRepository extends IRepository<Livro>{
	
	@Query("select l from Livro l where l.titulo like %?1% ")
	List<Livro> findLivroByTitulo(String titulo);
}
