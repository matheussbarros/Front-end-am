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

import br.com.fiap.bo.EnderecoBO;
import br.com.fiap.bo.MedicoBO;
import br.com.fiap.bo.PacienteBO;
import br.com.fiap.bo.UsuarioBO;


@WebServlet(urlPatterns = "/deleteUser")
public class DeletaUser extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter wr = resp.getWriter();
		
		try {
			
			int cod =Integer.parseInt(req.getParameter("cod"));			
			int nivel = Integer.parseInt(req.getParameter("nvl"));			
			
			wr.println("Deletar usuario " + cod);
			String msg = (UsuarioBO.deletaUsuario(cod, nivel));
			
			/*if(nivel == 2) {
				String msgMed = MedicoBO.deletaMedico(cod);				
				wr.println(msgMed);
			}else if(nivel == 3) {
				String msgPac = PacienteBO.deletaPaciente(cod);				
				wr.println(msgPac);
			}*/
			
			//wr.println(EnderecoBO.deletaEndereco(cod));			
			//wr.println(UsuarioBO.deletaUsuario(cod));
			if(msg.equalsIgnoreCase("Error")) {
				Cookie delUser = new Cookie("NotDelUser", "UsuarioNaoDeletado");
				delUser.setMaxAge(10);
				resp.addCookie(delUser);
			}else {
				Cookie delUser = new Cookie("delUser", "UsuarioDeletado");
				delUser.setMaxAge(10);
				resp.addCookie(delUser);
				
			}
			
			
			
			 RequestDispatcher rd = req.getRequestDispatcher("super-admin.jsp");
			  rd.forward(req, resp);
			
		}catch(Exception ex) {			
			ex.printStackTrace();
		}
		
		
		
	}

}
