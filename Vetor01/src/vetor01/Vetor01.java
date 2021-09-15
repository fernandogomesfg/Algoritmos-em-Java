/**
 * Algoritmo sobre vetor construido com base no curo de Java para iniciantes do canal Curso em Video
 * Data:16/0/2021
 */
package vetor01;

/**
 *
 * @author Fernando Gomes
 */
public class Vetor01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n[] = {1, 8, 9, 5, 1, 5, 7, 75, 75, 7};

        //Mostrar o tamanho do vetor
        System.out.println("O tamanho do vetor e " + n.length);

        //Mostrar os elementos do vetor
        for (int i = 0; i <= n.length; i++) {
            System.out.println("Na posicao " + i + " temos o valor " + n[i]);
        }
    }

}
