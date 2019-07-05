package br.com.cintia.ferias.dao;

import br.com.cintia.ferias.util.EntidadeDominio;
import br.com.cintia.ferias.util.Resultado;

public interface IDAO<T extends EntidadeDominio> {
	
	public Resultado consultar (T entidade);
	
	public Resultado excluir (T entidade);
	
	public Resultado alterar (T entidade);

	public Resultado salvar(T entidade);
	
	public Resultado findByID(T entidade);

	public Resultado findByFilter(T entidade);

	Resultado excluirById(T entidade);
}
