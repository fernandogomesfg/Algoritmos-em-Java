package numero2;

/**
 *
 * @author Fernando Gomes
 */
public class Trabalhador {

    //atributos
    public String nome;
    public int idade;
    public double salario;

    //construtor
    public Trabalhador(String nome, int idade, double salario) {
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
    }

    //Metodos de acesso ao atributos ao atributos
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    //Metodo que altera o salario
    public void alteraSalario(double salarioNovo) {
        salario = salarioNovo;
        System.out.println("O salrio de"+getNome()+" foi alterado para "+salario);

    }

    //metodo para imprimir dados do trabalhador
    public void print() {
        System.out.println("Dados do Trabalhador");
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
        System.out.println("Salario: " + this.salario);
    }

}
