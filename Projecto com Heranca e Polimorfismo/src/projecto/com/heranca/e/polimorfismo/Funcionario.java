package projecto.com.heranca.e.polimorfismo;

/**
 *
 * @author Fernando Gomes
 */
public class Funcionario {

    //Atributos para todos funcionarios
    private String Nome;
    private String CPF;
    private String Telefone;
    protected Double Salario;

    public Funcionario(String Nome, String CPF, String Telefone) {
        this.Nome = Nome;
        this.CPF = CPF;
        this.Telefone = Telefone;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public Double getSalario() {
        return this.Salario;
    }

    public void setSalario(Double Salrio) {
        this.Salario = Salrio;
    }

    public String getDados() {
        return "Nome: " + this.getNome() + "\nTelefone: " + this.getTelefone() + "\nSalario: " + this.getSalario() + "\n";

    }
}
