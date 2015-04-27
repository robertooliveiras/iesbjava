package br.iesb.posgraduacao.android.aula1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Classe01 extends ClasseBase {
	public Classe01(){
		
	}

	public void fechar() {
		
	}

	public void abrir() {
		
	}
	
	public static void main(String[] args) {
		Random rnd = new Random(System.currentTimeMillis());
		
		List<Integer> ar = new ArrayList<Integer>();
		for (int z = 1; z <= 3; z++) {
			ar.add(z);
		}
		
		for (int i = 0; i < 3; i++) { 
			int x = rnd.nextInt(ar.size());
			if(x >= 0){
				int num = ar.get(x);
				ar.remove(x);
				System.out.println(num);
			}
		}
	}

}
