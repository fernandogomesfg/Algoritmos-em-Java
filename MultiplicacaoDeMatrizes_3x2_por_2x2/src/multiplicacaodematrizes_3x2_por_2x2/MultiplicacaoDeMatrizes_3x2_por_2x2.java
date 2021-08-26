package multiplicacaodematrizes_3x2_por_2x2;

import java.util.Scanner;

/**
 *
 * @author Fernando Gomes
 */
public class MultiplicacaoDeMatrizes_3x2_por_2x2 {

    public static void main(String[] args) {
        int ma[][] = new int[3][2];
        int mb[][] = new int[2][2];
        int mab[][] = new int[3][2];

        //Digitando os valores da primeira matriz
        System.out.println("Primeira Matriz");
        for (int i = 0; i < ma.length; i++) {
            for (int j = 0; j < ma[i].length; j++) {
                System.out.print("Digite o elemento da linha " + (i + 1) + " e coluna " + (j + 1) + " da matriz 1: ");
                ma[i][j] = new Scanner(System.in).nextInt();
            }
        }
        
        System.out.println();

        //Digitando os valores da segunda matriz
        System.out.println("Segunda Matriz");
        for (int i = 0; i < mb.length; i++) {
            for (int j = 0; j < mb[i].length; j++) {
                System.out.print("Digite o elemento da linha " + (i + 1) + " e coluna " + (j + 1) + " da matriz 2: ");
                mb[i][j] = new Scanner(System.in).nextInt();
            }
        }
        
        System.out.println();

        //Fazendo a multiplicacao das matrizes
        mab[0][0] = (ma[0][0] * mb[0][0]) + (ma[0][1] * mb[1][0]);
        mab[0][1] = (ma[0][0] * mb[0][1]) + (ma[0][1] * mb[1][1]);
        mab[1][0] = (ma[1][0] * mb[0][0]) + (ma[1][1] * mb[0][1]);
        mab[1][1] = (ma[1][0] * mb[0][1]) + (ma[1][1] * mb[1][1]);
        mab[2][0] = (ma[2][0] * mb[0][0]) + (ma[2][1] * mb[1][0]);
        mab[2][1] = (ma[2][0] * mb[0][1]) + (ma[2][1] * mb[1][1]);

        System.out.println("Multipliacação das matrizes:");

        //Imprimindo a matriz nova
        for (int i = 0; i < mab.length; i++) {
            for (int j = 0; j < mab[i].length; j++) {
                System.out.printf("%d \t", mab[i][j]);
            }
            System.out.println();
        }
    }

}
