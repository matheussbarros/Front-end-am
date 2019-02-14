package br.com.fiap.teste;

import br.com.fiap.beans.Acompanhamento;
import br.com.fiap.beans.Medico;
import br.com.fiap.beans.Paciente;
import br.com.fiap.bo.AcompanhamentoBO;
import br.com.fiap.bo.PacienteBO;

public class TesteGravarPacienteBO {

	public static void main(String[] args) {
		
		
		try {
			
			
			
			//System.out.println(PacienteBO.novoPaciente
				//	(new Paciente(772, "Matheus", "email@email", "senha", "11961962282", 3, "40119144833", "26/05/1991")));
			
			
			System.out.println(AcompanhamentoBO.novoAcomp(new Acompanhamento
					(99, "Acomp Teste", "Desc Test", "10/10/2018", "15/10/2018", 
							new Paciente(599, "Matheus", "em@il", "1346", "656565", 3, "595959", "29/09/1991"),
							new Medico(85, "DrTeste Acomp", "Email@testAcom", "Acomp", "987984564", 2, 13245, "Clinico"))));
			
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
