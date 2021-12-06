/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package divisores.proprios;

import java.util.Scanner;

/**
 *
 * @author Fernando Gomes
 */
public class DivisoresProprios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int num, soma = 0, par = 0, impar = 0;

        System.out.print("Numero: ");
        num = teclado.nextInt();

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                System.out.println(i);
                soma = soma + i;
                
//Alinea c
                if (i % 2 == 0) {
                    par = par + 1;
                } else {
                    impar = impar + 1;
                }
            }

        }
        System.out.println("A soma dos divisores de " + num + " e igual a:" + soma);
        System.out.println("Os numeros pares sao: " + par);
        System.out.println("Os numeros impares sao: " + impar);
    }

}
