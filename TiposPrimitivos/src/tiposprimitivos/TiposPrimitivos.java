package tiposprimitivos;

import java.util.Scanner;

/**
 *
 * @author Fernando Gomes
 */
public class TiposPrimitivos {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite o seu nome: ");
        String nome = teclado.nextLine();

        System.out.print("Digite a nota: ");
        float nota = teclado.nextFloat();

        System.out.println("O " + nome + " tem a nota " + nota);
    }

}
