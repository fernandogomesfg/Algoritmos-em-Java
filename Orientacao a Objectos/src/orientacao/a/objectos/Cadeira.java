package orientacao.a.objectos;

/**
 *
 * @author Fernando Gomes
 */
public class Cadeira {
    
    private double altura;
    private double altura_assento;
    private String cor;
    
    //Metodo construtor
    public Cadeira(){
        //Pode se informar os valores padroes de cada atributo no metodo contrutor (aquele que dispara logo que o programa for excutado e tem mesmo nome da classe
        cor = "Branca";
        altura = 2.5;
        altura_assento = 1.7;
        
    }
    
    public void serrar() {
        System.out.println("Serrando a madeira");
        
    }
    
    public void lixar() {
        System.out.println("Lixando a madeira");
        
    }
    
    public void pintar() {
        System.out.println("Pintando a cadeira");
        
    }

    //Obtendo a cor padrao
    String getCor() {
        return cor;
    }

    //Passando a cor diferente da cor padrao
    public void setCor(String c) {
        //Define duas cores para a cadeira, para alem da cor padrao
        if (c.equals("Verde") || (c.equals("Vermelho"))) {
            cor = c;
        } else if (c.equals("Branca")) {
            cor = cor;
        } else {
            System.out.println("Nao ha tinta para a cor desejada");
        }
    }
}
