/**
 * Algoritmo que mostra a hora do sistema no terminal
 * Data: 12/08/2020
 */
package horadosistema;

import java.util.Date;

/**
 *
 * @author Fernando Gomes
 */
public class HoraDoSistema {

    public static void main(String[] args) {
        //Progrma que mostra hora e data do sistema
        
        Date relogio = new Date();
        System.out.println("A hora do Sistema eh:");
        System.out.println(relogio.toString());
    }
    
}
