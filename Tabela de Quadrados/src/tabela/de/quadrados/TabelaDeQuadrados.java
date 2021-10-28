/**
 * Algoritmo que imprime o quadrado dos 100 primeiros numeros
 * Data:28/10/2021
 */
package tabela.de.quadrados;

/**
 *
 * @author Fernando Gomes
 */
public class TabelaDeQuadrados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Tabela de Quadrados");
        for (int i = 0; i <= 100; i++) {
            System.out.println("O quadrado de " + i + " eh " + Math.pow(i, 2));
        }

    }

}
