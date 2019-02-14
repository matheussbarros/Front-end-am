package br.com.fiap.beans;

public class Admin extends Usuario {

	private String cnpj;
	private String empresa;

	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Admin(int cod, String nome, String email, String senha, String fone, int nivel, String cnpj, String empresa) {
		super(cod, nome, email, senha, fone, nivel);
		setCnpj(cnpj);
		setEmpresa(empresa);
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public String getEmpresa() {
		return empresa;
	}


	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}


	

	
}


