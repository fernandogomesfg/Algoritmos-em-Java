/**
 * Algoritmo que calcula o IMC do individuo
 * Data: 12/08/2019
 */
package indice.de.massa.corporal;

import java.util.Scanner;

/**
 *
 * @author Fernando Gomes
 */
public class IndiceDeMassaCorporal {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        double peso, altura, IMC;

        System.out.print("Digite o seu Peso em Kilogramas: ");
        peso = teclado.nextDouble();
        System.out.print("Digite a sua Altura em Metros: ");
        altura = teclado.nextDouble();
        IMC = peso / (altura * altura);

        if (IMC < 20) {
            System.out.println("Abaixo do Peso");
        } else if (IMC >= 20 && IMC < 25) {
            System.out.println("Peso Ideal");
        } else if (IMC >= 25 && IMC < 30) {
            System.out.println("Obesidade");
        } else if (IMC >= 30 && IMC < 35) {
            System.out.println("Obesidade Moderada");
        } else if (IMC >= 35 && IMC < 40) {
            System.out.println("Obesidade Severa");
        } else {
            System.out.println("Super Obesidade");
        }
        System.out.println("IMC: " + IMC);

    }

}
