/**
 * Menu das 4 operacoes basicas da Matematica
 * Data: 13/08/2019
 */
package menu.de.operacoes.matematicas;

import java.util.Scanner;

public class MenuDeOperacoesMatematicas {

    public static void main(String[] args) {
        double n1, n2, res = 0;
        Scanner teclado = new Scanner (System.in);
        
        System.out.print("Digite o primeiro número: ");
        n1 = teclado.nextDouble();
        System.out.print("Digite o segundo número: ");
        n2 = teclado.nextDouble();
        
        System.out.println(" ");
        System.out.println("MENU");
        System.out.println("ESCOLHA A OPÇÃO");
        System.out.println("1 - SOMA");
        System.out.println("2 - SUBTRACÇÃO");
        System.out.println("3 - MULTIPLICAÇÃO");
        System.out.println("4 - DIVISÃO");
        System.out.println(" ");
        
        int op = teclado.nextInt();
        switch (op){
            case 1: res = n1 + n2; break;
            case 2: res = n1 - n2; break;
            case 3: res = n1 * n2; break;
            case 4: res = n1 / n2; break;
        }
        System.out.println("Resultado: "+res);
        
        
    }
    
}
