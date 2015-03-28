package br.iesb.graduacao.ads.lp.UIA;

public abstract class Calculos implements CalculosInterface {

	public double calcularMedia(float[] a){
		float m;
		float soma = 0;
		for(int i = 0; i <= a.length; i++){
			soma += a[i];
		}
		m = soma/a.length;
		return m;
	}

	public double calcularMedia(int[] a){
		float m;
		int soma = 0;
		for(int i = 0; i <= a.length; i++){
			soma += a[i];
		}
		m = soma/a.length;
		return m;
	}

	public double calcularMedia(double[] a){
		double m;
		double soma = 0;
		for(int i = 0; i <= a.length; i++){
			soma += a[i];
		}
		m = soma/a.length;
		return m;
	}

	public double calcularMedia(long[] a){
		double m;
		long soma = 0;
		for(int i = 0; i <= a.length; i++){
			soma += a[i];
		}
		m = soma/a.length;
		return m;
	}

	public double calcularMedia(short[] a){
		double m;
		long soma = 0;
		for(int i = 0; i <= a.length; i++){
			soma += a[i];
		}
		m = soma/a.length;
		return m;
	}
	
	public abstract double calcularArea(double[] a);

}
