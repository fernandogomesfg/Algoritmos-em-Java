
/**
 *
 * @author Fernando Gomes
 */
public class Director {

    //atriutos
    public String nome, departamento;
    public double salario;

    //construtor
    public Director(String nome, String departamento, double salario) {
        this.nome = nome;
        this.departamento = departamento;
        this.salario = salario;
    }

    //metodos de acesso aos atributos
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    //metodo altera salario
    public void alteraSalario(double novoSalario) {
        salario = novoSalario;
        System.out.println("O salario do" + getNome() + " foi alterado para " + salario);
    }

    //print
    public void print() {
        System.out.println("Dados do director");
        System.out.println("Nome: " + getNome());
        System.out.println("Departamento: " + getDepartamento());
        System.out.println("Salario: " + getSalario());
    }

}
