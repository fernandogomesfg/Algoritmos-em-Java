/**
 * Algoritmo que calcula a area de um triangulo
 * Data: 16/08/2019
 */
package area.triangulo;

import java.util.Scanner;

/**
 *
 * @author Fernando Gomes
 */
public class AreaDoTriangulo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double base, altura, Area;

        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite o valor da base: ");
        base = teclado.nextDouble();
        System.out.print("Digite o valor da altura: ");
        altura = teclado.nextDouble();

        Area = ((base * altura) / 2);
        System.out.println("O seu triângulo tem como área: " + Area);

    }

}
