package br.iesb.graduacao.ads.lp.exercicios;

public class FuncionarioI extends Pessoa {
	
	double salarioBase;
	double gratificacao;

	public FuncionarioI(String m, String n, int i, double sb, double g) {
		super(m, n, i);
		this.salarioBase = sb;
		this.gratificacao = g;
	}
	
	@Override
	public double calculaSalario() {
		double s = this.salarioBase + this.gratificacao;
		return s;
	}

	@Override
	public void imprimirDados() {
		System.out.println("Matricula: " + this.matricula
				+ " | Nome: " + this.nome
				+ " | Idade: " + this.idade
				+ " | Salário: R$ "+ this.calculaSalario());
		
	}

}
