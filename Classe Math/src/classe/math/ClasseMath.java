/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe.math;

/**
 *
 * @author Fernando Gomes
 */
public class ClasseMath {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long num = 100;
        //Raiz quadrada
        System.out.println("A raiz quadrada de " + num + " eh " + Math.sqrt(num));

        //Random
        System.out.println("Numero aletorio: " + Math.random());

        //POW
        System.out.println("O quadrado de " + num + " e " + Math.pow(num, 2));
    }

}
