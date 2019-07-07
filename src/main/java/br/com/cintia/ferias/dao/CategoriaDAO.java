package br.com.cintia.ferias.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cintia.ferias.model.Categoria;

@Repository
@Transactional
public class CategoriaDAO extends AbstractDAO<Categoria>{

}
