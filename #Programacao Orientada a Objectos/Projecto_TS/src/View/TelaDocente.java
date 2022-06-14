/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static Controller.Controller.*;
import Model.Conexao;
import Model.Docente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Fernando Gomes
 */
public class TelaDocente extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaDocente
     */
    public TelaDocente() {
        initComponents();
        conexao = Conexao.conexaoDB();
    }

    Connection conexao;
    PreparedStatement pst;
    ResultSet rs;

    //metodo responsavel por fazer pesquisa
    private void pesquisarDocente() {
        String sql = "select tbl_usuario.id_user, tbl_usuario.nome, tbl_usuario.data_nasc, tbl_usuario.endereco, tbl_usuario.num_telefone, tbl_usuario.usuario, tbl_usuario.senha, tbl_usuario.perfil, tbl_docente.nome_cadeira, tbl_docente.status_docente from tbl_usuario, tbl_docente where tbl_usuario.id_user = tbl_docente.id_user and nome like?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txt_pesquisar.getText() + "%");
            rs = pst.executeQuery();
            tbl_docente.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //metodo responsavel por setar os campos na tabela
    private void setarTabelaDocente() {
        int setar = tbl_docente.getSelectedRow();
        txt_id.setText(tbl_docente.getModel().getValueAt(setar, 0).toString());
        txt_nome.setText(tbl_docente.getModel().getValueAt(setar, 1).toString());
        txt_datanasc.setText(tbl_docente.getModel().getValueAt(setar, 2).toString());
        txt_endereco.setText(tbl_docente.getModel().getValueAt(setar, 3).toString());
        txt_telefone.setText(tbl_docente.getModel().getValueAt(setar, 4).toString());
        txt_usuario.setText(tbl_docente.getModel().getValueAt(setar, 5).toString());
        txt_senha.setText(tbl_docente.getModel().getValueAt(setar, 6).toString());
        txt_perfil.setText(tbl_docente.getModel().getValueAt(setar, 7).toString());
        txt_cadeira.setText(tbl_docente.getModel().getValueAt(setar, 8).toString());
        ButtonModel bm = null;
        rb_status.setSelected(bm, true);

        //habilita os botoes de ACTUALIZAR e APAGAR e desabilita o botao de ADICIONAR
        btn_adicionar.setEnabled(false);
        btn_actualizar.setEnabled(true);
        btn_apagar.setEnabled(true);

    }

    //metodo responsavel por actualizar dados do docente
    private void actulizarDadosDocente() {
        String sql = "update tbl_usuario inner join tbl_docente on tbl_usuario.id_user = tbl_docente.id_user set tbl_usuario.nome=?, tbl_usuario.data_nasc=?, tbl_usuario.endereco=?, tbl_usuario.num_telefone=?, tbl_usuario.usuario=?, tbl_usuario.senha=?, tbl_usuario.perfil=?, tbl_docente.nome_cadeira=?, tbl_docente.status_docente=?  WHERE tbl_usuario.id_user = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txt_nome.getText());
            pst.setString(2, txt_datanasc.getText());
            pst.setString(3, txt_endereco.getText());
            pst.setString(4, txt_telefone.getText());
            pst.setString(5, txt_usuario.getText());
            pst.setString(6, txt_senha.getText());
            pst.setString(7, txt_perfil.getText());
            pst.setString(8, txt_cadeira.getText());
            if (!(rb_activo.setSelected(rb_activo.setText("9") {
                pst.setString(9, rb_inativo.getText());
            } else {
                pst.setString(9, rb_activo.getText());
            }
            
            //pst.setString(9, rb_status.getSelection().toString());
            pst.setString(10, txt_id.getText());
            if ((txt_nome.getText().isEmpty()) || (txt_datanasc.getText().isEmpty()) || (txt_usuario.getText().isEmpty()) || (txt_senha.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios", "AVISO", JOptionPane.ERROR_MESSAGE);
            } else {
                int adicionado = pst.executeUpdate();//actualiza na base de dados
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do Docente alterados com sucesso");
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

    //metodo responsavel por apagar um docente
    private void apagarDocente() {
        String sql = "delete from tbl_docente where id_user=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txt_id.getText());
            int apagado = pst.executeUpdate();
            if (apagado > 0) {
                JOptionPane.showMessageDialog(null, "Docente removido com sucesso");
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

    //metodo responsavel por limpar os campos apos uma operacao
    private void limpar() {
        txt_pesquisar.setText(null);
        txt_id.setText(null);
        txt_nome.setText(null);
        txt_datanasc.setText(null);
        txt_endereco.setText(null);
        txt_telefone.setText(null);
        txt_usuario.setText(null);
        txt_senha.setText(null);
        txt_cadeira.setText(null);
        ((DefaultTableModel) tbl_docente.getModel()).setRowCount(0);

        //depois de limpar os campos vai habilitar o botap ADICIONAR e desabilitar os campos ACTUALIZAR e APAGAR
        btn_actualizar.setEnabled(true);
        btn_actualizar.setEnabled(false);
        btn_apagar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rb_status = new javax.swing.ButtonGroup();
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
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txt_cadeira = new javax.swing.JTextField();
        txt_perfil = new javax.swing.JTextField();
        txt_datanasc = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_docente = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_pesquisar = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btn_apagar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        btn_adicionar = new javax.swing.JButton();
        rb_activo = new javax.swing.JRadioButton();
        rb_inativo = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Docente");

        jLabel7.setText("* Campos obrigatórios");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Docente"));

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

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel24.setText("Perfil");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel25.setText("Cadeira");

        txt_cadeira.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        txt_perfil.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txt_perfil.setText("Docente");
        txt_perfil.setEnabled(false);

        txt_datanasc.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel42.setText("yyyy-mm-dd");

        tbl_docente.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_docente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_docenteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_docente);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N

        txt_pesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pesquisarKeyReleased(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_apagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delete.png"))); // NOI18N
        btn_apagar.setText("APAGAR");
        btn_apagar.setToolTipText("Apagar");
        btn_apagar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_apagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_apagarActionPerformed(evt);
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
                .addGap(30, 30, 30)
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
                .addContainerGap(36, Short.MAX_VALUE))
        );

        rb_status.add(rb_activo);
        rb_activo.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        rb_activo.setSelected(true);
        rb_activo.setText("Activo");

        rb_status.add(rb_inativo);
        rb_inativo.setText("Inativo");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("Status");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txt_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addContainerGap(483, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel36)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel35)
                                                    .addComponent(jLabel41))
                                                .addGap(16, 16, 16))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel37)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel39)
                                                .addComponent(jLabel38)
                                                .addComponent(jLabel40)))
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_endereco)
                                    .addComponent(txt_nome)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(txt_datanasc, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(82, 82, 82)
                                                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 172, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txt_senha, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                            .addComponent(txt_usuario, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_telefone, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(32, 32, 32)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(rb_activo)
                                                .addGap(18, 18, 18)
                                                .addComponent(rb_inativo))
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txt_perfil, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                                                .addComponent(txt_cadeira)))))
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38))))
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
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_datanasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel42))
                            .addComponent(jLabel36))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(txt_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(txt_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24)
                            .addComponent(txt_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)
                            .addComponent(txt_cadeira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel40)
                                .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rb_activo)
                                .addComponent(rb_inativo)
                                .addComponent(jLabel2)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        setBounds(0, 0, 1008, 670);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_telefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefoneActionPerformed

    private void btn_adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adicionarActionPerformed
        Docente d = new Docente();

        d.setNome(txt_nome.getText());
        d.setData_nasc(txt_datanasc.getText());
        d.setEndereco(txt_endereco.getText());
        d.setNum_telefone(txt_telefone.getText());
        d.setUsuario(txt_usuario.getText());
        d.setSenha(txt_senha.getText());
        d.setPerfil(txt_perfil.getText());
        d.setNome_cadeira(txt_cadeira.getText());
        String status = null;
        if (rb_activo.isSelected()) {
            status = "Activo";
        } else {
            status = "Inactivo";
        }
        d.setStatus(status);

        if ((txt_nome.getText().isEmpty()) || (txt_datanasc.getText().isEmpty()) || (txt_usuario.getText().isEmpty()) || (txt_senha.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios", "AVISO", JOptionPane.ERROR_MESSAGE);
        } else {
            adicionarUsuario(d);
            adicionarDocente(d);

            limpar();
        }
    }//GEN-LAST:event_btn_adicionarActionPerformed

    private void btn_apagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_apagarActionPerformed
        // TODO add your handling code here:
        apagarDocente();
    }//GEN-LAST:event_btn_apagarActionPerformed

    private void txt_pesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pesquisarKeyReleased
        // TODO add your handling code here:
        pesquisarDocente();
    }//GEN-LAST:event_txt_pesquisarKeyReleased

    private void tbl_docenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_docenteMouseClicked
        // TODO add your handling code here:
        setarTabelaDocente();
    }//GEN-LAST:event_tbl_docenteMouseClicked

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        // TODO add your handling code here:
        actulizarDadosDocente();
    }//GEN-LAST:event_btn_actualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_adicionar;
    private javax.swing.JButton btn_apagar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rb_activo;
    private javax.swing.JRadioButton rb_inativo;
    private javax.swing.ButtonGroup rb_status;
    private javax.swing.JTable tbl_docente;
    private javax.swing.JTextField txt_cadeira;
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
