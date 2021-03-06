/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prjrx.telas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import br.com.prjrx.dal.ConexaoBd;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandre
 */
public class TelaFilme extends javax.swing.JInternalFrame {
    //estabelece a conexao com o bd

    Connection conexao = null;
    //prepara a conexao
    PreparedStatement pst = null;
    //testa a conexao
    ResultSet rs = null;

    /**
     * Creates new form TelaFilme
     */
    public TelaFilme() {
        initComponents();
        conexao = ConexaoBd.conector();
    }

    //Método Adicionar Filme a partir do BD.
    private void adicionaFilme() {
        String sql = "insert into gcfilmes values(?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            // Pega os Valores dos campos no BD e seta no textfield selecionado.
            pst.setString(1, txtFilmId.getText());
            pst.setString(2, txtFilmTitle.getText());
            pst.setString(3, txtFilmGen.getText());
            pst.setString(4, txtFilmAno.getText());
            pst.setString(5, cboFilmVal.getSelectedItem().toString());
            pst.setString(6, cboFilmClass.getSelectedItem().toString());
            if ((txtFilmId.getText().isEmpty()) || (txtFilmTitle.getText().isEmpty())
                    || (txtFilmGen.getText().isEmpty()) || (txtFilmAno.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campo obrigatórios!");
            } else {
                // a linha abaixo atualiza a tabela gcfilmes com os dados do formulário
                //a estrutura abaixo é usada para confirmar a inserção dos dados do usuário no BD.
                int adiciona = pst.executeUpdate();
                if (adiciona > 0) {
                    JOptionPane.showMessageDialog(null, "Filme Cadastrado com Sucesso!");
                    txtFilmId.setText(null);
                    txtFilmTitle.setText(null);
                    txtFilmGen.setText(null);
                    txtFilmAno.setText(null);

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //Método Deletar Filme a partir do BD.
    private void removeFilme() {
//a estrutura abaixo confirma a remoção de um Filme.
        int confirma = JOptionPane.showConfirmDialog(null,
                 "Tem certeza que deseja remover este Filme?",
                 "Atenção!", JOptionPane.YES_NO_OPTION);

        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from gcfilmes where idfilme=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtFilmId.getText());
                int apagado = pst.executeUpdate();

                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null,
                             "Filme removido com sucesso!");
                    txtFilmId.setText(null);
                    txtFilmTitle.setText(null);
                    txtFilmGen.setText(null);
                    txtFilmAno.setText(null);
                    
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFilmId = new javax.swing.JTextField();
        txtFilmTitle = new javax.swing.JTextField();
        txtFilmGen = new javax.swing.JTextField();
        txtFilmAno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnFilmCreate = new javax.swing.JButton();
        btnFilmDelete = new javax.swing.JButton();
        cboFilmVal = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cboFilmClass = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastro Filme");
        setPreferredSize(new java.awt.Dimension(430, 480));

        jLabel1.setText("Id*");

        jLabel2.setText("Título*");

        jLabel3.setText("Gênero*");

        jLabel4.setText("Ano*");

        jLabel5.setText("Valor*");

        txtFilmGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFilmGenActionPerformed(evt);
            }
        });

        txtFilmAno.setText("AA/MM/DD");
        txtFilmAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFilmAnoActionPerformed(evt);
            }
        });

        jLabel6.setText("* Campos Obrigatórios.");

        btnFilmCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prjrx/icones/addmovie.png"))); // NOI18N
        btnFilmCreate.setToolTipText("Adicionar Filme");
        btnFilmCreate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFilmCreate.setPreferredSize(new java.awt.Dimension(64, 64));
        btnFilmCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilmCreateActionPerformed(evt);
            }
        });

        btnFilmDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prjrx/icones/removie.png"))); // NOI18N
        btnFilmDelete.setToolTipText("Remover Filme");
        btnFilmDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFilmDelete.setPreferredSize(new java.awt.Dimension(64, 64));
        btnFilmDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilmDeleteActionPerformed(evt);
            }
        });

        cboFilmVal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "15.00 (Filme Hd)", "30.00 (Filme 3D)" }));

        jLabel7.setText("Classificação Indicativa*");

        cboFilmClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Livre", "10", "12", "14", "16", "18" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(26, 26, 26)
                                .addComponent(cboFilmVal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(cboFilmClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFilmAno, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFilmId, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFilmTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFilmGen, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFilmCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFilmDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtFilmAno, txtFilmGen, txtFilmId, txtFilmTitle});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(btnFilmCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel2)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(btnFilmDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtFilmAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(cboFilmClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(txtFilmId, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                        .addGap(25, 25, 25)
                        .addComponent(txtFilmTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFilmGen, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                            .addComponent(jLabel3))
                        .addGap(115, 115, 115)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboFilmVal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jLabel6)
                .addGap(101, 101, 101))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFilmDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilmDeleteActionPerformed
        // Chamando Método removeFilme.
        removeFilme();
    }//GEN-LAST:event_btnFilmDeleteActionPerformed

    private void btnFilmCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilmCreateActionPerformed
        // Chamando Método AdicionaFilme.
        adicionaFilme();
    }//GEN-LAST:event_btnFilmCreateActionPerformed

    private void txtFilmGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFilmGenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFilmGenActionPerformed

    private void txtFilmAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFilmAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFilmAnoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFilmCreate;
    private javax.swing.JButton btnFilmDelete;
    private javax.swing.JComboBox<String> cboFilmClass;
    private javax.swing.JComboBox<String> cboFilmVal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtFilmAno;
    private javax.swing.JTextField txtFilmGen;
    private javax.swing.JTextField txtFilmId;
    private javax.swing.JTextField txtFilmTitle;
    // End of variables declaration//GEN-END:variables
}
