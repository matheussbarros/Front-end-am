package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.beans.Medico;
import br.com.fiap.dao.MedicoDAO;


/**
 * Classe para validar dados para a tabela T_SAP_MEDICO
 * @see MedicoDAO
 * @version 1.0
 * @since 1.0
 * 
 * @author Matheus
 *
 */
public class MedicoBO {

	/**
	 * Este m�todo realiza a valida��o do CRM do medico Verifica se o mesmo j�
	 * existe no Banco
	 * 
	 * @param med
	 *            Rebece um Objeto Medico
	 * @return String msg
	 * @throws Exception
	 */
	public static String novoMedico(Medico med) throws Exception {

		MedicoDAO dao = new MedicoDAO();
		if (med.getCrm() == dao.cunsultaCrmMed(med.getCrm())) {

			return "J� Existe um Medico cadastrado com esse CRM ";
		}

		String msg = dao.gravar(med);
		dao.fechar();
		return msg;
	}
	

	
	/**
	 * Este m�todo realiza a valida��o ao deletar um M�dico verificando se existem Acompanhamento em aberto
	 * caso exista o med n�o pode ser excluido
	 * 
	 * @param cod
	 *            Rebece o cod do medico
	 * @return String 
	 * @throws Exception
	 */
	public static String deletaMedico(int cod) throws Exception {

		MedicoDAO dao = new MedicoDAO();
		
		if(AcompanhamentoBO.checarAcompMed(cod)) {
			
			return "Erro";
			
		}

		String msg = dao.deletar(cod);
		dao.fechar();
		return msg;
	}
	
	
	/**
	 * Este m�todo retorna a lista gerada pelo MedicoDao
	 * 
	 * @param 
	 * @return List medicos
	 * @throws Exception
	 */
	public static List<Medico> listaDeMedico() throws Exception{
		
		MedicoDAO dao = new MedicoDAO();
		
		
		
		List<Medico> medicos = dao.listarMedico();
		dao.fechar();
		return medicos;
	}
	
	
	/**
	 * Este m�todo retorna um Objeto Medico gerada pelo MedicoDao
	 * 
	 * @param cod Recebe o Cod do Medico
	 * @return Objeto Medico
	 * @throws Exception
	 */
	public static Medico consultar(int cod) throws Exception {

		MedicoDAO dao = new MedicoDAO();
		

		Medico medico = dao.consultarMedico(cod);
		dao.fechar();
		return medico;
	}
	

}
