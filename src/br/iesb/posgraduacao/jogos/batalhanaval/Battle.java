package br.iesb.posgraduacao.jogos.batalhanaval;

import java.util.Scanner;
import java.util.Random;

public class Battle {

	protected Scanner entrada;
	private Tabuleiro[][] tblJogador;
	private Tabuleiro[][] tblInimigo;
	private int tamanho;
	
	private char turn = 'X';
	private boolean win = false;
	private int count = 0;
	private Random generator = new Random(System.currentTimeMillis());
	private Navio sub = new Navio(1);
	private Navio destroyer = new Navio(2);
	private Navio battleship = new Navio(3);
	private Navio esub = new Navio(1);
	private Navio edestroyer = new Navio(2);
	private Navio ebattleship = new Navio(3);
	private JogadaComputador AI = new JogadaComputador();

	public Battle( int t ) {
		tamanho = t;
		Tabuleiro tj = new Tabuleiro();
		tblJogador = tj.criaTabuleiro(t);
		
		Tabuleiro ti = new Tabuleiro();
		tblInimigo = ti.criaTabuleiro(t);
	}
	
	public void play(){
		printBoard();
		place();
		AIplace();
		System.out.println("Jogadas no formato Linha Coluna: 'C4'");
		while(!win)
			move();
	}
	
	public void printBoard(){
		String jogadores = "";
		String colunas = "";
		System.out.println("           JOGADOR                         INIMIGO");
		for(int x=1; x<=tamanho; x++){
			colunas = colunas +"   "+x;
			jogadores = jogadores +"   "; 
		}
		System.out.println(colunas+"       "+colunas);
		for(int x=0; x<tamanho; x++){
			System.out.print((char)(65+x) + " ");
			for(int y=0; y<tamanho; y++){
				System.out.print(tblJogador[x][y].piece);
			}
			System.out.print("     ");
			System.out.print((char)(65+x) + " ");
			for(int z=0; z<tamanho; z++){
				System.out.print(tblInimigo[x][z].piece);
			}
			System.out.println();
		}
	}
	
	public void place(){
		System.out.println();
		System.out.println("Para distribuir sua frota no tabuleiro, digite os comandos na seguinte sequencia:"
				+ "\nPrimeiro insira o número equivalente ao navio que você quer utilizar e tecle espaço;"
				+ "\n   1: Submarino (duas células)\n   2: Destroyer (três células)\n   3: Navio de Guerra (quatro células)"
				+ "\nEm seguida insira a Célula onde será localizada a ponta do o navio (ex: C2) e tecle espaço;"
				+ "\nPor último, informe a orientação do navio: Utilize H (Horizontal) ou V (Vertical) e tecle Enter."
				+ "\nex.: 1 B2 H"
				+ "\n\nO tiro Errado será mostrado como ~O~; o tiro certo será mostrado como ~X~.");
		System.out.println("\nApós posicionar a frota, digite 'I' para Iniciar o jogo.");
		
		String input = "";
		boolean start = false;
		
		while(!start){
			input = entrada.nextLine();
			
			if(input.length() == 1){
				if(input.charAt(0) == 'I'){
					if(battleship.placed && destroyer.placed && sub.placed)
						start = true;
					else
						System.out.println("Distribua toda a frota no tabuleiro.");
				} else {
					System.out.println("Texto Inválido.");
				}
			}
			else if(input.length() == 6){
				if(((int)input.charAt(0)-48) >= 4){
					System.out.println("Frota inválida.");
				}
				else if(((int)input.charAt(2)-65) >= tamanho){
					System.out.println("Linha inválida.");
				}
				else if(((int)input.charAt(3)-48) >= 7){
					System.out.println("Coluna Inválida.");
				}
				else if((int)input.charAt(5) != 72 && (int)input.charAt(5) != 86){
					System.out.println("Direção inválida.");
				}
				else{   //Valid Input
					if((int)input.charAt(5) == 72 && (((int)input.charAt(0)-48) + 1) > (7 - ((int)input.charAt(3)-48))){
						System.out.println("Falta células para posição Horizontal.");
					}
					else if((int)input.charAt(5) == 86 && (((int)input.charAt(0)-48) + 1) > (7 - ((int)input.charAt(2) - 64))){
						System.out.println("Falta Celulas para posição Vertical.");
					}
					else{ //Valid Placement, except for overlap
						if(((int)input.charAt(0)-48) == 1){
							plactblInimigo(input.charAt(5), sub, input.substring(2,4));
						}
						else if(((int)input.charAt(0)-48) == 2){
							plactblInimigo(input.charAt(5), destroyer, input.substring(2,4));
						}
						else{
							plactblInimigo(input.charAt(5), battleship, input.substring(2,4));
						}
					}
				}
			} else {
				System.out.println("Texto inválido, siga as instruções de preenchimento. ex: 1 B2 H");
			}
		}
	}
	
	public void AIplace(){
		boolean flag = false;
		for(int x=1;x<4;x++){
			flag = false;
			while(!flag){
				int a = generator.nextInt(2);
				int b = generator.nextInt(tamanho);
				int c = generator.nextInt(tamanho);
				if(a == 0)
					a = 72;
				else
					a = 86;
				b += 65;
				c += 49;
				
				if(a == 72 && (x + 1) > (7 - (c-48))){
					//no good, try again
				}
				else if(a == 86 && (x + 1) > (7 - (b-64))){
					//no good, try again
				}
				else{ //Valid Placement, except for overlap
					String d = String.valueOf((char)b) + String.valueOf((char)c);
					if(x == 1){
						flag = AIplactblInimigo((char)a, esub, d); 
					}
					else if(x == 2){
						flag = AIplactblInimigo((char)a, edestroyer, d);
					}
					else{
						flag = AIplactblInimigo((char)a, ebattleship, d);
					}
				}
			}
		}
	}
	
	public void plactblInimigo(char layout, Navio current, String locale){
		
		boolean overlap = false;
		
		if(layout == 'H'){
			for(int x=((int)locale.charAt(1)-49);x<((int)locale.charAt(1)-49)+(current.type + 1);x++){
				if(tblJogador[((int)locale.charAt(0)-65)][x].type != current.type &&
				   tblJogador[((int)locale.charAt(0)-65)][x].used == true)
					overlap = true;
			}
		}
		else{  //layout == 'V'
			for(int x=((int)locale.charAt(0)-65);x<((int)locale.charAt(0)-65)+(current.type + 1);x++){
				if(tblJogador[x][((int)locale.charAt(1)-49)].type != current.type &&
				   tblJogador[x][((int)locale.charAt(1)-49)].used == true)
					overlap = true;
			}
		}
		if(!overlap){ //If ships don't overlap
			if(current.placed){
				if(current.orientation == 'H'){
					for(int x=((int)current.location.charAt(1)-49);x<((int)current.location.charAt(1)-49)+(current.type + 1);x++){
						tblJogador[((int)current.location.charAt(0)-65)][x].piece = "~~~|";
						tblJogador[((int)current.location.charAt(0)-65)][x].used = false;
						tblJogador[((int)current.location.charAt(0)-65)][x].type = 0;
					}
				}
				else{  //orientation == 'V'
					for(int x=((int)current.location.charAt(0)-65);x<((int)current.location.charAt(0)-65)+(current.type + 1);x++){
						tblJogador[x][((int)current.location.charAt(1)-49)].piece = "~~~|";
						tblJogador[x][((int)current.location.charAt(1)-49)].used = false;
						tblJogador[x][((int)current.location.charAt(1)-49)].type = 0;
					}
				}
			}
			if(layout == 'H'){
				for(int x=((int)locale.charAt(1)-49);x<((int)locale.charAt(1)-49)+(current.type + 1);x++){
					tblJogador[((int)locale.charAt(0)-65)][x].piece = "[8]|";
					tblJogador[((int)locale.charAt(0)-65)][x].used = true;
					tblJogador[((int)locale.charAt(0)-65)][x].type = current.type;
				}
			}
			else{  //layout == 'V'
				for(int x=((int)locale.charAt(0)-65);x<((int)locale.charAt(0)-65)+(current.type + 1);x++){
					tblJogador[x][((int)locale.charAt(1)-49)].piece = "[8]|";
					tblJogador[x][((int)locale.charAt(1)-49)].used = true;
					tblJogador[x][((int)locale.charAt(1)-49)].type = current.type;
				}
			}
			current.placed = true;
			current.location = locale;
			current.orientation = layout;
			printBoard();
		}
		else
			System.out.println("Local inválido para o navio.");
	}
	
public boolean AIplactblInimigo(char layout, Navio current, String locale){
		
		boolean overlap = false;
		
		if(layout == 'H'){
			for(int x=((int)locale.charAt(1)-49);x<((int)locale.charAt(1)-49)+(current.type + 1);x++){
				if(tblInimigo[((int)locale.charAt(0)-65)][x].type != current.type &&
				   tblInimigo[((int)locale.charAt(0)-65)][x].used == true)
					overlap = true;
			}
		}
		else{  //layout == 'V'
			for(int x=((int)locale.charAt(0)-65);x<((int)locale.charAt(0)-65)+(current.type + 1);x++){
				if(tblInimigo[x][((int)locale.charAt(1)-49)].type != current.type &&
				   tblInimigo[x][((int)locale.charAt(1)-49)].used == true)
					overlap = true;
			}
		}
		if(!overlap){ //If ships don't overlap
			if(layout == 'H'){
				for(int x=((int)locale.charAt(1)-49);x<((int)locale.charAt(1)-49)+(current.type + 1);x++){
					tblInimigo[((int)locale.charAt(0)-65)][x].used = true;
					tblInimigo[((int)locale.charAt(0)-65)][x].type = current.type;
				}
			}
			else{  //layout == 'V'
				for(int x=((int)locale.charAt(0)-65);x<((int)locale.charAt(0)-65)+(current.type + 1);x++){
					tblInimigo[x][((int)locale.charAt(1)-49)].used = true;
					tblInimigo[x][((int)locale.charAt(1)-49)].type = current.type;
				}
			}
			current.placed = true;
			current.location = locale;
			current.orientation = layout;
			return true;
		}
		else
			return false;
	}

	public void move(){
		String move = "";
		String valid = "";

		if(turn == 'X'){
			System.out.println("Ataque: ");	
			move = entrada.nextLine();
		}
		else
			move = moveAI();
		
		valid = checkMove(move);
		while(valid != "ok"){
			if(turn == 'X'){
				System.out.println("ERRO: "+ valid);
				move = entrada.nextLine();
			}
			else
				move = moveAI(); 
			valid = checkMove(move);
		}
		
		processMove(move);
		
		if(turn == 'O')
			printBoard();
		
		if(count >= 17)
			checkWin();
		
		if(turn == 'X')
			turn = 'O';
		else
			turn = 'X';
	}
	
	public String checkMove(String move){
		
		if(((int)move.charAt(0)-65) >= tamanho)
			return "Linha inválida, tente novamente: ";	
		if(((int)move.charAt(1)-48) >= 7)
			return "Coluna inválida, tente novamente: ";
		if(turn == 'X'){
			if(tblInimigo[((int)move.charAt(0)-65)][((int)move.charAt(1)-49)].selected)  
				return "Você já atacou nessa célula, tente novamente: ";
		}
		else{
			if(tblJogador[((int)move.charAt(0)-65)][((int)move.charAt(1)-49)].selected){
		        AI.error = true;
		        AI.himi = 'M';
				return "olha o computador errando";
			}
		}
		
		return "ok";
	}
	
	public void processMove(String move){
		
		count++;
		char himi = ' ';
		String message = "";
		
		if(turn == 'X'){
			if(tblInimigo[((int)move.charAt(0)-65)][((int)move.charAt(1)-49)].used){   
				himi = 'X';
				message = "Em cheio!!!";
			}
			else{
				himi = 'O';
				message = "Errou!";
			}
			tblInimigo[((int)move.charAt(0)-65)][((int)move.charAt(1)-49)].piece = "~"+himi+"~|";
			tblInimigo[((int)move.charAt(0)-65)][((int)move.charAt(1)-49)].selected = true;
		}
		else{
			if(tblJogador[((int)move.charAt(0)-65)][((int)move.charAt(1)-49)].used){   
				himi = 'X';
				message = "Em cheio!!!";
				AI.himi2 = AI.himi;
				AI.himi = 'H';
				AI.count++;
			}
			else{
				himi = 'O';
				message = "Errou!";
				AI.himi2 = AI.himi;
				AI.himi = 'M';
				AI.count++;
			}
			tblJogador[((int)move.charAt(0)-65)][((int)move.charAt(1)-49)].piece = "~"+himi+"~|";
			tblJogador[((int)move.charAt(0)-65)][((int)move.charAt(1)-49)].selected = true;
		}
		
		int counter = 0;
		if(himi == 'X'){
			if(turn == 'X'){
				int stype = tblInimigo[((int)move.charAt(0)-65)][((int)move.charAt(1)-49)].type;
				
				for(int x=0;x<tamanho;x++){
					for(int y=0;y<tamanho;y++){
						if(tblInimigo[x][y].selected && tblInimigo[x][y].type == stype)
							counter++;
					}
				}
				if(counter == (stype + 1)){
					String xship = "";
					if(stype == 1){
						xship = "Submarino!";
						esub.destroyed = true;
					}
					else if(stype == 2){
						xship = "Destroyer!";
						edestroyer.destroyed = true;
					}
					else{
						xship = "Navio de Guerra!";
						ebattleship.destroyed = true;
					}
					message += " Você destruiu o " + xship+" do inimigo!";
				}
			}
			else{
				int stype = tblJogador[((int)move.charAt(0)-65)][((int)move.charAt(1)-49)].type;
				
				for(int x=0;x<tamanho;x++){
					for(int y=0;y<tamanho;y++){
						if(tblJogador[x][y].selected && tblJogador[x][y].type == stype)
							counter++;
					}
				}
				if(counter == (stype + 1)){
					String xship = "";
					if(stype == 1){
						xship = "Submarino!";
						sub.destroyed = true;
					}
					else if(stype == 2){
						xship = "Destroyer!";
						destroyer.destroyed = true;
					}
					else{
						xship = "Navio de Guerra!";
						battleship.destroyed = true;
					}
					message += " UM NAVIO DA SUA FROTA FOI DESTRUÍDO: " + xship;
					AI.himi = 'M';  //Make it choose a random X next time, because ship destroyed
					AI.himi2 = 'M';
				}
			}
		}
		if(turn == 'O')
			message = "INIMIGO " + message;
		System.out.println(message);
	}
	
	public void checkWin(){  
       if(esub.destroyed && edestroyer.destroyed && ebattleship.destroyed){
    	   win = true;
    	   System.out.println("VITÓRIA!!!! VOCÊ DESTRUIU TODA A FROTA INIMIGA!");
       }
       if(sub.destroyed && destroyer.destroyed && battleship.destroyed){
    	   win = true;
    	   System.out.println("GAME OVER. SUA FROTA FOI COMPLETAMENTE DESTRUÍDA.");
       }
	}
	
	public void init(){
		  for(int x=0;x<tamanho;x++){
			  for(int y=0;y<tamanho;y++){
				  tblInimigo[x][y] = new Tabuleiro();
				  tblJogador[x][y] = new Tabuleiro();
			  }			 
		  }
		  turn = 'X';
		  win = false;
		  count = 0;
		  sub = new Navio(1);
		  destroyer = new Navio(2);
		  battleship = new Navio(3);
		  esub = new Navio(1);
		  edestroyer = new Navio(2);
		  ebattleship = new Navio(3);
	}
	
	public String moveAI(){
		int x = 0;
		int y = 0;
		
		if(AI.count<1 || (AI.himi == 'M' && AI.himi2 == 'M') || AI.error){
			x = generator.nextInt(tamanho);
		    y = generator.nextInt(tamanho);
			x += 65;
			y += 49;
			AI.error = false;
		}
		else if(AI.himi == 'H'){
			x = AI.lasta;
			if(AI.lastb<54)
				y = AI.lastb + 1;
			else
				y = AI.lastb - 1;
		}
		else if(AI.himi2 == 'H' && AI.himi == 'M'){
			if(AI.lasta2<70)
				x = AI.lasta2 + 1;
			else
				x = AI.lasta2 - 1;
			y = AI.lastb2;
		}

		String z = String.valueOf((char)x) + String.valueOf((char)y);
		
		AI.lasta2 = AI.lasta;
		AI.lastb2 = AI.lastb;
		AI.lasta = x;
		AI.lastb = y;
		
		return z;
	}
	
}
