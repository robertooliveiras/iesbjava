package br.iesb.graduacao.ads.lp.uia3.aulas;

public class MatrizesE1 {

    /**
     * @param args
     */
    public static void main(String[] args) {
	String[] disciplinas = new String[10];
	String[] alunos = new String[10];
	float[][] notas = new float[10][10];
	String zero = "0";
	
	//notas do aluno 1 nas disciplinas 1 a 4
	notas[0][0] = (float) 7.1; 
	notas[0][1] = (float) 8.3; 
	notas[0][2] = (float) 8.0; 
	notas[0][3] = (float) 9.5; 
	
	//atribuindo um nome generico às disciplinas e aos alunos
	for (int i = 1; i <= alunos.length; i++) {
	    if(i > 9) zero = "";
	    disciplinas[i-1] = "Disciplina " + zero + i;
	    alunos[i-1] = "Aluno " + zero + i;
	}
	
	//imprimindo a linha head
	System.out.print("            | ");	
	for (int j = 0; j < disciplinas.length; j++) {
	    System.out.print(disciplinas[j]+"      |      ");
	}
	
	for (int i = 0; i < notas.length; i++) {
	    System.out.println();
	    System.out.print(alunos[i] +"    | ");
	    for (int j = 0; j < notas[i].length; j++) {
		System.out.print(notas[i][j]+"                |      ");
	    }
	    
	}
	
	System.exit(0);

    }

}
