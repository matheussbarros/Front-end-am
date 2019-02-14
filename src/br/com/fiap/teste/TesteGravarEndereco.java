package br.com.fiap.teste;

import br.com.fiap.beans.Endereco;
import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.EnderecoDAO;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.excecao.Excecao;

public class TesteGravarEndereco {

	public static void main(String[] args) {
		
		
		try {

			Endereco end = new Endereco("Rua teste", 123, "Bairro do teste", "cidade do teste", "Estado do teste ", 12345,
					new Usuario(17, "Nome teste", "teste@teste", "teste", "13245679", 2));
			
			EnderecoDAO dao = new EnderecoDAO();

			System.out.println(dao.gravar(end));

		} catch (Exception e) {

			e.printStackTrace();

			System.out.println(Excecao.tratarExcecao(e));

		}
		
	}
}
