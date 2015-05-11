package br.iesb.graduacao.ads.lp.uia3.aulas;

public class VetoresE1 {

    public static void main(String[] args){
        int[] meuArray;
        meuArray = new int[10];
        for (int i = 0; i < meuArray.length; i++) {
            meuArray[i] = i * 2 + 3;
        }

        for (int i = 0; i < meuArray.length; i++) {
            System.out.println("A posição " + i + " do meu array é igula a: " + meuArray[i]);
        }
    }
}
