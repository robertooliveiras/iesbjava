/**
 * Exercicio 1
 */
package br.iesb.graduacao.ads.lp.exercicios;

/**
 * Esse pacote permite escanear entradas de dados
 */
import java.util.Scanner;

/**
 * 
 * O Indice de Massa Corporal eh uma medida utilizada para medir a obesidade adotada pela 
 * Organizacao Mundial de Saude (OMS). Eh o padrao internacional para avaliar o grau de obesidade
 * 
 * IMC = Peso/(altura*altura)  //Peso em Kg dividido pelo quadrado do valor da altura em metros
 * 
 * @author RobertoOliveira
 *
 */


public class IndiceMassaCorporal {
	
	private TabelaIMC tIMC;
	
	enum TabelaIMC { MAP(1,"Muito Abaixo do Peso","Cuidado, você está muito abaixo do peso!"
			+ "\né preciso se alimentar bem para ser saudável.")
				, AbP(2,"Abaixo do Peso","[Frase apreensiva]")
				, PNo(3,"Peso Normal","Muito bom!! você está de parabéns pois seu peso está compatível com sua altura!"
						+ "\ncontinue assim!")
				, AcP(4,"Acima do Peso","[Frase apreensiva]")
				, OI(5,"Obesidade I","[Frase muito apreensiva]")
				, OII(6,"Obesidade II","[Frase preocupante]")
				, OIII(7,"Obesidade III","[Frase ainda ais preocupante]" );
		private int size;
		private String description, frase;
		TabelaIMC(int s, String d, String f){
				this.size = s;
				this.description = d;
				this.frase = f;
		}
		
		public int getSize(){
			return size;
		}

		public String getDescription(){
			return description;
		}

		public String getFrase(){
			return frase;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		float IMC, altura, peso;
        String nome;
		
		Scanner entrada = new Scanner(System.in);
        System.out.println("Bom dia!\n" +
        				   "Sou o dr. Jarvis.\n\n" +
        				   "Qual é o seu nome?"); 
        
        nome = entrada.next();
        
        System.out.println(nome +
        				   ", estou aqui para avaliar seu Indice de Massa Corporal (IMC).\n" +
        				   "Você precisará responder apenas duas perguntas!\n\n" +
        				   "Não vale mentir, heim!\n\n");
        
    	
        System.out.println("Qual é a sua altura em metros? ");
        altura = entrada.nextFloat();
        
        System.out.println("Qual é o seu peso em kg?: ");
        peso = entrada.nextFloat();
        
        entrada.close();
        
        IMC = peso / (altura * altura);

        IndiceMassaCorporal myIMC = new IndiceMassaCorporal();        
        if(IMC <= 17){
        	myIMC.tIMC = TabelaIMC.MAP;
        }else if(IMC > 17 && IMC <= 18.49){
        	myIMC.tIMC = TabelaIMC.AbP;
        }else if(IMC > 18.49 && IMC <= 24.99){
        	myIMC.tIMC = TabelaIMC.PNo;
        }else if(IMC > 24.99 && IMC <= 29.99){
        	myIMC.tIMC = TabelaIMC.AcP;
        }else if(IMC > 29.99 && IMC <= 34.99){
        	myIMC.tIMC = TabelaIMC.OI;
        }else if(IMC > 34.99 && IMC <= 39.99){
        	myIMC.tIMC = TabelaIMC.OII;
        }else if(IMC > 39.99){
        	myIMC.tIMC = TabelaIMC.OIII;
        }
        
        System.out.println("Pesando "+peso+" kg com "+altura+"m de altura, O seu IMC é igual a " + IMC);
        System.out.println("O seu estado físico é "+myIMC.tIMC.getDescription());        
        System.out.println("\n\n"+myIMC.tIMC.getFrase());

        System.out.println("\n\nVeja abaixo os níveis de estado físico registrados na br.iesb.java.Ex1");

        
        for(TabelaIMC mi: TabelaIMC.values()){
    		System.out.println(mi.getSize() + " = " + mi.getDescription() );
    	}
	}

	/**
	 * @return the t_imc
	 */
	public TabelaIMC getTIMC() {
		return tIMC;
	}

	/**
	 * @param t_imc the t_imc to set
	 */
	public void setTIMC(TabelaIMC tIMC) {
		this.tIMC = tIMC;
	}
}
