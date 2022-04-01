
/**
 *
 * @author Fernando Gomes
 */
public class Func_comissionado extends Funcionario {

    //atributos
    private double percentagem;
    private int num_vendas;

    //construtor
    public Func_comissionado(String nome, String num_BI, String estado_civil, String data_nasc, String morada, String nome_pai, String nome_mae, String data_ingresso, String sexo, double altura, double salario, double percentagem, int num_vendas) {
        super(nome, num_BI, estado_civil, data_nasc, morada, nome_pai, nome_mae, data_ingresso, sexo, altura, salario);
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

    //metodo toString
    @Override
    public String toString() {
        return super.toString() + " Percentagem=" + percentagem + ", Numero de vendas=" + num_vendas + '}';
    }

    //metodo para calcular salario do comissionado
    @Override
    public double calcularRemuneracao() {
        return this.getSalario() + (this.getNum_vendas() * this.getPercentagem());
    }
}
