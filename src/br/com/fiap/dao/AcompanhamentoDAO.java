package br.com.fiap.dao;

/**
 * Está classe manipula a tabela T_SAP_ACOMPANHAMENTO,
 * onde possui métodos de cadastrar, consultar, atualizar e deletar
 * @author Guilherme
 * @author Matheus 
 * @version 1.0
 * @since 1.0
 * @see Acompanhamento
 * @see AcompanhamentoBO
 * 
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Acompanhamento;
import br.com.fiap.beans.Medico;
import br.com.fiap.beans.Paciente;
import br.com.fiap.conexao.Conexao;

public class AcompanhamentoDAO {
	
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	
	
	
	/**
	 * Neste método construtor, estabelecemos a comunicação com o banco
	 * 
	 * @author Guilherme
	 * @author Matheus
	 * @param não possui parâmetos
	 * @return não há retorno
	 * @throws Exception chamada da exceção ckecked SQLException
	 */
	public AcompanhamentoDAO() throws Exception{
		
		con = new Conexao().conectar();
	}
	
	/**
	 * Responsável por criar uma lista da tabela T_SAP_ACOMPANHAMENTO com base no COD do Medico
	 * 
	 * @param cod
	 *            Recebe um Cod do Medico
	 * @return Uma Lista de Acompanhamentos
	 * @throws Excepiton
	 *             chamada da exceção checked
	 * @author Guilherme
	 * @author Matheus
	 */
	public List<Acompanhamento> listaAcompMed(int cod) throws Exception {
		   List<Acompanhamento> lista = new ArrayList<Acompanhamento>();
		   stmt= con.prepareStatement("SELECT *" + 
		   		" FROM T_SAP_ACOMPANHAMENTO   INNER JOIN T_SAP_MEDICO ON" + 
		   		"(T_SAP_ACOMPANHAMENTO.CD_MEDICO = T_SAP_MEDICO.CD_MEDICO ) where T_SAP_ACOMPANHAMENTO.CD_MEDICO = ? ");
		   stmt.setInt(1, cod);
		   
		   rs = stmt.executeQuery();
		   
		   while(rs.next()) {
			   lista.add(new Acompanhamento(rs.getInt("CD_ACOMPANHAMENTO"), rs.getString("NM_ACOMPANHAMENTO"), rs.getString("DS_ACOMPANHAMENTO"), rs.getString("DT_ABERTURA"), rs.getString("DT_ENCERRAMENTO"),
					   new Paciente(rs.getInt("CD_PACIENTE")),
					   new Medico(rs.getInt("CD_MEDICO")))); 
			   
		   }
		   
		   return lista;
	
	}
	
	
	/**
	 * Responsável por criar uma lista da tabela T_SAP_ACOMPANHAMENTO com base no COD do Paciente
	 * 
	 * @param cod
	 *            Recebe um Cod do Paciente
	 * @return Uma Lista de Acompanhamentos
	 * @throws Excepiton
	 *             chamada da exceção checked
	 * @author Guilherme
	 * @author Matheus
	 */
	public List<Acompanhamento> listaAcompPac(int cod) throws Exception {
		   List<Acompanhamento> lista = new ArrayList<Acompanhamento>();
		   stmt= con.prepareStatement("SELECT * " + 
		   		" FROM T_SAP_ACOMPANHAMENTO   INNER JOIN T_SAP_PACIENTE ON " + 
		   		"(T_SAP_ACOMPANHAMENTO.CD_PACIENTE = T_SAP_PACIENTE.CD_PACIENTE ) where T_SAP_ACOMPANHAMENTO.CD_PACIENTE = ? ");
		   stmt.setInt(1, cod);
		   
		   rs = stmt.executeQuery();
		   
		   while(rs.next()) {
			   lista.add(new Acompanhamento(rs.getInt("CD_ACOMPANHAMENTO"), rs.getString("NM_ACOMPANHAMENTO"), rs.getString("DS_ACOMPANHAMENTO"), rs.getString("DT_ABERTURA"), rs.getString("DT_ENCERRAMENTO"),
					   new Paciente(rs.getInt("CD_PACIENTE")),
					   new Medico(rs.getInt("CD_MEDICO")))); 
			   
		   }
		   
		   return lista;
	
	}
	
	
	/**
	 * Responsável por adicionar uma linha na tabela T_SAP_ACOMPANHAMENTO
	 * 
	 * @param acomp
	 *            Recebe um objeto do tipo Acompanhamento Bens
	 * @return Uma string com a mensagem de confirmação
	 * @throws Excepiton
	 *             chamada da exceção checked
	 * @author Guilherme
	 * @author Matheus
	 */
	
	public String gravar(Acompanhamento acomp) throws Exception {
		stmt = con.prepareStatement("INSERT INTO T_SAP_ACOMPANHAMENTO (CD_ACOMPANHAMENTO,CD_MEDICO,CD_PACIENTE,NM_ACOMPANHAMENTO,DS_ACOMPANHAMENTO,DT_ABERTURA,DT_ENCERRAMENTO)" + 
				"VALUES(?,?,?,?,?,?,?)");

		stmt.setInt(1,acomp.getCod());
		stmt.setInt(2,acomp.getMedico().getCod());
		stmt.setInt(3,acomp.getPaciente().getCod());
		stmt.setString(4,acomp.getNome());
		stmt.setString(5,acomp.getDescricao());
		stmt.setString(6,acomp.getAbertura());
		stmt.setString(7,acomp.getEncerramento());
	
		stmt.executeUpdate();

		return "Acompanhamento Cadastrado com sucesso!";

	}
	
	
	/**
	 * Responsável por realizar uma consulta na tabela T_SAP_ACOMPANHAMENTO
	 * 
	 * @param id
	 *            Recebe um tipo int
	 * @return lista 
	 * @throws Excepiton
	 *             chamada da exceção checked
	 * @author Guilherme
	 * @author Matheus
	 */
	
	public List<Acompanhamento> consultarAcompanhamento(int id) throws Exception {
		   List<Acompanhamento> lista = new ArrayList<Acompanhamento>();
		stmt = con.prepareStatement("SELECT T_SAP_ACOMPANHAMENTO.CD_ACOMPANHAMENTO," + 
				"       T_SAP_ACOMPANHAMENTO.NM_ACOMPANHAMENTO," + 
				"       T_SAP_ACOMPANHAMENTO.DS_ACOMPANHAMENTO," + 
				"       TO_CHAR (T_SAP_ACOMPANHAMENTO.DT_ABERTURA,'DD/MM/YYYY') \"DT_ABERTURA\"," + 
				"       TO_CHAR (T_SAP_ACOMPANHAMENTO.DT_ENCERRAMENTO, 'DD/MM/YYYY') \"DT_ENCERRAMENTO\"," + 
				"       T_SAP_MEDICO.CD_MEDICO," + 
				"       T_SAP_MEDICO.NR_CRM," + 
				"       T_SAP_MEDICO.DS_ESPECIALIDADE," + 
				"       T_SAP_PACIENTE.CD_PACIENTE," + 
				"       T_SAP_PACIENTE.NR_CPF," + 
				"       TO_CHAR (T_SAP_PACIENTE.DT_NASCIMENTO, 'DD/MM/YYYY') \"DT_NASCIMENTO\" " + 
				"FROM T_SAP_ACOMPANHAMENTO " + 
				"INNER JOIN T_SAP_MEDICO ON (T_SAP_MEDICO.CD_MEDICO=T_SAP_ACOMPANHAMENTO.CD_ACOMPANHAMENTO) " + 
				"INNER JOIN T_SAP_PACIENTE ON (T_SAP_PACIENTE.CD_PACIENTE=T_SAP_ACOMPANHAMENTO.CD_ACOMPANHAMENTO) " + 
				"WHERE T_SAP_ACOMPANHAMENTO.CD_ACOMPANHAMENTO=?");
		stmt.setInt(1, id);

		rs = stmt.executeQuery();

		while (rs.next()) {
			lista.add (new Acompanhamento(
							rs.getInt("CD_ACOMPANHAMENTO"),
							rs.getString("NM_ACOMPANHAMENTO"),
							rs.getString("DS_ACOMPANHAMENTO"),
							rs.getString("DT_ABERTURA"),
							rs.getString("DT_ENCERRAMENTO"),
							new Paciente(rs.getInt("CD_PACIENTE"),
									rs.getString("NM_USUARIO"),
									rs.getString("DS_EMAIL"),
									rs.getString("DS_SENHA"),
									rs.getString("NR_FONE"),
									rs.getInt("NVL_ACESSO"),
									rs.getString("NR_CPF"),
									rs.getString("DT_NASCIMENTO")),
							new Medico(rs.getInt("CD_MEDICO"),
									  rs.getString("NM_USUARIO"),
									  rs.getString("DS_EMAIL"),
									  rs.getString("DS_SENHA"),
									  rs.getString("NR_FONE"),
									  rs.getInt("NVL_ACESSO"),
									  rs.getInt("NR_CRM"),
									  rs.getString("DS_ESPECIALIDADE"))
					));
							
		} 
			return lista;
		
	}

	
	/**
	 * Responsável por atualizar uma linha na tabela T_SAP_ACOMPANHAMENTO
	 * 
	 * @param acomp
	 *            Recebe um objeto do tipo Acompanhamento Bens
	 * @return Uma string com a mensagem de confirmação
	 * @throws Excepiton
	 *             chamada da exceção checked
	 * @author Guilherme
	 * @author Matheus
	 */
	
	public String atualiza(Acompanhamento acomp) throws Exception {

		stmt = con.prepareStatement(
				"UPDATE T_SAP_ACOMPANHAMENTO SET CD_MEDICO=?,CD_PACIENTE=?,NM_ACOMPANHAMENTO=?,DS_ACOMPANHAMENTO=?,DT_ABERTURA=?,DT_ENCERRAMENTO=?"
						+ "WHERE CD_ACOMPANHAMENTO=?");

		stmt.setInt(1,acomp.getMedico().getCod());
		stmt.setInt(2,acomp.getPaciente().getCod());
		stmt.setString(3,acomp.getNome());
		stmt.setString(4,acomp.getDescricao());
		stmt.setString(5,acomp.getAbertura());
		stmt.setString(6,acomp.getEncerramento());
	

		stmt.executeUpdate();

		return "Atualizado com sucesso";

	}
	


	/**
	 * Responsável por deletar uma linha na tabela T_SAP_ACOMPANHAMENTO checando se não
	 * existe uma Duvida em aberto.
	 * 
	 * @param numero
	 *            Recebe um tipo int
	 * @return atualização da tabela
	 * @throws Excepiton
	 *             chamada da exceção checked
	 * @author Guilherme
	 * @author Matheus
	 */
	public String deletar(int cod) throws Exception {

		stmt = con.prepareStatement("DELETE FROM T_SAP_ACOMPANHAMENTO WHERE CD_ACOMPANHAMENTO=?");
		stmt.setInt(1, cod);		
		if(new DuvidaDAO().checarDuvida(cod)) {
			return "Existe Duvida em aberto, Finalise a duvida primeiro";
		}else {
			stmt.executeUpdate();
			return "Acompanhamento Exluido com Sucesso";
		}		
	}
	
	/**
	 * Responsável por checar se existe um acompanhamento em aberto com o ID do Medico
	 * 
	 * @param cod
	 *            Recebe um tipo int
	 * @return atualização da tabela
	 * @throws Excepiton
	 *             chamada da exceção checked
	 * @author Guilherme
	 * @author Matheus
	 */
	public boolean checarAcompMed(int cod) throws Exception{
		stmt = con.prepareStatement("SELECT * FROM  T_SAP_ACOMPANHAMENTO WHERE CD_MEDICO = ?");
		stmt.setInt(1, cod);
		
		rs = stmt.executeQuery();
		if(rs.next()) {
			return true;
		}else {
			return false;
		}		
	}
	
	/**
	 * Responsável por checar se existe um acompanhamento em aberto com o ID do Paciente
	 * 
	 * @param cod
	 *            Recebe um tipo int
	 * @return atualização da tabela
	 * @throws Excepiton
	 *             chamada da exceção checked
	 * @author Guilherme
	 * @author Matheus
	 */
	public boolean checarAcompPac(int cod) throws Exception{
		stmt = con.prepareStatement("SELECT * FROM  T_SAP_ACOMPANHAMENTO WHERE  CD_PACIENTE =?");
		stmt.setInt(1, cod);
		
		rs = stmt.executeQuery();
		if(rs.next()) {
			return true;
		}else {
			return false;
		}		
	}
	
	
	/**
	 * Responsável por fechar a conexão com o banco de dados
	 * @param não possui parametro
	 * @return não possui retorno
	 * @throws Excepiton
	 *             chamada da exceção checked
	 * @author Guilherme
	 * @author Matheus
	 */
	
	public void fechar() throws Exception{
		
		con.close();
	}
	

}
