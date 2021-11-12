/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.*;

/**
 *
 * @author Fernando Gomes
 */
public class ModuloConexao {
    
    private Connection conexao;
    
    //Cria a conexao com o banco de dados e cria o banco de dados se nao existir
    public boolean conectar() {
        try {
            //caminho do banco de dados
            String url = "jdbc:sqlite:banco_de_dados/banco_sqlite.db";

            //criando a conexao
            this.conexao = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        System.out.println("Conectou");
        return true;
    }

    public boolean desconectar() {
        try {
            if (this.conexao.isClosed() == false) {
                this.conexao.close();
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        System.out.println("Conectou");

        return true;
    }
    
}
