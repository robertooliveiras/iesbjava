package br.iesb.graduacao.ads.lp.uia3.exercicio1;

import java.util.ArrayList;
import java.util.Scanner;

import br.iesb.graduacao.ads.lp.exercicio3.Estagiario;
import br.iesb.graduacao.ads.lp.exercicio3.FuncionarioI;
import br.iesb.graduacao.ads.lp.exercicio3.FuncionarioII;
import br.iesb.graduacao.ads.lp.exercicio3.Professor;
/*
 * Lista de Exercícios UIA 3 e 4 Exercício 1 (valor: 0,5 pontos)
 * Helmuth Karl Bernhard Graf von Moltke (1800 – 1891) foi um Marechal alemão. 
 *   Chefe do estado maior do Exército prussiano por trinta anos, ele é amplamente reconhecido 
 *   como um dos maiores estrategistas da segunda metade do século XIX, e o criador de um 
 *   método inovador de condução de exércitos.
 * Moltke tinha uma percepção e abordagem própria para categorizar o seu corpo de oficiais, 
 *   algo que perdura até hoje em muitas forças armadas e que pode se aplicar a todas as 
 *   formas de liderança.
 * Se você considerar os dois intervalos de características individuais, aqueles que vão do 
 *   diligente até o preguiçoso e aqueles que vão do não-inteligente até o inteligente (sendo 
 *   politicamente correto aqui), então você obtém os quatro tipos de caracteres do diagrama 
 *   acima.
 * Moltke dividiu o seu corpo de oficiais nestes quatro tipos distintos, de acordo com suas 
 *   características mentais e físicas. E culminou com 
 *   tipo A: não-inteligente e preguiçoso, 
 *   tipo B: inteligente e diligente, 
 *   tipo C: não-inteligente e diligente e 
 *   tipo D: inteligente e preguiçoso.
 * Os oficiais do tipo ‘A’, os quais eram mentalmente inexpressivos e fisicamente preguiçosos, 
 *   receberam atividades simples, repetitivas e sem desafios. Eles já tinham atingido o seu 
 *   pico de carreira no exército. Quer dizer, se forem deixados sozinhos, algum dia eles 
 *   poderão vir com alguma boa idéia ou, se nada trouxerem, também não causarão qualquer 
 *   tipo de problema.
 * Os oficiais do tipo ‘B’, os quais eram mentalmente brilhantes e fisicamente ativos, eram 
 *   considerados como obsessivos em gerenciamento detalhado e, por consequência, seriam líderes 
 *   medíocres. Poderiam ser promovidos durante um período de tempo, mas não para uma posição 
 *   de comando no Estado-Maior das forças armadas. Esses oficiais eram melhores para garantir 
 *   que ordens seriam cumpridas e que todos os detalhes seriam observados.
 * Os oficiais do tipo ‘C’, que eram mentalmente inexpressivos, mas fisicamente ativos eram 
 *   considerados como perigosos. Para Moltke, eles eram oficiais que iriam requerer supervisão 
 *   constante, o que significaria uma sobrecarga e distração inaceitável, e pelo fato de que 
 *   eles criariam potenciais problemas mais rápido do que poderiam ser gerenciados, esses oficiais 
 *   foram considerados muito trabalhosos e foram demitidos. Nenhuma carreira para eles!
 * O que nos leva aos oficiais do tipo ‘D’; esses eram oficiais mentalmente brilhantes ainda 
 *   que fisicamente preguiçosos, a quem Moltke sentiu que poderia e deveria levar aos mais altos 
 *   níveis de comando. Este tipo de oficial era, ao mesmo tempo, inteligente o suficiente para 
 *   perceber o que precisava ser feito e também era motivado pela sua preguiça natural a encontrar 
 *   as formas mais fáceis e simples de alcançar o que era requerido. Colocando de uma forma mais 
 *   positiva, eles saberiam como ser bem sucedidos com um esforço mais eficiente.
 *   
 *   Fonte: https://tarciocaldas.wordpress.com/2010/04/08/arte-da-preguica-produtiva/
 *   
 *   ---------------------------------------------------   
 *   Desta forma, crie um programa em Java que tenha uma:
 *   
 *   classe Pessoa, contendo as seguintes propriedades: 
 *      nome do tipo String, 
 *      idade do tipo inteiro (int), 
 *      ehInteligente do tipo boolean, 
 *      ehDiligente do tipo boolean. 
 *      Crie os métodos 
 *         set e get para estes atributos, 
 *         bem como um construtor que receba todos esses parâmetros.
 *   classe chamada Main, onde irá conter o 
 *      método main da aplicação (public static void main (String args[]), 
 *         onde serão programados as instruções de interação com o usuário.
 *   
 *   A aplicação permitirá o cadastramento de algumas pessoas (OBS.: número indeterminado de cadastros), 
 *   onde o operador irá digitar os campos do usuário.
 *   
 *   Ao final do cadastro o programa deverá perguntar se deseja cadastrar outra pessoa. 
 *   Ao encerrar o processo de cadastramento o programa deverá imprimir os dados de 
 *      todas as pessoas cadastrados (em ordem) e conforme o que foi respondido e armazenado nas 
 *      variáveis ehInteligente e ehDiligente, o sistema deve informar se a pessoa corresponde a 
 *      uma pessoa do tipo A, B, C ou D, conforme os critérios de classificação de Moltke.
 *   
 *   Segue exemplo de uma interação entre o usuário e o computador através do programa em execução:
 *      Digite o nome: José da Silva
 *      É inteligente (S/N)?: N
 *      É diligente (S/N)?: N
 *      Deseja cadastrar outra pessoa (S/N)?: S
 *      
 *      Digite o nome: Antônio Xavier
 *      É inteligente (S/N)?: S
 *      É diligente (S/N)?: S
 *      Deseja cadastrar outra pessoa (S/N)?: S
 *      
 *      Digite o nome: Joaquim dos Santos
 *      É inteligente (S/N)?: N
 *      É diligente (S/N)?: S
 *      Deseja cadastrar outra pessoa (S/N)?: S
 *      
 *      Digite o nome: Thiago Pereira
 *      É inteligente (S/N)?: S
 *      É diligente (S/N)?: N
 *      Deseja cadastrar outra pessoa (S/N)?: N
 *      
 *         nome: José da Silva
 *         tipo: A
 *         
 *         nome: Antônio Xavier
 *         tipo: B
 *         
 *         nome: Joaquim dos Santos
 *         tipo: C
 *         
 *         nome: Thiago Pereira
 *         tipo: D
 * */
public class Main {
	private ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
	public Scanner entrada = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Esse sistema tem por finalidade classificar o tipo de cada oficial informado\n" +
				"Informe o nome e a idade de quantos oficiais desejar e dica se são inteligentes e se são diligentes.\n" +
				"Caso queira terminar o preenchimento, informe N à perguta 'Deseja cadastrar outra pessoa (S/N)?'" +
				"\n\n");
		
		Main m = new Main();

		m.pessoas.add(m.getDados());
		
		boolean continuar = true;
		String cadastrar;
		int c = 0;
		do{
			do{
				if(c++ == 0){
					System.out.println("Deseja cadastrar outra pessoa (S/N)?");
				}else{
					System.out.println("Atenção!\n" +
										"informe uma resposta válida.\n" +
										"Deseja cadastrar outra pessoa (S/N)?:");
				}
				cadastrar = m.entrada.next();
			}while(!cadastrar.equalsIgnoreCase("s") && !cadastrar.equalsIgnoreCase("n") );
			
			
			if(cadastrar.equalsIgnoreCase("s")){
				c = 0;
				continuar = true;
				m.pessoas.add(m.getDados());
			}else{
				continuar = false;
			}
				
			
		} while(continuar);
			
		for (int i = 0; i < m.pessoas.size(); i++) {
			System.out.println("\nNome: " + m.pessoas.get(i).getNome());
			/*
			 * tipo A: não-inteligente e preguiçoso,
			 * tipo B: inteligente e diligente,
			 * tipo C: não-inteligente e diligente e
			 * tipo D: inteligente e preguiçoso.*/
			@SuppressWarnings("unused")
			String tipo = "";
			if(!m.pessoas.get(i).isEhDiligente() && !m.pessoas.get(i).isEhInteligente()){
				tipo = "A";
			}
			if(m.pessoas.get(i).isEhDiligente() && m.pessoas.get(i).isEhInteligente()){
				tipo = "B";
			}
			if(m.pessoas.get(i).isEhDiligente() && !m.pessoas.get(i).isEhInteligente()){
				tipo = "C";
			}
			if(!m.pessoas.get(i).isEhDiligente() && m.pessoas.get(i).isEhInteligente()){
				tipo = "D";
			}
			System.out.println("Tipo: " + tipo);
		}
		
	}
	
	private Pessoa getDados() 
	{
		//recebendo informações
		System.out.println("Digite o nome:");
		String nome = entrada.next();
		
		System.out.println("Digite a idade:");
		int idade = entrada.nextInt();
		
		String i;
		int c = 0;
		do{
			if(c++ == 0){
				System.out.println("É inteligente (S/N)?:");
			}else{
				System.out.println("Atenção!\n" +
									"informe uma resposta válida.\n" +
									"É inteligente (S/N)?:");
			}
			i = entrada.next();
		}while(!i.equalsIgnoreCase("s") && !i.equalsIgnoreCase("n") );
		
		c = 0;
		String d;
		do{
			if(c++ == 0){
				System.out.println("É diligente (S/N)?:");
			}else{
				System.out.println("Atenção!\n" +
									"informe uma resposta válida.\n" +
									"É diligente (S/N)?:");
			}
			d = entrada.next();
		}while(!d.equalsIgnoreCase("s") && !d.equalsIgnoreCase("n") );
		
		
		boolean ehInteligente;
		if(i.equalsIgnoreCase("s")){
			ehInteligente = true;
		}else{
			ehInteligente = false;
		}
		
		boolean ehDiligente = true;
		if(d.equalsIgnoreCase("s")){
			ehDiligente = true;
		}else{
			ehDiligente = false;
		}
		
		Pessoa p = new Pessoa(nome, idade, ehInteligente, ehDiligente);
		return p;
	}

	/**
	 * @return the pessoas
	 */
	public ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}

	/**
	 * @param pessoas the pessoas to set
	 */
	public void setPessoas(ArrayList<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

}
