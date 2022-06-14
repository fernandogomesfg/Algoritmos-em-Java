package Controller;

import Model.*;
import Model.FuncComissionado;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 *
 * @author Fernando Gomes & Samuel Ouana
 */
public class Controler {

    //arraylist de funcionarios
    public static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

    //metodo para adicionar funcionario comissionado
    public static void addFuncComissionado(FuncComissionado fc) {

        try {

            //Carrega o arquivo
            FileInputStream folha_salario = new FileInputStream("folhasalario.dat");
            //Classe responsavel por recuperar os objetos do arquivo
            ObjectInputStream objLeitura = new ObjectInputStream(folha_salario);
            funcionarios = (ArrayList) objLeitura.readObject();
            fc.getNum_BI();
            fc.getData_ingresso();
            fc.getSalario_fixo();
            fc.getPercentagem();
            fc.getNum_vendas();

            //adiciona o objecto no array list
            funcionarios.add(fc);

            //Gera o arquivo para armazenar o objeto
            FileOutputStream folhasalario = new FileOutputStream("folhasalario.dat");
            //Classe responsavel por inserir os objetos
            ObjectOutputStream objGravar = new ObjectOutputStream(folhasalario);
            //Grava o objeto cliente no arquivo
            objGravar.writeObject(funcionarios);
            objGravar.flush();
            objGravar.close();
            folhasalario.flush();
            folhasalario.close();
            //System.out.println("Objeto gravado com sucesso!");
            JOptionPane.showMessageDialog(null, "Funcionario Comissionado cadastrado com sucesso", "Funcionario Comissionado", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
            try {
                fc.getNum_BI();
                fc.getData_ingresso();
                fc.getSalario_fixo();
                fc.getPercentagem();
                fc.getNum_vendas();

                //adiciona o objecto no array list
                funcionarios.add(fc);
                //Gera o arquivo para armazenar o objeto se nao existir
                FileOutputStream folhasalario = new FileOutputStream("folhasalario.dat");
                //Classe responsavel por inserir os objetos
                ObjectOutputStream objGravar = new ObjectOutputStream(folhasalario);

                //Grava o objeto cliente no arquivo
                objGravar.writeObject(funcionarios);
                objGravar.flush();
                objGravar.close();
                folhasalario.flush();
                folhasalario.close();
                //System.out.println("Objeto gravado com sucesso!");
                JOptionPane.showMessageDialog(null, "Funcionario Comissionado cadastrado com sucesso", "Funcionario Comissionado", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {

            }
        }
    }

    //metodo para listar funcionarios comissionarios
    public static void listFuncComissionario(FuncComissionado fc) {
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
            System.out.println("");
            objLeitura.close();
            folhasalario.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /////////////////////////////////////////////////
    //metodo para adicionar funcionario comissionado
    public static void addFuncProdutividade() {

        try {

            //Carrega o arquivo
            FileInputStream folha_salario = new FileInputStream("folhasalario.dat");
            //Classe responsavel por recuperar os objetos do arquivo
            ObjectInputStream objLeitura
                    = new ObjectInputStream(folha_salario);
            funcionarios = (ArrayList) objLeitura.readObject();
            funcionarios.add(new FuncProdutividade(JOptionPane.showInputDialog("Numero do BI do funcionario produtividade"), JOptionPane.showInputDialog("Data de ingresso do funcionario produtividade"), Double.parseDouble(JOptionPane.showInputDialog("Salario do funcionario produtividade")), Integer.parseInt(JOptionPane.showInputDialog("Unidade produzida do funcionario produtividade")), Double.parseDouble(JOptionPane.showInputDialog("Valor da unidade produzida funcionario produtividade"))));

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
            //System.out.println("Objeto gravado com sucesso!");
            JOptionPane.showMessageDialog(null, "Funcionario Produtividade gravado com sucesso", "Funcionario Produtividade", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
            try {
                //Gera o arquivo para armazenar o objeto se nao existir
                FileOutputStream folhasalario
                        = new FileOutputStream("folhasalario.dat");
                //Classe responsavel por inserir os objetos
                ObjectOutputStream objGravar = new ObjectOutputStream(folhasalario);

                funcionarios.add(new FuncProdutividade(JOptionPane.showInputDialog("Numero do BI do funcionario produtividade"), JOptionPane.showInputDialog("Data de ingresso do funcionario produtividade"), Double.parseDouble(JOptionPane.showInputDialog("Salario do funcionario produtividade")), Integer.parseInt(JOptionPane.showInputDialog("Unidade produzida do funcionario produtividade")), Double.parseDouble(JOptionPane.showInputDialog("Valor da unidade produzida funcionario produtividade"))));

                //Grava o objeto cliente no arquivo
                objGravar.writeObject(funcionarios);
                objGravar.flush();
                objGravar.close();
                folhasalario.flush();
                folhasalario.close();
                //System.out.println("Objeto gravado com sucesso!");
                JOptionPane.showMessageDialog(null, "Funcionario Produtividade gravado com sucesso", "Funcionario Produtividade", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {

            }
        }
    }

    //metodo para listar funcionarios comissionarios
    public static void listFuncProdutividade() {
        try {
            //Carrega o arquivo
            FileInputStream folhasalario = new FileInputStream("folhasalario.dat");
            //Classe responsavel por recuperar os objetos do arquivo
            ObjectInputStream objLeitura
                    = new ObjectInputStream(folhasalario);
            funcionarios = (ArrayList) objLeitura.readObject();

            System.out.println("\nFuncionarios Produtividade");
            for (int i = 0; i < funcionarios.size(); i++) {
                if (funcionarios.get(i) instanceof FuncProdutividade) {
                    System.out.println(funcionarios.get(i).toString());
                }

            }

            objLeitura.close();
            folhasalario.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printSort() {
        //ordenacao do array
        System.out.println("\nOrdem dos salarios");
        Collections.sort(funcionarios);
        for (int i = 0; i < funcionarios.size(); i++) {
            //funcionarios.sort(cmprtr);
            System.out.println(funcionarios.get(i));
        }
    }

    //metodo para cancelar a operacao de registro
    public static void cancelar() {
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja canncelar?", "Atenção", JOptionPane.YES_NO_OPTION);
        //System.out.println(sair);
        if (sair == JOptionPane.YES_OPTION) {
            System.exit(0);
        }

    }

}
