package br.com.prjrx.dal;
import java.sql.*;
public class ConexaoBd {
    //Método que conecta com o banco de dados.
    public static Connection conector(){
        java.sql.Connection conexao = null;
        //atribui driver
        String driver = "com.mysql.jdbc.Driver";
        //armazena info do banco
        String url = "jdbc:mysql://localhost:3306/gerenciamento_cinema";
        String user = "root";
        String password = "";
        //establecer conexão com o Banco de Dados.
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url,user,password);
            return conexao;
        } catch (Exception e) {
            //a linha abaixo informa onde se encontra o erro(url,user,pw,driver
            //depois retorna null).
            System.out.println(e);
            return null;
        }
    }
    
}
