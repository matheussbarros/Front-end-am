package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.beans.Paciente;
import br.com.fiap.dao.PacienteDAO;

/**
 * Classe para validar dados para a tabela T_SAP_PACIENTE
 * 
 * @see PacienteDAO
 * @version 1.0
 * @since 1.0
 * 
 * @author Matheus
 *
 */

public class PacienteBO {

	/**
	 * Este método realiza a validação do CPF do paciente Verifica se o mesmo já
	 * existe no Banco
	 * 
	 * @param p
	 *            Rebece um Objeto Paciente
	 * @return String msg
	 * @throws Exception
	 */
	public static String novoPaciente(Paciente p) throws Exception {

		PacienteDAO dao = new PacienteDAO();

		if (p.getCpf().equalsIgnoreCase(checkCpf(p.getCpf()))) {

			return "Já Existe um Paciente cadastrado com esse CPF ";
		}
		
		// if (text == null || !text.matches("\\d{4}-[01]\\d-[0-3]\\d"))
		      //  return false;
		
		if(p.getNacimento() == null || !p.getNacimento().matches("(0[1-9]|[12]\\d|3[01])\\/(0?[1-9]|1[012])\\/[12]\\d{3}")) {
			
			return "Data Invalida";
		}

		String msg = dao.gravar(p);
		dao.fechar();
		return msg;
	}

	/**
	 * Este método Verifica se já existe um usuario com o mesmo CPF
	 * 
	 * @param cpf
	 *            Rebece uma String
	 * @return Retorna uma String msg
	 * @throws Exception
	 */
	public static String checkCpf(String cpf) throws Exception {

		PacienteDAO dao = new PacienteDAO();

		String msg = dao.consultaCpfPac(cpf);
		dao.fechar();
		return msg;
	}

	/**
	 * Este método retorna um Objeto Paciente gerada pelo PacienteDao
	 * 
	 * @param cod
	 *            codigo do paciente
	 * @return Objeto Paciente
	 * @throws Exception
	 */
	public static Paciente consultar(int cod) throws Exception {

		PacienteDAO dao = new PacienteDAO();

		Paciente paciente = dao.consultarPaciente(cod);
		dao.fechar();
		return paciente;
	}

	/**
	 * Este método realiza a validação ao Deletar um paciente Verifica se o mesmo já
	 * existe no Banco
	 * 
	 * @param cod
	 *            Rebece um Int
	 * @return String msg
	 * @throws Exception
	 */
	public static String deletaPaciente(int cod) throws Exception {

		PacienteDAO dao = new PacienteDAO();

		if (AcompanhamentoBO.checarAcompPac(cod)) {

			return "Erro";

		}

		String msg = dao.deletar(cod);
		dao.fechar();
		return msg;
	}

	/**
	 * Este método retorna a lista gerada pelo PacienteDao
	 * 
	 * @param não recebe
	 * @return List de pacientes
	 * @throws Exception
	 */
	public static List<Paciente> listaDePaciente() throws Exception {

		PacienteDAO dao = new PacienteDAO();

		List<Paciente> pacientes = dao.listarPaciente();
		dao.fechar();
		return pacientes;
	}

}
