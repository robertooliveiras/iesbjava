package br.iesb.graduacao.ads.lp.exercicio3;

public class FuncionarioI extends Pessoa {
	
	double salarioBase;
	double gratificacao;

	public FuncionarioI(String m, String n, int i, double sb, double g) {
		super(m, n, i);
		this.salarioBase = sb;
		this.gratificacao = g;
	}
	
	public double calculaSalario() {
		double s = this.salarioBase + this.gratificacao;
		return s;
	}

	public void imprimirDados() {
		System.out.println("Matricula: " + this.matricula
				+ " | Nome: " + this.nome
				+ " | Idade: " + this.idade
				+ " | Salário: R$ "+ this.calculaSalario());
		
	}

	public String getDados() {
		return "Matricula: " + this.matricula
				+ " | Nome: " + this.nome
				+ " | Idade: " + this.idade
				+ " | Salário: R$ "+ this.calculaSalario();
		
	}

}
