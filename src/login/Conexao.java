package login;

import java.sql.Connection; // Conexão com Banco de Dados
import java.sql.DriverManager; // Driver de conexão para o mySQL
import java.sql.Statement; // interpreta comandos SQL
import java.sql.ResultSet; // resultados das operações em banco

        
        
public class Conexao {
    // Atributos de conexão ligados a lib
    public Connection con = null;
    public Statement stmt = null;
    public ResultSet resultset = null;
    
    // Atributos de conexão
    private final String servidor = "jdbc:mysql://127.0.0.1:8080/login";
    private final String usuario = "root";
    private final String senha = "";
    
    private final String driver = "com.mysql.jdbc.Driver";
    
    // Método de abertura de conexão
    public Connection AbrirConexao() {
      try {
          Class.forName(driver); // driver de utilização
          // Atributos de conexão
          con = DriverManager.getConnection(servidor,usuario,senha);
          
          stmt = con.createStatement(); // faz conxexão com banco
          
          
          System.out.println("Conexão com banco bem sucedida");
          
      } catch (Exception e) {
          System.out.println("Erro ao acessar o banco");
      }
      return con; // retorna a conexão
    };
    
    // método de fechamento de conexão
    public void FecharConexao() {
        try {
            con.close(); // fecha conexao com banco
            System.out.println("Conexao finalizada com o sucesso");
        } catch (Exception e) {
            System.out.println("Erro ao fechar conexao" + e.getMessage());
        }
    }
    
}


