package br.com.fiap.teste;

import br.com.fiap.dao.EnderecoDAO;

public class testeDelEnd {

	public static void main(String[] args) {
		
		 try {
			 EnderecoDAO dao = new EnderecoDAO();
			 
			 System.out.println(dao.deletar(888));
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		
		
		
	}

}
