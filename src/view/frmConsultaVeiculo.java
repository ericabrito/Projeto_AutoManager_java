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
public class frmConsultaVeiculo extends javax.swing.JFrame {

     private void atualizarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tblConsVeiculo.getModel();
        
        modelo.setRowCount(0);
        
        String sql = "SELECT * FROM veiculo "
                     + "ORDER BY id";
        
        try (Connection conex = conexao.conectar();
             PreparedStatement stmt = conex.prepareStatement(sql);
             ResultSet resultado = stmt.executeQuery() ){
            
            while (resultado.next()){
                modelo.addRow(new Object[] {
                    resultado.getInt("id"),
                    resultado.getInt("cliente_id"),
                    resultado.getString("placa"),
                    resultado.getString("marca"),
                    resultado.getString("modelo"),
                    resultado.getString("ano"),
                    resultado.getString("cor"),
                    resultado.getString("observacao"),
                    resultado.getBoolean("ativo")
                });
            }
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(
                        this,
                        "Erro ao atualizar tabela:\n" + erro.getMessage(),
                        "Erro no banco de dados",
                        JOptionPane.ERROR_MESSAGE);
        }
    
     }
    public frmConsultaVeiculo() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("AutoManager - Consulta de Veiculo");
        tblConsVeiculo.setModel(new DefaultTableModel(new Object[][]{},
                            new String[] {"ID","Cliente ID","Placa","Marca","Modelo","Ano","Cor","Observação","Ativo"}){
                    @Override
                    public boolean isCellEditable(int linha, int coluna){
                        return false;
                    }
                    });                   
                
        tblConsVeiculo.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        
        atualizarTabela();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsVeiculo = new javax.swing.JTable();
        cmbPesquisarPor = new javax.swing.JComboBox<>();
        txtPesquisando = new javax.swing.JTextField();
        btnLocalizar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir3 = new javax.swing.JButton();
        btnFechar3 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        cmbCliente = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblConsVeiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Cliente", "Placa", "Marca", "Modelo", "Ano", "Cor", "Observação", "Ativo"
            }
        ));
        jScrollPane1.setViewportView(tblConsVeiculo);

        cmbPesquisarPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "ID Cliente", "Marca" }));
        cmbPesquisarPor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisar Por:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        cmbPesquisarPor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPesquisarPorActionPerformed(evt);
            }
        });

        txtPesquisando.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Valor Pesquisado:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        txtPesquisando.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisandoActionPerformed(evt);
            }
        });

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

        btnExcluir3.setBackground(new java.awt.Color(0, 0, 0));
        btnExcluir3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExcluir3.setForeground(new java.awt.Color(255, 153, 0));
        btnExcluir3.setText("Excluir");
        btnExcluir3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluir3ActionPerformed(evt);
            }
        });

        btnFechar3.setBackground(new java.awt.Color(0, 0, 0));
        btnFechar3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFechar3.setForeground(new java.awt.Color(255, 153, 0));
        btnFechar3.setText("Fechar");
        btnFechar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFechar3ActionPerformed(evt);
            }
        });

        jTextField2.setBackground(new java.awt.Color(0, 0, 0));
        jTextField2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 153, 0));
        jTextField2.setText("                           Consulta Veiculos");

        jButton1.setText("Dados do Veículo");

        txtId.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        cmbCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        jTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Placa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        jTextField3.setText("jTextField3");
        jTextField3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Marca:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbPesquisarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtPesquisando, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(62, 62, 62)
                                        .addComponent(btnLocalizar)
                                        .addGap(61, 61, 61)
                                        .addComponent(btnAtualizar))
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(164, 164, 164)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(btnAlterar)
                        .addGap(86, 86, 86)
                        .addComponent(btnExcluir3)
                        .addGap(61, 61, 61)
                        .addComponent(btnFechar3)))
                .addContainerGap(200, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cmbPesquisarPor, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtPesquisando, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAlterar)
                            .addComponent(btnExcluir3))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnFechar3)
                        .addGap(21, 21, 21))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFechar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFechar3ActionPerformed
         dispose();
    }//GEN-LAST:event_btnFechar3ActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        atualizarTabela();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarActionPerformed
        String pesquisa = txtPesquisando.getText().trim();
        String tipo_pesquisa = cmbPesquisarPor.getSelectedItem().toString().trim();

        ///////////////////////////////////////////Conferindo as informaçoes///////////////////////////////////////////
        if (pesquisa.isEmpty()){
            JOptionPane.showMessageDialog(
                this,
                "Digite o id, marca  ou placa.",
                "Pesquisa Vazia",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        DefaultTableModel modelo = (DefaultTableModel) tblConsVeiculo.getModel();

        modelo.setRowCount(0);

        String sql ="";

        ///////////////////////////////////Verificando Pesquisa/////////////////////////////////////////////////////

        if (tipo_pesquisa == "ID") {
            sql = "SELECT * FROM veiculo "
            + "WHERE id = ?";

        }else if (tipo_pesquisa == "ID Cliente") {

            sql = "SELECT * FROM veiculo "
            + "WHERE cliente_id = ?";

        }else if (tipo_pesquisa == "Placa"){

            sql = "SELECT * FROM veiculo "
            + "WHERE placa ILIKE ? ";

        }else if (tipo_pesquisa == "Marca"){
            sql = "SELECT * FROM veiculo "
            + "WHERE marca ILIKE ?";
        }

        /////////////////////////////////// TRY INSERT //////////////////////////////////////////////////////
        try (Connection conex = conexao.conectar();
            PreparedStatement stmt = conex.prepareStatement(sql)) {

            if (tipo_pesquisa.equals("ID")) {
                stmt.setInt(1, Integer.parseInt(pesquisa));

            }else if (tipo_pesquisa.equals("ID Cliente")){

                stmt.setInt(1, Integer.parseInt(pesquisa));

            } else {
                stmt.setString(1, "%" + pesquisa + "%");
            }

            try (ResultSet resultado = stmt.executeQuery()){
                while (resultado.next()){
                    modelo.addRow(new Object [] {
                        resultado.getInt("id"),
                        resultado.getInt("cliente_id"),
                        resultado.getString("placa"),
                        resultado.getString("marca"),
                        resultado.getString("modelo"),
                        resultado.getString("ano"),
                        resultado.getString("cor"),
                        resultado.getString("observacao"),
                        resultado.getBoolean("ativo")});
            }
        }
        if (modelo.getRowCount() == 0){
            JOptionPane.showMessageDialog(this,
                "Nenhum Veiculo encontrado para: " + pesquisa,
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

    private void cmbPesquisarPorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPesquisarPorActionPerformed
         txtPesquisando.setText("");
         txtPesquisando.requestFocus();
    }//GEN-LAST:event_cmbPesquisarPorActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
       String pesquisa = txtPesquisando.getText().trim(); 
       String tipoPesquisa = cmbPesquisarPor.getSelectedItem().toString();

if (pesquisa.isEmpty()) {
    JOptionPane.showMessageDialog(
            this,
            "Digite o id, placa, marca, modelo ou cliente.",
            "Pesquisa Vazia",
            JOptionPane.WARNING_MESSAGE);
    return;
}

    DefaultTableModel modelo = (DefaultTableModel) tblConsVeiculo.getModel();
     
    modelo.setRowCount(0);

       String sql = "";
        Integer id = null;
        
        if (tipo_pesquisa.equals("Id")) {
        try {
            id = Integer.parseInt(pesquisa);
            
            sql = "SELECT * FROM veiculo WHERE id = ? ORDER BY id";
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID deve ser numérico.");
            return;
        }
        
        if (tipo_pesquisa == ("Nome")) {
        
             sql = "SELECT * FROM veiculo "
                   + "WHERE nome ILIKE ? "
                   + "ORDER BY nome";
                }
        
        else if (tipo_pesquisa == "CPF"){
        
             sql = "SELECT * FROM veiculo "
                   + "WHERE cpf   ILIKE ?";
        }
        else if (tipo_pesquisa == "ID"){
                sql = "SELECT * FROM veiculo"
                        + "WHERE telefone ?";
                }

 try (Connection conex = conexao.conectar();
                
              PreparedStatement stmt = conex.prepareStatement(sql)){
            stmt.setString(1,"%" + pesquisa + "%");
            
            try (ResultSet resultado = stmt.executeQuery()){
                while (resultado.next()){
                    modelo.addRow(new Object [] {
                        resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getString("cpf"),
                        resultado.getString("telefone") });
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
        } 

    if (modelo.getRowCount() == 0) {
        JOptionPane.showMessageDialog(this,
                "Nenhum veículo encontrado para: " + pesquisa,
                "Resultado da Pesquisa",
                JOptionPane.INFORMATION_MESSAGE);
    }


    }//GEN-LAST:event_btnAlterarActionPerformed
    
    private void btnExcluir3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluir3ActionPerformed
         int linha = tblConsVeiculo.getSelectedRow();
        if (linha == -1){
        JOptionPane.showMessageDialog(this,"Selecione um veiculo para excluir!");
        return;
}
        int id = Integer.parseInt(tblConsVeiculo.getValueAt(linha, 0).toString());

        int resposta = JOptionPane.showConfirmDialog(this,
                                                    "Desejar realmente excluir o veiculo do ID" + id + "?", 
                                                    "Confirmar Excluir", JOptionPane.YES_NO_CANCEL_OPTION,
                                                    JOptionPane.QUESTION_MESSAGE);
        if(resposta != JOptionPane.YES_OPTION) {
           return;
}
        String sql = "Delete from veiculo WHERE id = ?";

        try(Connection conex = conexao.conectar();
                PreparedStatement stmt = conex.prepareStatement(sql)){

                stmt.setInt(1, id);

                int registros = stmt.executeUpdate();
                if (registros > 0){
                JOptionPane.showMessageDialog(this, "Veiculo excluido com sucesso!");
                atualizarTabela();
        } else{
        JOptionPane.showMessageDialog(this, "Veiculo não encontrado!");
        }
      }catch (SQLException erro){
        JOptionPane.showMessageDialog(this, "Erro ao excluir veiculo: " + erro.getMessage());

    }//GEN-LAST:event_btnExcluir3ActionPerformed
}
    private void txtPesquisandoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisandoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisandoActionPerformed
    
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
            java.util.logging.Logger.getLogger(frmConsultaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmConsultaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmConsultaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmConsultaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmConsultaVeiculo().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnExcluir3;
    private javax.swing.JButton btnFechar3;
    private javax.swing.JButton btnLocalizar;
    private javax.swing.JComboBox<String> cmbCliente;
    private javax.swing.JComboBox<String> cmbPesquisarPor;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable tblConsVeiculo;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtPesquisando;
    // End of variables declaration//GEN-END:variables

   
}
