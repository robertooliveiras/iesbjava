package br.iesb.graduacao.ads.lp.exercicios;

public class FuncionarioII extends FuncionarioI {
	
//	double salarioBase;
//	double gratificacao;
	int tempoServico;
	
	public FuncionarioII(String m, String n, int i, double sb, double g, int t) {
//		super(m, n, i);
		super(m, n, i, sb, g);
//		this.salarioBase = sb;
//		this.gratificacao = g;
		this.tempoServico = t;
	}
	
	@Override
	public double calculaSalario() {
		double s = this.salarioBase + this.gratificacao;
		double ats = (s * 0.01) * this.tempoServico;
		s += ats;
		return s;
	}

//	@Override
//	public void imprimirDados() {
//		System.out.println("Matricula: " + this.matricula
//				+ " | Nome: " + this.nome
//				+ " | Idade: " + this.idade
//				+ " | Salário: R$ "+ this.calculaSalario());
//		
//	}

}
