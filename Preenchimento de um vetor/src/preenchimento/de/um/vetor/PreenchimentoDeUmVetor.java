/**
 * Preenhimento de um vetor
 * Data:16/09/2021
 */
package preenchimento.de.um.vetor;

import java.util.Arrays;

/**
 *
 * @author Fernando Gomes
 */
public class PreenchimentoDeUmVetor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int vetor[] = new int[20];
        Arrays.fill(vetor, 0);
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
            
        }
    }
    
}
