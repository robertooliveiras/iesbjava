package br.iesb.posgraduacao.jogos.jogovelha;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.iesb.posgraduacao.uteis.Randomicos;

public class Computador extends Jogador{
    
    public Computador(int jogador){
        super(jogador);
        System.out.println("Jogador 'Computador' criado!");
    }
    
    @Override
    public void jogar(Tabuleiro tabuleiro){

        Tentativa(tabuleiro);
        tabuleiro.setPosicao(tentativa, jogador);
    }
    
    public int getNumero(){
    	Random rnd = new Random(System.currentTimeMillis());
    	int num = 0;
		
		List<Integer> ar = new ArrayList<Integer>();
		for (int z = 1; z <= 3; z++) {
			ar.add(z);
		}
		
		for (int i = 0; i < 3; i++) { 
			int x = rnd.nextInt(ar.size());
			if(x > 0 && x <= 3 ){
				num = ar.get(x);
				ar.remove(x);
				return num;
			}
		}
		if(num == 0) num=2;
		return num;
    	
    }
    
    @Override
    public void Tentativa(Tabuleiro tabuleiro){
    	Random rnd = new Random(System.currentTimeMillis());
    	Randomicos r = new Randomicos();
        do{
            do{
                System.out.print("Linha: ");
                tentativa[0] = r.getPositiveRandomNumber(3,rnd);
                
                if( tentativa[0] > 3 ||tentativa[0] < 1)
                    System.out.println("Linha "+tentativa[0]+" inválida. informe  1, 2 ou 3");
                
            }while( tentativa[0] > 3 ||tentativa[0] < 1);
            
            do{
                System.out.print("Coluna: ");
                tentativa[1] = r.getPositiveRandomNumber(3,rnd);
                
                if(tentativa[1] > 3 ||tentativa[1] < 1)
                    System.out.println("Coluna "+tentativa[1]+" inválida. informe 1, 2 ou 3");
                
            }while(tentativa[1] > 3 ||tentativa[1] < 1);
            
            tentativa[0]--; 
            tentativa[1]--;
            
            if(!checaTentativa(tentativa, tabuleiro))
                System.out.println("Esse local ja foi marcado. Tente outro.");
        }while( !checaTentativa(tentativa, tabuleiro) );
        
    }
}
