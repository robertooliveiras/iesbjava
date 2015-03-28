package br.iesb.graduacao.ads.lp.exercicios;

public abstract class Pessoa implements IEmpregado {
	public String matricula;
	public String nome;
	public int idade;
	
	public Pessoa(String matricula) {
		this.matricula = matricula;
	}
}
