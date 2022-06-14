/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static Controller.Controller.*;
import Model.Conexao;
import Model.Estudante;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Fernando Gomes
 */
public class TelaEstudante extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaEstudante
     */
    public TelaEstudante() {
        initComponents();
        conexao = Conexao.conexaoDB();
    }

    Connection conexao;
    PreparedStatement pst;
    ResultSet rs;

    //metodo responsavel por fazer pesquisa
    private void pesquisarEstudante() {
        String sql = "select tbl_usuario.id_user, tbl_usuario.nome, tbl_usuario.data_nasc, tbl_usuario.endereco, tbl_usuario.num_telefone, tbl_usuario.usuario, tbl_usuario.senha, tbl_usuario.perfil, tbl_estudante.num_estudante, tbl_estudante.curso from tbl_usuario, tbl_estudante where tbl_usuario.id_user = tbl_estudante.id_user AND nome like?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txt_pesquisar.getText() + "%");
            rs = pst.executeQuery();
            tbl_estudantes.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    //metodo responsavel por setar os campos de texto com dados da tabela
    private void setarTabela() {
        int setar = tbl_estudantes.getSelectedRow();
        txt_id.setText(tbl_estudantes.getModel().getValueAt(setar, 0).toString());
        txt_nome.setText(tbl_estudantes.getModel().getValueAt(setar, 1).toString());
        txt_datanasc.setText(tbl_estudantes.getModel().getValueAt(setar, 2).toString());
        txt_endereco.setText(tbl_estudantes.getModel().getValueAt(setar, 3).toString());
        txt_telefone.setText(tbl_estudantes.getModel().getValueAt(setar, 4).toString());
        txt_usuario.setText(tbl_estudantes.getModel().getValueAt(setar, 5).toString());
        txt_senha.setText(tbl_estudantes.getModel().getValueAt(setar, 6).toString());
        txt_perfil.setText(tbl_estudantes.getModel().getValueAt(setar, 7).toString());
        txt_numEstudante.setText(tbl_estudantes.getModel().getValueAt(setar, 8).toString());
        cb_curso.setSelectedItem(tbl_estudantes.getModel().getValueAt(setar, 9).toString());
        
        //habilita os botoes de ACTUALIZAR e APAGAR e desabilita o botao de ADICIONAR
        btn_adicionar.setEnabled(false);
        btn_actualizar.setEnabled(true);
        btn_apagar.setEnabled(true);

    }

    //metodo responsavel por actulizar dados do estudante
    private void actualizarDados() {
        String sql = "update tbl_usuario inner join tbl_estudante on tbl_usuario.id_user = tbl_estudante.id_user set tbl_usuario.nome=?, tbl_usuario.data_nasc=?, tbl_usuario.endereco=?, tbl_usuario.num_telefone=?, tbl_usuario.usuario=?, tbl_usuario.senha=?, tbl_usuario.perfil=?, tbl_estudante.num_estudante=?, tbl_estudante.curso=? WHERE tbl_usuario.id_user = ? ";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txt_nome.getText());
            pst.setString(2, txt_datanasc.getText());
            pst.setString(3, txt_endereco.getText());
            pst.setString(4, txt_telefone.getText());
            pst.setString(5, txt_usuario.getText());
            pst.setString(6, txt_senha.getText());
            pst.setString(7, txt_perfil.getText());
            pst.setString(8, txt_numEstudante.getText());
            pst.setString(9, cb_curso.getSelectedItem().toString());
            pst.setString(10, txt_id.getText());

            if ((txt_nome.getText().isEmpty()) || (txt_datanasc.getText().isEmpty()) || (txt_usuario.getText().isEmpty()) || (txt_senha.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios", "AVISO", JOptionPane.ERROR_MESSAGE);
            } else {
                int adicionado = pst.executeUpdate();//actualiza na base de dados
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do Estudante alterados com sucesso");
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

    //metodo responsavel por apagar um estudante
    private void apagarEstudante() {
        String sql = "delete from tbl_estudante WHERE id_user=?";
        //String sql2 = "delete from tbl_usuario where id_user =?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txt_id.getText());
            //pst.setString(2, txt_id.getText());
            int apagado = pst.executeUpdate();
            if (apagado > 0) {
                JOptionPane.showMessageDialog(null, "Estudante removido com sucesso");
                //depois de apagar os dados, habilita o botao ADICIONAR e desabilita ACTUALIZAR e APAGAR
                btn_adicionar.setEnabled(true);
                btn_actualizar.setEnabled(false);
                btn_apagar.setEnabled(false);
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
        txt_numEstudante.setText(null);
        cb_curso.setSelectedIndex(0);
        ((DefaultTableModel) tbl_estudantes.getModel()).setRowCount(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
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
        jLabel42 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txt_numEstudante = new javax.swing.JTextField();
        cb_curso = new javax.swing.JComboBox<>();
        txt_perfil = new javax.swing.JTextField();
        txt_pesquisar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_estudantes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btn_adicionar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        btn_apagar = new javax.swing.JButton();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Estudante");

        jLabel7.setText("* Campos obrigatórios");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Estudante"));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel35.setText("*Nome:");

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel36.setText("*Data de Nascimento: ");

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel37.setText("Endereço:");

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel38.setText("Telefone:");

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel39.setText("*Usuario:");

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel40.setText("*Senha:");

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

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel42.setText("yyyy-mm-dd");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel24.setText("Perfil");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel25.setText("Curso");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel26.setText("*Numero Estudante");

        txt_numEstudante.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        cb_curso.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        cb_curso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CIG", "Estatistica", "Informatica", "Matematica" }));

        txt_perfil.setEditable(false);
        txt_perfil.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txt_perfil.setText("Estudante");

        txt_pesquisar.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txt_pesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pesquisarKeyReleased(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N

        tbl_estudantes.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_estudantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_estudantesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_estudantes);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_adicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/create.png"))); // NOI18N
        btn_adicionar.setText("ADICIONAR");
        btn_adicionar.setToolTipText("Adicionar");
        btn_adicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adicionarActionPerformed(evt);
            }
        });

        btn_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/update.png"))); // NOI18N
        btn_actualizar.setText("ACTUALIZAR");
        btn_actualizar.setToolTipText("Actualizar");
        btn_actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });

        btn_apagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delete.png"))); // NOI18N
        btn_apagar.setText("  APAGAR");
        btn_apagar.setToolTipText("Apagar");
        btn_apagar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_apagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_apagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_adicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_apagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(58, 58, 58))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_adicionar)
                .addGap(18, 18, 18)
                .addComponent(btn_actualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_apagar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel36)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(txt_senha, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                                                    .addComponent(txt_usuario))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel24)
                                                        .addComponent(jLabel25))
                                                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addGap(36, 36, 36))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txt_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addComponent(txt_datanasc, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(55, 55, 55)
                                                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)))
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_perfil, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                            .addComponent(cb_curso, 0, 145, Short.MAX_VALUE)
                                            .addComponent(txt_numEstudante)))
                                    .addComponent(txt_endereco)
                                    .addComponent(txt_nome))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txt_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_pesquisar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(txt_datanasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(txt_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(txt_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24)
                            .addComponent(txt_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_numEstudante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(824, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(61, 61, 61))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        setBounds(0, 0, 1008, 667);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_telefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefoneActionPerformed

    private void btn_adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adicionarActionPerformed
        // TODO add your handling code here:
        Estudante e = new Estudante();

        e.setNome(txt_nome.getText());
        e.setData_nasc(txt_datanasc.getText());
        e.setEndereco(txt_endereco.getText());
        e.setNum_telefone(txt_telefone.getText());
        e.setUsuario(txt_usuario.getText());
        e.setSenha(txt_senha.getText());
        e.setPerfil(txt_perfil.getText());
        e.setNum_estudante(txt_numEstudante.getText());
        e.setCurso(cb_curso.getSelectedItem().toString());

        if ((txt_nome.getText().isEmpty()) || (txt_datanasc.getText().isEmpty()) || (txt_usuario.getText().isEmpty()) || (txt_senha.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios", "AVISO", JOptionPane.ERROR_MESSAGE);
        } else {
            adicionarUsuario(e);
            adicionarEstudante(e);
            limpar();
        }

    }//GEN-LAST:event_btn_adicionarActionPerformed

    private void txt_pesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pesquisarKeyReleased
        pesquisarEstudante();

    }//GEN-LAST:event_txt_pesquisarKeyReleased

    private void tbl_estudantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_estudantesMouseClicked
        // TODO add your handling code here:
        setarTabela();
    }//GEN-LAST:event_tbl_estudantesMouseClicked

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        // TODO add your handling code here:
        actualizarDados();
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void btn_apagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_apagarActionPerformed
        // TODO add your handling code here:
        apagarEstudante();
    }//GEN-LAST:event_btn_apagarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_adicionar;
    private javax.swing.JButton btn_apagar;
    private javax.swing.JComboBox<String> cb_curso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_estudantes;
    private javax.swing.JTextField txt_datanasc;
    private javax.swing.JTextField txt_endereco;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_numEstudante;
    private javax.swing.JTextField txt_perfil;
    private javax.swing.JTextField txt_pesquisar;
    private javax.swing.JTextField txt_senha;
    private javax.swing.JTextField txt_telefone;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
