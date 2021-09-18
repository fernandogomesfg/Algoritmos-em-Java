/**
 * Lista de Objectos com classe Aluno
 * Data: 19/09/2021
 */
package lista.de.objectos.pkg2;

import java.util.ArrayList;

/**
 *
 * @author Fernando Gomes
 */
public class ListaDeObjectos2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Aluno> ListaAlunos = new ArrayList();
        Aluno a1 = new Aluno();
        a1.setNome("Fernando Gomes");
        a1.setMatricula("1111");
        a1.setTelefone("841111");
        ListaAlunos.add(a1);
        
        Aluno a2 = new Aluno();
        a2.setNome("Gomes");
        a2.setMatricula("2222");
        a2.setTelefone("82222");
        ListaAlunos.add(a2);
        
        Aluno a3 = new Aluno("Fernando", "33333","8333");
        ListaAlunos.add(a3);
        
        ListaAlunos.add(new Aluno("Paulo", "4444", "840404"));
        
        for (int i = 0; i < ListaAlunos.size(); i++) {
            System.out.println(ListaAlunos.get(i).getDados());
        }
    }
    
}
