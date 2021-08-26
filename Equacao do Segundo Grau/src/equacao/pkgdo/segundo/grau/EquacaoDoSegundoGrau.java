/**
 * Descrisao: Equação Quadrática ou equação do segundo grau é uma equação polinomial de grau dois. A forma geral deste tipo de equação é: ax^{2}+bx+c=0, em que x é uma variável, sendo a, b e c constantes, com a ≠ 0
 * Data: 25/08/2021
 */

package equacao.pkgdo.segundo.grau;

import static java.lang.Math.sqrt;
import java.util.Scanner;

/**
 *
 * @author Fernando Gomes
 */
public class EquacaoDoSegundoGrau {

    public static void main(String[] args) {
        double a, b, c, x, x1, x2, Delta;
        Scanner FG = new Scanner(System.in);
        
        //Pede os valores de a, b, c
        System.out.print("Digite o valor de a: ");
        a = FG.nextDouble();
        System.out.print("Digite o valor de b: ");
        b = FG.nextDouble();
        System.out.print("Digite o valor de c: ");
        c = FG.nextDouble();

        //Calcula o Delta
        Delta = ((b * b) - 4 * a * c);

        //Imprime o Delta
        System.out.println("O valor de Delta é " + Delta);
        
        //Verifuca as comdicoes de existencia de solucao
        if (Delta > 0) {
            System.out.println("Tem Duas Raizes");
            x1 = (-b + sqrt(Delta) / (2 * a));
            x2 = (-b - sqrt(Delta) / (2 * a));
            System.out.println("Valor de x1" + x1);
            System.out.println("Valor de x2" + x2);
        } else if (Delta < 0) {
            System.out.println("Nao tem Raizes");
        } else {
            System.out.println("Tem Raiz distinta");
            x = (-b + sqrt(Delta) / (2 * a));
            System.out.println("Valor de x" + x);
        }
    }
}
