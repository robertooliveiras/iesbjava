package br.iesb.posgraduacao.uteis;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Randomicos {
	
	/**
	 * Random rnd = new Random(System.currentTimeMillis());
	 * Randomicos r = new Randomicos();
	 * System.out.println(r.getPositiveRandomNumber(30,rnd));
	 * 
	 * @param s
	 * @param rnd
	 * @return
	 */
	public int getPositiveRandomNumber(int s, Random rnd){
			List<Integer> aceitos = new ArrayList<Integer>();
			for (int z = 1; z <= s; z++) {
				aceitos.add(z);
			}
			int n = rnd.nextInt(s);
			while(n < 0){
				n = rnd.nextInt(s);
			}
			return aceitos.get(n);
	}

}
