/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escritor;

import java.io.*;

/**
 *
 * @author Fernando Gomes
 */
public class Escritor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try {
            FileOutputStream arquivo  = new FileOutputStream("arquivo.txt");
            PrintWriter pr = new PrintWriter(arquivo);
            
            pr.println("Fernando Gomes 10 14 11");
            pr.println("Fernando Gomes 14 18 13");
            pr.println("Fernando Gomes 10 10 08");
            
            pr.close();
            arquivo.close();
        } catch (Exception e) {
        }
    }
    
}
