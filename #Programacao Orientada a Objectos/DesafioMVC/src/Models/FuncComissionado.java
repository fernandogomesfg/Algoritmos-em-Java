
package Models;

/**
 *
 * @author Fernando Gomes
 */
public class FuncComissionado extends Funcionario{
    
    //atributos
    private double percentagem;
    private int num_vendas;

    //construtor
    public FuncComissionado(String num_BI, String data_ingresso, double salario_fixo, double percentagem, int num_vendas) {
        super(num_BI, data_ingresso, salario_fixo);
        this.percentagem = percentagem;
        this.num_vendas = num_vendas;
    }

    //GET e SET
    public double getPercentagem() {
        return percentagem;
    }

    public void setPercentagem(double percentagem) {
        this.percentagem = percentagem;
    }

    public int getNum_vendas() {
        return num_vendas;
    }

    public void setNum_vendas(int num_vendas) {
        this.num_vendas = num_vendas;
    }

    //toString
    @Override
    public String toString() {
        return super.toString() + " Percentagem=" + percentagem + ", Numero de vendas=" + num_vendas + '}';
    }

    //metodo para calcular salario do comissionado
    @Override
    public double calcularRemuneracao() {
        return this.getSalario_fixo() + (this.getNum_vendas() * this.getPercentagem());
    }

    
}
