
/**
 *
 * @author Fernando Gomes
 */
public class FuncProdutividade extends Funcionario{
    //atributis
    private int unidade_produzida;
    private double valor_unidade_produzida;
    
    //construtor
    public FuncProdutividade(String num_BI, String data_ingresso, double salario_fixo, int unidade_produzida, double valor_unidade_produzida) {
        super(num_BI, data_ingresso, salario_fixo);
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
    
    //toString
    @Override
    public String toString() {
        return "FuncProdutividade{" + "unidade_produzida=" + unidade_produzida + ", valor_unidade_produzida=" + valor_unidade_produzida + '}';
    }
    
    //metodo para calcular salario do produtividade
    @Override
    public double calcularRemuneracao() {
        return this.getSalario_fixo() + (this.getUnidade_produzida() * 0.1);    //duvida
    }

}
