package array.de.pkg20.soma.e.maior.numero;

import java.util.Scanner;

/**
 *
 * @author Fernando Gomes
 */
public class ArrayDe20SomaEMaiorNumero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int[] num = new int[10];
        
        //Preencheminto do array com SCANNER
        for (int i = 1; i < num.length; i++) {
            System.out.print("Digite o " + i + "o numero: ");
            num[i] = teclado.nextInt();

        }

        //impressao dos valores
        //for (int i = 0; i < num.length; i++) {
          //  System.out.print("Os elementos do array sao: " + num[i] + "");

        //}
    }

}
