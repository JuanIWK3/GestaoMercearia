
package Tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    private static final String ipMySQL = "localhost:3306/mercearia";
    private static final String userMySQL = "newuser";
    private static final String senha = "password";
    private static Connection conexaoMySQL;

  public static Connection getConnectionMySQL(){
    try {
      
      if(conexaoMySQL == null || conexaoMySQL.isClosed()){
        conexaoMySQL = DriverManager.getConnection("jdbc:mysql://"+ipMySQL, 
          userMySQL, senha);
      }

      return conexaoMySQL;
    } catch (SQLException ex) {
        System.err.println("Não foi possivel estabelecer a conexão com o banco");
        ex.printStackTrace();
        return null;
    }
  }
}
