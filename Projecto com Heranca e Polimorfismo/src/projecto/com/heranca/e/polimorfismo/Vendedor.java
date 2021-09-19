package projecto.com.heranca.e.polimorfismo;

/**
 *
 * @author Fernando Gomes
 */
public class Vendedor extends Funcionario {

    //Atributos so do vendedor
    private int Qtd_Vendas;
    private Double Comissao;

    public Vendedor(String Nome, String CPF, String Telefone) {
        super(Nome, CPF, Telefone);
    }

    @Override
    public Double getSalario() {
        return this.Salario() + (this.Qtd_Vendas * this.Comissao);
    }

    @Override
    public String getDados() {
        return "Nome: " + this.getNome() + "\nTelefone: " + this.getTelefone() + "\nSalario: " + this.getSalario() + "\n";

    }

    public int getQtd_Vendas() {
        return Qtd_Vendas;
    }

    public void setQtd_Vendas(int Qtd_Vendas) {
        this.Qtd_Vendas = Qtd_Vendas;
    }

    public Double getComissao() {
        return Comissao;
    }

    public void setComissao(Double Comissao) {
        this.Comissao = Comissao;
    }

    

}
