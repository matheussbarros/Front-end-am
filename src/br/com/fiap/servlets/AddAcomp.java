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

import br.com.fiap.beans.Acompanhamento;
import br.com.fiap.beans.Medico;
import br.com.fiap.beans.Paciente;
import br.com.fiap.bo.AcompanhamentoBO;
import br.com.fiap.bo.MedicoBO;
import br.com.fiap.bo.PacienteBO;


@WebServlet(urlPatterns = "/AddAcomp")
public class AddAcomp extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter wr = resp.getWriter();
		
		try {
			
			/*nome,codPaciente,codAcomp,codMedico,descricao
			 * 
			 * */
			
			String nome = req.getParameter("nome");
			String descricao = req.getParameter("descricao");
			String abertura = req.getParameter("abertura");
			String encerramento = req.getParameter("encerramento");
			int codPaciente = Integer.parseInt(req.getParameter("codPaciente"));
			int codAcomp = Integer.parseInt(req.getParameter("codAcomp"));
			int codMedico = Integer.parseInt(req.getParameter("codMedico"));
			
			Paciente paciente = PacienteBO.consultar(codPaciente);
			Medico medico = MedicoBO.consultar(codMedico);
			Acompanhamento acomp = new Acompanhamento(codAcomp, nome, descricao, abertura, encerramento, paciente, medico);
			
			
			AcompanhamentoBO.novoAcomp(acomp);
			
			Cookie newAcomp = new Cookie("newAcomp", "AcompAberto");
			newAcomp.setMaxAge(10);
			resp.addCookie(newAcomp);
			
			RequestDispatcher rd = req.getRequestDispatcher("admin-medico.jsp");
			rd.forward(req, resp);
			
			//wr.println(msg);
			
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
		}
		
		
		
	}
	
	

}
