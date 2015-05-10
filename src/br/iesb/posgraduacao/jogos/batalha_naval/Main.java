package br.iesb.posgraduacao.jogos.batalha_naval;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public List<String> ataquesValidos = new ArrayList<String>();
	private Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		Main m = new Main();
		CampoBatalha cb1 = new CampoBatalha(true);
		CampoBatalha cb2 = new CampoBatalha(true);
		m.imprimeTabuleiro(cb1, cb2);
		String input;
		int L;
		int C;
		do{
			//		Ataque do jogador 1
			//--------------------------
			System.out.println("\n");
			System.out.println("Jogador 1, informe seu ataque:");
			

			input = m.entrada.nextLine();
			while(m.ataquesValidos.indexOf(input) < 0){
				System.out.println("Atenção! Opção inválida.\n"
									+ "Jogador 1, informe seu ataque:");
				input = m.entrada.nextLine();
			}

			L = cb2.getIndexOfLinhasChar(input.toUpperCase().toCharArray()[0]);
			if (input.toCharArray().length == 2) {
				C = cb2.getIndexOfColunasChar(input.toUpperCase().toCharArray()[1]);
			}else{
				C = cb2.getIndexOfColunasChar(input.toUpperCase().toCharArray()[2]);
			}
			
			if(cb2.getCampoDeBatalha()[L][C].getTPeca().isAtingido()){
				m.imprimeTabuleiro(cb1, cb2);
				System.out.println("Jogador 1 acertou num destroço. Jogada ruim! perdeu a chance nessa jogada");
			}else{
				cb2.getCampoDeBatalha()[L][C].getTPeca().setAtingido(true);
				if (cb2.getCampoDeBatalha()[L][C].getTPeca() instanceof Agua) {
					System.out.println("Jogador 1 errou!");
				}else{
					System.out.println("Jogador 1 acertou um objeto da Frota do Jogador 2!");
					if(m.verificaFrotaDestruida(cb2.getCampoDeBatalha())){
						System.out.println("Jogador 1 destruiu a Frota do Jogador 2!");
						System.out.println("VITÓRIA DO JOGADOR 1!!!!");
						System.exit(0);
					}
				}
				m.imprimeTabuleiro(cb1, cb2);
			}
			
			//		Ataque do jogador 2
			//--------------------------

			System.out.println("\n");
			System.out.println("Jogador 1, informe seu ataque:");

			input = m.entrada.nextLine();
			while(m.ataquesValidos.indexOf(input) < 0){
				System.out.println("Atenção! Opção inválida.\n"
									+ "Jogador 1, informe seu ataque:");
				input = m.entrada.nextLine();
			}
			
			L = cb1.getIndexOfLinhasChar(input.toUpperCase().toCharArray()[0]);
			if (input.toCharArray().length == 2) {
				C = cb1.getIndexOfColunasChar(input.toUpperCase().toCharArray()[1]);
			}else{
				C = cb1.getIndexOfColunasChar(input.toUpperCase().toCharArray()[2]);
			}
			
			if(cb1.getCampoDeBatalha()[L][C].getTPeca().isAtingido()){
				m.imprimeTabuleiro(cb1, cb2);
				System.out.println("Jogador 2 acertou num destroço. Jogada ruim! perdeu a chance nessa jogada");
			}else{
				cb1.getCampoDeBatalha()[L][C].getTPeca().setAtingido(true);
				if (cb1.getCampoDeBatalha()[L][C].getTPeca() instanceof Agua) {
					System.out.println("Jogador 2 errou!");
				}else{
					System.out.println("Jogador 2 acertou um objeto da Frota do Jogador 1!");
					if(m.verificaFrotaDestruida(cb1.getCampoDeBatalha())){
						System.out.println("Jogador 1 destruiu a Frota do Jogador 2!");
						System.out.println("VITÓRIA DO JOGADOR 1!!!!");
						System.exit(0);
					}
				}
				m.imprimeTabuleiro(cb1, cb2);
			}
			

		}while(!m.verificaFrotaDestruida(cb1.getCampoDeBatalha()) && !m.verificaFrotaDestruida(cb2.getCampoDeBatalha()));
//		Ataque do computador
//		char[] cell;		
//		cell = cb.getRandomicCellChar();
//		cb.getPecaCampoBatalhaByPositionChar(cell).getTPeca().setAtingido(true);
//		
//
//		cb.imprimeCampoDeBatalha();
//		System.out.println("\n");
		
		System.exit(0);

	}
	
	public Main(){
		initValidadoresDeEntrada();
	}
	
	private void initValidadoresDeEntrada() {
		
		for (char i = 'a', j='A'; i <= 'j'; i++, j++) {
			for (Integer c = 1; c <= 10; c++) {
				ataquesValidos.add(""+i+""+c.toString());
				ataquesValidos.add(j +""+c.toString());
			}
		}
	}
	

	
	public void imprimeTabuleiro(CampoBatalha c1, CampoBatalha c2){
		System.out.println();
		System.out.println("                      JOGADOR 1                             "
						 + "                        JOGADOR 2");
		
		for (int i = 0; i < c1.getCampoDeBatalha().length; i++) {
			System.out.print(c1.linhas[i] + " ");
			for (int j = 0; j < c1.getCampoDeBatalha()[i].length; j++) {
				System.out.print(c1.getCampoDeBatalha()[i][j].getTPeca().getForma());
			}
			System.out.print("          ");
			System.out.print(c2.linhas[i] + " ");
			for (int j = 0; j < c2.getCampoDeBatalha()[i].length; j++) {
				System.out.print(c2.getCampoDeBatalha()[i][j].getTPeca().getForma());
			}
			System.out.println();
		}
		for (int i = 0; i < c1.getCampoDeBatalha().length; i++) {
			System.out.print("    " + c1.colunas[i] );
		}
		System.out.print("          ");
		for (int i = 0; i < c2.getCampoDeBatalha().length; i++) {
			System.out.print("    " + c2.colunas[i] );
		}
		System.out.println();
	}
	
	public boolean verificaFrotaDestruida(Peca[][] p){
		boolean destruido = true;
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p[i].length; j++) {
				if(!(p[i][j].getTPeca() instanceof Agua)){
					if(!p[i][j].getTPeca().isAtingido()){
						destruido = false;
						break;
					}
				}
			}
			if(!destruido){
				break;
			}
		}
		return destruido;
	}

}
