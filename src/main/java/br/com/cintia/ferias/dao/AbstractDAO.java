package br.com.cintia.ferias.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cintia.ferias.repository.IRepository;
import br.com.cintia.ferias.util.EntidadeDominio;
import br.com.cintia.ferias.util.Resultado;

public  abstract class AbstractDAO<T extends EntidadeDominio> implements IDAO<T>{
	
	String chave;
	@Autowired
	private Map<String, IRepository<T>> mapRepository;
	
	private IRepository<T> getRepository(EntidadeDominio entidadeDominio){
		String nome = entidadeDominio.getClass().getSimpleName().concat("Repository").toUpperCase();
		mapRepository.keySet().forEach(key -> {
			if(key.toUpperCase().equals(nome)) {
				chave = key;
			}
		});
		return mapRepository.get(chave);
	}
	
	@Override
	public Resultado salvar(T entidade) {
		
		IRepository<T> repository = getRepository(entidade);
		Resultado resultado = new Resultado();
		resultado.setEntidade(repository.save(entidade));
		return resultado;
	}

	@Override
	public Resultado consultar(T entidade) {
		Resultado resultado = new Resultado();
		resultado.getListaEntidade().addAll(getRepository(entidade).findAll());
		return resultado;
	}

	@Override
	public Resultado excluir(T entidade) {

		IRepository<T> repository = getRepository(entidade);
		Resultado resultado = new Resultado();
		repository.deleteById(entidade.getId());
	
		return resultado;
	}

	@Override
	public Resultado alterar(T entidade) {
		// TODO Auto-generated method stub
		return null;
	}
	
	


}
