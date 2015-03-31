package br.iesb.graduacao.ads.lp.exercicios;

public class Estagiario extends Pessoa {
	
	int cargaHorariaSemanal;

	public Estagiario(String m, String n, int i, int c) {
		super(m, n, i);
		this.cargaHorariaSemanal = c;
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculaSalario() {
		double v = 35;
		double s = v * this.cargaHorariaSemanal;
		return s;
	}
	
	public void getDadosImpressao(){
		this.imprimirDados();
	};

	@Override
	public void imprimirDados() {
		System.out.println("Matricula: " + this.matricula
				+ " | Nome: " + this.nome
				+ " | Idade: " + this.idade
				+ " | Carga Horária: "+ this.cargaHorariaSemanal+"h"
				+ " | Salário: R$ "+ this.calculaSalario());
		
	}

}
