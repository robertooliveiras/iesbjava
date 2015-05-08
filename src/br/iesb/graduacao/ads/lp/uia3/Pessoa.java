package br.iesb.graduacao.ads.lp.uia3;

public class Pessoa {
	private String nome;
	private int idade;
	private boolean ehInteligente;
	private boolean ehDiligente; 

	public Pessoa(String nome, int idade, boolean ehInteligente, boolean ehDiligente) {
		setNome(nome);
		setIdade(idade);
		setEhInteligente(ehInteligente);
		setEhDiligente(ehDiligente);
	}

	/**
	 * @return the ehInteligente
	 */
	public boolean isEhInteligente() {
		return ehInteligente;
	}

	/**
	 * @param ehInteligente the ehInteligente to set
	 */
	public void setEhInteligente(boolean ehInteligente) {
		this.ehInteligente = ehInteligente;
	}

	/**
	 * @return the idade
	 */
	public int getIdade() {
		return idade;
	}

	/**
	 * @param idade the idade to set
	 */
	public void setIdade(int idade) {
		this.idade = idade;
	}

	/**
	 * @return the ehDiligente
	 */
	public boolean isEhDiligente() {
		return ehDiligente;
	}

	/**
	 * @param ehDiligente the ehDiligente to set
	 */
	public void setEhDiligente(boolean ehDiligente) {
		this.ehDiligente = ehDiligente;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

}
