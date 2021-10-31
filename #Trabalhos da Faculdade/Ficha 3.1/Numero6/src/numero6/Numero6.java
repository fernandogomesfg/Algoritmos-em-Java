/**
 * Qual será a saída do programa abaixo
 *
 * public class Ciclo{
 *  public static void main (String args []){
 *      boolean a = true;
 *      int i;
 *      while(a)
 *          for(i=0; i<=5; i++)
 *              System.out.println(i);
 *      System.out.println("Fim do Ciclo");
 *  }
 * }
 */
package numero6;

/**
 *
 * @author Fernando Gomes
 */
public class Numero6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean a = true;
        int i;
        while (a) {
            for (i = 0; i <= 5; i++) {
                System.out.println(i);
            }
        }
        System.out.println("Fim do Ciclo");
        
        //A saida sera: 0 1 2 3 4 5 0 1 2 3 4 5....
    }

}
