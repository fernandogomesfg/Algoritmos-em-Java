/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numero8;

import javax.swing.JOptionPane;

/**
 *
 * @author Fernando Gomes
 */
public class Numero8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i;
     while (true){
         String s= JOptionPane.showInputDialog("Introduza um inteiro:");
         i= Integer.parseInt(s);
         if(i==0) /*return*/;
         System.out.println("i="+i);
    }
    
    }
}
