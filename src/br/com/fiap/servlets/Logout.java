package br.com.fiap.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;

@WebServlet(urlPatterns = "/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter wr = resp.getWriter();

		wr.println("Usuario Deslogou");
		

		resp.setContentType("text/html");
		HttpSession session = req.getSession();

		if (session != null) {
			session.invalidate();
		}
		resp.sendRedirect("login.jsp");

		// wr.println("User=" + session.getAttribute("user"));

	}

}
