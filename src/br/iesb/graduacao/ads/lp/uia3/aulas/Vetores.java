package br.iesb.graduacao.ads.lp.uia3.aulas;

public class Vetores {
    public int[] meuArrayDeInteiros1 = new int[10];
    public int[] meuArrayDeInteiros2 = {11,12,13,14,15,16,17,18,19,20};
    public float[] meuArrayDefloats1 = new float[3];
    public float[] nota = {(float)9.3, (float)5.3};
    public String[] concorrentes = new String[20];

    public Vetores() {
//        nota[2] = (float) 5.5; //erro de compilação
//        nota[3] = (float) 10.0; //erro de compilação pois o vetor foi declarado com 2 posições
        System.out.println(nota[0]);
        System.out.println(nota[1]);        
        
        for (int i = 0; i < meuArrayDeInteiros2.length; i++) {
            System.out.println(meuArrayDeInteiros2[i]);            
        }
        
        for (int i = 0; i < concorrentes.length; i++) {
            concorrentes[i] = i+1 +"º Colocado";
            System.out.println(i+1 +"º Colocado");
        }
        
        int[] meuArray;
        meuArray = new int[10];
        for (int i = 0; i < meuArray.length; i++) {
            meuArray[i] = i * 2 + 3;
        }

        for (int i = 0; i < meuArray.length; i++) {
            System.out.println("A posição " + i + " do meu array é igula a: " + meuArray[i]);
        }
        
    }
    public static void main(String[] args){
        @SuppressWarnings("unused")
        Vetores v = new Vetores();
    }

}
