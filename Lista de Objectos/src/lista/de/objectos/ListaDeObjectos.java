/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista.de.objectos;

import java.util.ArrayList;

/**
 *
 * @author Fernando Gomes
 */
public class ListaDeObjectos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int valor = 5;
        double valor_d = 10.5;
        boolean maior_idade = true;

        String nome = "Fernando Gomes";
       String nome2 = "Fernando Gomes";

        if (nome.equals(nome2)) {
            //System.out.println("Nomes Iguais");
        } else {
            //System.out.println("Nomes diferentes");
        }
        
        //Listas
        ArrayList<String> lista = new ArrayList();
        //Adicionar item na lista
        lista.add("Fernando");
        lista.add("Jose");
        lista.add("Lucas");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
                
    }

}
