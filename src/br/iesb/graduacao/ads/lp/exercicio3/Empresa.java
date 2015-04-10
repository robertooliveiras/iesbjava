package br.iesb.graduacao.ads.lp.exercicio3;

import java.util.Scanner;

public class Empresa {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String opcao;
		String tpEmpregado;
		boolean continuar = true;
		Professor professores = null;
		FuncionarioI funcionariosI = null;
		FuncionarioII funcionariosII = null;
		Estagiario estagiarios = null;
		String matricula = null;
		String nome = null;
		int idade = 0;
		int cargaHoraria = 0;
		double salarioBase = 0;
		double gratificacao = 0;
		int tempoServico = 0;
		int titulacao = 0;
		String saida = "";
		
		System.out.println("Bem vindo ao sistema de cadastro de Empregados!\n\n");
		System.out.println("Funciona assim:");
		System.out.println("1. O programa perguntará se vc deseja inserir um empregado. Informe \"s\" ou \"n\" para sim ou não, respectivamente.");
		System.out.println("2. O programa perguntará o tipo de empregado que vc deseja inserir. Responda conforme tabela abaixo");
		System.out.println("\tE\t=\tEstagiário");
		System.out.println("\tF1\t=\tFuncionário I");
		System.out.println("\tF2\t=\tFuncionário II");
		System.out.println("\tP\t=\tProfessor\n");
		System.out.println("3. O programa perguntará os dados do funcionário. A cada informação respondida pressine \"enter\"");
		System.out.println("\n\nO programa repetirá as operações de 1 a 3 até que você responda \"n\" à primeira pergunta.");
		System.out.println("Fique atento às mensagens do programa!\n\n\n");
		System.out.println("Vamos começar!\n\n");
		

		Scanner entrada = new Scanner(System.in);
		
		do {
			System.out.println("Deseja inserir um novo empregado (s || n)?");
			opcao = entrada.next();
			
			if(opcao.equalsIgnoreCase("S")){
				System.out.println("Digite o tipo de empregado (E || F1 || F2 || P):");
				tpEmpregado = entrada.next();
				switch (tpEmpregado.toString()) { //needs JRE7
				case "e":
				case "E":
					System.out.println("Informações do Estagiário:");
					System.out.println("Matricula:");
					matricula = entrada.next();
					System.out.println("Nome:");
					nome = entrada.next();
					System.out.println("Idade:");
					idade = entrada.nextInt();
					System.out.println("Carga Horária:");
					cargaHoraria = entrada.nextInt();
					estagiarios = new Estagiario(matricula,nome,idade,cargaHoraria);
					saida += estagiarios.getDados() + "\n";
					estagiarios.getDadosImpressao();
					break;
				case "f1":
				case "F1":
				case "fi":
				case "Fi":
					System.out.println("Informações do FuncionárioI:");
					System.out.println("Matricula:");
					matricula = entrada.next();
					System.out.println("Nome:");
					nome = entrada.next();
					System.out.println("Idade:");
					idade = entrada.nextInt();
					System.out.println("Salario Base:");
					salarioBase = entrada.nextDouble();
					System.out.println("Gratificação:");
					gratificacao = entrada.nextDouble();
					funcionariosI = new FuncionarioI(matricula,nome,idade,salarioBase,gratificacao);
					funcionariosI.imprimirDados();
					saida += funcionariosI.getDados() + "\n";
					System.out.println("sua opção foi " + tpEmpregado.toString());
					break;
				case "f2":
				case "F2":
				case "fii":
				case "FII":
				case "Fii":
				case "fII":
					System.out.println("Informações do FuncionárioII:");
					System.out.println("Matricula:");
					matricula = entrada.next();
					System.out.println("Nome:");
					nome = entrada.next();
					System.out.println("Idade:");
					idade = entrada.nextInt();
					System.out.println("Salario Base:");
					salarioBase = entrada.nextDouble();
					System.out.println("Gratificação:");
					gratificacao = entrada.nextDouble();
					System.out.println("Tempo de Serviço:");
					tempoServico = entrada.nextInt();
					funcionariosII = new FuncionarioII(matricula,nome,idade,salarioBase,gratificacao,tempoServico);
					funcionariosII.imprimirDados();
					saida += funcionariosII.getDados() + "\n";
					System.out.println("sua opção foi " + tpEmpregado.toString());
					break;
				case "p":
				case "P":
					System.out.println("Informações do Professor:");
					System.out.println("Matricula:");
					matricula = entrada.next();
					System.out.println("Nome:");
					nome = entrada.next();
					System.out.println("Idade:");
					idade = entrada.nextInt();
					System.out.println("Carga Horária:");
					cargaHoraria = entrada.nextInt();
					System.out.println("Titulação:");
					titulacao = entrada.nextInt();
					professores = new Professor(matricula,nome,idade,cargaHoraria,titulacao);
					funcionariosII.imprimirDados();
					saida += professores.getDados() + "\n";
					System.out.println("sua opção foi " + tpEmpregado.toString());
					break;

				default:
					System.out.println("Opção inválida, comece novamente");
					break;
				}
			}else if(opcao.equalsIgnoreCase("N")){
				continuar = false;
				System.out.println("Terminamos de colher os dados.");
			}else{
				System.out.println("OPA! NÃO ENTENDI! Deseja inserir um novo empregado (s ou n)?");
			}
			
		} while (continuar);
		
		entrada.close();
		if(saida != ""){
			System.out.println("Veja os dados colhidos:");		
			System.out.println(saida);
		}else{
			System.out.println("Nenhuma informação cadastrada");
		}

	}

}
