package br.iesb.posgraduacao.jogos.wumpus;

public class Main {
    
    public static void main(String[] args) {

        System.out.println("BEM VINDOS AO JOGO WUMPUS!"
                        + "\n\nVejam as instruções:\n"
                        + "\n1. Ache o ouro, mas cuidado com o monstro Wumpus"
                        + " e com os buracos! "
                        + "\n2. Para mover, informe os seguntes comandos:"
                        + "\n\t f = move para frente"
                        + "\n\t t = move para tras"
                        + "\n\t s = sobe "
                        + "\n\t d = desce"
                        + "\n\t\t\t   s"
                        + "\n\t\t\t    ^"
                        + "\n\t\t\tt<     >f"
                        + "\n\t\t\t    \\/"
                        + "\n\t\t\t     d\n\n"
                        + " o movimento só pode ser na horizontal ou na vertical"
                        + " e de casa em casa. "
                        + "\n3. Sempre haverá brisa (≈) nas casas adjacentes aos buracos"
                        + " e semre haverá fedor (*) nas casas adjacentes ao monstro Wumpus "
                        + "\n4. O Explorador 'P' começa todas as rodadas na primeira coluna"
                        + " da última linha."
                        + "QUE O JOGO COMEÇE!!");
        Tabuleiro t = new Tabuleiro(4);
        t.jogar();
    }
}
