/**
 * Informando qual pacote abarcará o programa GeradorDeLeroLero
 */
package br.iesb.graduacao.ads.lp.exercicios;

/**
 * Criando a Classe GeradorDeLeroLero com vizibilidade para todas as outras classes (public)
 * @author RobertoOliveira
 *
 */
public class GeradorDeLeroLeroOtmz {

	/**
	 * Criando o método main que receberá em args um array de objetos do tipo String
	 * Esse método reune as frases disponíveis no manual de redação oficial que são contraindicadas
	 * na forma de escrever (http://www.planalto.gov.br/ccivil_03/manual/manual.htm)
	 * 
	 * trabalhando
	 * http://www.caelum.com.br/apostila-java-orientacao-objetos/um-pouco-de-arrays/#5-2-arrays-de-referencias
	 * http://www.devmedia.com.br/trabalhando-com-arrays-em-java/25530
	 * @param args
	 */
	public static void main(String[] args) {
		
		String[][] frases = {
								{	 "O óbice sistêmico"
									, "A necessidade emergente"
									, "O quadro normativo"
									, "O critério metodológico"
									, "O modelo de desenvolvimento"
									, "O novo tema social"
									, "O método participativo"
									, "A utilização potencial"}
								 , {  " se caracteriza por"
									 , " prefigura"
									 , " reconduz a sínteses" 
									 , " incrementa"
									 , " propicia"
									 , " propõe-se a"
									 , " privilegia"}
								 , {" uma correta relação entre estrutura e superestrutura"
									," a superação de cada obstáculo e/ou resistência passiva"
									," a pontual correspondência entre objetivos e recursos"
									," o redirecionamento das linhas de tendências em ato"
									," o incorporamento das funções e a descentralização decisional"
									," o reconhecimento da demanda não satisfeita"
									," uma coligação orgânica interdisciplinar para uma práxis de trabalho de grupo,"}
								 , {" no interesse primário da população,"
									 ," sem prejudicar o atual nível das contribuições,"
									," com critérios não-dirigísticos,"
									," para além das contradições e dificuldades iniciais,"
									," numa visão orgânica e não totalizante,"
									," mediante mecanismos da participação,"
									," segundo um módulo de interdependência horizontal,"}
								 , {" substanciando e vitalizando,"," não assumindo nunca como implícito,"
									," potenciando e incrementando,"
									," evidenciando e explicitando"
									," ativando e implementando,"
									," não omitindo ou calando, mas antes particularizando,"
									," recuperando, ou antes revalorizando,"}
								 , {" numa ótica preventiva e não mais curativa,"
									 ," no contexto de um sistema integrado,"
									," na medida em que isso seja factível,"
									," em termos de eficácia e eficiência,"
									," a cavaleiro da situação contingente,"
									," com as devidas e imprescindíveis enfatizações,"
									," como sua premissa indispensável e condicionante,"}
								 , {" a transparência de cada ato decisional."
									 ," um indispensável salto de qualidade."
									," o aplanamento de discrepâncias e discrasias existentes."
									," a adoção de uma metodologia diferenciada."
									," a redefinição de uma nova figura profissional."
									," o co-envolvimento ativo de operadores e utentes."
									," uma congruente flexibilidade das estruturas."}
							};
		
		int[] frand = new int[frases.length];
		String lerolero = "";
		for(int i = 0; i < frases.length; i++){
			frand[i] = (int) (Math.random() * frases[i].length);
			String quebra = "";
			if(i == 2 || i == 4) quebra = "\n";
			lerolero = lerolero + frases[i][frand[i]] + quebra;
		}
		System.out.println(lerolero);    
	}
}
