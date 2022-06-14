
package Controller;

import Model.*;
import View.*;
import static View.TelaPrincipal.desktop;
import static View.TelaPrincipal.lbl_data;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Fernando Gomes
 */
public class TelaPrincipalController {
    
    //metodo para colocar data a tela principal do programa
    public static void dataActual(){
        Date data = new Date();
        DateFormat formato = DateFormat.getDateInstance(DateFormat.SHORT);
        lbl_data.setText(formato.format(data));
    }
    
    //metodo para perguntar ao usuario se quer sair ou nao
    public static void querSair(){
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Atencao", JOptionPane.YES_NO_OPTION);
        System.out.println(sair);
        if(sair == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }
    
    /*As linhas abaixo sao referentes ao metodos para acessar todas as telas que sao chamadas a partir da tela principal*/
    
    //metodo para acessar a Tela Administrador
    public static void acessarTelaAdministrador(){
        TelaAdministrador administrador = new TelaAdministrador();
        administrador.setVisible(true);
        desktop.add(administrador);
    }
    
    //metodo para acessar a Tela Docente
    public static void acessarTelaDocente(){
        TelaDocente docente = new TelaDocente();
        docente.setVisible(true);
        desktop.add(docente);
    }
    
    //metodo para acessar a Tela Estudante
    public static void acessarTelaEstudante(){
        TelaEstudante estudante = new TelaEstudante();
        estudante.setVisible(true);
        desktop.add(estudante);
    }
    
    //metodo para acessar a Tela Estudante
    public static void acessarTelaTCC(){
        TelaTCC tcc = new TelaTCC();
        tcc.setVisible(true);
        desktop.add(tcc);
    }
    
}
