package Model;

/**
 *
 * @author Antonio Macarringue, Fernando Gomes, Helio Langa & Samuel Ouana
 */
public class Estudante extends Usuario {

    //atributos
    private String num_estudante, curso;


    //construtor
    public Estudante(String nome, String data_nasc, String endereco, String num_telefone, String usuario, String senha, String perfil, int id, String num_estudante, String curso) {
        super(nome, data_nasc, endereco, num_telefone, usuario, senha, perfil, id);
        this.num_estudante = num_estudante;
        this.curso = curso;
    }

    public Estudante() {
    }

    //get e set
    public String getNum_estudante() {
        return num_estudante;
    }

    public void setNum_estudante(String num_estudante) {
        this.num_estudante = num_estudante;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

}
