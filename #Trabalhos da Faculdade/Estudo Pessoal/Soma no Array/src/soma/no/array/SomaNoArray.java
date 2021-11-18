/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soma.no.array;

import java.util.Scanner;

/**
 *
 * @author Fernando Gomes
 */
public class SomaNoArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int[] a = new int[3];

        //Preencheminto do array com SCANNER
        for (int i = 0; i < a.length; i++) {
            System.out.print("Digite o " + (i + 1) + "o numero: ");
            a[i] = teclado.nextInt();

        }

        //impressao do aray
        System.out.println("");
        System.out.println("Os elemntos do array sao:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        //maior elemento do array
        int maior = a[0];
        for (int i = 0; i < a.length; i++) {
            if (maior < a[i]) {
                maior = a[i];

            }
        }
        System.out.println("\n");
        System.out.println("O maior valor do array eh: " + maior);

        //soma dos elementos do array
        int soma = 0;
        for (int i = 0; i < a.length; i++) {
            soma = soma + a[i];
        }
        System.out.println("");
        System.out.println("A soma dos valores do array eh: " + soma);

        //multiplicacao dos elementos do array
        int multiplicacao = 1;
        for (int i = 0; i < a.length; i++) {
            multiplicacao = multiplicacao * a[i];

        }
        System.out.println("");
        System.out.println("A multiplicacao dos valores do array eh: " + multiplicacao);
    }

}
