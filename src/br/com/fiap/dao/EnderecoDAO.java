package br.com.fiap.dao;
/**
 * Está classe manipula a tabela T_SAP_ENDERECO,
 * onde possui métodos de cadastrar, consultar, atualizar e deletar
 * @author Guilherme
 * @author Matheus 
 * @version 1.0
 * @since 1.0
 * @see Endereco
 * @see EnderecoBO
 * 
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.beans.Endereco;
import br.com.fiap.beans.Usuario;
import br.com.fiap.conexao.Conexao;

public class EnderecoDAO {

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
	public EnderecoDAO() throws Exception {		
		con = new Conexao().conectar();		
	}
	
	/**
	 * Responsável por adicionar uma linha na tabela T_SAP_ENDERECO
	 * 
	 * @param end
	 *            Recebe um objeto do tipo Endereco Bens
	 * @return Uma string com a mensagem de confirmação
	 * @throws Excepiton
	 *             chamada da exceção checked
	 * @author Guilherme
	 * @author Matheus
	 */	
	public String gravar(Endereco end) throws Exception{
		
		stmt = con.prepareStatement("INSERT INTO t_sap_endereco "
				+ "(cd_endereco,cd_usuario,ds_logradouro,nm_bairro,nr_endereco,nr_cep,nm_cidade,nm_estado)" + 
				"VALUES (?,?,?,?,?,?,?,?)");
		
		stmt.setInt(1, end.getCod());
		stmt.setInt(2, end.getUsuario().getCod());
		stmt.setString(3, end.getLogradouro());
		stmt.setString(4, end.getBairro());
		stmt.setInt(5, end.getNumero());
		stmt.setInt(6, end.getCep());
		stmt.setString(7, end.getCidade());
		stmt.setString(8, end.getEstado());
		
		stmt.executeUpdate();
		
		return "Cadastrado com sucesso!";	
		
	}
	
	
	/**
	 * Responsável por realizar uma consulta na tabela T_SAP_ENDERECO
	 * 
	 * @param id
	 *            Recebe um tipo int
	 * @return new Usuario()
	 * @throws Excepiton
	 *             chamada da exceção checked
	 * @author Guilherme
	 * @author Matheus
	 */	
	public Endereco consultarEndereco (int id) throws Exception {
		stmt = con.prepareStatement("SELECT * FROM T_SAP_ENDERECO " + 
				"INNER JOIN T_SAP_USUARIO ON (T_SAP_USUARIO.CD_USUARIO=T_SAP_ENDERECO.CD_ENDERECO) " + 
				"WHERE T_SAP_ENDERECO.CD_ENDERECO=?");
		stmt.setInt(1, id);
		
		stmt.executeQuery();
		rs = null;
		rs = stmt.executeQuery();

		if (rs.next()) {
			return new Endereco(
					rs.getInt("CD_ENDERECO"),
					rs.getString("DS_LOGRADOURO"),
					rs.getInt("NM_BAIRRO"),
					rs.getString("NR_CEP"),
					rs.getString("NR_ENDERECO"),
					rs.getString("NM_CIDADE"),
					rs.getInt("NM_ESTADO"),
					new Usuario(
							rs.getInt("CD_USUARIO"),
							rs.getString("NM_USUARIO"),
							rs.getString("DS_EMAIL"),
							rs.getString("DS_SENHA"),
							rs.getString("NR_FONE"),
							rs.getInt("NVL_ACESSO"))
					);
		} else {
			return new Endereco();
		}
	}

	
	 /**
	 * Responsável por atualizar uma linha na tabela T_SAP_ENDERECO
	 * 
	 * @param end
	 *            Recebe um objeto do tipo Endereco Bens
	 * @return Uma string com a mensagem de confirmação
	 * @throws Excepiton
	 *             chamada da exceção checked
	 * @author Guilherme
	 * @author Matheus
	 */
	public String atualizar(Endereco end) throws Exception {

		stmt = con.prepareStatement("UPDATE T_SAP_ENDERECO SET DS_LOGRADOURO=?,NM_BAIRRO=?,NR_CEP=?,NR_ENDERECO=?,NM_CIDADE=?,NM_ESTADO=? " + 
				"WHERE CD_ENDERECO=?");

		stmt.setInt(1, end.getCod());
		stmt.setString(2, end.getLogradouro());
		stmt.setString(3, end.getBairro());
		stmt.setInt(4, end.getCep());
		stmt.setInt(5, end.getNumero());
		stmt.setString(6, end.getCidade());
		stmt.setString(7, end.getEstado());

		stmt.executeUpdate();

		return "Atualizado com sucesso";

	}

	/**
	 * Responsável por deletar um endereco na tabela T_SAP_ENDERECO 
	 * com base o COD de usuario
	 * 
	 * @param numero
	 *            Recebe um tipo int
	 * @return atualização da tabela
	 * @throws Excepiton
	 *             chamada da exceção checked
	 * @author Guilherme
	 * @author Matheus
	 */	
	public String deletar(int numero) throws Exception {

		stmt = con.prepareStatement("DELETE FROM T_SAP_ENDERECO WHERE CD_USUARIO=?");
		stmt.setInt(1, numero);
		stmt.executeUpdate();
		
		return "Endereco do Usuario: "+ numero +" Excluido";
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
