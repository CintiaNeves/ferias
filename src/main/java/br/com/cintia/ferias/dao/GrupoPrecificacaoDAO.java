package br.com.cintia.ferias.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cintia.ferias.model.GrupoPrecificacao;

@Repository
@Transactional
public class GrupoPrecificacaoDAO extends AbstractDAO<GrupoPrecificacao>{

}
