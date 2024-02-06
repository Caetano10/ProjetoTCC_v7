/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetotcc_v5.view.funcionario;

import javax.swing.JOptionPane;
import projetotcc_v5.DAO.FuncionarioDAO;
import projetotcc_v5.modelo.Endereco;
import projetotcc_v5.modelo.Funcionario;

/**
 *
 * @author Maria
 */
public class FrmCadFuncionario extends javax.swing.JFrame {

    /**
     * Creates new form FrmFuncionario
     */
    public FrmCadFuncionario() {
        initComponents();
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
        jButton1 = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        txtCpf = new javax.swing.JTextField();
        txtDtNasc = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        txtUf = new javax.swing.JTextField();
        txtRua = new javax.swing.JTextField();
        txtLogNum = new javax.swing.JTextField();
        txtCep = new javax.swing.JTextField();
        txtComplemento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setText("Cadastro de Funcionario");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 11, -1, -1));

        jButton1.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        jButton1.setText("Cadastrar");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 376, -1, -1));

        txtNome.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 93, 182, -1));

        txtCpf.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfActionPerformed(evt);
            }
        });
        getContentPane().add(txtCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 93, 116, -1));

        txtDtNasc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtDtNasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 131, 116, -1));

        txtTelefone.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneActionPerformed(evt);
            }
        });
        getContentPane().add(txtTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 131, 88, -1));

        txtCidade.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCidadeActionPerformed(evt);
            }
        });
        getContentPane().add(txtCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 217, 188, -1));

        txtBairro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 253, 173, -1));

        txtUf.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtUf, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 217, 111, -1));

        txtRua.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtRua, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 253, 204, -1));

        txtLogNum.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtLogNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 291, 50, -1));

        txtCep.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 291, 244, -1));

        txtComplemento.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 329, 394, -1));

        jLabel2.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        jLabel2.setText("Nome Funcionario");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 93, -1, -1));

        jLabel3.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        jLabel3.setText("CPF");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 93, -1, -1));

        jLabel4.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        jLabel4.setText("Data Nascimento");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 131, -1, -1));

        jLabel5.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        jLabel5.setText("Telefone");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 131, -1, -1));

        jLabel6.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        jLabel6.setText("Unidade Federal");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 219, -1, -1));

        jLabel7.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        jLabel7.setText("Cidade");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 217, -1, -1));

        jLabel8.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        jLabel8.setText("Bairro");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 253, -1, -1));

        jLabel9.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        jLabel9.setText("Rua");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 253, -1, -1));

        jLabel10.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        jLabel10.setText("Numero da Casa");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 291, -1, -1));

        jLabel11.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        jLabel11.setText("CEP");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 291, -1, -1));

        jLabel12.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        jLabel12.setText("Complemento");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 329, -1, -1));

        jLabel13.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        jLabel13.setText("Funcionario");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 49, -1, -1));

        jLabel14.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        jLabel14.setText("Endereço");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 169, -1, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetotcc_v5/imagens/fundoTCC.png"))); // NOI18N
        jLabel15.setText("jLabel15");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, -10, 870, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Funcionario f = new Funcionario();
        Endereco e = new Endereco();
        FuncionarioDAO fdao = new FuncionarioDAO();
        
        f.setNome(txtNome.getText());
        f.setCpf(txtCpf.getText());
        f.setDataNascimento(txtDtNasc.getText());
        f.setTelefone(txtTelefone.getText());
        e.setUnidadeFederal(txtUf.getText());
        e.setCidade(txtCidade.getText());
        e.setBairro(txtBairro.getText());
        e.setRua(txtRua.getText());
        e.setLogradouroNum(Integer.parseInt(txtLogNum.getText()));
        e.setCep(txtCep.getText());
        e.setComplemento(txtComplemento.getText());

        fdao.adiciona(f, e);
        
       // JOptionPane.showMessageDialog(null, "Funcionario cadastrado com sucesso.");
        
        txtNome.setText("");
        txtCpf.setText("");
        txtDtNasc.setText("");
        txtTelefone.setText("");
        txtUf.setText("");
        txtCidade.setText("");
        txtBairro.setText("");
        txtRua.setText("");
        txtLogNum.setText("");
        txtCep.setText("");
        txtComplemento.setText("");
        
        txtNome.requestFocus(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfActionPerformed

    private void txtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneActionPerformed

    private void txtCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCidadeActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCadFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtDtNasc;
    private javax.swing.JTextField txtLogNum;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtRua;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JTextField txtUf;
    // End of variables declaration//GEN-END:variables
}
