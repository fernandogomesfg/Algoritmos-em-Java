

/**
 *
 * @author Fernando Gomes
 */
public class Func_Comissionado extends Funcionario{
    //atriutos
    private double percentual, num_vendas;
    
    //construtor
    public Func_Comissionado(String nome, String data_nasc, String nome_pai, String nome_mae, String morada, String naturalidade, String data_emissao, String data_ingresso, double atura, double salario, double percentual, double num_vendas) {
        super(nome, data_nasc, nome_pai, nome_mae, morada, naturalidade, data_emissao, data_ingresso, atura, salario);
        this.percentual = percentual;
        this.num_vendas = num_vendas;
    }
    
    //GET e SET
    public double getPercentual() {
        return percentual;
    }

    public void setPercentual(double percentual) {
        this.percentual = percentual;
    }

    public double getNum_vendas() {
        return num_vendas;
    }

    public void setNum_vendas(double num_vendas) {
        this.num_vendas = num_vendas;
    }
    
    
    //to String
    @Override
    public String toString() {
        return super.toString() + " percentual=" + percentual + ", num_vendas=" + num_vendas + '}';
    }
    
    //metodo para calcular remuneracao
    @Override
    public double calcularRemuneracao(){
        return this.getSalario() + (this.getPercentual() * this.getNum_vendas());
    }
    
    
}
