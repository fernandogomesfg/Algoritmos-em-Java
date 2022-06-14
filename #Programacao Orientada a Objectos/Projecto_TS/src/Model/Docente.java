package Model;

/**
 *
 * @author Antonio Macarringue, Fernando Gomes, Helio Langa & Samuel Ouana
 */
public class Docente extends Usuario {

    //atriutos
    private String nome_cadeira, status;
   

    //construtor
    public Docente(String nome, String data_nasc, String endereco, String num_telefone, String usuario, String senha, String perfil, int id, String nome_cadeira, String status) {
        super(nome, data_nasc, endereco, num_telefone, usuario, senha, perfil, id);
        this.nome_cadeira = nome_cadeira;
    }

    public Docente() {
    }

    //get e set
    public String getNome_cadeira() {
        return nome_cadeira;
    }

    public void setNome_cadeira(String nome_cadeira) {
        this.nome_cadeira = nome_cadeira;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    

}
