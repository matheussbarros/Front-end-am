package br.com.fiap.teste;

import br.com.fiap.beans.Acompanhamento;
import br.com.fiap.beans.Endereco;
import br.com.fiap.beans.Medico;
import br.com.fiap.beans.Paciente;
import br.com.fiap.beans.Usuario;
import br.com.fiap.bo.AcompanhamentoBO;
import br.com.fiap.bo.EnderecoBO;
import br.com.fiap.bo.PacienteBO;
import br.com.fiap.bo.UsuarioBO;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.excecao.Excecao;

public class TesteGravarUser {

	public static void main(String[] args) {

		try {

			//Usuario user = new Usuario(50,"Matheus", "em@il.com", "123qwe", "987654321", 3);

			//UsuarioDAO dao = new UsuarioDAO();

			//System.out.println(UsuarioBO.novoUsuario(new Usuario(591,"Matheus", "esdm@il01.com", "123qwe", "927654321", 3)));
			//System.out.println(PacienteBO.novoPaciente(new Paciente(591,"Matheus", "esdm@il01.com", "123qwe", "907654321", 3, "41147646", "26/0/1991")));
			
			
			//System.out.println(EnderecoBO.novoEndereco(new Endereco("Rua Teste", 99, "Bairro teste", "Cidade","estado", 2313564, new Usuario(599,"Matheus", "esdm@il.com", "123qwe", "987654321", 3))));

			//System.out.println(AcompanhamentoBO.novoAcomp(new Acompanhamento(15, "Dores", "Paciente com dores", "10/10/2018", "20-10/2018",
					//new Paciente(3), new Medico(10))));
			
			
		} catch (Exception e) {

			e.printStackTrace();

			System.out.println(Excecao.tratarExcecao(e));

		}

	}

}
