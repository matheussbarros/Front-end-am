package br.com.fiap.teste;

import java.util.List;

import br.com.fiap.beans.Acompanhamento;
import br.com.fiap.dao.AcompanhamentoDAO;

public class ListaAcomp {

	public static void main(String[] args) {
		try {
		
		AcompanhamentoDAO dao = new AcompanhamentoDAO();
		
		List<Acompanhamento> acomps = dao.consultarAcompanhamento(10);
		
		Object[] ob = acomps.toArray();
		
		for (Object value : ob) {
		System.out.println("Number = " + value);
		
		}
		
		}catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
