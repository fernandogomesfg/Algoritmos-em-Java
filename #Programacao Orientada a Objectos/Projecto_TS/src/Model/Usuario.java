package Model;

/**
 *
 * @author Antonio Macarringue, Fernando Gomes, Helio Langa & Samuel Ouana
 */
public abstract class Usuario{

    //atributos
    private String nome, data_nasc, endereco, num_telefone, usuario, senha, perfil;
    private int id;
    

    //construtor
    public Usuario() {
    }

    public Usuario(String nome, String data_nasc, String endereco, String num_telefone, String usuario, String senha, String perfil, int id) {
        this.nome = nome;
        this.data_nasc = data_nasc;
        this.endereco = endereco;
        this.num_telefone = num_telefone;
        this.usuario = usuario;
        this.senha = senha;
        this.perfil = perfil;
        this.id = id;
    }

    //get e set
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNum_telefone() {
        return num_telefone;
    }

    public void setNum_telefone(String num_telefone) {
        this.num_telefone = num_telefone;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }

   
}
