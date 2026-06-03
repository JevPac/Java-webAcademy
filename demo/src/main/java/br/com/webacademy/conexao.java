package br.com.webacademy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {
     public static final String URL = "jdbc:mysql://localhost:3396/dbproduct";
    public static final String USUARIO = "root";
    public static final String  SENHA = "root";

    public static Connection obterConexao() throws SQLException{
        return DriverManager.getConnection( URL , USUARIO, SENHA);
    }
}
