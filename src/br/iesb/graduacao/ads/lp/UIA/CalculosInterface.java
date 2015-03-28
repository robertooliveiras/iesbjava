package br.iesb.graduacao.ads.lp.UIA;

public interface CalculosInterface {
	
	double piValue = 3.14159265359;
	
	//Calculos com números
	
	public double calcularMedia(double[] a);
	public double calcularMedia(float[] a);
	public double calcularMedia(long[] a);
	public double calcularMedia(int[] a);
	public double calcularMedia(short[] a);
	
	//Calculos de áreas
	
	/**
	 * Serve para Quadrado e Circulo
	 * @param a
	 * @return
	 */	 
	public double calcularArea(double a);
	
	/**
	 * Serve para Retangulo, Triangulo, Losangulo, Polígono Regular
	 * @param a
	 * @param b
	 * @return
	 */
	public double calcularArea(double[] a, double b);
	
	/**
	 * Serve para Trapézio
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public double calcularArea(double a, double b, double c);
	
	//Calculos de perímetros
	
	/**
	 * Serve para Quadrados
	 * @param a
	 * @return
	 */
	public double calcularPerimetro(double[][] a);
	
	/**
	 * Calcula o perímetro de Circulos
	 * @param a
	 * @return
	 */
	public double calcularPerimetro(double a);
	
	//Calculos de volumes
	
	/**
	 * Serve para Cubos e Esferas
	 * @param a
	 * @return
	 */
	public double calculaVolume(double a);
	
	/**
	 * Serve para Paralelepipedos
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public double calculaVolume(double a, double b, double c);
	
	/**
	 * Serve para Prismas regulares, Cilindros, Cones
	 * @param a
	 * @param b
	 * @return
	 */
	public double calculaVolume(double a, double b);
	
	
	//Calculos de Funções e Equações  ---- essas são difíceis, mas são o pulo do gato
	
	/**
	 * 
	 * @param tipo = D ou I  (Direta ou Inversa)
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public double calculaProporcionalidade(String tipo, double k, double x , double y);
	
	/**
	 * (-b +/-raiz de b² - 4ac) / 2a
	 * Concavidaee a > 0 cima
	 * Concavidade a < 0 baixo
	 * Binômio discriminante delta = b² - 4ac
	 * Vértice da Parábola = V (-b/2a , -delta/4a)
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public double calculaEquacaoSegundoGrau(double a, double b , double c);
	
	

}
