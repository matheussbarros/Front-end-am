package br.com.fiap.dao;

/**
 * Está classe manipula a tabela T_SAP_ADMIN,
 * onde possui métodos de cadastrar, consultar, atualizar e deletar
 * @author Guilherme
 * @author Matheus 
 * @version 1.0
 * @since 1.0
 * @see Admin
 * @see AdminBO
 * 
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.beans.Admin;
import br.com.fiap.conexao.Conexao;

public class AdminDAO {

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
	public AdminDAO() throws Exception {
		con = new Conexao().conectar();
	}

	
	
	/**
	 * Responsável por adicionar uma linha na tabela T_SAP_ADMIN
	 * 
	 * @param adm
	 *            Recebe um objeto do tipo Admin Bens
	 * @return Uma string com a mensagem de confirmação
	 * @throws Excepiton
	 *             chamada da exceção checked
	 * @author Guilherme
	 * @author Matheus
	 */	
	public String gravar(Admin adm) throws Exception {
		stmt = con.prepareStatement("INSERT INTO T_SAP_ADMIN (CD_ADMIN, NM_CNPJ, NM_EMPRESA) " + 
				"VALUES (?,?,?)");

		stmt.setInt(1, adm.getCod());
		stmt.setString(2, adm.getCnpj());
		stmt.setString(3, adm.getEmpresa());

		stmt.executeUpdate();

		return "Cadastrado com sucesso!";

	}
	
	/**
	 * Responsável por realizar uma consulta na tabela T_SAP_ADMIN
	 * 
	 * @param id
	 *            Recebe um tipo int
	 * @return new Usuario()
	 * @throws Excepiton
	 *             chamada da exceção checked
	 * @author Guilherme
	 * @author Matheus
	 */	
	public Admin consultarAdmin(int id) throws Exception {
		stmt = con.prepareStatement("SELECT T_SAP_USUARIO.CD_USUARIO," + 
				"       T_SAP_USUARIO.NM_USUARIO," + 
				"       T_SAP_USUARIO.DS_EMAIL," + 
				"       T_SAP_USUARIO.DS_SENHA," + 
				"       T_SAP_USUARIO.NR_FONE," + 
				"       T_SAP_USUARIO.NVL_ACESSO," + 
				"       T_SAP_ADMIN.CD_ADMIN," + 
				"       T_SAP_ADMIN.NM_CNPJ," + 
				"       T_SAP_ADMIN.NM_EMPRESA " + 
				"FROM T_SAP_ADMIN INNER JOIN T_SAP_USUARIO ON (T_SAP_USUARIO.CD_USUARIO=T_SAP_ADMIN.CD_ADMIN)\r\n" + 
				"WHERE T_SAP_ADMIN.CD_ADMIN=?");
		stmt.setInt(1, id);


		rs = stmt.executeQuery();

		if (rs.next()) {
			return new Admin(
					rs.getInt("CD_ADMIN"),
					rs.getString("NM_USUARIO"),
					rs.getString("DS_EMAIL"),
					rs.getString("DS_SENHA"),
					rs.getString("NR_FONE"),
					rs.getInt("NVL_ACESSO"),
					rs.getString("NM_CNPJ"),
					rs.getString("NM_EMPRESA"));
		} else {
			return new Admin();
		}
	}

	
	 /**
	 * Responsável por atualizar uma linha na tabela T_SAP_ADMIN
	 * 
	 * @param adm
	 *            Recebe um objeto do tipo Admin Bens
	 * @return Uma string com a mensagem de confirmação
	 * @throws Excepiton
	 *             chamada da exceção checked
	 * @author Guilherme
	 * @author Matheus
	 */
	public String atualiza(Admin adm) throws Exception {

		stmt = con.prepareStatement("UPDATE T_SAP_ADMIN SET NM_CNPJ=?, NM_EMPRESA=?" + 
				" WHERE CD_ADMIN=?");

		stmt.setInt(1, adm.getCod());
		stmt.setString(2, adm.getCnpj());
		stmt.setString(3, adm.getEmpresa());

		stmt.executeUpdate();

		return "Atualizado com sucesso";

	}
	

	/**
	 * Responsável por deletar uma linha na tabela T_SAP_ADMIN
	 * 
	 * @param numero
	 *            Recebe um tipo int
	 * @return atualização da tabela
	 * @throws Excepiton
	 *             chamada da exceção checked
	 * @author Guilherme
	 * @author Matheus
	 */

	public int deletar(int numero) throws Exception {

		stmt = con.prepareStatement("DELETE FROM T_SAP_ADMIN WHERE CD_ADMIN=?");
		stmt.setInt(1, numero);
		return stmt.executeUpdate();
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
