package br.com.fiap.teste;

import br.com.fiap.dao.EnderecoDAO;
import br.com.fiap.dao.MedicoDAO;
import br.com.fiap.dao.UsuarioDAO;

public class testeDelUser {

	public static void main(String[] args) {
		
		 try {
			UsuarioDAO dao = new UsuarioDAO();
			 
			 System.out.println(dao.deletar(888));
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		
		
		
	}

}
