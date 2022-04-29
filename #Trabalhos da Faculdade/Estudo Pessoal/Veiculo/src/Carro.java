/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fernando Gomes
 */
public class Carro extends Veiculo {

    //atributos
    private String num_motor;

    //construtor
    public Carro(String num_motor, String marca, String modelo, String cor, double preço) {
        super(marca, modelo, cor, preço);
        this.num_motor = num_motor;
    }

    //get e set
    public String getNum_motor() {
        return num_motor;
    }

    public void setNum_motor(String num_motor) {
        this.num_motor = num_motor;
    }

    
    //toString

    @Override
    public String toString() {
        return super.toString() + "Carro{" + "num_motor=" + num_motor + '}';
    }
    
}
