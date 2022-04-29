/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Fernando Gomes
 */
public class JavaApplication13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        lista.add("Sérgio");
        lista.add("Paulo");
        lista.add("Guilherme");

        System.out.println(lista);
        Collections.sort(lista);
        System.out.println(lista);
    }

}
