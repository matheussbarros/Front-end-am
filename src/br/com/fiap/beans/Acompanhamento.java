package br.com.fiap.beans;

public class Acompanhamento implements Comparable<Acompanhamento> {

	private int cod;
	private String nome;
	private String descricao;
	private String abertura;
	private String encerramento;
	private Paciente paciente;
	private Medico medico;
	
	public int compareTo(Acompanhamento outro) {
		return this.nome.compareTo(outro.nome);
	}
	
	public Acompanhamento() {
		
	}
	
	public Acompanhamento(int cod) {
		setCod(cod);
	}


	public Acompanhamento(int cod, String nome, String descricao, String abertura, String encerramento, Paciente paciente,
			Medico medico) {
		setCod(cod);
		setNome(nome);
		setDescricao(descricao);
		setAbertura(abertura);
		setEncerramento(encerramento);
		setPaciente(paciente);
		setMedico(medico);
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


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getAbertura() {
		return abertura;
	}


	public void setAbertura(String abertura) {
		this.abertura = abertura;
	}


	public String getEncerramento() {
		return encerramento;
	}


	public void setEncerramento(String encerramento) {
		this.encerramento = encerramento;
	}


	public Paciente getPaciente() {
		return paciente;
	}


	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}


	public Medico getMedico() {
		return medico;
	}


	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	
	
	
	
	
	
	
	
}
