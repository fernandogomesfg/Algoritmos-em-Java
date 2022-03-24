
/**
 *
 * @author Fernando Gomes
 */
public class Operario extends Colaborador {

    //atriutos
    private double valor_producao, comissao;

    //construtor
    public Operario(String nome, String endereco, String telefone, int cod_setor, double salario, double imposto, double valor_producao, double comissao) {
        super(nome, endereco, telefone, cod_setor, salario, imposto);
        this.valor_producao = valor_producao;
        this.comissao = comissao;
    }

    //GET e SET
    public double getValor_producao() {
        return valor_producao;
    }

    public void setValor_producao(double valor_producao) {
        this.valor_producao = valor_producao;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    //metodo toString
    @Override
    public String toString() {
        return super.toString() + ", Valor da producao = " + valor_producao + ", Comissao = " + comissao + '}';
    }

    //metodo para calcular salario do operario
    @Override
    public double calcularSalario() {
        return super.calcularSalario() + (this.comissao * this.valor_producao);
    }

}
