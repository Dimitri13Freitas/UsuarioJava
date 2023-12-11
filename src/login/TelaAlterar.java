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


public class TelaAlterar extends JFrame {
    private final JTextField txtNome;
    private final JTextField txtSenhaAtual;
    private final JPasswordField newSenha;
    private final JPasswordField confNewSenha;
    
    
    private String user;
    private boolean resultAltera;
    
    
    public TelaAlterar(String u) {
        Usuario usu = new Usuario();

        
        user = u;
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Alterando Dados");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 500, 250);

        JPanel tela = new JPanel();
        tela.setBackground(SystemColor.LIGHT_GRAY);
        setContentPane(tela);
        tela.setLayout(null);

        JLabel lblIdentificacao = new JLabel("Informar campos para alteração");
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
        txtNome.setText(user);

        JLabel lblUsuario = new JLabel("Senha Atual:");
        lblUsuario.setBounds(50, 80, 100, 25);
        tela.add(lblUsuario);

        txtSenhaAtual = new JTextField();
        txtSenhaAtual.setBounds(200, 80, 250, 25);
        tela.add(txtSenhaAtual);
        txtSenhaAtual.setColumns(10);

        JLabel lblSenha = new JLabel("Nova Senha:");
        lblSenha.setBounds(50, 110, 100, 25);
        tela.add(lblSenha);

        newSenha = new JPasswordField();
        newSenha.setBounds(200, 110, 250, 25);
        tela.add(newSenha);

        JLabel lblconfsenha = new JLabel("Confirmar Senha:");
        lblconfsenha.setBounds(50, 140, 100, 25);
        tela.add(lblconfsenha);

        confNewSenha = new JPasswordField();
        confNewSenha.setBounds(200, 140, 250, 25);
        tela.add(confNewSenha);

        JButton btnAlterar = new JButton("Alterar");
        btnAlterar.setBounds(350, 175, 100, 25);
        tela.add(btnAlterar);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(225, 175, 100, 25);
        tela.add(btnCancelar);
        
        
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaMenu t = new TelaMenu(user);
                t.AbreTela();
                dispose();
            }
        });
        
        btnAlterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txtNome.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,"Campo nome do usuário precisa ser informado!","Atenção",JOptionPane.ERROR_MESSAGE);
                    txtNome.grabFocus();
                } else if (txtSenhaAtual.getText().equals("") || confNewSenha.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,"Campo senha precisa ser informado!","Atenção",JOptionPane.ERROR);
                    txtSenhaAtual.grabFocus();
                } else if(confNewSenha != newSenha) {
                    JOptionPane.showMessageDialog(null,"Os campos de nova senha precisam estar iguais. Digite novamente","Atenção",JOptionPane.ERROR);
                } else {
                    resultAltera = usu.AlteraUsuario(user, txtNome.getText(), txtNome.getText(), newSenha.getText());
                    
                    if(resultAltera == true) {
                        JOptionPane.showMessageDialog(null,"Seus dados foram atualizados","Atenção",JOptionPane.INFORMATION_MESSAGE);
                        TelaLogin t = new TelaLogin();
                        t.AbreTela();
                        dispose();
                    }
                    
                }

            }
        });
    }

    
    
    
    public void AbreTela() {
        TelaAlterar panelCadastro = new TelaAlterar(user);
        panelCadastro.setVisible(true);
    }

}
