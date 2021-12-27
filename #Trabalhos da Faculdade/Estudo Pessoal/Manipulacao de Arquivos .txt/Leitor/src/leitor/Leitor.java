/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leitor;

import java.io.*;

/**
 *
 * @author Fernando Gomes
 */
public class Leitor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            FileInputStream arquivo  = new FileInputStream("arquivo.txt");
            InputStreamReader input = new InputStreamReader(arquivo);
            BufferedReader br = new BufferedReader(input);
            String linha;
            
            do {   
                linha = br.readLine();
                if (linha != null) {
                    //System.out.println("Lido = "+linha);
                    String[] palavras = linha.split(" ");
                    System.out.println("Nova linha----------");
                    for (int i = 0; i < palavras.length; i++) {
                        System.out.println("Palavra lida: "+ palavras[i]);
                        
                    }
                }
                
            } while (linha != null);
        } catch (Exception e) {
        }
    }
    
}
