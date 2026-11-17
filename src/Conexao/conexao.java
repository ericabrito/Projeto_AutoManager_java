package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author ERICABRITODASILVA
 */
public class conexao {
      public static Connection conectar(){
          
        Connection conexao = null;
        
        String url = "jdbc:postgresql://localhost/AutoManager_T261T";
        String usuario = "postgres";
        String senha = "root";
        
        try{
            conexao = DriverManager.getConnection(url,usuario,senha);
        } catch (SQLException erro){
            System.out.println("Erro ao conectar com o Banco - Erro: "+ erro);
        }
        return conexao;
    }

    public static Connection getConexao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   
}
