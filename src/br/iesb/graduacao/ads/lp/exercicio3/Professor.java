package br.iesb.graduacao.ads.lp.exercicio3;

public class Professor extends Pessoa {
	
	int cargaHoraria;
	int titulacao;

	public Professor(String m, String n, int i, int c, int t) {
		super(m, n, i);
		this.cargaHoraria = c;
		this.titulacao = t;
	}
	
	public double calculaSalario() {
		double vh = 1;
		switch(this.titulacao){
		case 0:
			vh = 50;
			break;
		case 1:
			vh = 90;
			break;
		case 2:
			vh = 130;
			break;
		}
		
		double s = this.cargaHoraria * 4 * vh;
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
