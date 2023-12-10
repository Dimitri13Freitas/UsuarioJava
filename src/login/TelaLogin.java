package login;

/**
 *
 * @author freit
 */

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JOptionPane;



public class TelaLogin extends JFrame {
    private final JTextField txtUsuario;
    private final JPasswordField pswSenha;
    
    private boolean  usuarioValido;

    
    
    public TelaLogin() {
         setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 500, 250);

        JPanel panelTela = new JPanel();
        panelTela.setBackground(SystemColor.LIGHT_GRAY);
        setContentPane(panelTela);
        panelTela.setLayout(null);

        JLabel lblIdentificacao = new JLabel("Identificação");
        lblIdentificacao.setBounds(180, 20, 500, 40);
        lblIdentificacao.setFont(new Font("Arial", Font.BOLD, 19));
        panelTela.add(lblIdentificacao);

        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setBounds(50, 70, 100, 25);
        panelTela.add(lblUsuario);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(50, 100, 100, 25);
        panelTela.add(lblSenha);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(200, 70, 250, 25);
        panelTela.add(txtUsuario);
        txtUsuario.setColumns(10);

        pswSenha = new JPasswordField();
        pswSenha.setBounds(200, 100, 250, 25);
        panelTela.add(pswSenha);

        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(350, 140, 100, 25);
        panelTela.add(btnEntrar);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(225, 140, 100, 25);
        panelTela.add(btnCadastrar);
        
        
        btnEntrar.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                Usuario usu = new Usuario();
                
                
                usu.setUsuario(txtUsuario.getText());
                usu.setSenha(pswSenha.getText());
                
                if("".equals(txtUsuario.getText())) {
                    JOptionPane.showMessageDialog(null,"Campo usuário precisa ser informado!", "Atenção",JOptionPane.ERROR_MESSAGE);
                    txtUsuario.grabFocus();
                    
                } else if("".equals(pswSenha.getText())){
                    
                    JOptionPane.showMessageDialog(null,"Campo senha precisa ser informado!", "Atenção",JOptionPane.ERROR_MESSAGE);
                    pswSenha.grabFocus();
                } else {

                    usuarioValido = usu.verificaUsuario(usu.getUsuario(), usu.getSenha());
                    
                    if(usuarioValido == true) {
                        JOptionPane.showMessageDialog(null, "Usuario Valido em nossa base de dados","Atenção",JOptionPane.INFORMATION_MESSAGE);
                        TelaMenu tm = new TelaMenu(txtUsuario.getText());
                        tm.AbreTela();
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario inválido ou inexistente","Atenção",JOptionPane.ERROR_MESSAGE);
                        LimpaText();
                        txtUsuario.grabFocus();
                    }
                }
                
            }
            
        });
        
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaCadastro tela = new TelaCadastro();
                tela.AbreTela();
                
                dispose();
            }
        });

    }
    
    
    
    
    
    public void AbreTela() {
        TelaLogin tela = new TelaLogin();
        tela.setVisible(true);
    }
    
    public void LimpaText() {
        txtUsuario.setText("");
        pswSenha.setText("");
    }
    
}
