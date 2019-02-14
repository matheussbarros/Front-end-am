package br.com.fiap.bo;

import br.com.fiap.beans.Endereco;
import br.com.fiap.dao.EnderecoDAO;

/**
 * Classe para validar dados para a tabela T_SAP_ENDERECO
 * @see EnderecoDAO
 * @version 1.0
 * @since 1.0
 * 
 * @author Matheus
 *
 */
public class EnderecoBO {

	
	/**
	 * Este m�todo realiza a valida��o de cadastro de endere�o
	 * 
	 * @param end  Rebece um Objeto Endereco
	 * @return String com mensagem de erro ou Sucesso
	 * @throws Exception
	 */
	public static String novoEndereco(Endereco end) throws Exception {
		EnderecoDAO dao = new EnderecoDAO();

		// valida��o Lougradouro
		if (end.getLogradouro().length() > 40) { 

			return "Campo Endere�o exedeu o limite de caracteres";

		}

		// valida��o Bairro
		if (end.getBairro().length() > 40) {

			return "Campo Bairro exedeu o limite de caracteres";
		}

		// valida��o Cidade
		if (end.getCidade().length() > 20) {

			return "Campo Cidade exedeu o limite de caracteres";
		}

		// valida��o Estado
		if (end.getEstado().length() > 20) {
			return "Campo Estado exedeu o limite de caracteres";
		}

		String msg = dao.gravar(end);
		dao.fechar();

		return msg;

	}

	
	
	/**
	 * Este m�todo realiza a valida��o ao deletar um Endereco
	 * 
	 * @param cod  Recebe um Int 
	 * @return String msg
	 * @throws Exception
	 */
	public static String deletaEndereco(int cod) throws Exception {

		EnderecoDAO dao = new EnderecoDAO();

		String msg = dao.deletar(cod);
		dao.fechar();
		return msg;
	}

}
