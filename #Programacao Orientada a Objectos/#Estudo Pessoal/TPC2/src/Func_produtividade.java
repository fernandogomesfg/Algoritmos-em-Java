

/**
 *
 * @author Fernando Gomes
 */
public class Func_produtividade extends Funcionario{
    //atributos
    private int unidade_produzida;
    private double valor_por_unidade;
    
    //construtor
    public Func_produtividade(String nome, String data_nasc, String nome_pai, String nome_mae, String morada, String naturalidade, String data_emissao, String data_ingresso, double atura, double salario, int unidade_produzida, double valor_por_unidade) {
        super(nome, data_nasc, nome_pai, nome_mae, morada, naturalidade, data_emissao, data_ingresso, atura, salario);
        this.unidade_produzida = unidade_produzida;
        this.valor_por_unidade = valor_por_unidade;
    }
    
    //GET eSET
    public int getUnidade_produzida() {
        return unidade_produzida;
    }

    public void setUnidade_produzida(int unidade_produzida) {
        this.unidade_produzida = unidade_produzida;
    }

    public double getValor_por_unidade() {
        return valor_por_unidade;
    }

    public void setValor_por_unidade(double valor_por_unidade) {
        this.valor_por_unidade = valor_por_unidade;
    }
    
    
    //metodo toSTring
    @Override
    public String toString() {
        return super.toString() + " unidade_produzida=" + unidade_produzida + ", valor_por_unidade=" + valor_por_unidade + '}';
    }
    
    //metodo para calcular a remuneracao
    @Override
    public double calcularRemuneracao(){
        return this.getSalario() + (this.getUnidade_produzida() * this.getValor_por_unidade());
    }
    
    
            
    
}
