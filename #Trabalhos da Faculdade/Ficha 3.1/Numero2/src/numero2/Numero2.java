/**
 * Faça um programa java que determine se um dado número é ímpar ou par.
 *
 * Data: 31/10/2021
 */
package numero2;

import java.util.Scanner;

/**
 *
 * @author Fernando Gomes
 */
public class Numero2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num;
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digiete um numero: ");
        num = teclado.nextInt();
        if (num % 2 == 0) {
            System.out.println("O numero " + num + " eh par");
        } else {
            System.out.println("O numero " + num + " eh impar");
        }
    }

}
