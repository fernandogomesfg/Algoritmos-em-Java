/**
 * Faça um programa java para calcular as duas raízes de uma equação do segundo grau, sendo dado os valores dos coeficientes a, b, c
 * 
 * Data: 31/10/2021
 */
package numero1;

import java.util.Scanner;

/**
 *
 * @author Fernando Gomes
 */
public class Numero1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Variaveis
        double a, b, c, x1, x2, delta = 0;
        Scanner teclado = new Scanner(System.in);

        //Inserindo dados com o teclado
        System.out.print("Digite o valor de a: ");
        a = teclado.nextDouble();
        System.out.print("Digite o valor de b: ");
        b = teclado.nextDouble();
        System.out.print("Digite o valor de c: ");
        c = teclado.nextDouble();

        //Verificando se o valor de a nao eh igual a zero
        if (a != 0) {
            delta = ((b * b) - 4 * a * c);
        } else {
            System.out.println("O valor deve ser diferente de zero");
        }
        
        //Exibindo o valor de Delta
        System.out.println("O valor de Delta eh: " + delta);

        if (delta < 0) {
            System.out.println("A equacao nao possui raizes, pois o Delta eh negativo");
        } else if (delta == 0) {
            System.out.println("A equacao possui duas raizez distintas");
            x1 = (-b + (Math.sqrt(delta))) / (2 * a);
            System.out.println("O valor de x1 eh: " + x1 + " e o x2 eh: " + x1);
        } else {
            System.out.println("A equacao possui duas raizes, pois o Delta e maior que zero");
            x1 = (-b + (Math.sqrt(delta))) / (2 * a);
            x2 = (-b - (Math.sqrt(delta))) / (2 * a);
            System.out.println("O valor de x1 eh: " + x1 + " e o x2 eh: " + x2);
        }

    }

}
