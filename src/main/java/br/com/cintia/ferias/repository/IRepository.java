package br.com.cintia.ferias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cintia.ferias.util.EntidadeDominio;

public interface IRepository<T extends EntidadeDominio> extends JpaRepository<T, Long>{

}
