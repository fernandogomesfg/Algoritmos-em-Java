/**
 * Orientecao a objectos com classe Aluno
 * Data: 18/09/2021
 */
package orientacao.a.objectos.pkg2;

/**
 *
 * @author Fernando Gomes
 */
public class Aluno {

    private String nome;
    private String numero;
    private String matricula;

    //Construtor aluno
    //O aluno deve ser criado com um nome --Aluno a1 = new Aluno("[nome do aluno]")
    public Aluno(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    //Funcao/metodo para imprimir dados com objecto ALUNO
    public void ImprimirDados() {
        System.out.println("Nome: " + this.getNome() + "\nNumero: " + this.getNumero() + "\nMatricula: " + this.getMatricula());

    }
    
    public static double Media(double nota1, double nota2){
        return (nota1 + nota2)/2;
    }

}
