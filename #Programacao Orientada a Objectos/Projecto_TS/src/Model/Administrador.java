package Model;

/**
 *
 * @author Antonio Macarringue, Fernando Gomes, Helio Langa & Samuel Ouana
 */
public class Administrador extends Usuario {

    //atributos
    private String sector;

    //construtor
    public Administrador(String nome, String data_nasc, String endereco, String num_telefone, String usuario, String senha, String perfil, int id, String sector) {
        super(nome, data_nasc, endereco, num_telefone, usuario, senha, perfil, id);
        this.sector = sector;
    }

    public Administrador() {
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
