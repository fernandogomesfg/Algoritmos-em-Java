package Model;

/**
 *
 * @author Antonio Macarringue, Fernando Gomes, Helio Langa & Samuel Ouana
 */
public class Docente extends Usuario {

    //atriutos
    private String nome_cadeira;

    //construtor
    public Docente(String nome_cadeira, String nome, String endereco, String num_telefone, int idade) {
        super(nome, endereco, num_telefone, idade);
        this.nome_cadeira = nome_cadeira;
    }

    //GET e SET
    public String getNome_cadeira() {
        return nome_cadeira;
    }

    public void setNome_cadeira(String nome_cadeira) {
        this.nome_cadeira = nome_cadeira;
    }

    //toString
    @Override
    public String toString() {
        return super.toString() + "Docente{" + "Nome da cadeira que lecciona=" + nome_cadeira + '}';
    }

}
