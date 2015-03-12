/**
 * Informando qual pacote abarcará o programa TiposECaracteristicas
 */
package meuprimeiroprograma;

/**
 * Criando uma classe para brincar com TIPOS PRIMITIVOS E CARACTERÍSTICAS ESPECÍFICAS DO JAVA
 * TIPOS PRIMITIVOS
 * OPERADORES
 * @author RobertoOliveira
 *
 */
public class TiposECaracteristicas {
	/**
	 * byte 8 bits com sinal -128 a + 127
	 */
	private static byte contar;
	/**
	 * boolean 8 bits true ou false
	 */
	private static boolean verdade;
	/**
	 * short 16 bits com sinal - 32.768 a + 32.767
	 */
	private static short curto;
	/**
	 * int 32 bits com sinal - 2.147.483.648 a + 2.147.483.647
	 */
	private static int inteiro;
	/**
	 * long 64 bits com sinal - 9.223.372.036.854.775.808 a + 9.223.372.036.854.775.807
	 */
	private static long longo;
	/**
	 * char 16 bits sem sinal 0 a 65535
	 */
	private static char caracter;
	/**
	 * float 32 bits com sinal - 1.40239846E-45 a + 3.40282347E + 38 *
	 * 9 dígitos de precisão
	 */
	private static float flutuante;
	/**
	 * double 64 bits com sinal - 4.94065645841246544E-324 a + 1.79769313486231570E + 308
	 * 18 dígitos de precisão
	 */
	private static double flutuanteDuplo;
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Brincando com variáveis\n" +
				"\n '/'  = divisão" +
				"\n '%' = resto da divisão\n\n");
		
		int a = 8;
		int b = 3;
		
		int c = a / b;
		System.out.println("int c = a / b = " + c);
		
		float c1 = a / b;
		System.out.println("float c1 = a / b = " + c1);
		
		int c2 = a % b;
		System.out.println("float c2 = a % b = " + c2);
		
		
		
		System.out.println("Perceba que não adiantou declarar c1 como float para ter precisão." +
				"\nIsso é porque quem precisa ter precisão é pelo menos uma das variáveis da " +
				"\nequação (a ou b), não o resultado (c1).\n");
		System.out.println("");
		float d = 8;
		int e = 3;
		
		float f = d / e;
		System.out.println("int f = a / b = " + f);
		System.out.println("agora sim tem precisão, porque uma das variáveis da equação é float." +
				"\n e a variável do resultado também é float. " +
				"\n nesse caso, a variável do resultado obrigatóriamente precisa ser float, pois o " +
				"\n java não aceita outro tipo (a não se double).\n");
		float f1 = d % e; //retorna o resto da divisão
		System.out.println("float f2 = a % b = " + f1);
		
		System.out.println(" 'x++'  = incrementa 1 em x = x + 1" +
				"\n 'x--' = decrementa 1 em x = x - 1\n\n");
		
		int x = 8;
		System.out.println("x = " + x);
		x++;
		System.out.println("x++ >>> x = " + x);
		x--;
		System.out.println("x-- >>> x = " + x);
		
		System.out.println("\n\n\n OPERADORES ARITMÉTICOS" +
				"\n + Possibilita a soma de valores inteiros e de ponto flutuante" +
				"\n - Possibilita a subtração de valores inteiros e de ponto flutuante" +
				"\n * Possibilita a multiplicação de valores inteiros e de ponto flutuante" +
				"\n / Possibilita a divisão de valores inteiros e de ponto flutuante" +
				"\n % Possibilita a obtenção do valor de resto, em formato inteiro, após uma divisão" +
				"\n ++ Possibilita o incremento de valores inteiros e de ponto flutuante" +
				"\n -- Possibilita o decremento de valores inteiros e de ponto flutuante");
		
		System.out.println("\n\n\n OPERADORES LÓGICOS" +
				"\n && and (e lógico)" +
				"\n || or (ou lógico)" +
				"\n ! not (não lógico)");
		
		System.out.println("\n\n\n OPERADORES RELACIONAIS" +
				"\n > Compara se o operando do lado esquerdo é maior que o operando do lado direito" +
				"\n < Compara se o operando do lado esquerdo é menor que o operando do lado direito" +
				"\n >= Compara se o operando do lado esquerdo é maior ou igual ao operando do lado direito" +
				"\n <= Compara se o operando do lado esquerdo é menor ou igual ao operando do lado direito" +
				"\n == Compara se o operando do lado esquerdo é igual ao operando do lado direito" +
				"\n != Compara se o operando do lado esquerdo é diferente ao operando do lado direito\n\n\n");
		
		
		//vamos testar
		int alturaMinima = 178;
		int alturaMaxima = 183;
		int altura = 179;
		
		if( altura < alturaMinima){
			System.out.println("Altura "+ altura + " menor que a média (178 a 183)");
		}

		if( altura > alturaMaxima){
			System.out.println("Altura "+ altura + " maior que a média (178 a 183)");
		}

		if( altura >= alturaMinima && altura <= alturaMaxima ){
			System.out.println("Altura "+ altura + " está na média (178 a 183)");
		}
		
		System.out.println("\n\n\nPALAVRAS RESERVADAS EM JAVA\n\n Não podem ser utilizadas como identificadores (variaveis,classes,metodos...)\n" +
				"\n abstract continue for new switch" +
				"\n assert default if package synchronized" +
				"\n boolean do goto private this" +
				"\n break double implements protected throw" +
				"\n byte else import public throws" +
				"\n case enum instanceof return transient" +
				"\n catch extends int short try" +
				"\n char final interface static void" +
				"\n class finally long strictfp volatile" +
				"\n const float native super while\n\n\n");
		
		
	}

	public static byte getContar() {
		return contar;
	}

	/**
	 * @return the verdade
	 */
	public static boolean isVerdade() {
		return verdade;
	}

	/**
	 * @param verdade the verdade to set
	 */
	public static void setVerdade(boolean verdade) {
		TiposECaracteristicas.verdade = verdade;
	}

	/**
	 * @return the curto
	 */
	public static short getCurto() {
		return curto;
	}

	/**
	 * @param curto the curto to set
	 */
	public static void setCurto(short curto) {
		TiposECaracteristicas.curto = curto;
	}

	/**
	 * @return the inteiro
	 */
	public static int getInteiro() {
		return inteiro;
	}

	/**
	 * @param inteiro the inteiro to set
	 */
	public static void setInteiro(int inteiro) {
		TiposECaracteristicas.inteiro = inteiro;
	}

	/**
	 * @return the longo
	 */
	public static long getLongo() {
		return longo;
	}

	/**
	 * @param longo the longo to set
	 */
	public static void setLongo(long longo) {
		TiposECaracteristicas.longo = longo;
	}

	/**
	 * @return the caracter
	 */
	public static char getCaracter() {
		return caracter;
	}

	/**
	 * @param caracter the caracter to set
	 */
	public static void setCaracter(char caracter) {
		TiposECaracteristicas.caracter = caracter;
	}

	/**
	 * @return the flutuante
	 */
	public static float getFlutuante() {
		return flutuante;
	}

	/**
	 * @param flutuante the flutuante to set
	 */
	public static void setFlutuante(float flutuante) {
		TiposECaracteristicas.flutuante = flutuante;
	}

	/**
	 * @return the flutuanteDuplo
	 */
	public static double getFlutuanteDuplo() {
		return flutuanteDuplo;
	}

	/**
	 * @param flutuanteDuplo the flutuanteDuplo to set
	 */
	public static void setFlutuanteDuplo(double flutuanteDuplo) {
		TiposECaracteristicas.flutuanteDuplo = flutuanteDuplo;
	}

}
