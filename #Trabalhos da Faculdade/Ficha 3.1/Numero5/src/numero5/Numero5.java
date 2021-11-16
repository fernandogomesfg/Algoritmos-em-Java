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
        int num, num_maior = 0, num_menor = 0;
        Scanner teclado = new Scanner(System.in);
        
      
        for (int i = 1; i <= 10; i++) {
            System.out.print("Digite o " + i + "o numero: ");
            num = teclado.nextInt();

            if (num > num_maior) {
                num_maior = num;
            }
            if (num < num_menor) {
                num_menor = num;
            }
        }
        System.out.println("O menor numero menor eh: " + num_menor);
        System.out.println("O menor numero maior eh: " + num_maior);

    }

}
