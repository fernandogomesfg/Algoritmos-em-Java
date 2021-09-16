/**
 * Fazendo busca no vetor
 * Data:16/09/2021
 */
package fazendo.buscas.no.vetor;

import java.util.Arrays;

/**
 *
 * @author Fernando Gomes
 */
public class FazendoBuscasNoVetor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int vet[] = {1, 5, 4, 3, 98, 34, 22};
        for (int v : vet) {
            System.out.print(v + " ");
        }
        System.out.println("");
        int posicao = Arrays.binarySearch(vet, 5);
        System.out.println("Encontrei o valor na posicao " + posicao);
    }

}
