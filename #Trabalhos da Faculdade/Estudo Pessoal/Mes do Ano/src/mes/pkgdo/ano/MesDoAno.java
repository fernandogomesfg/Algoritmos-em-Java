/**
 * Ler um número inteiro entre 1 e 12 e escrever o mês correspondente. Caso o número seja fora desse intervalo, informar que não existe mês com este número
 */
package mes.pkgdo.ano;

import java.util.Scanner;

/**
 *
 * @author Fernando Gomes
 */
public class MesDoAno {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        //int op;

        System.out.println("Introduza um numero de 1-12");
        int op = teclado.nextInt();

        switch (op) {
            case 1:
                System.out.println("Jaeiro");
                break;
            case 2:
                System.out.println("Fevereiro");
                break;
            case 3:
                System.out.println("Marco");
                break;
            case 4:
                System.out.println("Abril");
                break;
            case 5:
                System.out.println("Maio");
                break;
            case 6:
                System.out.println("Junho");
                break;
            case 7:
                System.out.println("Julho");
                break;
            case 8:
                System.out.println("Agosto");
                break;
            case 9:
                System.out.println("Setembro");
                break;
            case 10:
                System.out.println("Outubro");
                break;
            case 11:
                System.out.println("Novemro");
                break;
            case 12:
                System.out.println("Dezembro");
            default:
                System.out.println("ERRO");
        }
    }

}
