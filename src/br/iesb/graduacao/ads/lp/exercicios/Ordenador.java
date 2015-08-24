package br.iesb.graduacao.ads.lp.exercicios;

public class Ordenador {
    public int[] sequenciaA = {4000000,300000,20000,1000};
    
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Ordenador objO = new Ordenador();
	objO.imprimirNumeros();
	System.out.println("após ordenação: ");
	objO.ordenarSequencia();
	objO.imprimirNumeros();
    }
    
    public void imprimirNumeros(){
	for(int j = 0; j < this.sequenciaA.length; j++){
	    System.out.format("%8d˚ | ", j + 1);
	}
	System.out.println("");
	for(int j = 0; j < this.sequenciaA.length; j++){
	    System.out.format("%8d  | ", this.sequenciaA[j]);
	}
	System.out.println("\n\n");
    }
    
    public void ordenarSequencia(){
	int i;
	int valor;
	for(int j = 1; j < this.sequenciaA.length; j++){
	    valor = this.sequenciaA[j];
	    i = j-1;
	    while(i >= 0 && this.sequenciaA[i] > valor){
		this.sequenciaA[i + 1] = this.sequenciaA[i];
		i = i-1;
	    }
	    this.sequenciaA[i+1] = valor;
	}
    }
    
}
