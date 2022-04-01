

/**
 *
 * @author Fernando Gomes
 */
public abstract class Funcionario {
    //atributos
    private String nome, num_BI,estado_civil, data_nasc, morada, nome_pai, nome_mae, data_ingresso, sexo;
    private double altura, salario;
    
    //construtor
    public Funcionario(String nome, String num_BI, String estado_civil, String data_nasc, String morada, String nome_pai, String nome_mae, String data_ingresso, String sexo, double altura, double salario) {
        this.nome = nome;
        this.num_BI = num_BI;
        this.estado_civil = estado_civil;
        this.data_nasc = data_nasc;
        this.morada = morada;
        this.nome_pai = nome_pai;
        this.nome_mae = nome_mae;
        this.data_ingresso = data_ingresso;
        this.sexo = sexo;
        this.altura = altura;
        this.salario = salario;
    }
    
    //GET e SET
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNum_BI() {
        return num_BI;
    }

    public void setNum_BI(String num_BI) {
        this.num_BI = num_BI;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
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

    public String getData_ingresso() {
        return data_ingresso;
    }

    public void setData_ingresso(String data_ingresso) {
        this.data_ingresso = data_ingresso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
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
        return "Funcionario{" + "nome=" + nome + ", num_BI=" + num_BI + ", estado_civil=" + estado_civil + ", data_nasc=" + data_nasc + ", morada=" + morada + ", nome_pai=" + nome_pai + ", nome_mae=" + nome_mae + ", data_ingresso=" + data_ingresso + ", sexo=" + sexo + ", altura=" + altura + ", salario=" + salario + ' ';
    }
    
    //metodo abstrato (so possui cabecalho) 
    public abstract double calcularRemuneracao();
    
    
    
    
            
    
}
