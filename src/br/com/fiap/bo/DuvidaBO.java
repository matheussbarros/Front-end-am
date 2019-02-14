package br.com.fiap.bo;

import br.com.fiap.beans.Duvida;
import br.com.fiap.dao.DuvidaDAO;


/**
 * Classe para validar dados para a tabela T_SAP_DUVIDA
 * @see DuvidaDAO
 * @version 1.0
 * @since 1.0
 * 
 * @author Matheus
 *
 */
public class DuvidaBO {
	
	
	/**
	 * Este método realiza a validação de cadastro de nova Duvida
	 * 
	 * @param du  Rebece um Objeto Duvida beans
	 * @return String 
	 * @throws Exception
	 */
	public static String novaDuvida(Duvida du) throws Exception {
		
		DuvidaDAO dao = new DuvidaDAO();
		
		
		
		
		String msg = dao.gravar(du);
		
		dao.fechar();
		
		return msg;
	}

}
