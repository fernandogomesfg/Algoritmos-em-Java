package Model;

import java.io.Serializable;

/**
 *
 * @author Fernando Gomes
 */
public abstract class TCC implements Comparable, Serializable {

    //atributos
    private String nome_estudante, tema, curso;
    private int ano;

    //construtor
    public TCC() {
    }

    public TCC(String nome_estudante, String tema, String curso, int ano) {
        this.nome_estudante = nome_estudante;
        this.tema = tema;
        this.curso = curso;
        this.ano = ano;
    }

    //get e set
    public String getNome_estudante() {
        return nome_estudante;
    }

    public void setNome_estudante(String nome_estudante) {
        this.nome_estudante = nome_estudante;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    //to String
    @Override
    public String toString() {
        return "TCC{" + "Nome do Estudante = " + nome_estudante + ", Tema = " + tema + ", Curso = " + curso + ", Ano=" + ano + '}';
    }
    
    //metodo para ordenar dois objectos atraaves do seu anos TCC
    public int compareTo(Object t){
        TCC outro = (TCC) t;
        if (this.getAno() > outro.getAno()) {
            return 1;
        } else  if(this.getAno() < outro.getAno()){
            return -1;
        }else{
            return 0;
        }
    }

}
