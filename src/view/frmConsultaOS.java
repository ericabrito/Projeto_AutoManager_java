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
public class frmConsultaOS extends javax.swing.JFrame {

   private void atualizarTabela() {
        DefaultTableModel modelo = (DefaultTableModel)tblConsultaOs.getModel();/*Metodo para atualizar tabela*/
        
        modelo.setRowCount(0);/*metodo para zera linhas na tabela*/
        
        String sql = "SELECT * FROM ordem_servico "/* Variaveis sql*/
                + "ORDER BY id";
        
        try(Connection conex = conexao.conectar();
           PreparedStatement stmt = conex.prepareStatement(sql);   
           ResultSet resultado = stmt.executeQuery() ){
            
           while(resultado.next()){
               modelo.addRow(new Object[] {
                resultado.getInt("id"),
                resultado.getString("veiculo_id"),
                resultado.getString("mecanico_id"),
                resultado.getString("servico-id"),
                resultado.getString("data_abertura"),
                resultado.getString("data_conclusao"),
                 resultado.getString("descricao_problema"),
               
               
               });
           } 
        }catch (SQLException erro){
            JOptionPane.showMessageDialog(this, "Erro ao atualizar tabela:\n" + erro.getMessage(),
                    "Erro no banco de dados",
                   JOptionPane.ERROR_MESSAGE);
        }
        }
    public frmConsultaOS() {
        initComponents();
        
         setLocationRelativeTo(null);
        setTitle("AutoManager -  Consulta de ordem_servico");
        tblConsultaOs.setModel(new DefaultTableModel(new Object[][]{},
                            new String[] {"id","veiculo_id","mecanico_id","servico_id","data_abertura","data_conclusao","descricao_problema"}){
                    @Override
                    public boolean isCellEditable(int linha, int coluna){
                        return false;
                    }
                    });                   
                
        tblConsultaOs.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        
        atualizarTabela();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsultaOs = new javax.swing.JTable();
        cmbPesquisarPor = new javax.swing.JComboBox<>();
        txtPesquisando = new javax.swing.JTextField();
        btnLocalizar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblConsultaOs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nº Ordem Serv.", "Placa", "Cliente", "Mecânico", "Serviço", "Dt Abertura", "Status", "Vl Cobrado", "Dt Conclusão"
            }
        ));
        jScrollPane1.setViewportView(tblConsultaOs);

        cmbPesquisarPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nºda OS", "Placa", "Cliente", "Mecânico", "Status", "P Abertura" }));
        cmbPesquisarPor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisar Por:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        txtPesquisando.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Valor Pesquisando:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N

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

        btnAlterar.setBackground(new java.awt.Color(0, 0, 0));
        btnAlterar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAlterar.setForeground(new java.awt.Color(255, 153, 0));
        btnAlterar.setText("Alterar");

        btnExcluir.setBackground(new java.awt.Color(0, 0, 0));
        btnExcluir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 153, 0));
        btnExcluir.setText("Excluir");

        btnFechar.setBackground(new java.awt.Color(0, 0, 0));
        btnFechar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFechar.setForeground(new java.awt.Color(255, 153, 0));
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 153, 0));
        jTextField1.setText(" Consulta de ordens de serviço");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(btnAlterar)
                .addGap(76, 76, 76)
                .addComponent(btnExcluir)
                .addGap(68, 68, 68)
                .addComponent(btnFechar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbPesquisarPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPesquisando, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLocalizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAtualizar)
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbPesquisarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPesquisando, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLocalizar)
                            .addComponent(btnAtualizar))
                        .addGap(68, 68, 68)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir)
                    .addComponent(btnFechar))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarActionPerformed
       String pesquisa = txtPesquisando.getText().trim();
        String tipo_pesquisa = cmbPesquisarPor.getSelectedItem().toString();
        
        
        ///////////////////////////////////////////Conferindo as informaçoes///////////////////////////////////////////
         if (pesquisa.isEmpty()){
            JOptionPane.showMessageDialog(
                        this,
                        "Digite o Nºda Os, placa, cleinte,mecanica,status,p_abertura",
                        "Pesquisa Vazia",
                        JOptionPane.WARNING_MESSAGE);
            return;
        }
         
         DefaultTableModel modelo = (DefaultTableModel) tblConsultaOs.getModel();
        
        modelo.setRowCount(0);
        
        
        
        String sql ="";
        
        ///////////////////////////////////Verificando Pesquisa/////////////////////////////////////////////////////
        
         if (tipo_pesquisa.equals("ID")) {
            sql = "SELECT * FROM ordem_servico "
                  + "WHERE id = ?";
                  
        
        }
        
        else if (tipo_pesquisa.equals("Nome")) {
        
             sql = "SELECT * FROM ordem_servico "
                   + "WHERE nome ILIKE ? "
                   + "ORDER BY nome";
                }
        
        else if (tipo_pesquisa.equals("CPF")){
        
             sql = "SELECT * FROM cliente "
                   + "WHERE cpf ILIKE ? ";
        }
        
        
            try (Connection conex = conexao.conectar();
            PreparedStatement stmt = conex.prepareStatement(sql)) {

            if (tipo_pesquisa.equals("ID")) {
        stmt.setInt(1, Integer.parseInt(pesquisa));
        
        
            } else {
        stmt.setString(1, "%" + pesquisa + "%");
    }
            
            try (ResultSet resultado = stmt.executeQuery()){
                while (resultado.next()){
                    modelo.addRow(new Object [] {
                        resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getString("cpf"),
                        resultado.getString("telefone"),
                        resultado.getString("email"),
                        resultado.getString("endereco"),
                        resultado.getBoolean("ativo")});
                }
            }
            if (modelo.getRowCount() == 0){
             JOptionPane.showMessageDialog(this,
                           "Nenhum Cliente encontrado para: " + pesquisa,
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
            java.util.logging.Logger.getLogger(frmConsultaOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmConsultaOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmConsultaOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmConsultaOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmConsultaOS().setVisible(true);
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
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblConsultaOs;
    private javax.swing.JTextField txtPesquisando;
    // End of variables declaration//GEN-END:variables
}
