package Model;

/**
 *
 * @author Antonio Macarringue, Fernando Gomes, Helio Langa & Samuel Ouana
 */
public class Administrador extends Usuario {

    //atributos
    private String sector;

    //construtor
    public Administrador(String sector, String nome, String endereco, String num_telefone, int idade) {
        super(nome, endereco, num_telefone, idade);
        this.sector = sector;
    }

    //GET e SET
    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    //toStrig
    @Override
    public String toString() {
        return super.toString() + "Administrador{" + "sector=" + sector + '}';
    }

}
