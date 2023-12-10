package login;

/**
 *
 * @author freit
 */
public class TestaConexao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Conexao c = new Conexao();
         c.AbrirConexao();
         
         try {
             Thread.sleep(4000); // espera 4 segundos
             c.FecharConexao();
         } catch (InterruptedException e) {
             System.out.println("Não foi");
         }
         
    }
    
}
