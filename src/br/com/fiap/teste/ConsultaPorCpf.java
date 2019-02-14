package br.com.fiap.teste;

import br.com.fiap.dao.PacienteDAO;

public class ConsultaPorCpf {

	public static void main(String[] args) {
		try {
			
			System.out.println(new PacienteDAO().consultaCpfPac("40719144833"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
