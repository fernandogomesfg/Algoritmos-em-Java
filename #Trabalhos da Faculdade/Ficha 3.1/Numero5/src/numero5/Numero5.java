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

        //int[] a = {14, 4, 5, 7, 84, 6, 14, 3, 4, 0,-14};
        int[] a = new int[10];
        //Preencheminto do array com SCANNER

        for (int i = 1; i < a.length; i++) {
            System.out.print("Digite o " + i + "o numero: ");
            a[i] = teclado.nextInt();

        }

        //Inicializar uma variavel
        int num_maior = a[0], num_menor = a[1];
        //Comparacao dos valores introduzidos no array
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
