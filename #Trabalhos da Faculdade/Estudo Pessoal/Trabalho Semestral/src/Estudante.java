
/**
 *
 * @author Fernando Gomes
 */
public class Estudante {

    //Atributos
    private int número_estudante;
    private String nome;
    private double nota1, nota2, nota3;
    
    //Construtores
    public Estudante() {
    
    }

    public Estudante(int número_estudante, String nome, double nota1, double nota2, double nota3) {
        this.número_estudante = número_estudante;
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }
    
    //Metodos GET e SET
    public int getNúmero_estudante() {
        return número_estudante;
    }

    public void setNúmero_estudante(int número_estudante) {
        this.número_estudante = número_estudante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }
    
    

    //Metodo calculo de media
    public void calculo_media(double nota1, double nota2, double nota3) {
        double media = 0;
        media = 0.4 * ((nota1 + nota2) / 2) + nota3 * 0.6;
        if (media < 10) {
            System.out.println("Excluido");
        } else if((media >= 10) &&(media<=13.5) ){
            System.out.println("Admitido");
        }else{
            System.out.println("Dispensado");
        }
    }
}
