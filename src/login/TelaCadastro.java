package login;

/**
 *
 * @author freit
 */


import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TelaCadastro extends JFrame {

    private final JTextField txtNome;
    private final JTextField txtUsuario;
    private final JPasswordField passSenha;
    private final JPasswordField passConfSenha;
    
    
    private boolean usuarioValido;
    
    private boolean cadastroValido;
    
    public TelaCadastro() {
    
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Cadastro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 500, 250);

        JPanel tela = new JPanel();
        tela.setBackground(SystemColor.LIGHT_GRAY);
        setContentPane(tela);
        tela.setLayout(null);

        JLabel lblIdentificacao = new JLabel("Informar campos para cadastro");
        lblIdentificacao.setBounds(50, 0, 500, 40);
        lblIdentificacao.setFont(new Font("Arial", Font.BOLD, 19));
        tela.add(lblIdentificacao);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(50, 50, 100, 25);
        tela.add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(200, 50, 250, 25);
        tela.add(txtNome);
        txtNome.setColumns(10);

        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setBounds(50, 80, 100, 25);
        tela.add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(200, 80, 250, 25);
        tela.add(txtUsuario);
        txtUsuario.setColumns(10);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(50, 110, 100, 25);
        tela.add(lblSenha);

        passSenha = new JPasswordField();
        passSenha.setBounds(200, 110, 250, 25);
        tela.add(passSenha);

        JLabel lblconfsenha = new JLabel("Confirmar Senha:");
        lblconfsenha.setBounds(50, 140, 100, 25);
        tela.add(lblconfsenha);

        passConfSenha = new JPasswordField();
        passConfSenha.setBounds(200, 140, 250, 25);
        tela.add(passConfSenha);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(350, 175, 100, 25);
        tela.add(btnCadastrar);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(225, 175, 100, 25);
        tela.add(btnCancelar);
        
        
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaLogin t = new TelaLogin();
                t.AbreTela();
                
                dispose();
            }
        });
        
        
        btnCadastrar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
                Usuario usu = new Usuario();
                
                usu.setNome(txtNome.getText());
                usu.setUsuario(txtUsuario.getText());
                usu.setSenha(passSenha.getText());
                
                if("".equals(usu.getNome())) {
                    JOptionPane.showMessageDialog(null,"Campo nome do usuário precisa ser informado!","Atenção",JOptionPane.ERROR_MESSAGE);
                    txtNome.grabFocus();
                } else if ("".equals(usu.getUsuario())) {
                    JOptionPane.showMessageDialog(null,"Campo usuário precisa ser informado!","Atenção",JOptionPane.ERROR);
                    txtNome.grabFocus();
                } else if(!passSenha.getText().equals(passConfSenha.getText())){
                    JOptionPane.showMessageDialog(null,"Campo senha precisa ser informado!","Atenção",JOptionPane.ERROR);
                    passSenha.grabFocus();
                } else if(!passSenha.getText().equals(passConfSenha.getText())){
                    JOptionPane.showMessageDialog(null,"Campos de senha e confirmação não são iguais","Atenção",JOptionPane.ERROR);
                    passSenha.grabFocus();
                } else {
                    usuarioValido = usu.verificaUsuario(usu.getUsuario(),usu.getSenha());
                    
                    if(usuarioValido == true) {
                        JOptionPane.showMessageDialog(null,"Usuario ja existente em nossa base de dados","Atenção",JOptionPane.ERROR_MESSAGE);
                        txtUsuario.grabFocus();
                    } else {
                        cadastroValido = usu.cadastraUsuario(usu.getNome(),usu.getUsuario(),usu.getSenha());
                        if(cadastroValido == true) {
                            JOptionPane.showMessageDialog(null,"Usuario cadastrado corretamente, voltaremos" + "a tela de login.", "Atenção",JOptionPane.INFORMATION_MESSAGE);
                            
                            TelaLogin tLogin = new TelaLogin();
                            tLogin.AbreTela();
                            
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(null,"Problemas ao inserir o usuario","Atenção",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });
    }
    

    
    
    
    public void AbreTela() {
        TelaCadastro panelCadastro = new TelaCadastro();
        panelCadastro.setVisible(true);
    }

}
