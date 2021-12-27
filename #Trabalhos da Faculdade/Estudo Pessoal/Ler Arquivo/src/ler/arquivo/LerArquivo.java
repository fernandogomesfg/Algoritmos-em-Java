
package ler.arquivo;

import java.nio.file.*;
import javax.swing.JOptionPane;
//import java.nio.file.Paths;

/**
 *
 * @author Fernando Gomes
 */
public class LerArquivo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Path caminho = Paths.get("C:/arquivo.txt");
        try {
            byte [] texto = Files.readAllBytes(caminho);
            String leitura = new String(texto);
            //JOptionPane.showMessageDialog(null, leitura);
            System.out.println(leitura);
        } catch (Exception e) {
        }
    }
    
}
