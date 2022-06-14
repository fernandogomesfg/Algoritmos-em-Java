
package Model;

import java.sql.*;  //importando bibliotecas para trabalhar com sql

/**
 *
 * @author Antonio Macarringue, Fernando Gomes, Helio Langa & Samuel Ouana
 */
public class Conexao {
    //metodo responsavel por estabelecer conexao com a base de dados  
    public static Connection conexaoDB(){ //Connection - conjunto de funcionalidades do java.sql
        //variavel 'conexao' para armazenar infomacao da base de dados
        java.sql.Connection conexao = null;
        
        //a linha abaixo chama o driver que imporatmos no sql
        String driver = "com.mysql.cj.jdbc.Driver";
        
        //variaveis que vao armazenar informacoes referentes a base de dados
        String caminho = "jdbc:mysql://localhost:3306/db_sigatcc";    //jdbc:mysql: - eh referente ao driver | localhost - refere-se ao servidor local instalado no computador | 3306 - eh a porta padrao do MySQL
        String usuario = "root";
        String senha = "";   //a senha eh varia por padrao no XAMPP    
        //Estabelecendo a conexao com a base de dados
        try {
            Class.forName(driver);  //executa o arquivo do driver 
            conexao = DriverManager.getConnection(caminho, usuario, senha);  //parametros para oter a conexao usado os parametros -url, usuari, password)
            return conexao;
        } catch (Exception e) {
            //caso haja um erro
            System.out.println(e);  //imprime o erro
            return null;
        }
    }
    
    
}
