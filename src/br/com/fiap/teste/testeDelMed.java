package br.com.fiap.teste;

import br.com.fiap.bo.MedicoBO;
import br.com.fiap.dao.EnderecoDAO;
import br.com.fiap.dao.MedicoDAO;

public class testeDelMed {

	public static void main(String[] args) {
		
		 try {
			
			 
			 
			 System.out.println(MedicoBO.deletaMedico(26));
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		
		
		
	}

}
