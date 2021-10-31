/**
 * Faça um programa que calcule o factorial de um número n;
 *
 * Data: 31/10/2021
 */
package numero4;

import java.util.Scanner;

/**
 *
 * @author Fernando Gomes
 */
public class Numero4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int fat = 1, n;
        Scanner teclado = new Scanner(System.in);

        //Pedindo o valor de n
        System.out.print("Digite o valor de n: ");
        n = teclado.nextInt();
        
        //fazendo o calculo de factorial
        for (int i = 1; i <= n; i++) {
            fat = fat * i;
        }
        
        //Imprimindo o valor de factorial
        System.out.println("O factorial de " + n + " eh " + fat);
    }

}
