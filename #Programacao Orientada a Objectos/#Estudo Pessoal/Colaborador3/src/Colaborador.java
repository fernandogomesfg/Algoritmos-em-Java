

/**
 *
 * @author Fernando Gomes
 */
public class Colaborador {
    //atriutos
    private String nome, endereco, telefone;
    private int cod_sector;
    private double salario, imposto;
    
    
    
    //construtor
    public Colaborador(String nome, String endereco, String telefone, int cod_sector, double salario, double imposto) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cod_sector = cod_sector;
        this.salario = salario;
        this.imposto = imposto;
    }
    
    //GET e SET
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getCod_sector() {
        return cod_sector;
    }

    public void setCod_sector(int cod_sector) {
        this.cod_sector = cod_sector;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }
    
    //metodo toString
    @Override
    public String toString() {
        return "Colaborador{" + "nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + ", cod_sector=" + cod_sector + ", salario=" + salario + ", imposto=" + imposto + '}';
    }
    
    //metodo calcular salario
    public double calcularSalario(){
        return this.salario - (this.salario * this.imposto);
        
    }
    
    
    
    
    
}
