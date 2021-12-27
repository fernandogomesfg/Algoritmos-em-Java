
/**
 *
 * @author Fernando Gomes
 */
public class Estudante {

    //Atributos
    public int idade;
    public String nome, nivel;

    //Construtor
    public Estudante(int idade, String nome, String nivel) {
        this.idade = idade;
        this.nome = nome;
        this.nivel = nivel;
    }

    //Metodos de acesso aos atributos
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    //metodo que altera o nivel
    public String altera_nivel() {
        return null;

    }

    //metodo print
    public void print() {
        System.out.println("Dados do Estuandate");
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
        System.out.println("Nivel: " + this.nivel);
    }

}
