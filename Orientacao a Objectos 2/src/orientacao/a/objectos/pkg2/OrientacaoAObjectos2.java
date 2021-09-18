/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orientacao.a.objectos.pkg2;

/**
 *
 * @author Fernando Gomes
 */
public class OrientacaoAObjectos2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Aluno a1 = new Aluno("Fernando Gomes");
        a1.setNumero("1111111111111");
        a1.setMatricula("00000000000001");

        Aluno a2 = new Aluno("Pedro Jose");
        a2.setNumero("2222222222222");
        a2.setMatricula("0000000000002");

        /*
        System.out.println("Aluno 1\nNome: " + a1.getNome() + "\nNumero: " + a1.getNumero() + "\nMatricula: " + a1.getMatricula());
        System.out.println("");
        System.out.println("Aluno 2\nNome: " + a2.getNome() + "\nNumero: " + a2.getNumero() + "\nMatricula: " + a2.getMatricula());
         */
        a1.ImprimirDados();
        System.out.println("");
        a2.ImprimirDados();
        double media = Aluno.Media(10, 14);
        System.out.println("Media: " + media);

    }

}
