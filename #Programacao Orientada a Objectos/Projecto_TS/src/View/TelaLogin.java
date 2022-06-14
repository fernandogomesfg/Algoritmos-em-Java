package View;

import Model.*;
import static Controller.LoginController.*;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Antonio Macarringue, Fernando Gomes, Helio Langa & Samuel Ouana
 */
public class TelaLogin extends javax.swing.JFrame {

    Connection conexao = null;

    //variveis especiais de apoio a conexao a base de dados
    PreparedStatement pst = null;
    ResultSet rs = null;    //exibe o resultado das operacoes executadas pelo sql no java

    /**
     * Creates new form TelaLogin
     */
    public TelaLogin() {
        initComponents();

        //liga a conexao
        Connection conexao = Conexao.conexaoDB();
        System.out.println(conexao);
        
        if (conexao != null) {
            lbl_status.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/dbok.png")));     //colocar um icone de conexao OK na tela de login
        } else {
            lbl_status.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/dberror.png")));  ////colocar um icone de conexao de ERRO na tela de login
        }

    }

    //metodo responsavel pela autenticacao do usuario 
    private void login() {
        String sql = "select * from tbl_usuario where usuario = ? and senha=?";
        try {
            conexao = Conexao.conexaoDB();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txt_usuario.getText());
            pst.setString(2, txt_senha.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                String nomeUsuario = rs.getString(2);    //pega o nome do usuario na base de dados
                String perfil = rs.getString(8);        //pega o perfil do usuario na base de dados
                if (perfil.equals("Administrador")) {
                    // metodo para trocar de tela
                    acessarTelaPrincipal();
                    TelaPrincipal.lbl_usuario.setText(nomeUsuario);
                    TelaPrincipal.Menucadastro.setEnabled(true);
                    TelaPrincipal.MenuRelatorio.setEnabled(true);
                    TelaPrincipal.MenRelAdmin.setEnabled(true);
                    TelaPrincipal.MenRelDoc.setEnabled(true);
                    this.dispose();     //fecha a tela de login
                } else if (perfil.equals("Docente")) {
                    // metodo para trocar de tela
                    acessarTelaPrincipal();
                    TelaPrincipal.lbl_usuario.setText(nomeUsuario);
                    TelaPrincipal.MenuRelatorio.setEnabled(true);
                    this.dispose();     //fecha a tela de login
                } else {
                    // metodo para trocar de tela
                    acessarTelaPrincipal();
                    TelaPrincipal.lbl_usuario.setText(nomeUsuario);
                    this.dispose();     //fecha a tela de login
                }

            } else {
                JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválido(s)");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        txt_senha = new javax.swing.JPasswordField();
        btn_acessar = new javax.swing.JButton();
        lbl_status = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIGA TCC - LOGIN");
        setPreferredSize(new java.awt.Dimension(319, 164));
        setResizable(false);

        jLabel1.setText("Usuário");

        jLabel2.setText("Senha");

        txt_usuario.setText("admin");

        txt_senha.setText("admin");

        btn_acessar.setText("Acessar");
        btn_acessar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_acessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_acessarActionPerformed(evt);
            }
        });

        lbl_status.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/dberror.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lbl_status)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_acessar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_senha)
                            .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_status)
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btn_acessar)
                        .addContainerGap(46, Short.MAX_VALUE))))
        );

        setSize(new java.awt.Dimension(335, 203));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_acessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_acessarActionPerformed
        //chamando o metodo login
        login();
    }//GEN-LAST:event_btn_acessarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_acessar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel lbl_status;
    private javax.swing.JPasswordField txt_senha;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
