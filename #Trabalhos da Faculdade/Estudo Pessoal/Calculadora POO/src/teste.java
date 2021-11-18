/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fernando Gomes
 */
public class teste extends Calculadora{
    public static void main(String[] args) {
        
        Calculadora c1 = new Calculadora(10, 0, '/');
        c1.calcular();
        
    }

    public teste(double num1, double num2, char op) {
        super(num1, num2, op);
    }
    
}
