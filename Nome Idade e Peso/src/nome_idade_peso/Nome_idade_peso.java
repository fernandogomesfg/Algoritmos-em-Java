/**
 * Mostra o seu nome, idade e peso, depoois de introduzidos pelo teclado
 * Data: 02/10/2020
 */
package nome_idade_peso;

import java.util.Scanner;

/**
 *
 * @author Fernando Gomes
 */
public class Nome_idade_peso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String nome; 
        int idade; 
        float peso;
        
        System.out.print("Digite seu nome: ");
        nome = teclado.nextLine();
        
        System.out.print("Digite sua idade: ");
        idade = teclado.nextInt();
        
        System.out.print("Digite seu peso: ");
        peso = teclado.nextFloat();
        
        System.out.println("Seu nome eh " + nome + ", tem " + idade + " anos de idade.\n" + "O seu peso eh " +peso );
        
       
        
    }
    
}
