/**
 * Informando qual pacote abarcará o programa GeradorDeLeroLero
 */
package exercicios;

/**
 * Criando a Classe GeradorDeLeroLero com vizibilidade para todas as outras classes (public)
 * @author RobertoOliveira
 *
 */
public class GeradorDeLeroLero {

	/**
	 * Criando o método main que receberá em args um array de objetos do tipo String
	 * Esse método reune as frases disponíveis no manual de redação oficial que são contraindicadas
	 * na forma de escrever (http://www.planalto.gov.br/ccivil_03/manual/manual.htm)
	 * @param args
	 */
	public static void main(String[] args) {
		
		String[] frase1 = {"O óbice sistêmico","A necessidade emergente"
							,"O quadro normativo"
							,"O critério metodológico"
							,"O modelo de desenvolvimento"
							,"O novo tema social"
							,"O método participativo"
							,"A utilização potencial"};

		String[] frase2 = {" se caracteriza por"," prefigura"," reconduz a sínteses" ," incrementa"," propicia"
								," propõe-se a"," privilegia"};       

		String[] frase3 = {" uma correta relação entre estrutura e superestrutura"
								," a superação de cada obstáculo e/ou resistência passiva"
								," a pontual correspondência entre objetivos e recursos"
								," o redirecionamento das linhas de tendências em ato"
								," o incorporamento das funções e a descentralização decisional"
								," o reconhecimento da demanda não satisfeita"
								," uma coligação orgânica interdisciplinar para uma práxis de trabalho de grupo,"}; 
		String[] frase4 = {" no interesse primário da população,"," sem prejudicar o atual nível das contribuições,"
							," com critérios não-dirigísticos,"," para além das contradições e dificuldades iniciais,"
							," numa visão orgânica e não totalizante,"," mediante mecanismos da participação,"
							," segundo um módulo de interdependência horizontal,"};  
		String[] frase5 = {" substanciando e vitalizando,"," não assumindo nunca como implícito,"
							," potenciando e incrementando,"," evidenciando e explicitando"," ativando e implementando,"
							," não omitindo ou calando, mas antes particularizando,"
							," recuperando, ou antes revalorizando,"};
		String[] frase6 = {" numa ótica preventiva e não mais curativa,"," no contexto de um sistema integrado,"
							," na medida em que isso seja factível,"," em termos de eficácia e eficiência,"
							," a cavaleiro da situação contingente,"," com as devidas e imprescindíveis enfatizações,"
							," como sua premissa indispensável e condicionante,"};
		String[] frase7 = {" a transparência de cada ato decisional."," um indispensável salto de qualidade."
							," o aplanamento de discrepâncias e discrasias existentes."
							," a adoção de uma metodologia diferenciada."," a redefinição de uma nova figura profissional."
							," o co-envolvimento ativo de operadores e utentes."
							," uma congruente flexibilidade das estruturas."};

		//Descubra
		int aLength = frase1.length;
		int bLength = frase2.length;
		int cLength = frase3.length;       
		int dLength = frase4.length;       
		int eLength = frase5.length;       
		int fLength = frase6.length;       
		int gLength = frase7.length;       

		//gere tres numeros aleatorios
		int rand1 = (int) (Math.random() * aLength);
		int rand2 = (int) (Math.random() * bLength);
		int rand3 = (int) (Math.random() * cLength);
		int rand4 = (int) (Math.random() * dLength);
		int rand5 = (int) (Math.random() * eLength);
		int rand6 = (int) (Math.random() * fLength);
		int rand7 = (int) (Math.random() * gLength);
		
		//Contruir frase
		String phrase = frase1[rand1] + frase2[rand2] + frase3[rand3] +"\n"+ frase4[rand4] + frase5[rand5] +"\n"+ frase6[rand6] + frase7[rand7];
		System.out.println(phrase);    
	}
}
