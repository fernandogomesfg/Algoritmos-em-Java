/**
 * Programa basico de uso da funcao RANDOm
 * Data: 18/06/2021.
 */
package Random;

import java.util.Random;

/**
 *
 * @author Fernando Gomes
 */
public class Funcao_Random {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Random numeroGerado = new Random();
       
        //Imprime uma sequencia de 10 numeros inteiros aleatorios de 0-99
        for (int i = 0; i < 10; i++) {
            System.out.println(numeroGerado.nextInt(100));
        }
    }
    

}
