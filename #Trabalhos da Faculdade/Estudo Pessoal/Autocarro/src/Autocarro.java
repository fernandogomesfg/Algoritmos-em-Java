/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fernando Gomes
 */
public class Autocarro {

    //atributos
    public String nome_da_empresa;
    public String matricula_do_carro;
    public String capacidade;

    //Construtor sem parametro
    public Autocarro() {

    }

    //Construtor

    public Autocarro(String nome_da_empresa, String matricula_do_carro, String capacidade) {
        this.nome_da_empresa = nome_da_empresa;
        this.matricula_do_carro = matricula_do_carro;
        this.capacidade = capacidade;
    }
    

    //Metodo imprimir
    public void imprimr() {
        System.out.println("Impressao dos dados da empresa");
        System.out.println("Nome: " + this.nome_da_empresa);
        System.out.println("Matricula: " + this.matricula_do_carro);
        System.out.println("Capacidade: " + this.capacidade);
    }

}
