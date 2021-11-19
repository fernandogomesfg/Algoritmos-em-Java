/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testado.ciclos;

/**
 *
 * @author Fernando Gomes
 */
public class TestadoCiclos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        int k = 0;
        for (int i = 0; i < 10; i++) {
            k +=3;
            System.out.println("S="+k);
        }
*/
        int k = 0, i=0;
        while (i < 10) {            
            i++;
            k = k +i;
            
        }
        System.out.println("S="+k);
        
        
    }
    
}
