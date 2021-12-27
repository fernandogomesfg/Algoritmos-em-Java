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
public class Numero2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] x = {-2, 3, 1, 6, 4, 7, 2, 3, -1, -7};
        
        for (int i = 0; i < x.length; i+=2) {
            x[i] = 2 *x[i];
            //System.out.println(x[i]);
            
        }
        
        int s = 0;
        for (int i = 0; i < x.length; i++) {
            s = s +x[i] ;
            System.out.println("soma" +s);
            
        }
        
    }

}
