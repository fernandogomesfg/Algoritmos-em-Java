/**
 * Programa que recebe um numero n e vai calculando a soma e produto dos numeros digitados, se n for multiplo de 3 ele mostra so a soma, caso contrario mostra o produto
 * Data:22/12/2020
 */
package javaapplication24;

import java.util.Scanner;

/**
 *
 * @author Fernando Gomes
 */
public class Soma_Produto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);

        int prod = 1;
        int soma = 0;
        int n;
        do {

            System.out.print("Introduza um numero: ");
            n = teclado.nextInt();
            if (n >= 0) {
                soma = soma + n;
                prod = prod * n;
                if (n % 3 == 0) {
                    System.out.println("O valor da soma e " + soma);
                } else {
                    System.out.println("O valor do produto e " + prod);
                }

            } else {
                System.out.println("Fim do Programa");
            }
        } while (n < 0 || n > 0);
        {

        }

    }

}
