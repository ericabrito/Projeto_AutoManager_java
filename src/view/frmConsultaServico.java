package view;

import Conexao.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ERICABRITODASILVA
 */
public class frmConsultaServico extends javax.swing.JFrame {
         
    private void atualizarTabela() {
        DefaultTableModel modelo = (DefaultTableModel)tblConsServiço.getModel();/*Metodo para atualizar tabela*/
        
        modelo.setRowCount(0);/*metodo para zera linhas na tabela*/
        
        String sql = "SELECT * FROM cliente "/* Variaveis sql*/
                + "ORDER BY id";
        
        try(Connection conex = conexao.conectar();
           PreparedStatement stmt = conex.prepareStatement(sql);   
           ResultSet resultado = stmt.executeQuery() ){
            
           while(resultado.next()){
               modelo.addRow(new Object[] {
                resultado.getInt("id"),
                resultado.getString("descricao"),
                resultado.getString("categoria"),
                resultado.getString("valor_base"),
                resultado.getString("tempo_estimado"),
                resultado.getString("observacao"),
                resultado.getString("Ativo"),
               
               });
           } 
        }catch (SQLException erro){
            JOptionPane.showMessageDialog(this, "Erro ao atualizar tabela:\n" + erro.getMessage(),
                    "Erro no banco de dados",
                   JOptionPane.ERROR_MESSAGE);

        }
        }
    /**
     * Creates new form frmConsultaServico
     */
    public frmConsultaServico() {
        initComponents();
        
        setLocationRelativeTo(null);
        setTitle("AutoManager -  Consulta de servico");
        tblConsServiço.setModel(new DefaultTableModel(new Object[][]{},
                            new String[] {"id","descricao","categoria","valor_base","tempo_estimado_horas","observacao","Ativo"}){
                    @Override
                    public boolean isCellEditable(int linha, int coluna){
                        return false;
                    }
                    });                   
                
        tblConsServiço.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        
        atualizarTabela();

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbPesquisaPor = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsServiço = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        txtPesquisando = new javax.swing.JTextField();
        btnLocalizar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnAlterar2 = new javax.swing.JButton();
        btnExcluir2 = new javax.swing.JButton();
        btnFechar2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cmbPesquisaPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Descrição", "Categoria." }));
        cmbPesquisaPor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisar Por:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        cmbPesquisaPor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPesquisaPorActionPerformed(evt);
            }
        });

        tblConsServiço.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Descrição", "Categoria", "Valor Base", "Tempo Estimado", "Ativo"
            }
        ));
        jScrollPane1.setViewportView(tblConsServiço);

        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 153, 0));
        jTextField1.setText("                 Consulta de serviços ");

        txtPesquisando.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtPesquisando.setForeground(new java.awt.Color(0, 0, 0));
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

        btnAlterar2.setBackground(new java.awt.Color(0, 0, 0));
        btnAlterar2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAlterar2.setForeground(new java.awt.Color(255, 153, 0));
        btnAlterar2.setText("Alterar");
        btnAlterar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterar2ActionPerformed(evt);
            }
        });

        btnExcluir2.setBackground(new java.awt.Color(0, 0, 0));
        btnExcluir2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExcluir2.setForeground(new java.awt.Color(255, 153, 0));
        btnExcluir2.setText("Excluir");
        btnExcluir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluir2ActionPerformed(evt);
            }
        });

        btnFechar2.setBackground(new java.awt.Color(0, 0, 0));
        btnFechar2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFechar2.setForeground(new java.awt.Color(255, 153, 0));
        btnFechar2.setText("Fechar");
        btnFechar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFechar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbPesquisaPor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtPesquisando, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnLocalizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAtualizar)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(btnAlterar2)
                .addGap(73, 73, 73)
                .addComponent(btnExcluir2)
                .addGap(73, 73, 73)
                .addComponent(btnFechar2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbPesquisaPor, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPesquisando, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLocalizar)
                            .addComponent(btnAtualizar))
                        .addGap(45, 45, 45)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterar2)
                    .addComponent(btnExcluir2)
                    .addComponent(btnFechar2))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluir2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcluir2ActionPerformed

    private void btnFechar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFechar2ActionPerformed
         dispose();
    }//GEN-LAST:event_btnFechar2ActionPerformed

    private void cmbPesquisaPorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPesquisaPorActionPerformed
        
    }//GEN-LAST:event_cmbPesquisaPorActionPerformed

    private void btnLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarActionPerformed
        String pesquisa = txtPesquisando.getText().trim();
        String tipo_pesquisa = cmbPesquisaPor.getSelectedItem().toString();
        
        
        ///////////////////////////////////////////Conferindo as informaçoes///////////////////////////////////////////
         if (pesquisa.isEmpty()){
            JOptionPane.showMessageDialog(
                        this,
                        "Digite o id, descricao, categoria.",
                        "Pesquisa Vazia",
                        JOptionPane.WARNING_MESSAGE);
            return;
        }
         
         DefaultTableModel modelo = (DefaultTableModel) tblConsServiço.getModel();
        
        modelo.setRowCount(0);
        
        
        
        String sql ="";
        
        ///////////////////////////////////Verificando Pesquisa/////////////////////////////////////////////////////
        
        if (tipo_pesquisa.equals("ID")) {
            sql = "SELECT * FROM servico "
                  + "WHERE ID = ?";
        
        }
        
        else if (tipo_pesquisa.equals("descricao")) {
        
             sql = "SELECT * FROM servico "
                   + "WHERE descricao ILIKE ? "
                   + "ORDER BY descricao";
                }
        
        else if (tipo_pesquisa.equals("categoria")){
        
             sql = "SELECT * FROM servico "
                   + "WHERE categoria ILIKE ? ";
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
                        resultado.getString("descricao"),
                        resultado.getString("categoria"),
                        resultado.getString("valor_base"),
                        resultado.getString("tempo_estimado_horas"),
                        resultado.getString("observacao"),
                        resultado.getBoolean("ativo")});
                        
                }
            }
            if (modelo.getRowCount() == 0){
             JOptionPane.showMessageDialog(this,
                           "Nenhum serviço encontrado para: " + pesquisa,
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

    private void btnAlterar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterar2ActionPerformed
        String pesquisa = txtPesquisando.getText().trim();
        String tipo_pesquisa =cmbPesquisaPor.getSelectedItem().toString();
        
         if (pesquisa.isEmpty()){
            JOptionPane.showMessageDialog(
                        this,
                        "Digite o id, descricao, categoria",
                        "Pesquisa Vazia",
                        JOptionPane.WARNING_MESSAGE);
            return;
        }
         
         DefaultTableModel modelo = (DefaultTableModel)tblConsServiço.getModel();
        
        modelo.setRowCount(0);
        
        
        
        String sql = "";
        
        Integer id = null;
        
        if (tipo_pesquisa.equals("Id")) {
        try {
            id = Integer.parseInt(pesquisa);
            
            sql = "SELECT * FROM servico WHERE id = ? ORDER BY id";
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID deve ser numérico.");
            return;
        }
        
        if (tipo_pesquisa.equals("ID")) {
        
             sql = "SELECT * FROM servico "
                   + "WHERE ID ILIKE ? "
                   + "ORDER BY ID";
                }
        
        else if (tipo_pesquisa.equals("descricao")){
        
             sql = "SELECT * FROM servico "
                   + "WHERE descricao   ILIKE ?";
        }
        else if (tipo_pesquisa.equals("categoria")){
                sql = "SELECT * FROM servico"
                        + "WHERE categoria ?";
                }
        
        try (Connection conex = conexao.conectar();
                
              PreparedStatement stmt = conex.prepareStatement(sql)){
            stmt.setString(1,"%" + pesquisa + "%");
            
            try (ResultSet resultado = stmt.executeQuery()){
                while (resultado.next()){
                    modelo.addRow(new Object [] {
                        resultado.getInt("ID"),
                        resultado.getString("descricao"),
                        resultado.getString("categoria"),
                       });
                }
            }
            if (modelo.getRowCount() == 0){
             JOptionPane.showMessageDialog(this,
                           "Nenhum servico encontrado para: " + pesquisa,
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
    }//GEN-LAST:event_btnAlterar2ActionPerformed

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
            java.util.logging.Logger.getLogger(frmConsultaServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmConsultaServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmConsultaServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmConsultaServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmConsultaServico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar2;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnExcluir2;
    private javax.swing.JButton btnFechar2;
    private javax.swing.JButton btnLocalizar;
    private javax.swing.JComboBox<String> cmbPesquisaPor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblConsServiço;
    private javax.swing.JTextField txtPesquisando;
    // End of variables declaration//GEN-END:variables
}
