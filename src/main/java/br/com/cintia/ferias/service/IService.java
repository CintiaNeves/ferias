package br.com.cintia.ferias.service;

import br.com.cintia.ferias.util.EntidadeDominio;
import br.com.cintia.ferias.util.Resultado;

public interface IService<T extends EntidadeDominio> {

	public Resultado salvar(T entidade);

	public Resultado consultar(T entidade);

	public Resultado excluir(T entidade);

	public Resultado alterar(T entidade);
	
	public Resultado findByID(T entidade);
	
	public Resultado inicio(T entidade);

	public Resultado findByFilter(T entidade);
	
	public Resultado excluirById(T entidade);
}
