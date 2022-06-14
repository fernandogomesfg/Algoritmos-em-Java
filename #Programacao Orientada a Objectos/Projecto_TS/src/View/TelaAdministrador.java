/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import static Controller.Controller.adicionarAdministrador;
import static Controller.Controller.adicionarUsuario;
import Model.Administrador;
import Model.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Fernando Gomes
 */
public class TelaAdministrador extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaAdministrador
     */
    public TelaAdministrador() {
        initComponents();
        conexao = Conexao.conexaoDB();
    }

    Connection conexao;
    PreparedStatement pst;
    ResultSet rs;

    //metodo responsavel pela pesquisa
    private void pesquisarAdministrador() {
        String sql = "select tbl_usuario.id_user, tbl_usuario.nome, tbl_usuario.data_nasc, tbl_usuario.endereco, tbl_usuario.num_telefone, tbl_usuario.usuario, tbl_usuario.senha, tbl_usuario.perfil, tbl_administrador.sector from tbl_usuario, tbl_administrador where tbl_usuario.id_user = tbl_administrador.id_user AND nome like?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txt_pesquisar.getText() + "%");
            rs = pst.executeQuery();
            tbl_administrador.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //metodo responsavel por setar os campos de texto com dados da tabela
    private void setarTabela() {
        int setar = tbl_administrador.getSelectedRow();
        txt_id.setText(tbl_administrador.getModel().getValueAt(setar, 0).toString());
        txt_nome.setText(tbl_administrador.getModel().getValueAt(setar, 1).toString());
        txt_datanasc.setText(tbl_administrador.getModel().getValueAt(setar, 2).toString());
        txt_endereco.setText(tbl_administrador.getModel().getValueAt(setar, 3).toString());
        txt_telefone.setText(tbl_administrador.getModel().getValueAt(setar, 4).toString());
        txt_usuario.setText(tbl_administrador.getModel().getValueAt(setar, 5).toString());
        txt_senha.setText(tbl_administrador.getModel().getValueAt(setar, 6).toString());
        txt_perfil.setText(tbl_administrador.getModel().getValueAt(setar, 7).toString());
        cb_sector.setSelectedItem(tbl_administrador.getModel().getValueAt(setar, 8).toString());

        //habilita os botoes de ACTUALIZAR e APAGAR e desabilita o botao de ADICIONAR
        btn_adicionar.setEnabled(false);
        btn_actualizar.setEnabled(true);
        btn_apagar.setEnabled(true);

    }

    //metodo responsavel por actualizar dados do administrador
    private void actualizarDadosAdministrador() {
        String sql = "update tbl_usuario inner join tbl_administrador on tbl_usuario.id_user = tbl_administrador.id_user set tbl_usuario.nome=?, tbl_usuario.data_nasc=?, tbl_usuario.endereco=?, tbl_usuario.num_telefone=?, tbl_usuario.usuario=?, tbl_usuario.senha=?, tbl_usuario.perfil=?, tbl_administrador.sector=? WHERE tbl_usuario.id_user = ? ";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txt_nome.getText());
            pst.setString(2, txt_datanasc.getText());
            pst.setString(3, txt_endereco.getText());
            pst.setString(4, txt_telefone.getText());
            pst.setString(5, txt_usuario.getText());
            pst.setString(6, txt_senha.getText());
            pst.setString(7, txt_perfil.getText());
            pst.setString(8, cb_sector.getSelectedItem().toString());
            pst.setString(9, txt_id.getText());
            if ((txt_nome.getText().isEmpty()) || (txt_datanasc.getText().isEmpty()) || (txt_usuario.getText().isEmpty()) || (txt_senha.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios", "AVISO", JOptionPane.ERROR_MESSAGE);
            } else {
                int adicionado = pst.executeUpdate();   //actualiza na base de dados
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do Administrador alterados com sucesso");
                    //depois de alterar os dados, habilita o botao ADICIONAR e desabilita ACTUALIZAR e APAGAR
                    btn_adicionar.setEnabled(true);
                    btn_actualizar.setEnabled(false);
                    btn_apagar.setEnabled(false);
                    //depois limpamos os campos na tela
                    limpar();

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //metodo responsavel por apagar um administrador
    private void apagarAdministrador() {
        String sql = "delete from tbl_administrador where id_user=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txt_id.getText());
            //pst.setString(2, txt_id.getText());
            int apagado = pst.executeUpdate();
            if (apagado > 0) {
                JOptionPane.showMessageDialog(null, "Administrador removido com sucesso");
                //depois de apagar os dados, habilita o botao ADICIONAR e desabilita ACTUALIZAR e APAGAR
                btn_adicionar.setEnabled(true);
                btn_actualizar.setEnabled(false);
                btn_apagar.setEnabled(false);
                //depois limpamos os campos na tela
                limpar();

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //metodo para limpar os campos apos uma operacao
    private void limpar() {
        txt_pesquisar.setText(null);
        txt_id.setText(null);
        txt_nome.setText(null);
        txt_datanasc.setText(null);
        txt_endereco.setText(null);
        txt_telefone.setText(null);
        txt_usuario.setText(null);
        txt_senha.setText(null);
        cb_sector.setSelectedIndex(0);
        ((DefaultTableModel) tbl_administrador.getModel()).setRowCount(0);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        txt_endereco = new javax.swing.JTextField();
        txt_telefone = new javax.swing.JTextField();
        txt_usuario = new javax.swing.JTextField();
        txt_senha = new javax.swing.JTextField();
        txt_id = new javax.swing.JTextField();
        txt_datanasc = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        cb_sector = new javax.swing.JComboBox<>();
        txt_perfil = new javax.swing.JTextField();
        txt_pesquisar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_administrador = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_apagar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        btn_adicionar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Administrador");
        setPreferredSize(new java.awt.Dimension(640, 480));

        jLabel7.setText("* Campos obrigatórios");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Administrador"));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel35.setText("*Nome:");

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel36.setText("*Data de Nascimento: ");

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel37.setText("Endereço");

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel38.setText("Telefone");

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel39.setText("*Usuario");

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel40.setText("*Senha");

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel41.setText("ID: ");

        txt_nome.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        txt_endereco.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        txt_telefone.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txt_telefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telefoneActionPerformed(evt);
            }
        });

        txt_usuario.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        txt_senha.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        txt_id.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txt_id.setEnabled(false);

        txt_datanasc.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel43.setText("yyyy/mm/dd");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel24.setText("Perfil");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel25.setText("Sector");

        cb_sector.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        cb_sector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Recursos Humanos", "Financas", "Administracao", "Tecnico de Informatica" }));
        cb_sector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_sectorActionPerformed(evt);
            }
        });

        txt_perfil.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txt_perfil.setText("Administrador");
        txt_perfil.setEnabled(false);

        txt_pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pesquisarActionPerformed(evt);
            }
        });
        txt_pesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pesquisarKeyReleased(evt);
            }
        });

        tbl_administrador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Curso", "Telefone"
            }
        ));
        tbl_administrador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_administradorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_administrador);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_apagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delete.png"))); // NOI18N
        btn_apagar.setText("APAGAR");
        btn_apagar.setToolTipText("Apagar");
        btn_apagar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_apagar.setEnabled(false);
        btn_apagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_apagarActionPerformed(evt);
            }
        });

        btn_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/update.png"))); // NOI18N
        btn_actualizar.setText("ACTUALIZAR");
        btn_actualizar.setToolTipText("Actualizar");
        btn_actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_actualizar.setEnabled(false);
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });

        btn_adicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/create.png"))); // NOI18N
        btn_adicionar.setText("ADICIONAR");
        btn_adicionar.setToolTipText("Adicionar");
        btn_adicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_adicionar)
                    .addComponent(btn_actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_apagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_adicionar)
                .addGap(18, 18, 18)
                .addComponent(btn_actualizar)
                .addGap(18, 18, 18)
                .addComponent(btn_apagar)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel36)
                                    .addComponent(jLabel41)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel37)
                                    .addComponent(jLabel38)
                                    .addComponent(jLabel39)
                                    .addComponent(jLabel40))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel25))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel24)))
                                        .addGap(26, 26, 26)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cb_sector, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txt_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(txt_datanasc, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txt_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(txt_datanasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(txt_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel38)
                                    .addComponent(txt_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel39)
                                    .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel40))
                                .addGap(20, 20, 20))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel24)
                                    .addComponent(txt_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel25)
                                    .addComponent(cb_sector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_pesquisar))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(838, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(48, 48, 48))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(166, 166, 166))
        );

        setBounds(0, 0, 1009, 670);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_telefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefoneActionPerformed

    private void btn_adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adicionarActionPerformed
        Administrador a = new Administrador();

        a.setNome(txt_nome.getText());
        a.setData_nasc(txt_datanasc.getText());
        a.setEndereco(txt_endereco.getText());
        a.setNum_telefone(txt_telefone.getText());
        a.setUsuario(txt_usuario.getText());
        a.setSenha(txt_senha.getText());
        a.setPerfil(txt_perfil.getText());
        a.setSector(cb_sector.getSelectedItem().toString());

        if ((txt_nome.getText().isEmpty()) || (txt_datanasc.getText().isEmpty()) || (txt_usuario.getText().isEmpty()) || (txt_senha.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios", "AVISO", JOptionPane.ERROR_MESSAGE);
        } else {
            adicionarUsuario(a);
            adicionarAdministrador(a);
            limpar();
        }


    }//GEN-LAST:event_btn_adicionarActionPerformed

    private void txt_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pesquisarActionPerformed

    private void txt_pesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pesquisarKeyReleased
        // TODO add your handling code here:
        pesquisarAdministrador();
    }//GEN-LAST:event_txt_pesquisarKeyReleased

    private void tbl_administradorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_administradorMouseClicked
        // TODO add your handling code here:
        setarTabela();
    }//GEN-LAST:event_tbl_administradorMouseClicked

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        // TODO add your handling code here:
        actualizarDadosAdministrador();
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void btn_apagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_apagarActionPerformed
        // TODO add your handling code here:
        apagarAdministrador();
    }//GEN-LAST:event_btn_apagarActionPerformed

    private void cb_sectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_sectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_sectorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_adicionar;
    private javax.swing.JButton btn_apagar;
    private javax.swing.JComboBox<String> cb_sector;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_administrador;
    private javax.swing.JTextField txt_datanasc;
    private javax.swing.JTextField txt_endereco;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_perfil;
    private javax.swing.JTextField txt_pesquisar;
    private javax.swing.JTextField txt_senha;
    private javax.swing.JTextField txt_telefone;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
