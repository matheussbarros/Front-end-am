package br.com.fiap.beans;

public class Duvida implements Comparable<Duvida> {
	
	private int cod;
	private String descricao;
	private String resposta;
	private Acompanhamento acomp;
	private Medico medico;
	private Paciente paciente;
	
	public int compareTo(Duvida outro) {
		return this.descricao.compareTo(outro.descricao);
	}
	
	public Duvida() {
	}


	public Duvida(int cod, String descricao, String resposta, Acompanhamento acomp, Medico medico, Paciente paciente) {
		setCod(cod);
		setDescricao(descricao);
		setResposta(resposta);
		setAcomp(acomp);
		setMedico(medico);
		setPaciente(paciente);
	}


	public int getCod() {
		return cod;
	}


	public void setCod(int cod) {
		this.cod = cod;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getResposta() {
		return resposta;
	}


	public void setResposta(String resposta) {
		this.resposta = resposta;
	}


	public Acompanhamento getAcomp() {
		return acomp;
	}


	public void setAcomp(Acompanhamento acomp) {
		this.acomp = acomp;
	}


	public Medico getMedico() {
		return medico;
	}


	public void setMedico(Medico medico) {
		this.medico = medico;
	}


	public Paciente getPaciente() {
		return paciente;
	}


	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	

}
