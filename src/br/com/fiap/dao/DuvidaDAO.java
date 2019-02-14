package br.com.fiap.dao;

/**
 * Está classe manipula a tabela T_SAP_DUVIDA,
 * onde possui métodos de cadastrar, consultar, atualizar e deletar
 * @author Guilherme
 * @author Matheus 
 * @version 1.0
 * @since 1.0
 * @see Duvida
 * @see DuvidaBO
 * 
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.ResultSet;

import br.com.fiap.beans.Acompanhamento;
import br.com.fiap.beans.Duvida;
import br.com.fiap.beans.Medico;
import br.com.fiap.beans.Paciente;
import br.com.fiap.conexao.Conexao;

public class DuvidaDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	/**
	 * Neste método construtor, estabelecemos a comunicação com o banco
	 * 
	 * @author Guilherme
	 * @author Matheus
	 * @param não
	 *            possui parâmetos
	 * @return não há retorno
	 * @throws Exception
	 *             chamada da exceção ckecked SQLException
	 */
	public DuvidaDAO() throws Exception {
		con = new Conexao().conectar();
	}

	/**
	 * Responsável por adicionar uma linha na tabela T_SAP_DUVIDA
	 * 
	 * @param du
	 *            Recebe um objeto do tipo Duvida Bens
	 * @return Uma string com a mensagem de confirmação
	 * @throws Excepiton
	 *             chamada da exceção checked
	 * @author Guilherme
	 * @author Matheus
	 */
	public String gravar(Duvida du) throws Exception {

		stmt = con.prepareStatement(
				"INSERT INTO T_SAP_DUVIDA (CD_DUVIDA, CD_ACOMPANHAMENTO, CD_MEDICO, CD_PACIENTE, DS_DUVIDA, TX_RESPOSTA)"
						+ "VALUES(?,?,?,?,?,?)");

		stmt.setInt(1, du.getCod());
		stmt.setInt(2, du.getAcomp().getCod());
		stmt.setInt(3, du.getMedico().getCod());
		stmt.setInt(4, du.getPaciente().getCod());
		stmt.setString(5, du.getDescricao());
		stmt.setString(6, du.getResposta());

		stmt.executeUpdate();

		return "Duvida Adicionada com sucesso!";

	}

	/**
	 * Responsável por realizar uma consulta na tabela T_SAP_DUVIDA
	 * 
	 * @param id
	 *            Recebe um tipo int
	 * @return new Usuario()
	 * @throws Excepiton
	 *             chamada da exceção checked
	 * @author Guilherme
	 * @author Matheus
	 */
	public Duvida consultarDuvida(int id) throws Exception {

		stmt = con.prepareStatement("SELECT * FROM T_SAP_DUVIDA " + "WHERE CD_DUVIDA=?");
		stmt.setInt(1, id);
		rs = stmt.executeQuery();

		if (rs.next()) {

			return new Duvida(rs.getInt("CD_DUVIDA"), rs.getString("DS_DUVIDA"), rs.getString("TX_RESPOSTA"),
					new Acompanhamento(rs.getInt("CD_ACOMPANHAMENTO"), rs.getString("NM_ACOMPANHAMENTO"),
							rs.getString("DS_ACOMPANHAMENTO"), rs.getString("DT_ABERTURA"),
							rs.getString("DT_ENCERRAMENTO"),
							new Paciente(rs.getInt("CD_PACIENTE"), rs.getString("NM_USUARIO"), rs.getString("DS_EMAIL"),
									rs.getString("DS_SENHA"), rs.getString("NR_FONE"), rs.getInt("NVL_ACESSO"),
									rs.getString("NR_CPF"), rs.getString("DT_NASCIMENTO")),
							new Medico(rs.getInt("CD_MEDICO"), rs.getString("NM_USUARIO"), rs.getString("DS_EMAIL"),
									rs.getString("DS_SENHA"), rs.getString("NR_FONE"), rs.getInt("NVL_ACESSO"),
									rs.getInt("NR_CRM"), rs.getString("DS_ESPECIALIDADE"))),
					new Medico(rs.getInt("CD_MEDICO"), rs.getString("NM_USUARIO"), rs.getString("DS_EMAIL"),
							rs.getString("DS_SENHA"), rs.getString("NR_FONE"), rs.getInt("NVL_ACESSO"),
							rs.getInt("NR_CRM"), rs.getString("DS_ESPECIALIDADE")),
					new Paciente(rs.getInt("CD_PACIENTE"), rs.getString("NM_USUARIO"), rs.getString("DS_EMAIL"),
							rs.getString("DS_SENHA"), rs.getString("NR_FONE"), rs.getInt("NVL_ACESSO"),
							rs.getString("NR_CPF"), rs.getString("DT_NASCIMENTO")));

		} else {
			return new Duvida();
		}

	}

	/**
	 * Responsável por atualizar uma linha na tabela T_SAP_DUVIDA
	 * 
	 * @param du
	 *            Recebe um objeto do tipo Duvida Bens
	 * @return Uma string com a mensagem de confirmação
	 * @throws Excepiton
	 *             chamada da exceção checked
	 * @author Guilherme
	 * @author Matheus
	 */

	public String atualiza(Duvida du) throws Exception {

		stmt = con.prepareStatement(
				"UPDATE T_SAP_DUVIDA SET CD_DUVIDA=?,CD_ACOMPANHAMENTO=?,CD_MEDICO=?,CD_PACIENTE=?,DS_DUVIDA=?,TX_RESPOSTA=? "
						+ "WHERE CD_DUVIDA=?");

		stmt.setInt(1, du.getCod());
		stmt.setInt(2, du.getAcomp().getCod());
		stmt.setInt(3, du.getMedico().getCod());
		stmt.setInt(4, du.getPaciente().getCod());
		stmt.setString(5, du.getDescricao());
		stmt.setString(6, du.getResposta());

		stmt.executeUpdate();

		return "Atualizado com sucesso!";

	}
	
	public boolean checarDuvida(int cod) throws Exception {
		stmt = con.prepareStatement("SELECT * FROM  T_SAP_DUVIDA WHERE CD_ACOMPANHAMENTO = ?");
		stmt.setInt(1, cod);
		rs = stmt.executeQuery();
		if (rs.next()) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Responsável por deletar uma linha na tabela T_SAP_DUVIDA
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

		stmt = con.prepareStatement("DELETE FROM T_SAP_DUVIDA WHERE CD_DUVIDA=?");
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
