/**
 * Escreva um programa que calcula a area de um rectangulo
 * 
 * Data:28/10/2021
 */
package numero8;

import java.util.Scanner;

/**
 *
 * @author Fernando Gomes
 */
public class Numero8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double comprimento, largura, area;
        
        System.out.print("Digite o comprimento do rectangulo: ");
        comprimento = teclado.nextDouble();
        System.out.print("Digite a largura do rectangulo: ");
        largura = teclado.nextDouble();
        
        area = comprimento * largura;
        
        System.out.println("A area do rectangulo eh "+area);
    }
    
}
