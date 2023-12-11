package login;

/**
 *
 * @author freit
 */


public class Usuario {
    private String usuario;
    private String nome;
    private String senha;

    private boolean resultCadastro;
    private boolean resultExcluir;
    private boolean resultAltera;


    public String getUsuario() {
        return usuario;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean verificaUsuario(String usuario, String senha) {
        Conexao banco = new Conexao();
        try {
            banco.AbrirConexao();
            banco.stmt = banco.con.createStatement();
            
           banco.resultset = banco.stmt.executeQuery("SELECT * FROM usuario WHERE apelido = '" + usuario + "' AND senha = '" + senha + "'");
            
            resultCadastro = true;
                    
            if(banco.resultset.next()) {
                resultCadastro = true;
                
            } else {
                resultCadastro = false;
            }
            banco.FecharConexao();
        } catch (Exception ec) {
            System.out.println("Erro ao consultar dado " + ec.getMessage());
        }
        return resultCadastro;
    }
    
    public Boolean cadastraUsuario(String nome, String usuario, String senha) {
        Conexao banco = new Conexao();
        try {
            banco.AbrirConexao();
            banco.stmt = banco.con.createStatement();
            
            banco.stmt.execute("INSERT INTO usuario (nome, apelido, senha ) VALUES ('" + nome + "','" + usuario + "','" + senha + "')");
            
            resultCadastro = true;
        } catch (Exception ec) {
            System.out.println("Erro ao inserir usuario " + ec.getMessage());
            resultCadastro = false;
        }
        banco.FecharConexao();
        return resultCadastro;
    }
    
    public boolean ExcluirUsuario(String user) {
        Conexao banco = new Conexao();
        try{
            banco.AbrirConexao();
            banco.stmt = banco.con.createStatement();
            banco.stmt.execute("DELETE FROM usuario WHERE apelido = " + user);
            resultExcluir = true;
        } catch (Exception ec) {
            System.out.println("Erro ao inserir usuario " + ec.getMessage());
            resultExcluir = true;
        }
        banco.FecharConexao();
        return resultExcluir;
    }
    
     public boolean AlteraUsuario(String editUser, String newUserName, String newNickName, String newPassWord) {
        Conexao banco = new Conexao();
        try{
            banco.AbrirConexao();
            banco.stmt = banco.con.createStatement();
            banco.stmt.execute("update usuario set nome = '" + newUserName +"', apelido = '" + newNickName + "', senha = '" + newPassWord + "' where apelido = " + editUser);
            resultAltera = true;
        } catch (Exception ec) {
            System.out.println("Erro ao inserir usuario " + ec.getMessage());
            resultAltera = true;
        }
        banco.FecharConexao();
        return resultAltera;
    }
    
}
