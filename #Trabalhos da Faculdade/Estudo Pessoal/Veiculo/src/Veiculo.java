
/**
 *
 * @author Fernando Gomes
 */
public abstract class Veiculo implements Comparable{

    //atributos
    private String marca, modelo, cor;
    private double preco;

    //construtor
    public Veiculo(String marca, String modelo, String cor, double preço) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.preco = preço;
    }

    //get e set
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    //to String
    @Override
    public String toString() {
        return "Veiculo: " + "Marca=" + marca + ", modelo=" + modelo + ", cor=" + cor + ", preco=" + preco + '}';
    }
    
    //metodo para comparar dois objectos
    
    public int compareTo(Object f){
        //casting para garantir que o objecto comparado seja da classe FUNCIONARIO
        Veiculo outro = (Veiculo) f;
        if(this.getPreco() > outro.getPreco()){
            return 1;
        }else if (this.getPreco()< outro.getPreco()) {
            return -1;
        }else{
            return 0;
        }
    }
    
}
