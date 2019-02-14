package br.com.fiap.beans;


public class Paciente extends Usuario {

	private String cpf;
	private String nacimento;
	
	public int compareTo(Paciente outro) {
		return this.cpf.compareTo(outro.cpf);
	}
	
	public Paciente() {
		super();			
	}

	public Paciente(int cod) {
		super(cod);		
	}

	public Paciente(String cpf, String nacimento) {
		this.cpf = cpf;
		this.nacimento = nacimento;
	}

	public Paciente(int cod, String nome, String email, String senha, String fone, int nivel, String cpf, String nacimento) {
		super(cod, nome, email, senha, fone, nivel);
		setCpf(cpf);
		setNacimento(nacimento);
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getNacimento() {
		return nacimento;
	}


	public void setNacimento(String nacimento) {
		this.nacimento = nacimento;
	}
	
	
	

	
	
	
	
	
	
	
}
