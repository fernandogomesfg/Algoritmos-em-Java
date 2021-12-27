/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numero2;

/**
 *
 * @author Fernando Gomes
 */
public class Numero2  extends Trabalhador{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Trabalhador t1 = new Trabalhador("Fernando Gomes", 21, 100.5);
        t1.alteraSalario(150);
        
    }

    public Numero2(String nome, int idade, double salario) {
        super(nome, idade, salario);
    }
    
}
