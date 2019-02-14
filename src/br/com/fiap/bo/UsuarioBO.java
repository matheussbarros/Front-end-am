package br.com.fiap.bo;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;

/**
 * Classe para validar dados para a tabela T_SAP_USUARIO
 * @see  UsuarioDAO
 * @version 1.0
 * @since 1.0
 * 
 * @author Matheus
 *
 */
public class UsuarioBO {

	/**
	 * Este método realiza a validação de Usuario
	 * 
	 * @param user
	 *            Rebece um Objeto Usuario
	 * @return String
	 * @throws Exception
	 * 
	 */
	public static String novoUsuario(Usuario user) throws Exception {
		UsuarioDAO dao = new UsuarioDAO();

		// Validação de Senha
		if (user.getSenha().length() < 6 || user.getSenha().length() > 8) {

			return "A senha deve conter de 6 a 8 caracteres";

		}

		// Validação de email
		if (user.getEmail().indexOf("@") < 0 && user.getEmail().indexOf(".") < 0) {

			return "E-mail inválido";
		}
		
		//
		if(dao.consultaEmail(user.getEmail())) {
			return "Já Existe um Usuario cadastrado com este Email";
		}

		// Validação de Nível de acesso
		if (user.getNivel() != 1 && user.getNivel() != 2 && user.getNivel() != 3) {

			return "Nível de acesso inválido! o nivel de usuario deve ser 1,2 ou 3";
		}

		String msg = dao.gravar(user);
		dao.fechar();

		return msg;

	}

	/**
	 * Este método realiza a validação ao deletar um Usuario
	 * 
	 * @param cod Rebece um codigo do Usuario
	 * @param nvl Recebe o nvl do usuario
	 * @return String
	 * @throws Exception
	 */
	public static String deletaUsuario(int cod, int nvl) throws Exception {
		UsuarioDAO dao = new UsuarioDAO();

		if (nvl == 2) {

			String msgMed = MedicoBO.deletaMedico(cod);
			if (msgMed.equalsIgnoreCase("Erro")) {
				//return "Este Usuario possui acompanhamento(s) em aberto, Não pode ser Excluido!";
				return"Error";
			}

			EnderecoBO.deletaEndereco(cod);
			dao.deletar(cod);
			dao.fechar();

			return "Médico Exluido Com sucesso";

		} else {
			String msgPac = PacienteBO.deletaPaciente(cod);
			if (msgPac.equalsIgnoreCase("Erro")) {
				//return "Existe Acompanhamento em aberto para esta Usuario, Não pode ser Excluido!";
				return"Error";
			}

			EnderecoBO.deletaEndereco(cod);
			dao.deletar(cod);
			dao.fechar();

			return "Paciente Exluido Com sucesso";
		}

		// return msg;
	}

	/**
	 * Este método realiza o Login do usurio
	 * 
	 * @param user Rebece um email do usuario
	 * @param pass Recebe a senha do usuario
	 * @return Objeto usuario
	 * @throws Exception
	 */

	public static Usuario efetuaLogin(String user, String pass) throws Exception {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.loginUsuario(user, pass);
		dao.fechar();
		return usuario;
	}

}
