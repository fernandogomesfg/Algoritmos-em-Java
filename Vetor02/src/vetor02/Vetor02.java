/**
 * Algoritmo sobre vetor construido com base no curo de Java para iniciantes do canal Curso em Video
 * Data:16/0/2021
 */
package vetor02;

/**
 *
 * @author Fernando Gomes
 */
public class Vetor02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String mes[] = {"Janeiro", "Fevereiro", "Marco", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        int dias[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int i = 0; i < mes.length; i++) {
            System.out.println("O mes de " + mes[i] + " tem " + dias[i]+ " dias");
        }
    }

}
