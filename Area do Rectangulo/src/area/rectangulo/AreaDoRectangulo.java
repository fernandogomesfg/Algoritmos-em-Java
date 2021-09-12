/**
 * Algoritmo que calcula a area de um rectangulo
 * Data:19/08/2019
 */
package area.rectangulo;

import java.util.Scanner;

/**
 *
 * @author Fernando Gomes
 */
public class AreaDoRectangulo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double comprimento, largura, Area;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite o comprimento do retângulo");
        comprimento = teclado.nextDouble();
        System.out.println("Digite o largura do retângulo");
        largura = teclado.nextDouble();

        Area = comprimento * largura;
        System.out.println("A área do retângulo é de " + Area);

    }

}
