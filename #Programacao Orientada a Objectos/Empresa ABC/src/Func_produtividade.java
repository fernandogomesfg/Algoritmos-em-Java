
/**
 *
 * @author Fernando Gomes
 */
public class Func_produtividade extends Funcionario {

    //atributis
    private int unidade_produzida;
    private double valor_unidade_produzida;

    //construtor
    public Func_produtividade(String nome, String num_BI, String estado_civil, String data_nasc, String morada, String nome_pai, String nome_mae, String data_ingresso, String sexo, double altura, double salario, int unidade_produzida, double valor_unidade_produzida) {
        super(nome, num_BI, estado_civil, data_nasc, morada, nome_pai, nome_mae, data_ingresso, sexo, altura, salario);
        this.unidade_produzida = unidade_produzida;
        this.valor_unidade_produzida = valor_unidade_produzida;
    }

    //GET e SET
    public int getUnidade_produzida() {
        return unidade_produzida;
    }

    public void setUnidade_produzida(int unidade_produzida) {
        this.unidade_produzida = unidade_produzida;
    }

    public double getValor_unidade_produzida() {
        return valor_unidade_produzida;
    }

    public void setValor_unidade_produzida(double valor_unidade_produzida) {
        this.valor_unidade_produzida = valor_unidade_produzida;
    }

    //metodo toString
    @Override
    public String toString() {
        return super.toString() + " Unidade_produzida=" + unidade_produzida + ", valor_unidade_produzida=" + valor_unidade_produzida + '}';
    }

    //metodo para calcular salario do produvidade
    @Override
    public double calcularRemuneracao() {
        return this.getSalario() + (this.getValor_unidade_produzida() * 0.1);   //duvida
    }
    
    

}
