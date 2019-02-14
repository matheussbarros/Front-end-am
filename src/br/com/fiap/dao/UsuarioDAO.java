package br.com.fiap.dao;

/**
 * Está classe manipula a tabela T_SAP_USUARIO,
 * onde possui métodos de cadastrar, consultar, atualizar e deletar
 * @author Guilherme
 * @author Matheus 
 * @version 1.0
 * @since 1.0
 * @see Usuario
 * @see UsuarioBO
 * 
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.beans.Usuario;
import br.com.fiap.conexao.Conexao;

public class UsuarioDAO {

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
	public UsuarioDAO() throws Exception {
		con = new Conexao().conectar();
	}

	/**
	 * Responsável por adicionar uma linha na tabela T_SAP_USUARIO
	 * 
	 * @param usu
	 *            Recebe um objeto do tipo Usuario Bens
	 * @return Uma string com a mensagem de confirmação
	 * @throws Excepiton
	 *             chamada da exceção checked
	 * @author Guilherme
	 * @author Matheus
	 */
	public String gravar(Usuario usu) throws Exception {

		stmt = con.prepareStatement("INSERT INTO T_SAP_USUARIO (CD_USUARIO,NM_USUARIO, DS_EMAIL, DS_SENHA, NR_FONE, NVL_ACESSO)" + 
				"VALUES (?,?,?,?,?,?) ");
		stmt.setInt(1, usu.getCod());
		stmt.setString(2, usu.getNome());
		stmt.setString(3, usu.getEmail());
		stmt.setString(4, usu.getSenha());
		stmt.setString(5, usu.getFone());
		stmt.setInt(6, usu.getNivel());

		stmt.executeUpdate();
		this.fechar();
		return "Cadastrado com sucesso!!";

	}

	
	/**
	 * Responsável por realizar uma consulta na tabela T_SAP_USUARIO
	 * 
	 * @param id
	 *            Recebe um tipo int
	 * @return new Usuario()
	 * @throws Excepiton
	 *             chamada da exceção checked
	 * @author Guilherme
	 * @author Matheus
	 */	
	public Usuario consultarUsuario(int id) throws Exception {
		stmt = con.prepareStatement("SELECT * FROM T_SAP_USUARIO WHERE CD_USUARIO= ?");
		stmt.setInt(1, id);
		rs = stmt.executeQuery();
		if (rs.next()) {
			return (new Usuario(rs.getInt("CD_USUARIO"), rs.getString("NM_USUARIO"), rs.getString("DS_EMAIL"),
					rs.getString("DS_SENHA"), rs.getString("NR_FONE"), rs.getInt("NVL_ACESSO")));
		} else {

			return new Usuario();
		}

	}

	
	/**
	 * Responsável por atualizar uma linha na tabela T_SAP_USUARIO
	 * 
	 * @param usu
	 *            Recebe um objeto do tipo Usuario Bens
	 * @return Uma string com a mensagem de confirmação
	 * @throws Excepiton
	 *             chamada da exceção checked
	 * @author Guilherme
	 * @author Matheus
	 */
	public String atualizar(Usuario usu) throws Exception {

		stmt = con.prepareStatement("UPDATE T_SAP_USUARIO SET " + "NM_USUARIO=?," + "DS_EMAIL=?," + "DS_SENHA=?,"
				+ "NR_FONE=?," + "NVL_ACESSO=?" + "WHERE CD_USUARIO=?");

		stmt.setString(1, usu.getNome());
		stmt.setString(2, usu.getEmail());
		stmt.setString(3, usu.getSenha());
		stmt.setString(4, usu.getFone());
		stmt.setInt(5, usu.getNivel());

		stmt.executeUpdate();

		return "Atualizado com sucesso!";
	}

	/**
	 * Responsável por realizar login do usuario no sistema
	 * 
	 * @param user
	 *            Recebe uma string contendo o email
	 * @param pass Recebe uma String contendo a senha           
	 * @return Uma string com a mensagem de confirmação
	 * @throws Excepiton
	 *             chamada da exceção checked
	 * @author Guilherme
	 * @author Matheus
	 */
	public Usuario loginUsuario(String user, String pass) throws Exception {

		stmt = con.prepareStatement("SELECT * FROM T_SAP_USUARIO WHERE DS_EMAIL = ? AND DS_SENHA = ? ");

		stmt.setString(1, user);
		stmt.setString(2, pass);

		rs = stmt.executeQuery();
		
		if (rs.next()) {
			return (new Usuario(rs.getInt("CD_USUARIO"), rs.getString("NM_USUARIO"), rs.getString("DS_EMAIL"),
					rs.getString("DS_SENHA"), rs.getString("NR_FONE"), rs.getInt("NVL_ACESSO")));
		} else {

			return new Usuario();

		}

	}

	
	/**
	 * Responsável por deletar uma linha na tabela T_SAP_USUARIO
	 * 
	 * @param cod
	 *            Recebe um tipo int
	 * @return atualização da tabela
	 * @throws Excepiton
	 *             chamada da exceção checked
	 * @author Guilherme
	 * @author Matheus
	 */
	public String deletar(int cod) throws Exception {

		stmt = con.prepareStatement("DELETE FROM T_SAP_USUARIO WHERE CD_USUARIO= ?");
		stmt.setInt(1, cod);
		stmt.executeUpdate();
		return "Usuario com Cod: "+ cod +" Excluido";
	}
	
	
	/**
	 * Responsável por verificar se o email ja existe na T_SAP_USUARIO
	 * 
	 * @param email
	 *            Recebe uma String
	 * @return Boolean
	 * @throws Excepiton
	 *             chamada da exceção checked
	 * @author Guilherme
	 * @author Matheus
	 */
	public boolean consultaEmail(String email) throws Exception {

		stmt = con.prepareStatement("SELECT * FROM T_SAP_USUARIO WHERE DS_EMAIL = ?");
		stmt.setString(1, email);
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
