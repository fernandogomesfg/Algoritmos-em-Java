

/**
 *
 * @author Fernando Gomes
 */
public class Inscricao {
    //Atributos
    public String nome_disciplina, semestre, nome_docente;
    public int ano_lectivo;
    private Estudante[]estudantes;
    
    //Constrtutores

    public Inscricao(String nome_disciplina, String semestre, String nome_docente, int ano_lectivo,  int quantidadeDeEstudantes) {
        this.nome_disciplina = nome_disciplina;
        this.semestre = semestre;
        this.nome_docente = nome_docente;
        this.ano_lectivo = ano_lectivo;
        this.estudantes = new Estudante[quantidadeDeEstudantes];
    }
    
    
    
}
