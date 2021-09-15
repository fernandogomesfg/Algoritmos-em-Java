/**
 * Algoritmo que ordena elementos de um vetor
 * Data:16/09/2021
 */
package ordenando.valores.de.um.vetor;

import java.util.Arrays;

/**
 *
 * @author Fernando Gomes
 */
public class OrdenandoValoresDeUmVetor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int vetor[] = {1, 7, 712, 54, 8, -81, -814, 24};
        Arrays.sort(vetor);
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + ", ");

        }

    }

}
