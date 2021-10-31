/**
 * Faça um programa que some todos os números compreendidos de 0 à 20;
 *
 * Data: 31/10/2021
 */
package numero3;

/**
 *
 * @author Fernando Gomes
 */
public class Numero3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int soma = 0;

        for (int i = 0; i <= 20; i++) {
            soma = soma + i;
            //soma += i;
        }
        System.out.println("A soma de todos os números compreendidos de 0 à 20 eh: " + soma);
    }

}
