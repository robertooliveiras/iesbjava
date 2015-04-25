package br.iesb.posgraduacao.excessao;

public class Processo1 {
	
	private long valorAtual;

	public Processo1(long valor) {
		valorAtual = valor;
	}
	
	public void processoPesado(){
		try {
			for (int i = 100000000; i >=0; i--) {
				
				valorAtual = valorAtual * 1 * (i / 2) / i;
				System.out.println(this.getClass().getName() + " : " + valorAtual);
				
				if(i == (100000000 - 10)){
					throw new Error("Limite muito baixo");
				}
				
				if(i == 10){
					throw new Exception("'i' chegou a 10");
				}
			}
		} catch (ArithmeticException ae) {
			ae.printStackTrace();
			ae.getCause();
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		} catch (Error err) {
			err.getMessage();
			err.printStackTrace();
		} 
			
	}
	
	public void outroProcessoPesado() throws ArithmeticException, Exception, Error{
		for (int i = 100000000; i >=0; i--) {
			
			valorAtual = valorAtual * 1 * (i / 2) / i;
			System.out.println(this.getClass().getName() + " : " + valorAtual);
			
			if(i == (100000000 - 10)){
				throw new Error("Limite muito baixo");
			}
			
			if(i == 10){
				throw new Exception("'i' chegou a 10");
			}
		}
			
	}

}
