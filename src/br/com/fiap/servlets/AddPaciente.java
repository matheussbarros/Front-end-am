package br.com.fiap.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.beans.Endereco;
import br.com.fiap.beans.Paciente;
import br.com.fiap.beans.Usuario;
import br.com.fiap.bo.EnderecoBO;
import br.com.fiap.bo.PacienteBO;
import br.com.fiap.bo.UsuarioBO;

@WebServlet(urlPatterns = "/addPaciente")
public class AddPaciente extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter wr = resp.getWriter();
		
		try {
			
			// Dados de T_SAP_USUARIO
			String nome = req.getParameter("nome");
			String email = req.getParameter("email");
			String senha = req.getParameter("senha");
			String fone = req.getParameter("fone");
			int cod = Integer.parseInt(req.getParameter("cod"));
			// Dados para T_SAP_Paciente
			String cpf = req.getParameter("cpf");
			String nacimento = req.getParameter("dt-nasc");
			// Dados de T_SAP_ENDERECO
			String log = req.getParameter("logradouro");
			int numero = Integer.parseInt(req.getParameter("numero"));
			int cep = Integer.parseInt(req.getParameter("cep"));
			String bairro = req.getParameter("bairro");
			String cidade = req.getParameter("cidade");
			String estado = req.getParameter("estado");
			
			Usuario usuario = new Usuario(cod, nome, email, senha, fone, 3);
			Paciente paciente = new Paciente(cod, nome, email, senha, fone, 3, cpf, nacimento);
			Endereco endereco = new Endereco(log, numero, bairro, cidade, estado, cep, usuario);
			
			UsuarioBO.novoUsuario(usuario);
			EnderecoBO.novoEndereco(endereco);
			PacienteBO.novoPaciente(paciente);
			
		
			Cookie newUser = new Cookie("newUser", "Usuario");
			newUser.setMaxAge(10);
			resp.addCookie(newUser);
			

			wr.println(usuario.getCod());
			wr.println(paciente.getCod());
			wr.println("Usuario Gravado com Sucesso");
			
	
			
			 RequestDispatcher rd = req.getRequestDispatcher("super-admin.jsp");
			  rd.forward(req, resp);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	}
	
	

}
