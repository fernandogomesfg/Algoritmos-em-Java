/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

import java.util.Scanner;

/**
 *
 * @author Fernando Gomes
 */
public class Fibonacci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int anterior1 = 1, anterior2 = 1, proximo = 0, n;
        int soma = 0;
        System.out.print("N: ");
        n = teclado.nextInt();
        System.out.print("1 1");
        for (int i = 3; i <= n; i++) {
            proximo = anterior1 + anterior2;
            System.out.print(" " + proximo);
            anterior2 = anterior1;
            anterior1 = proximo;

        }
        System.out.println("\n");
        if (n == 2) {
            soma = 2;
            System.out.println("A soma dos " + n + "numeros eh: " + soma);
        } else {
            soma = soma + proximo;
            System.out.println("A soma dos " + n + "numeros eh: " + soma);
        }

    }

}
