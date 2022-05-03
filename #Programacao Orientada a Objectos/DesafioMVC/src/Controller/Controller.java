
package Controller;

import Models.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Fernando Gomes
 */
public class Controller {
    //arraylist de funcionarios
    public static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
    
    //metodo para adicionar funcionario comissionado
    public static void addFuncComissionado() {
        
        try {
            
            //Carrega o arquivo
            FileInputStream folha_salario = new FileInputStream("folhasalario.dat");
            //Classe responsavel por recuperar os objetos do arquivo
            ObjectInputStream objLeitura
                    = new ObjectInputStream(folha_salario);
            funcionarios = (ArrayList) objLeitura.readObject();
            funcionarios.add(new FuncComissionado(JOptionPane.showInputDialog("Numero do BI do funcionario comissionado"), JOptionPane.showInputDialog("Data de ingresso do funcionario comissionado"), Double.parseDouble(JOptionPane.showInputDialog("Salario do funcionario comissionado")), Double.parseDouble(JOptionPane.showInputDialog("Percentagem do funcionario comissionado")), Integer.parseInt(JOptionPane.showInputDialog("Numero de vendas do funcionario comissionado"))));
            
                //Gera o arquivo para armazenar o objeto
            FileOutputStream folhasalario
                    = new FileOutputStream("folhasalario.dat");
            //Classe responsavel por inserir os objetos
            ObjectOutputStream objGravar = new ObjectOutputStream(folhasalario);
            //Grava o objeto cliente no arquivo
            objGravar.writeObject(funcionarios);
            objGravar.flush();
            objGravar.close();
            folhasalario.flush();
            folhasalario.close();
            System.out.println("Objeto gravado com sucesso!");
            
            
        } catch (Exception ex) {
            try {
                //Gera o arquivo para armazenar o objeto se nao existir
            FileOutputStream folhasalario
                    = new FileOutputStream("folhasalario.dat");
            //Classe responsavel por inserir os objetos
            ObjectOutputStream objGravar = new ObjectOutputStream(folhasalario);
            
            funcionarios.add(new FuncComissionado(JOptionPane.showInputDialog("Numero do BI do funcionario comissionado"), JOptionPane.showInputDialog("Data de ingresso do funcionario comissionado"), Double.parseDouble(JOptionPane.showInputDialog("Salario do funcionario comissionado")), Double.parseDouble(JOptionPane.showInputDialog("Percentagem do funcionario comissionado")), Integer.parseInt(JOptionPane.showInputDialog("Numero de vendas do funcionario comissionado"))));
            
            //Grava o objeto cliente no arquivo
            objGravar.writeObject(funcionarios);
            objGravar.flush();
            objGravar.close();
            folhasalario.flush();
            folhasalario.close();
            System.out.println("Objeto gravado com sucesso!");
            } catch (Exception e) {
                
            }
        }
    }
    
    //metodo para listar funcionarios comissionarios
    public static void listFuncComissionario() {
        try {
            //Carrega o arquivo
            FileInputStream folhasalario = new FileInputStream("folhasalario.dat");
            //Classe responsavel por recuperar os objetos do arquivo
            ObjectInputStream objLeitura
                    = new ObjectInputStream(folhasalario);
            funcionarios = (ArrayList) objLeitura.readObject();

            System.out.println("Funcionarios Comissionarios");
            for (int i = 0; i < funcionarios.size(); i++) {
                if (funcionarios.get(i) instanceof FuncComissionado) {
                    System.out.println(funcionarios.get(i).toString());
                }

            }

            objLeitura.close();
            folhasalario.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
