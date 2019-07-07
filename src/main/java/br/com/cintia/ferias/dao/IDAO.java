package br.com.cintia.ferias.dao;

import br.com.cintia.ferias.util.EntidadeDominio;
import br.com.cintia.ferias.util.Resultado;

public interface IDAO<T extends EntidadeDominio> {
	
	public Resultado excluir (T entidade);
	
	public Resultado alterar (T entidade);

	public Resultado salvar(T entidade);
	
	public Resultado findByID(T entidade);

	public Resultado findByFilter(T entidade);

	public Resultado excluirById(T entidade);
	
	public Resultado findAll(T entidade);
}
