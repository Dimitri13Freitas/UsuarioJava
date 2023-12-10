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
import javax.swing.JOptionPane;


public class TelaMenu extends JFrame{
    private String user;
    
    public TelaMenu(String u) {
        user = u;
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 500, 250);

        JPanel panelTela = new JPanel();
        panelTela.setBackground(SystemColor.LIGHT_GRAY);
        setContentPane(panelTela);
        panelTela.setLayout(null);

        JLabel lblIdentificacao = new JLabel("Seja bem-vindo "+ user +"!!");
        lblIdentificacao.setBounds(150, 20, 500, 40);
        lblIdentificacao.setFont(new Font("Arial", Font.BOLD, 19));
        panelTela.add(lblIdentificacao);




        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(350, 150, 100, 25);
        panelTela.add(btnVoltar);

        JButton btnAlterar = new JButton("Alterar dados");
        btnAlterar.setBounds(183, 150, 120, 25);
        panelTela.add(btnAlterar);
        
        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(35, 150, 100, 25);
        panelTela.add(btnExcluir);
        
        
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaLogin tela = new TelaLogin();
                tela.AbreTela();
                dispose();
            }
        });
        
        btnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int resp = JOptionPane.showConfirmDialog(null, "Deseja realmente se excluir?", "Atenção", JOptionPane.YES_NO_OPTION);

                System.out.println(resp);
                if(resp == 0) {
                    Usuario usu = new Usuario();
                    usu.ExcluirUsuario(user);
                }
            }
        });
    }
    
    public void AbreTela() {
        TelaMenu t = new TelaMenu(user);
        t.setVisible(true);
    }
}
