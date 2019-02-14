package br.com.fiap.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.beans.Usuario;
import br.com.fiap.bo.UsuarioBO;


@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter wr = resp.getWriter();

		try {

			String usuario = req.getParameter("username");
			String senha = req.getParameter("senha");

			//UsuarioDAO userDao = new UsuarioDAO();
			Usuario user = UsuarioBO.efetuaLogin(usuario, senha);
			
			//wr.println("<p>Usuario" + user.getNome() + " Existe</p>");

			HttpSession session = req.getSession();
			session.setAttribute("user", user);

			if (usuario.equals(user.getEmail()) && senha.equals(user.getSenha())) {
				if (user.getNivel() == 2) {
					//resp.sendRedirect("admin-medico.jsp");
					
					  RequestDispatcher rd = req.getRequestDispatcher("admin-medico.jsp");
					  rd.forward(req, resp);
					 
				} else if (user.getNivel() == 3) {
					//resp.sendRedirect("admin-paciente.jsp");
					
					 RequestDispatcher rd = req.getRequestDispatcher("admin-paciente.jsp");
					 rd.forward(req, resp);
					
				} else {
					//resp.sendRedirect("super-admin.jsp");
					
					  RequestDispatcher rd = req.getRequestDispatcher("super-admin.jsp");
					  rd.forward(req, resp);
					 
				}
			} else {
				wr.print("Sorry UserName or Password Error!");
				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);
			}

			//userDao.fechar();
		} catch (Exception ex) {

			ex.printStackTrace();
		}

	}

}
