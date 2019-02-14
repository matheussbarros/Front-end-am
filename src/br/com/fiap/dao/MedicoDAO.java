package br.com.fiap.dao;
/**
 * Está classe manipula a tabela T_SAP_MEDICO,
 * onde possui métodos de cadastrar, consultar, atualizar e deletar
 * @author Guilherme
 * @author Matheus 
 * @version 1.0
 * @since 1.0
 * @see Medico
 * @see MedicoBO
 * 
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Medico;
import br.com.fiap.conexao.Conexao;

public class MedicoDAO {
	
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
	public MedicoDAO() throws Exception{		
		con = new Conexao().conectar();		
	}
	
	/**
	 * Responsável por adicionar uma linha na tabela T_SAP_MEDICO
	 * 
	 * @param med
	 *            Recebe um objeto do tipo Medico Bens
	 * @return Uma string com a mensagem de confirmação
	 * @throws Excepiton
	 *             chamada da exceção checked
	 * @author Guilherme
	 * @author Matheus
	 */	
	public String gravar (Medico med) throws Exception{
		 stmt = con.prepareStatement("INSERT INTO  t_sap_medico  (cd_medico,nr_crm,ds_especialidade)" + 
		 		"VALUES (?,?,?)");
		
		 stmt.setInt(1, med.getCod());
		 stmt.setInt(2, med.getCrm());
		 stmt.setString(3, med.getEspecialidade());
		 
		 stmt.executeUpdate();
		 this.fechar();
		return "Cadastrado com sucesso!";
		
	}
	
	/**
	 * Responsável por realizar uma consulta na tabela T_SAP_MEDICO
	 * 
	 * @param id
	 *            Recebe um tipo int
	 * @return new Usuario()
	 * @throws Excepiton
	 *             chamada da exceção checked
	 * @author Guilherme
	 * @author Matheus
	 */	
	public Medico consultarMedico(int id) throws Exception {
		stmt = con.prepareStatement("SELECT T_SAP_USUARIO.CD_USUARIO," + 
				"       T_SAP_USUARIO.NM_USUARIO," + 
				"       T_SAP_USUARIO.DS_EMAIL," + 
				"       T_SAP_USUARIO.DS_SENHA," + 
				"       T_SAP_USUARIO.NR_FONE," + 
				"       T_SAP_USUARIO.NVL_ACESSO," + 
				"       T_SAP_MEDICO.CD_MEDICO," + 
				"       T_SAP_MEDICO.NR_CRM," + 
				"       T_SAP_MEDICO.DS_ESPECIALIDADE " + 
				"FROM T_SAP_MEDICO INNER JOIN T_SAP_USUARIO ON (T_SAP_USUARIO.CD_USUARIO=T_SAP_MEDICO.CD_MEDICO)\r\n" + 
				"WHERE T_SAP_MEDICO.CD_MEDICO=?");
		stmt.setInt(1, id);

		stmt.executeQuery();
		rs = null;
		rs = stmt.executeQuery();

		if (rs.next()) {
			return new Medico(rs.getInt("CD_MEDICO"),
							  rs.getString("NM_USUARIO"),
							  rs.getString("DS_EMAIL"),
							  rs.getString("DS_SENHA"),
							  rs.getString("NR_FONE"),
							  rs.getInt("NVL_ACESSO"),
							  rs.getInt("NR_CRM"),
							  rs.getString("DS_ESPECIALIDADE"));
		} else {
			return new Medico();
		}
	}
	
	public int cunsultaCrmMed(int crm) throws Exception{
		stmt= con.prepareStatement("SELECT NR_CRM  FROM T_SAP_MEDICO WHERE NR_CRM = ?");
		stmt.setInt(1, crm);
		rs = stmt.executeQuery();
		if (rs.next()) {
			return rs.getInt("NR_CRM");	
		}else {
			return 0;	
		}
		
		
	}
	
	
	/**
	 * Responsável por criar um List de Medicos
	 * 
	 * @param  não possui
	 * @return listaMedico
	 * @throws Excepiton
	 *             chamada da exceção checked
	 * @author Guilherme
	 * @author Matheus
	 */	
	public List<Medico> listarMedico() throws Exception {
		
		List<Medico> listaMedico =  new ArrayList<>();
		stmt = con.prepareStatement("SELECT * FROM T_SAP_MEDICO INNER JOIN T_SAP_USUARIO ON "
				+ "(T_SAP_MEDICO.CD_MEDICO = T_SAP_USUARIO.CD_USUARIO) ORDER BY T_SAP_USUARIO.NM_USUARIO");
	
		rs = stmt.executeQuery();

		while (rs.next()) {
			listaMedico.add(new Medico(rs.getInt("CD_MEDICO"),
					  rs.getString("NM_USUARIO"),
					  rs.getString("DS_EMAIL"),
					  rs.getString("DS_SENHA"),
					  rs.getString("NR_FONE"),
					  rs.getInt("NVL_ACESSO"),
					  rs.getInt("NR_CRM"),
					  rs.getString("DS_ESPECIALIDADE")));
			
		} 
		
		return listaMedico;
	}
	
	
	/**
	 * Responsável por atualizar uma linha na tabela T_SAP_MEDICO
	 * 
	 * @param med
	 *            Recebe um objeto do tipo Medico Bens
	 * @return Uma string com a mensagem de confirmação
	 * @throws Excepiton
	 *             chamada da exceção checked
	 * @author Guilherme
	 * @author Matheus
	 */
	public String atualiza(Medico med) throws Exception{		
		stmt = con.prepareStatement("");
		stmt.executeUpdate();		
		return "Atualizado com sucesso";	
	}
	
	
	
	/**
	 * Responsável por deletar uma linha na tabela T_SAP_MEDICO
	 * 
	 * @param numero
	 *            Recebe um tipo int
	 * @return atualização da tabela
	 * @throws Excepiton
	 *             chamada da exceção checked
	 * @author Guilherme
	 * @author Matheus
	 */
	public String deletar(int cod) throws Exception{
		
		stmt = con.prepareStatement("DELETE FROM T_SAP_MEDICO WHERE CD_MEDICO=?");
		stmt.setInt(1, cod);
		 stmt.executeUpdate();	
		return "Medico com Cod: "+ cod +" Excluido";
		
		
		
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


