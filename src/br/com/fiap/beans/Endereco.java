package br.com.fiap.beans;

public class Endereco implements Comparable<Endereco>{

	private int cod;
	private String logradouro;
	private int numero;
	private String bairro;
	private String cidade;
	private String estado;
	private int cep;
	private Usuario usuario;
	
	public int compareTo(Endereco outro) {
		return this.logradouro.compareTo(outro.logradouro);
	}
	
	public Endereco() {
		
	}
	
	

	public Endereco(int cod, String logradouro, int numero, String bairro, String cidade, String estado, int cep,
			Usuario usuario) {
		setCod(cod);
		setLogradouro(logradouro);
		setNumero(numero);
		setBairro(bairro);
		setCidade(cidade);
		setEstado(estado);
		setCep(cep);
		setUsuario(usuario);			
	}
	
	public Endereco(String logradouro, int numero, String bairro, String cidade, String estado, int cep,
			Usuario usuario) {
		setLogradouro(logradouro);
		setNumero(numero);
		setBairro(bairro);
		setCidade(cidade);
		setEstado(estado);
		setCep(cep);
		setUsuario(usuario);			
	}



	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	


		
	
}


