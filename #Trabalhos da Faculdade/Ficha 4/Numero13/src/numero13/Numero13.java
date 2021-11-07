/**
 * Usando o formato do programa do exercicio 12, escreva um programa para testar as funcoes
 *
 * Data: 07/11/2021
 */
package numero13;

/**
 *
 * @author Fernando Gomes
 */
public class Numero13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Algumas funcoes matematicas");
        double num = 2;
        System.out.println("abs("+num+") = " + Math.abs(num));
        System.out.println("round("+num+") = " + Math.round(num));
        System.out.println("pow("+num+") = " + Math.pow(num, num));
        System.out.println("toDegrees("+num+") = " + Math.toDegrees(num));
        System.out.println("toRadians("+num+") = " + Math.toRadians(num));
        System.out.println("random() = " + Math.random());

    }

}
