package totoloto;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Fernando Gomes
 */
public class Totoloto {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random numeroGerado = new Random();

        //Declarando os vectores
        int vector[] = new int[5];
        int numDaSorte[] = new int[5];
        
         //Numeros gerados pelo radom
        for (int i = 0; i < vector.length; i++) {
            //Gera numeros aleatorios de 0-50
            vector[i] = numeroGerado.nextInt(4);

            //Mostra os 5 numeros gerados
            System.out.println("Os valores gerados sao:" + vector[i]);
        }

        //Pedidndo ao usuario para digitar os 5 numeros da sorte no intervalo de 0 -50
        System.out.println("Digite seus numeros da sorte no intervalo de 0-50");
        for (int i = 0; i < 5; i++) {
            System.out.print("Digite um numero: ");
            numDaSorte[i] = teclado.nextInt();
        }

        //Mostrando os numeros digitados pelo usuario
        for (int n : numDaSorte) {
            System.out.println("Numero escolhidos pelo usuario: " + n);
        }

       

        //Fazendo as comparacoes dos valores digitados e gerados
        if (Arrays.equals(vector, numDaSorte)) {
            System.out.println("Voce ganhou");
        } else {
            System.out.println("Perdeu");
        }

    }
}
