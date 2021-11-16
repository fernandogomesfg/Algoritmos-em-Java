

/**
 *
 * @author Fernando Gomes
 */
public class Pais {

    //Atributos da classe
    public String nome, nome_da_capital;
    public double dimensão;

    //a) Construtor que inicialize o nome, capital e a dimensão do país
    public Pais(String nome, String nome_da_capital, double dimensão) {
        this.nome = nome;
        this.nome_da_capital = nome_da_capital;
        this.dimensão = dimensão;
    }
    
    //Um construtor sem parametros nao nos pedem no exercicio, entao essa parte nao eh necessaria colocar, mas serve de apoio para criar objecto na CLASSE TESTE para usar inserir dados em usar o parametro do objecto
    //public Pais() {
    //}
    
    //A linha cria uma excepcao para o controle de do construtr sem parametros
    Pais() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //b)  Métodos (get e set) para todos os atributos do país
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome_da_capital() {
        return nome_da_capital;
    }

    public void setNome_da_capital(String nome_da_capital) {
        this.nome_da_capital = nome_da_capital;
    }

    public double getDimensão() {
        return dimensão;
    }

    public void setDimensão(double dimensão) {
        this.dimensão = dimensão;
    }

    //c)  Um método que possibilite imprimir todos os dados de um país
    public void imprimir() {
        System.out.println("Dados do pais");
        System.out.println("Pais: " + this.nome);
        System.out.println("Capital: " + this.nome_da_capital);
        System.out.println("Dimensao: " + this.dimensão + " km2");
        System.out.println();
    }
    
    //d)  Um método que permita verificar se dois países são iguais. Dois países são iguais se tiverem o mesmo nome e a mesma capital.
    public void verificar(){
        //Aqui ainda nao tenho ideia
        
    }
    
}
