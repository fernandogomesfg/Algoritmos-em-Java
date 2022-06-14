package Controller;

import Model.Administrador;
import Model.Conexao;
import Model.Docente;
import Model.Estudante;
import Model.TCC;
import Model.Usuario;
import View.TelaLogin;
import static View.TelaLogin.lbl_status;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

/**
 *
 * @author Fernando Gomes
 */
public class Controller {

    static Connection conexao;
    static PreparedStatement pst;
    static ResultSet rs;
    static String ultimoID_usuario;    //variavel para armazenar o ultimo do usuario para se atribuir ao estudante/docente/administrador

    //arraylist de docentes
    public static ArrayList<Administrador> administradores = new ArrayList<Administrador>();

    //metodo para ordenar os salarios
    //metodo responsavel por adicionar usuario
    public static void adicionarUsuario(Usuario u) {
        String sql = "insert into tbl_usuario (nome, data_nasc, endereco, num_telefone, usuario, senha, perfil) values (?, ?, ?, ?, ?, ?, ?)";
        try {
            conexao = Conexao.conexaoDB();
            pst = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, u.getNome());
            pst.setString(2, u.getData_nasc());
            pst.setString(3, u.getEndereco());
            pst.setString(4, u.getNum_telefone());
            pst.setString(5, u.getUsuario());
            pst.setString(6, u.getSenha());
            pst.setString(7, u.getPerfil());

            int adicionado = pst.executeUpdate(); //actualiza na base de dados
            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                ultimoID_usuario = rs.getString(1);
                //System.out.println(ultimoID_usuario);
            }

            if (adicionado > 0) {
                //JOptionPane.showMessageDialog(null, "Usuario adicionado com sucesso");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //metodo responsavel por adicionar estudante
    public static void adicionarEstudante(Estudante e) {
        String sql = "insert into tbl_estudante (num_estudante, curso, id_user) values (?, ?, ?)";
        try {
            conexao = Conexao.conexaoDB();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, e.getNum_estudante());
            pst.setString(2, e.getCurso());
            pst.setString(3, ultimoID_usuario);
            int adicionado = pst.executeUpdate();//actualiza na base de dados
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Estudante adicionado com sucesso");
            }
        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, e2);
        }
    }

    //metodo responsavel por adicionar um docente
    public static void adicionarDocente(Docente d) {
        String sql = "insert into tbl_docente (nome_cadeira, status_docente, id_user) values (?, ?, ?)";
        try {
            conexao = Conexao.conexaoDB();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, d.getNome_cadeira());
            pst.setString(2, d.getStatus());
            pst.setString(3, ultimoID_usuario);
            int adicionado = pst.executeUpdate();//actualiza na base de dados
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Docente adicionado com sucesso");
            }
        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, e2);
        }
    }

    //metodo responsavel por adicionar um administrador
    public static void adicionarAdministrador(Administrador a) {
        String sql = "insert into tbl_administrador (sector, id_user) values (?, ?)";
        try {
            conexao = Conexao.conexaoDB();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, a.getSector());
            pst.setString(2, ultimoID_usuario);
            int adicionado = pst.executeUpdate();//actualiza na base de dados
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Administrador adicionado com sucesso");
            }
        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, e2);
        }
    }

    /*METODO PARA O TCC*/
    //arraylist de tcc
    public static ArrayList<TCC> tcc = new ArrayList<TCC>();

    //metodo para adicionar um tcc
    public static void addTCC(TCC t) {
        try {
            //carrega o ficheiro
            FileInputStream trabalho = new FileInputStream("TCC.dat");

            //classe responsavel por recuperar os objectos do arquivo
            ObjectInputStream objLeitura = new ObjectInputStream(trabalho);
            tcc = (ArrayList) objLeitura.readObject();

            t.getNome_estudante();
            t.getTema();
            t.getCurso();
            t.getAno();

            //adicionado o objecto no array list
            tcc.add(t);

            //gerra o arquivo para armazenar o objecto
            FileOutputStream trabalho_tcc = new FileOutputStream("TCC.dat");

            //Classe responsavel por inserir os objectos
            ObjectOutputStream objGravar = new ObjectOutputStream(trabalho_tcc);

            //grava o objecto no arquivo
            objGravar.writeObject(tcc);
            objGravar.flush();
            objGravar.close();
            trabalho_tcc.flush();
            trabalho_tcc.close();

            //feedback
            JOptionPane.showMessageDialog(null, "Trabalho de Conclusao do Curso cadastrado com sucesso", "Trabalho de Conclusao do Curso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            try {
                t.getNome_estudante();
                t.getTema();
                t.getCurso();
                t.getAno();
                
                //adiciona o objecto no array list
                tcc.add(t);
                
                //gera o arquivo para armazenar o objecto se nao existir
                FileOutputStream  trabalho_tcc = new FileOutputStream("TCC.dat");
                
                //classe responsavel por inserir os objectos
                ObjectOutputStream objGravar = new ObjectOutputStream(trabalho_tcc);
                
                //grava o objecto tcc no arquivo
                objGravar.writeObject(tcc);
                objGravar.flush();
                objGravar.close();
                trabalho_tcc.flush();
                trabalho_tcc.close();
                
                //feedback
                JOptionPane.showMessageDialog(null, "Trabalho de Conclusao do Curso cadastrado com sucesso", "Trabalho de Conclusao do Curso", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e2) {
            }
        }
    }
    
    public static void printSort() {
        //ordenacao do array
        //System.out.println("\nOrdem dos anos dos TCC");
        Collections.sort(tcc);
        for (int i = 0; i < tcc.size(); i++) {
            //funcionarios.sort(cmprtr);
            JOptionPane.showMessageDialog(null, tcc.get(i).toString());
            //System.out.println(tcc.get(i));
        }
    }

}
