package view;

import Conexao.conexao;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet; /*Toda memoria da table*/
import javax.swing.JOptionPane;
/**
 *
 * @author ERICABRITODASILVA
 */
public class frmConsultaMecanico extends javax.swing.JFrame {

     private void atualizarTabela() {
        DefaultTableModel modelo = (DefaultTableModel)tblConsMecanico.getModel();/*Metodo para atualizar tabela*/
        
        modelo.setRowCount(0);/*metodo para zera linhas na tabela*/
        
        String sql = "SELECT * FROM mecanico "/* Variaveis sql*/
                + "ORDER BY id";
        
        try(Connection conex = conexao.conectar();
           PreparedStatement stmt = conex.prepareStatement(sql);   
           ResultSet resultado = stmt.executeQuery() ){
            
           while(resultado.next()){
               modelo.addRow(new Object[] {
                resultado.getInt("id"),
                resultado.getString("nome"),
                resultado.getString("especialidade"),
                resultado.getString("telefone"),
                resultado.getString("data_admissao"),
                resultado.getString("ativo"),
               
               });
           } 
        }catch (SQLException erro){
            JOptionPane.showMessageDialog(this, "Erro ao atualizar tabela:\n" + erro.getMessage(),
                    "Erro no banco de dados",
                   JOptionPane.ERROR_MESSAGE);

        }
     }
    public frmConsultaMecanico() {
        initComponents();
        
        setLocationRelativeTo(null);
        setTitle("AutoManager -  Consulta de Mecânicos");
        tblConsMecanico.setModel(new DefaultTableModel(new Object[][]{},
                            new String[] {"ID","Nome","especialidade","Telefone","data_admissao","Endereco","Ativo"}){
                    @Override
                    public boolean isCellEditable(int linha, int coluna){
                        return false;
                    }
                    });                   
                
        tblConsMecanico.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        
        atualizarTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblConsMecanico = new javax.swing.JTable();
        cmbPesquisarPor = new javax.swing.JComboBox<>();
        txtPesquisando = new javax.swing.JTextField();
        btnLocalizar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 153, 0));
        jTextField1.setText("                               Consulta de Mecânicos");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        tblConsMecanico.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tblConsMecanico.setForeground(new java.awt.Color(0, 0, 0));
        tblConsMecanico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Especialidade", "Telefone", "Observação", "Dt de Admissao", "Ativo"
            }
        ));
        jScrollPane2.setViewportView(tblConsMecanico);

        cmbPesquisarPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Nome", "Especialidade" }));
        cmbPesquisarPor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisar Por", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        cmbPesquisarPor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPesquisarPorActionPerformed(evt);
            }
        });

        txtPesquisando.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Valor Pesquisando", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        btnLocalizar.setBackground(new java.awt.Color(0, 0, 0));
        btnLocalizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLocalizar.setForeground(new java.awt.Color(255, 153, 0));
        btnLocalizar.setText("Localizar");
        btnLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizarActionPerformed(evt);
            }
        });

        btnAtualizar.setBackground(new java.awt.Color(0, 0, 0));
        btnAtualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAtualizar.setForeground(new java.awt.Color(255, 153, 0));
        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnAlterar.setBackground(new java.awt.Color(0, 0, 0));
        btnAlterar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAlterar.setForeground(new java.awt.Color(255, 153, 0));
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(0, 0, 0));
        btnExcluir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 153, 0));
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnFechar.setBackground(new java.awt.Color(0, 0, 0));
        btnFechar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFechar.setForeground(new java.awt.Color(255, 153, 0));
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jTextField1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbPesquisarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(txtPesquisando, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLocalizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(btnAtualizar)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(btnAlterar)
                .addGap(59, 59, 59)
                .addComponent(btnExcluir)
                .addGap(30, 30, 30)
                .addComponent(btnFechar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbPesquisarPor, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                            .addComponent(txtPesquisando))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLocalizar)
                            .addComponent(btnAtualizar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir)
                    .addComponent(btnFechar))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void cmbPesquisarPorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPesquisarPorActionPerformed
        cmbPesquisarPor.setActionCommand("");
        cmbPesquisarPor.requestFocus();
    }//GEN-LAST:event_cmbPesquisarPorActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void btnLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarActionPerformed
         String pesquisa = txtPesquisando.getText().trim();
        String tipo_pesquisa = cmbPesquisarPor.getSelectedItem().toString();
        
        
        ///////////////////////////////////////////Conferindo as informaçoes///////////////////////////////////////////
         if (pesquisa.isEmpty()){
            JOptionPane.showMessageDialog(
                        this,
                        "Digite o id, nome, especialidade.",
                        "Pesquisa Vazia",
                        JOptionPane.WARNING_MESSAGE);
            return;
        }
         
         DefaultTableModel modelo = (DefaultTableModel) tblConsMecanico.getModel();
        
        modelo.setRowCount(0);
        
        
        
        String sql ="";
        
        ///////////////////////////////////Verificando Pesquisa/////////////////////////////////////////////////////
        
        if (tipo_pesquisa.equals("ID")) {
            sql = "SELECT * FROM mecanico "
                  + "WHERE ID = ?";
        
        }
        
        else if (tipo_pesquisa.equals("Nome")) {
        
             sql = "SELECT * FROM mecanico "
                   + "WHERE nome ILIKE ? "
                   + "ORDER BY nome";
                }
        
        else if (tipo_pesquisa.equals("especialidade")){
        
             sql = "SELECT * FROM mecanico "
                   + "WHERE especialidade ILIKE ? ";
        }
        
       
            try (Connection conex = conexao.conectar();
            PreparedStatement stmt = conex.prepareStatement(sql)) {

            if (tipo_pesquisa.equals("Id")) {
        stmt.setInt(1, Integer.parseInt(pesquisa));
        
        
            } else {
        stmt.setString(1, "%" + pesquisa + "%");
    }
            
            try (ResultSet resultado = stmt.executeQuery()){
                while (resultado.next()){
                    modelo.addRow(new Object [] {
                        resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getString("especialidade"),
                        resultado.getString("telefone"),
                        resultado.getString("data_adimissao"),
                        resultado.getString("observacao"),
                        resultado.getBoolean("ativo")});
                        
                }
            }
            if (modelo.getRowCount() == 0){
             JOptionPane.showMessageDialog(this,
                           "Nenhum mecânico encontrado para: " + pesquisa,
                           "Resultado da Pesquisa",
                           JOptionPane.INFORMATION_MESSAGE);
              }
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(this,
                    "Erro ao localizar  :\n" + erro.getMessage(),
                    "Erro no banco de dados",
                     JOptionPane.ERROR_MESSAGE);
        }
         
    }//GEN-LAST:event_btnLocalizarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        atualizarTabela();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
         String pesquisa = txtPesquisando.getText().trim();
        String tipo_pesquisa = cmbPesquisarPor.getSelectedItem().toString();
        
         if (pesquisa.isEmpty()){
            JOptionPane.showMessageDialog(
                        this,
                        "Digite o id, nome,especialidade.",
                        "Pesquisa Vazia",
                        JOptionPane.WARNING_MESSAGE);
            return;
        }
         
         DefaultTableModel modelo = (DefaultTableModel)tblConsMecanico.getModel();
        
        modelo.setRowCount(0);
        
        
        
        String sql = "";
        
        Integer id = null;
        
        if (tipo_pesquisa.equals("Id")) {
        try {
            id = Integer.parseInt(pesquisa);
            
            sql = "SELECT * FROM mecanico WHERE id = ? ORDER BY id";
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID deve ser numérico.");
            return;
        }
        
        if (tipo_pesquisa.equals("Id")) {
        
             sql = "SELECT * FROM mecanico "
                   + "WHERE ID ILIKE ? "
                   + "ORDER BY ID";
                }
        
        else if (tipo_pesquisa.equals("nome")){
        
             sql = "SELECT * FROM mecanico "
                   + "WHERE nome   ILIKE ?";
        }
        else if (tipo_pesquisa.equals("especialidade")){
                sql = "SELECT * FROM mecanico"
                        + "WHERE especialidade ?";
                }
        
        try (Connection conex = conexao.conectar();
                
              PreparedStatement stmt = conex.prepareStatement(sql)){
            stmt.setString(1,"%" + pesquisa + "%");
            
            try (ResultSet resultado = stmt.executeQuery()){
                while (resultado.next()){
                    modelo.addRow(new Object [] {
                        resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getString("especialidade") });
                        
                }
            }
            if (modelo.getRowCount() == 0){
             JOptionPane.showMessageDialog(this,
                           "Nenhum mecânico encontrado para: " + pesquisa,
                           "Resultado da Pesquisa",
                           JOptionPane.INFORMATION_MESSAGE);
              }
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(this,
                    "Erro ao localizar  :\n" + erro.getMessage(),
                    "Erro no banco de dados",
                     JOptionPane.ERROR_MESSAGE);
        }
        } 
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
         int linha = tblConsMecanico.getSelectedRow();
        if (linha == -1){
        JOptionPane.showMessageDialog(this,"Selecione um mecanico para excluir!");
        return;
}
        int id = Integer.parseInt(tblConsMecanico.getValueAt(linha, 0).toString());

        int resposta = JOptionPane.showConfirmDialog(this,
                                                    "Desejar realmente excluir o mecanico do ID" + id + "?", 
                                                    "Confirmar Excluir", JOptionPane.YES_NO_CANCEL_OPTION,
                                                    JOptionPane.QUESTION_MESSAGE);
        if(resposta != JOptionPane.YES_OPTION) {
           return;
}
        String sql = "Delete from mecanico WHERE id = ?";

        try(Connection conex = conexao.conectar();
                PreparedStatement stmt = conex.prepareStatement(sql)){

                stmt.setInt(1, id);

                int registros = stmt.executeUpdate();
                if (registros > 0){
                JOptionPane.showMessageDialog(this, "Mecânico excluido com sucesso!");
                atualizarTabela();
        } else{
        JOptionPane.showMessageDialog(this, "Mecânico não encontrado!");
        }
      }catch (SQLException erro){
        JOptionPane.showMessageDialog(this, "Erro ao excluir mecânico: " + erro.getMessage());
}
                                          
    }//GEN-LAST:event_btnExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(frmConsultaMecanico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmConsultaMecanico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmConsultaMecanico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmConsultaMecanico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmConsultaMecanico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnLocalizar;
    private javax.swing.JComboBox<String> cmbPesquisarPor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblConsMecanico;
    private javax.swing.JTextField txtPesquisando;
    // End of variables declaration//GEN-END:variables
}
