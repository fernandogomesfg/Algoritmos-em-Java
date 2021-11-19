package criacaodamatriz;

import java.util.Scanner;

public class CriacaoDaMatriz {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int[][] matriz = new int[2][2];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = teclado.nextInt();
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.println(matriz[i][j] + "\t");
            }
        }
    }
}
