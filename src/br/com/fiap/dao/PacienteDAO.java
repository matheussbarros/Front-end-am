package br.com.fiap.dao;

/**
 * Est� classe manipula a tabela T_SAP_PACIENTE,
 * onde possui m�todos de cadastrar, consultar, atualizar e deletar
 * @author Guilherme
 * @author Matheus 
 * @version 1.0
 * @since 1.0
 * @see Paciente
 * @see PacienteBO
 * 
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import br.com.fiap.beans.Paciente;
import br.com.fiap.conexao.Conexao;

public class PacienteDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	/**
	 * Neste m�todo construtor, estabelecemos a comunica��o com o banco
	 * 
	 * @author Guilherme
	 * @author Matheus
	 * @param n�o
	 *            possui par�metos
	 * @return n�o h� retorno
	 * @throws Exception
	 *             chamada da exce��o ckecked SQLException
	 */
	public PacienteDAO() throws Exception {
		con = new Conexao().conectar();
	}

	/**
	 * Respons�vel por adicionar uma linha na tabela T_SAP_PACIENTE
	 * 
	 * @param p
	 *            Recebe um objeto do tipo Paciente Bens
	 * @return Uma string com a mensagem de confirma��o
	 * @throws Excepiton
	 *             chamada da exce��o checked
	 * @author Guilherme
	 * @author Matheus
	 */
	public String gravar(Paciente p) throws Exception {

		stmt = con.prepareStatement("INSERT INTO T_SAP_PACIENTE (CD_PACIENTE,NR_CPF,DT_NASCIMENTO)" + "VALUES(?,?,?)");

		stmt.setInt(1, p.getCod());
		stmt.setString(2, p.getCpf());
		stmt.setString(3, p.getNacimento());

		stmt.executeUpdate();
		return "Cadastrado com sucesso";

	}

	/**
	 * Respons�vel por realizar uma consulta na tabela T_SAP_PACIENTE
	 * 
	 * @param id
	 *            Recebe um tipo int
	 * @return new Usuario()
	 * @throws Excepiton
	 *             chamada da exce��o checked
	 * @author Guilherme
	 * @author Matheus
	 */
	public Paciente consultarPaciente(int id) throws Exception {
		stmt = con.prepareStatement("SELECT T_SAP_USUARIO.CD_USUARIO," + "       T_SAP_USUARIO.NM_USUARIO,"
				+ "       T_SAP_USUARIO.DS_EMAIL," + "       T_SAP_USUARIO.DS_SENHA," + "       T_SAP_USUARIO.NR_FONE,"
				+ "       T_SAP_USUARIO.NVL_ACESSO," + "       T_SAP_PACIENTE.CD_PACIENTE,"
				+ "       T_SAP_PACIENTE.NR_CPF,"
				+ "       TO_CHAR (T_SAP_PACIENTE.DT_NASCIMENTO, 'DD/MM/YYYY') \"DT_NASCIMENTO\" "
				+ "FROM T_SAP_PACIENTE INNER JOIN T_SAP_USUARIO ON (T_SAP_USUARIO.CD_USUARIO=T_SAP_PACIENTE.CD_PACIENTE)\r\n"
				+ "WHERE T_SAP_PACIENTE.CD_PACIENTE=?");
		stmt.setInt(1, id);
		rs = stmt.executeQuery();

		if (rs.next()) {
			return new Paciente(rs.getInt("CD_PACIENTE"), rs.getString("NM_USUARIO"), rs.getString("DS_EMAIL"),
					rs.getString("DS_SENHA"), rs.getString("NR_FONE"), rs.getInt("NVL_ACESSO"), rs.getString("NR_CPF"),
					rs.getString("DT_NASCIMENTO"));
		} else {
			return new Paciente();
		}
	}
	
	
	
	
	/**
	 * Respons�vel por realizar uma consulta somente na tabela T_SAP_PACIENTE sem usir com o T_SAP_USUARIO
	 * 
	 * @param 
	 * @return Paciente
	 * @throws Excepiton
	 *             chamada da exce��o checked
	 * @author Guilherme
	 * @author Matheus
	 */
	public Paciente consultaTdPaciente() throws Exception {
		
		stmt = con.prepareStatement("SELECT * FROM T_SAP_PACIENTE");
		rs = stmt.executeQuery();
		if (rs.next()) {
			return new Paciente(rs.getString("NR_CPF"),rs.getString("DT_NASCIMENTO"));			
		}
				
		return  new Paciente();
		
	}
	
	/**
	 * Respons�vel por realizar uma consultar na T_SAP_PACIENTE
	 * 
	 * @param cpf
	 *            Recebe uma String
	 * @return Uma string CPF caso exista
	 * @throws Excepiton
	 *             chamada da exce��o checked
	 * @author Guilherme
	 * @author Matheus
	 */
	public String consultaCpfPac(String cpf) throws Exception{
		stmt = con.prepareStatement("SELECT NR_CPF  FROM T_SAP_PACIENTE WHERE NR_CPF = ?");
		stmt.setString(1, cpf);		
		rs = stmt.executeQuery();
		if (rs.next()) {
			String msg = rs.getString("NR_CPF");
			
			return msg;	
		}else {
			String msg = "";
		
			return msg;
			
		}
		
	}
	
	

	/**
	 * Respons�vel por atualizar uma linha na tabela T_SAP_PACIENTE
	 * 
	 * @param p
	 *            Recebe um objeto do tipo Paciente Bens
	 * @return Uma string com a mensagem de confirma��o
	 * @throws Excepiton
	 *             chamada da exce��o checked
	 * @author Guilherme
	 * @author Matheus
	 */

	public String atualizar(Paciente p) throws Exception {

		stmt = con.prepareStatement("UPDATE T_SAP_PACIENTE SET NR_CPF=?,DT_NACIMENTO=? " + "WHERE CD_PACIENTE=?");

		stmt.setString(1, p.getCpf());
		stmt.setString(2, p.getNacimento());

		stmt.executeUpdate();

		return "Atualizado com sucesso";

	}

	/**
	 * Respons�vel por criar uma Lista de Pacientes
	 * 
	 * @param 
	 * @return listaPaciente
	 * @throws Excepiton
	 *             chamada da exce��o checked
	 * @author Guilherme
	 * @author Matheus
	 */
	public List<Paciente> listarPaciente() throws Exception {

		List<Paciente> listaPaciente = new ArrayList<>();
		stmt = con.prepareStatement("SELECT * FROM T_SAP_PACIENTE INNER JOIN T_SAP_USUARIO ON "
				+ "(T_SAP_PACIENTE.CD_PACIENTE = T_SAP_USUARIO.CD_USUARIO) ORDER BY T_SAP_USUARIO.NM_USUARIO");

		rs = stmt.executeQuery();

		while (rs.next()) {
			listaPaciente.add(new Paciente(rs.getInt("CD_PACIENTE"), rs.getString("NM_USUARIO"),
					rs.getString("DS_EMAIL"), rs.getString("DS_SENHA"), rs.getString("NR_FONE"), rs.getInt("NVL_ACESSO"),
					rs.getString("NR_CPF"), rs.getString("DT_NASCIMENTO")));

		}

		return listaPaciente;
	}

	/**
	 * Respons�vel por deletar uma linha na tabela T_SAP_PACIENTE
	 * 
	 * @param numero
	 *            Recebe um tipo int
	 * @return atualiza��o da tabela
	 * @throws Excepiton
	 *             chamada da exce��o checked
	 * @author Guilherme
	 * @author Matheus
	 */

	public String deletar(int numero) throws Exception {
		stmt = con.prepareStatement("DELETE FROM T_SAP_PACIENTE WHERE CD_PACIENTE=?");
		stmt.setInt(1, numero);	
		 stmt.executeUpdate();		 			 
		 return "Paciente com Cod: "+ numero +" Excluido";
		
	}

	/**
	 * Respons�vel por fechar a conex�o com o banco de dados
	 * 
	 * @param 
	 *            possui parametro
	 * @return n�o possui retorno
	 * @throws Excepiton
	 *             chamada da exce��o checked
	 * @author Guilherme
	 * @author Matheus
	 */
	public void fechar() throws Exception {
		con.close();
	}

}
