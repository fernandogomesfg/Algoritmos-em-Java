/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fernando Gomes
 */
public class Arvore_Binaria {

    //Represent the node of binary tree  
    public static class Vertice {

        int dados;
        Vertice esquerda;
        Vertice direita;

        public Vertice(int dados) {
            //Assign data to the new node, set esquerda and direita children to null  
            this.dados = dados;
            this.esquerda = null;
            this.direita = null;
        }
    }

    //Represent the root of binary tree  
    public Vertice root;

    public Arvore_Binaria() {
        root = null;
    }

    //findHeight() will determine the maximum height of the binary tree  
    public int findHeight(Vertice temp) {
        //Check whether tree is empty  
        if (root == null) {
            System.out.println("Tree is empty");
            return 0;
        } else {
            int alturaEsquerda = 0, alturaDireita = 0;

            //Calculate the height of esquerda subtree  
            if (temp.esquerda != null) {
                alturaEsquerda = findHeight(temp.esquerda);
            }

            //Calculate the height of direita subtree  
            if (temp.direita != null) {
                alturaDireita = findHeight(temp.direita);
            }

            //Compare height of esquerda subtree and direita subtree  
            //and store maximum of two in variable max  
            int max = (alturaEsquerda > alturaDireita) ? alturaEsquerda : alturaDireita;

            //Calculate the total height of tree by adding height of root  
            return (max + 1);
        }
    }

    public static void main(String[] args) {

        Arvore_Binaria ab = new Arvore_Binaria();
        //Add nodes to the binary tree  
        ab.root = new Vertice(1);
        ab.root.esquerda = new Vertice(2);
        ab.root.direita = new Vertice(3);
        ab.root.esquerda.esquerda = new Vertice(4);
        ab.root.direita.esquerda = new Vertice(5);
        ab.root.direita.direita = new Vertice(6);
        ab.root.direita.direita.direita = new Vertice(7);
        ab.root.direita.direita.direita.direita = new Vertice(8);

        //Display the maximum height of the given binary tree  
        System.out.println("Maximum height of given binary tree: " + ab.findHeight(ab.root));
    }
}


