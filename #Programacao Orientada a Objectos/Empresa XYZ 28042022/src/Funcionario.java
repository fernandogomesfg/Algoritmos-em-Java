

/**
 *
 * @author Fernando Gomes
 */
import java.io.*;

public abstract class Funcionario implements Serializable{
    //atributos
    private String num_BI, data_ingresso;
    private double salario_fixo;
    
    //construtor
    public Funcionario(String num_BI, String data_ingresso, double salario_fixo) {
        this.num_BI = num_BI;
        this.data_ingresso = data_ingresso;
        this.salario_fixo = salario_fixo;
    }
    
    //GET e SET
    public String getNum_BI() {
        return num_BI;
    }

    public void setNum_BI(String num_BI) {
        this.num_BI = num_BI;
    }

    public String getData_ingresso() {
        return data_ingresso;
    }

    public void setData_ingresso(String data_ingresso) {
        this.data_ingresso = data_ingresso;
    }

    public double getSalario_fixo() {
        return salario_fixo;
    }

    public void setSalario_fixo(double salario_fixo) {
        this.salario_fixo = salario_fixo;
    }
    
    //metodo toString

    @Override
    public String toString() {
        return "Funcionario: " + "Numnero de BI=" + num_BI + ", Data de Ingresso=" + data_ingresso + ", Salario fixo=" + salario_fixo + ' ';
    }
    
    
    //metodo abstrato (so possui cabecalho) 
    public abstract double calcularRemuneracao();
    
    
}
