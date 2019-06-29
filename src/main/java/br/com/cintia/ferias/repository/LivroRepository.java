package br.com.cintia.ferias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cintia.ferias.model.Livro;

@Repository
@Transactional
public interface LivroRepository extends JpaRepository<Livro, Long>{
	
	@Query("select l from Livro l where l.titulo like %?1% ")
	List<Livro> findLivroByTitulo(String titulo);
}
