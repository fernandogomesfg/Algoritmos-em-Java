/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fernando Gomes
 */
public class Cachorro {
    //atributos
    public String nome,raca;
    public int idade;
    
    //construtor
    public Cachorro(String nome, String raca, int idade) {
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
    }
    
    //metodo
    public void print(){
        System.out.println("Nome do cachorro: " +this.nome);
        System.out.println("Raca do Cachorro: " +this.raca);
        System.out.println("Idade do Cachoro: " +this.idade);
    }
    
}
