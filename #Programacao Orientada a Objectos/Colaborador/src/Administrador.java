
/**
 *
 * @author Fernando Gomes
 */
public class Administrador extends Colaborador {

    //atriutos
    private double ajuda_custos;

    //construtor
    public Administrador(String nome, String endereco, String telefone, int cod_sector, double salario, double imposto, double ajuda_custos) {
        super(nome, endereco, telefone, cod_sector, salario, imposto);
        this.ajuda_custos = ajuda_custos;
    }

    //GET e SET
    public double getAjuda_custos() {
        return ajuda_custos;
    }

    public void setAjuda_custos(double ajuda_custos) {
        this.ajuda_custos = ajuda_custos;
    }

    //metodo toString
    @Override
    public String toString() {
        return super.toString() + ", Ajuda de custos = " + ajuda_custos ;
    }

    //metodo para calcular salario do administrador
    public double calcularSalario() {
        return super.calcularSalario() + this.ajuda_custos;
    }
}
