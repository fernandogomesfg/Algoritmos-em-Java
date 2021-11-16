/**
 * Faça um programa que termine o maior e o menor valor de 10 números introduzidos.
 *
 * Data: 31/10/2021
 */
package numero5;

import java.util.Scanner;

/**
 *
 * @author Fernando Gomes
 */
public class Numero5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int[] a = {14, 4, 5, 7, 84, 6, 14, 3};
        int num_maior = a[0];
        int num_menor = a[0];
        
        for (int i = 1; i < a.length; i++) {
            if (num_maior < a[i]) {
                num_maior = a[i];
            }
            if (num_menor > a[i]) {
                num_menor = a[i];
            }
            
            
        }

        System.out.println("O menor numero menor eh: " + num_menor);
        System.out.println("O menor numero maior eh: " + num_maior);
    }
}
