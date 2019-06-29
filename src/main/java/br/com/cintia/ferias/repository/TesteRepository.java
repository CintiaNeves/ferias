package br.com.cintia.ferias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cintia.ferias.model.Teste;

public interface TesteRepository extends JpaRepository<Teste, Long>{

	List<Teste> findByName(String name);
}
