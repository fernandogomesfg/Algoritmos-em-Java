/**
 * Calcular o resultado das seguintes expressoes booleanas (se possivel)
 *
 * Data: 28/10/2021
 */
package numero7;

/**
 *
 * @author Fernando Gomes
 */
public class Numero7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int x = 0;
        System.out.println("Alinea a): " + ((true) && (3 > 4)));
        System.out.println("Alinea b): " + (!(x > 0) && (x > 0)));
        System.out.println("Alinea c): " + ((x > 0) || (x == 0)));
        System.out.println("Alinea d): " + ((x >= 0) || (x < 0)));
        System.out.println("Alinea d): " + ((x >= 1) || (!(x = 1))));
        
        
    }

}
