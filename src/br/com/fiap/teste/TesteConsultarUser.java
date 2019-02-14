package br.com.fiap.teste;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.MedicoDAO;
import br.com.fiap.dao.PacienteDAO;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.excecao.Excecao;

public class TesteConsultarUser {

	public static void main(String[] args) {

		try {
			
			Usuario user = new Usuario();
			UsuarioDAO dao = new UsuarioDAO();
			
			MedicoDAO medDao = new MedicoDAO();
			PacienteDAO pacDAO = new PacienteDAO();
			
			//user = dao.consultarUsuario(1);
			
			//System.out.println(user.getNome() +"\n" + user.getCod());
			
			
			System.out.println(pacDAO.consultarPaciente(5).getCod());
			
			

		} catch (Exception e) {

			e.printStackTrace();

			System.out.println(Excecao.tratarExcecao(e));
		}

	}

}
