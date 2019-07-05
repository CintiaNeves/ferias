package br.com.cintia.ferias.navigation;

import br.com.cintia.ferias.util.EntidadeDominio;
import br.com.cintia.ferias.util.Resultado;
import lombok.Data;

/**
 * @author Cintia
 * <p>Classe responsavel por gerenciar o processamento das entidades dentro do sistema.</p>
 *
 * @param <T>
 */
@Data
public class NavigationCase<T extends EntidadeDominio> {

	private Resultado resultado;
	private String nome;
	private Boolean cancelado;
	private T entidade;

	public NavigationCase(String nome, T entidade) {
		this.nome = nome;
		this.entidade = entidade;
		cancelado = false;
		resultado = new Resultado();
	}
	public void cancelar(String message) {
		cancelado = true;
		resultado.setMensagem(message);
	}
}