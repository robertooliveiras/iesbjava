package br.iesb.graduacao.ads.lp.exercicios;

public class Professor extends Pessoa {
	
	int cargaHoraria;
	int titulacao;

	public Professor(String m, String n, int i, int c, int t) {
		super(m, n, i);
		this.cargaHoraria = c;
		this.titulacao = t;
	}
	
	@Override
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
		default:
			break;
		}
		
		double s = this.cargaHoraria * 4 * vh;
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
