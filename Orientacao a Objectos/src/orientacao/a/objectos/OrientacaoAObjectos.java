/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orientacao.a.objectos;

/**
 *
 * @author Fernando Gomes
 */
public class OrientacaoAObjectos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cadeira c1 = new Cadeira();
        c1.serrar();
        c1.lixar();
        c1.pintar();
        c1.setCor("Branca");
        System.out.println("Cor actual: " + c1.getCor());
        
    }

}
