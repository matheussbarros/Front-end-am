package br.com.fiap.beans;

public class Medico extends Usuario {

	private int crm;
	private String especialidade;
	
	
	public int compareTo(Medico outro) {
		return this.especialidade.compareTo(outro.especialidade);
	}
	
	public Medico() {
		super();
	}

	public Medico(int cod) {
		super(cod);
	}
	
	public Medico(int cod, String nome, String email, String senha, String fone, int nivel, int crm,
			String especialidade) {
		super(cod, nome, email, senha, fone, nivel);
		setCrm(crm);
		setEspecialidade(especialidade);
	}
	

	public Medico(int cod,int crm, String especialidade) {
		
		this.crm = crm;
		this.especialidade = especialidade;
	}
	





	public int getCrm() {
		return crm;
	}


	public void setCrm(int crm) {
		this.crm = crm;
	}


	public String getEspecialidade() {
		return especialidade;
	}


	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}



	
	
	
}
