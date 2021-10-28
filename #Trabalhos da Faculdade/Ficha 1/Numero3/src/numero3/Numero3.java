/**
 * Supondo que a = 1, d = 1.0 e cada uma expressao e independente de outra, calcule o resultado de seguintes expressoes
 *
 * a) a = 49 / 6
 * b) a = 46 % 9 + 4 * 4 - 2
 * c) a = 45 + 45 * 50 % a --
 * d) a = 45 + 1 + 45 * 50 % (--a)
 * e) d = 34.23 * (a + 5) * d++
 * f) a %= 3/a + 3
 *
 * Data: 28/10/2021
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
        int a = 1;
        double d = 1.0;
        System.out.println("Alinea a): " + (a = 49 / 6));
        System.out.println("Alinea b): " + (a = 46 % 9 + 4 * 4 - 2));
        System.out.println("Alinea c): " + (a = 45 + 45 * 50 % a--));
        System.out.println("Alinea d): " + (a = 45 + 1 + 45 * 50 % (--a)));
        System.out.println("Alinea e): " + (d = 34.23 * (a + 5) * d++));
        System.out.println("Alinea f): " + (a %= 3 / a + 3));

    }

}
