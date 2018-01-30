/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prjrx.telas;

import java.sql.*;
import br.com.prjrx.dal.ConexaoBd;
import java.util.Locale;
import javax.swing.JOptionPane;
//importando biblioteca rs2xml.jar
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Alexandre
 */
public class TelaCliente extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form TelaCliente
     */
    public TelaCliente() {
        initComponents();
        conexao = ConexaoBd.conector();

    }

    private void comprarBilhete() {
        String sql = "insert into gcclientes(idade,horario,sessao,nome) values(?,?,?,?)";
        try {

            pst = conexao.prepareStatement(sql);
            // Pega os Valores dos campos no BD e seta no textfield selecionado.
            pst.setString(1, txtCliIdade.getText());
            pst.setString(2, cboCliHora.getSelectedItem().toString());
            pst.setString(3, cboCliSessao.getSelectedItem().toString());
            pst.setString(4, txtCliNome.getText());

            //se o cadastro nao for realizado de acordo com os campos obrigatorios
            if (txtCliIdade.getText().isEmpty() || txtCliNome.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!");

            } else {

                // a linha abaixo atualiza a tabela gcusuarios com os dados do formulário
                //a estrutura abaixo é usada para confirmar a inserção dos dados do usuário no BD.
                int adicionado = pst.executeUpdate();
                //caixa de messagem,confirmando cadastro.

                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário Cadastrado com Sucesso!");
                    txtCliIdade.setText(null);
                    txtCliNome.setText(null);

                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // método para cancelar compra de bilhete
    private void cancelarBilhete() {
        if (txtCliNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Por favor,insira o seu nome na caixa acima!");
        } else {
            int cancela = JOptionPane.showConfirmDialog(null,
                    "Tem certeza que deseja cancelar a compra do Bilhete?",
                    "Atenção", JOptionPane.YES_NO_OPTION);

            if (cancela == JOptionPane.YES_OPTION) {
                String sql = "delete from gcclientes where nome =?";

                try {
                    pst = conexao.prepareStatement(sql);
                    pst.setString(1, txtCliNome.getText());

                    int apaga = pst.executeUpdate();

                    if (apaga > 0) {
                        JOptionPane.showMessageDialog(null,
                                "A compra foi cancelada com sucesso!");
                        txtCliIdade.setText(null);
                        txtCliNome.setText(null);
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
    }

    //Método de pesquisar filmes com filtro.
    private void pesquisafilm() {
        String sql = "select * from gcfilmes where titulo like ?";
        try {
            pst = conexao.prepareStatement(sql);
            //passando o conteúdo do txtCliPesquisar para o ? do Bd.
            //na linha 100 faltou o "%" do sql,será necessário concatenar a string.
            pst.setString(1, txtCliPesquisar.getText() + "%");
            rs = pst.executeQuery();

            //A linha abaixo usa o biblioteca rs2xml.jar para preecher a tabela.
            tblCliFilm.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
//O método abaixo deveria fazer uma consulta ao BD,para comparar a idade do cliente
//com a classificação indicativa(caso fosse necessário).
    /*private void verifica_idade() {
        String sql = "select gcclientes.idade from gcclientes inner join gcfilmes on (idade >= classIndicativa) where idfilme = ?";
        
        boolean compara = sql.isEmpty();
        
        

        try {
            
            if (compara){
                JOptionPane.showMessageDialog(null, "Você não tem idade para assitir");
                
            }
            else {
                pst = conexao.prepareStatement(sql);
                pst.executeUpdate();
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    */
    
    
     
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCliPesquisar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliFilm = new javax.swing.JTable();
        txtCliIdade = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cboCliHora = new javax.swing.JComboBox<>();
        cboCliSessao = new javax.swing.JComboBox<>();
        btnCliBuy = new javax.swing.JButton();
        btnCLiCancel = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCliNome = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Área do Cliente");
        setPreferredSize(new java.awt.Dimension(430, 480));

        txtCliPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCliPesquisarKeyReleased(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prjrx/icones/search.png"))); // NOI18N

        tblCliFilm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblCliFilm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCliFilmMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCliFilm);

        jLabel3.setText("Idade* :");

        jLabel4.setText("Horário* :");

        jLabel5.setText("Sessão* : ");

        cboCliHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10:00", "14:00", "16:00", "20:00", "22:00" }));

        cboCliSessao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manhã", "Tarde", "Noite" }));

        btnCliBuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prjrx/icones/buyIcon.png"))); // NOI18N
        btnCliBuy.setToolTipText("Comprar Bilhete");
        btnCliBuy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCliBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliBuyActionPerformed(evt);
            }
        });

        btnCLiCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prjrx/icones/cancelIcon.png"))); // NOI18N
        btnCLiCancel.setToolTipText("Cancelar Compra");
        btnCLiCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCLiCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCLiCancelActionPerformed(evt);
            }
        });

        jLabel6.setText("* Campos Obrigatórios");

        jLabel7.setText("Nome* : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(386, 386, 386)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtCliPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel2)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCliBuy)
                                .addGap(56, 56, 56)
                                .addComponent(btnCLiCancel))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboCliSessao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(65, 65, 65)
                                        .addComponent(cboCliHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(26, 26, 26)
                                        .addComponent(txtCliIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCliNome, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtCliPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCliNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(txtCliIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboCliHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboCliSessao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCliBuy, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCLiCancel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(0, 42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCliBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliBuyActionPerformed
        // Chamando Método comprarBilhete
        
        comprarBilhete();
        
        
    }//GEN-LAST:event_btnCliBuyActionPerformed

    private void btnCLiCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCLiCancelActionPerformed
        // Chamando metodo cancelarBilhete.
        cancelarBilhete();
    }//GEN-LAST:event_btnCLiCancelActionPerformed

    private void txtCliPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCliPesquisarKeyReleased
        // O Evento abaixo é do tipo - 'Enquanto for digitando';
        pesquisafilm();
    }//GEN-LAST:event_txtCliPesquisarKeyReleased

    private void tblCliFilmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCliFilmMouseClicked
        // O Evento abaixo é para quando um filme for selecionado na tabela.

    }//GEN-LAST:event_tblCliFilmMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCLiCancel;
    private javax.swing.JButton btnCliBuy;
    private javax.swing.JComboBox<String> cboCliHora;
    private javax.swing.JComboBox<String> cboCliSessao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCliFilm;
    private javax.swing.JTextField txtCliIdade;
    private javax.swing.JTextField txtCliNome;
    private javax.swing.JTextField txtCliPesquisar;
    // End of variables declaration//GEN-END:variables
}
