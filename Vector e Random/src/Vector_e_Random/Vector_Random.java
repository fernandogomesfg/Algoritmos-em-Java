/**
 * Criando um vetor de 5 elementos usando a funcao Random
 * Data: 18/06/2021
 */
package Vector_e_Random;

import java.util.Random;

/**
 *
 * @author Fernando Gomes
 */
public class Vector_Random {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random numeroGerado = new Random();

        int vector[] = new int[5];

        for (int i = 0; i < vector.length; i++) {
            //Gera numeros aleatorios de 0-20
            vector[i] = numeroGerado.nextInt(21);

            //Mostra os 5 numeros gerados
            System.out.print(vector[i]+ " ");
        }
        System.out.println();
    }

}
