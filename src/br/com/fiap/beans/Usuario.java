package br.com.fiap.beans;

public class Usuario implements Comparable<Usuario> {
	
	private  int cod;
	private  String nome;
	private  String email;
	private  String senha;
	private  String fone;
	private int nivel;
	
	public int compareTo(Usuario outro) {
		return this.nome.compareTo(outro.nome);
	}
	
	public Usuario() {	
	}
	
	
	public Usuario(int cod) {		
		setCod(cod);
						
	}

	public Usuario(int cod, String nome, String email, String senha, String fone, int nivel) {		
		setCod(cod);
		setNome(nome);
		setEmail(email);
		setSenha(senha);
		setFone(fone);
		setNivel(nivel);				
	}
	

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	


		

}
