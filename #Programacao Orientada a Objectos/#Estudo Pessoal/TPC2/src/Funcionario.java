
/**
 *
 * @author Fernando Gomes
 */
public abstract class Funcionario {

    //atributos
    private String nome, data_nasc, nome_pai, nome_mae, morada, naturalidade, data_emissao, data_ingresso;
    private double atura, salario;

    //construtor
    public Funcionario(String nome, String data_nasc, String nome_pai, String nome_mae, String morada, String naturalidade, String data_emissao, String data_ingresso, double atura, double salario) {
        this.nome = nome;
        this.data_nasc = data_nasc;
        this.nome_pai = nome_pai;
        this.nome_mae = nome_mae;
        this.morada = morada;
        this.naturalidade = naturalidade;
        this.data_emissao = data_emissao;
        this.data_ingresso = data_ingresso;
        this.atura = atura;
        this.salario = salario;
    }
    
    //GET e SET
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

    public String getNome_pai() {
        return nome_pai;
    }

    public void setNome_pai(String nome_pai) {
        this.nome_pai = nome_pai;
    }

    public String getNome_mae() {
        return nome_mae;
    }

    public void setNome_mae(String nome_mae) {
        this.nome_mae = nome_mae;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getData_emissao() {
        return data_emissao;
    }

    public void setData_emissao(String data_emissao) {
        this.data_emissao = data_emissao;
    }

    public String getData_ingresso() {
        return data_ingresso;
    }

    public void setData_ingresso(String data_ingresso) {
        this.data_ingresso = data_ingresso;
    }

    public double getAtura() {
        return atura;
    }

    public void setAtura(double atura) {
        this.atura = atura;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    //metodo toString
    @Override
    public String toString() {
        return "Funcionario{" + "nome=" + nome + ", data_nasc=" + data_nasc + ", nome_pai=" + nome_pai + ", nome_mae=" + nome_mae + ", morada=" + morada + ", naturalidade=" + naturalidade + ", data_emissao=" + data_emissao + ", data_ingresso=" + data_ingresso + ", atura=" + atura + ", salario=" + salario + '}';
    }
    
    //metodo abstrato para calcular salrio
    public abstract double calcularRemuneracao();
 
    

}
