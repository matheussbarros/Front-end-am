package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.beans.Acompanhamento;
import br.com.fiap.dao.AcompanhamentoDAO;


/**
 * Classe para validar dados para a tabela T_SAP_ACOMPANHAMENTO
 * @see AcompanhamentoDAO
 * @version 1.0
 * @since 1.0
 * 
 * @author Matheus
 *
 */
public class AcompanhamentoBO {

	
	
	/**
	 * Método Responsável validar um novo Acompanhamento
	 * @param acomp  Objeto Acompanhamento beans
	 * @return String
	 * @throws Excepiton
	 *             chamada da exceção checked
	 * @author Guilherme
	 * @author Matheus
	 */
	public static String novoAcomp(Acompanhamento acomp) throws Exception{
		
		AcompanhamentoDAO dao = new AcompanhamentoDAO();
		
		String msg = dao.gravar(acomp);
		
		dao.fechar();
		
		return msg ;
	}
	
	
	/**
	 * Método Responsável validar uma lista do AcompanhamentoDAO com base no Cod do Medico
	 * @param cod  codigo do medico
	 * @return String
	 * @throws Excepiton
	 *             chamada da exceção checked
	 * @author Guilherme
	 * @author Matheus
	 */
	
	public static List<Acompanhamento> listAcomPorMed(int cod) throws Exception{
		AcompanhamentoDAO dao = new AcompanhamentoDAO();
		
		List<Acompanhamento> acomps = dao.listaAcompMed(cod);
		dao.fechar();
		
		return acomps;
		
	}
	
	/**
	 * Método Responsável validar uma lista do AcompanhamentoDAO() com base no Cod do Paciente
	 * @param cod codigo do Paciente
	 * @return String
	 * @throws Excepiton
	 *             chamada da exceção checked
	 * @author Guilherme
	 * @author Matheus
	 */
	
	public static List<Acompanhamento> listAcomPorPac(int cod) throws Exception{
		AcompanhamentoDAO dao = new AcompanhamentoDAO();
		
		List<Acompanhamento> acomps = dao.listaAcompPac(cod);
		dao.fechar();
		
		return acomps;
		
	}
	
	
	/**
	 * Método Responsável por checar se existe um acompanhamento aberto com cod do Médico
	 * @param cod codigo do medico
	 * @return Boolean
	 * @throws Excepiton
	 *             chamada da exceção checked
	 * @author Guilherme
	 * @author Matheus
	 */
	public static boolean checarAcompMed(int cod) throws Exception{
		AcompanhamentoDAO dao = new AcompanhamentoDAO();
		
		boolean msg = dao.checarAcompMed(cod);
		dao.fechar();
		return msg;
				
	}
	
	
	/**
	 * Método Responsável por checar se existe um acompanhamento aberto com cod do Paciente
	 * @param cod codigo do Paciente
	 * @return Boolean
	 * @throws Excepiton
	 *             chamada da exceção checked
	 * @author Guilherme
	 * @author Matheus
	 */
	public static boolean checarAcompPac(int cod) throws Exception{
		AcompanhamentoDAO dao = new AcompanhamentoDAO();
		
		boolean msg = dao.checarAcompPac(cod);
		dao.fechar();
		return msg;
				
	}
	
	
	
}
