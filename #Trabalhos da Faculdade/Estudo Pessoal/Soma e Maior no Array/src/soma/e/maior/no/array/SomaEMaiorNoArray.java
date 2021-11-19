/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soma.e.maior.no.array;

import java.util.Scanner;

/**
 *
 * @author Fernando Gomes
 */
public class SomaEMaiorNoArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        //Criando o array
        int[] num = new int[20];

        //Preenchimento do array
        for (int i = 0; i < num.length; i++) {
            System.out.print("Digite um elemento array: ");
            num[i] = teclado.nextInt();

        }

        //Soma dos elementos
        int soma = 0;
        for (int i = 0; i < num.length; i++) {
            soma = soma + num[i];

        }
        System.out.println("O valor da soma eh: " + soma);

        //maio elemento do array
        int maior = num[0];
        for (int i = 0; i < num.length; i++) {
            if (maior < num[i]) {
                maior = num[i];
            }

        }
        System.out.println("O maior elemento do array eh " + maior);
    }

}
