

/**
 *
 * @author Fernando Gomes
 */
public class Calculadora {

    //atributos
    public double num1, num2;
    public char op;

    //construtor
    public Calculadora(double num1, double num2, char op) {
        this.num1 = num1;
        this.num2 = num2;
        this.op = op;
    }

    public void calcular() {
        if (this.op == '+') {
            System.out.println(this.num1 + this.num2);
        }else if (this.op == '-') {
            System.out.println(this.num1 - this.num2);
        }else if (this.op == '*') {
            System.out.println(this.num1 * this.num2);
        }else if (this.op == '/') {
            if (this.num2 == 0) {
                System.out.println("Impossivel dividir por zero");
            }else{
                System.out.println(this.num1 / this.num2);
            }
            
        }
        
    }

}
