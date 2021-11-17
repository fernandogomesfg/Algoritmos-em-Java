/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preencheminto.pkgdo.array.com.scanner;

import java.util.Scanner;

/**
 *
 * @author Fernando Gomes
 */
public class PreenchemintoDoArrayComSCANNER {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        int[] a = new int[10];
        
        //Preencheminto do array com SCANNER
        for (int i = 1; i < a.length; i++) {
            System.out.print("Digite o " + i + "o numero: ");
            a[i] = teclado.nextInt();

        }
    }
    
}
