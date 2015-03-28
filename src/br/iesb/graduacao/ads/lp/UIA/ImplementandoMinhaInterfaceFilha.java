package br.iesb.graduacao.ads.lp.UIA;

public class ImplementandoMinhaInterfaceFilha implements MinhaInterfaceFilha {
	
	public static void main(String[] args){
		ImplementandoMinhaInterfaceFilha x = new ImplementandoMinhaInterfaceFilha();
		x.imprimeA();
		x.imprimeB();
		x.imprimeC("Olha eu aqui");
		x.imprimeC();
		x.imprimeD();
		String[] m = {"oi,","estou com fome!","vamos comer?","o que vc acha?","?????"};
		x.imprimeD(m);		
	}

	public void imprimeA() {
		System.out.println("A");
	}

	public void imprimeB() {
		System.out.println("B");
	}

	public void imprimeC() {
		System.out.println("C");
	}

	public void imprimeC(String a) {
		System.out.println(a);
	}

	public void imprimeD() {
		System.out.println("D");
	}

	public void imprimeD(String[] d) {
		String saida = "";
		for(int i = 0; i < d.length; i++){
			saida = saida + " " + d[i].toString();
		}
		System.out.println(saida);
	}
}
