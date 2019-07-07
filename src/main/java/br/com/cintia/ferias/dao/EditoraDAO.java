package br.com.cintia.ferias.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cintia.ferias.model.Editora;

@Repository
@Transactional
public class EditoraDAO extends AbstractDAO<Editora>{

}
