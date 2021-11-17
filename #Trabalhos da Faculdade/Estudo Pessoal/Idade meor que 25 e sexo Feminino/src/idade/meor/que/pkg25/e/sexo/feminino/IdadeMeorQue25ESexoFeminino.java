/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idade.meor.que.pkg25.e.sexo.feminino;

import java.util.Scanner;

/**
 *
 * @author Fernando Gomes
 */
public class IdadeMeorQue25ESexoFeminino {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String nome; 
        int idade, sexo;
        
        System.out.print("Nome: ");
        nome = teclado.next();
        System.out.print("Idade: ");
        idade = teclado.nextInt();
        System.out.println("Escolha o seu sexo");
        System.out.println("1 - Feminino");
        System.out.println("2 - Masculino");
        sexo = teclado.nextInt();
        
        if ((sexo == 1) && (idade < 25))   {
            System.out.println("Seu nome: "+nome+"\nAceita");
        } else {
            System.out.println("Seu nome: "+nome+"\nNao Aceita");
        }
        
    }
    
}
