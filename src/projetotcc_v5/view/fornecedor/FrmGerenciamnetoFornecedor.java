/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetotcc_v5.view.fornecedor;

import projetotcc_v5.view.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import projetotcc_v5.DAO.FornecedorDAO;
import projetotcc_v5.modelo.Fornecedor;
import sun.security.krb5.internal.rcache.DflCache;

/**
 *
 * @author lab
 */
public class FrmGerenciamnetoFornecedor extends javax.swing.JFrame {

    /**
     * Creates new form FrmGerenciamnetoFornecedor
     */
    public FrmGerenciamnetoFornecedor() {
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
        cbpes = new javax.swing.JComboBox<>();
        txtpes = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblfornecedor = new javax.swing.JTable();
        btncad = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetotcc_v5/imagens/fundoTCC.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbpes.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cbpes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome da Empresa", "CNPJ" }));
        getContentPane().add(cbpes, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 99, -1, -1));

        txtpes.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtpes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpesKeyReleased(evt);
            }
        });
        getContentPane().add(txtpes, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 99, 471, -1));

        tblfornecedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        tblfornecedor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tblfornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nome da Empresa", "CNPJ", "Telefone", "Data Cadastro"
            }
        ));
        tblfornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblfornecedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblfornecedor);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 128, 635, 95));

        btncad.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btncad.setText("Cadastrar");
        btncad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncadActionPerformed(evt);
            }
        });
        getContentPane().add(btncad, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 282, 136, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel2.setText("Gerenciamento Fornecedor");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 11, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetotcc_v5/imagens/fundoTCC.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 340));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtpesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpesKeyReleased
        FornecedorDAO fdao = new FornecedorDAO();
        Fornecedor f = new Fornecedor();
        String campo = null;
        if (cbpes.getSelectedIndex() == 0) {
            campo = "nomeFantasia";
        } else if (cbpes.getSelectedIndex() == 1) {
            campo = "cnpj";

        } else if (cbpes.getSelectedIndex() == 2) {
            campo = "telefone";
        } else if (cbpes.getSelectedIndex() == 3) {
            campo = "datacadastro";
        }
        //        cdao.pesquisar(campo, txtpes.getText(), c);
        //        txtcod.setText("" + c.getCod_Cliente());
        //        txtnome.setText(c.getNome());
        //        txttel.setText(c.getTelefone());
        //        txtend.setText(c.getEndereco());
        //        txtemail.setText(c.getEmail());
        //        txtidade.setText("" + c.getIdade());
        //        txtsal.setText("" + c.getSalario());

        //listar a pesquisa
        List<Fornecedor> fornecedores = fdao.listar(campo, txtpes.getText());
        DefaultTableModel model = (DefaultTableModel) tblfornecedor.getModel();
        model.setNumRows(0);
        for (Fornecedor forn : fornecedores) {
            model.addRow(new Object[]{
                forn.getIdFornecedor(),
                forn.getNomeFantasia(),
                forn.getCnpj(),
                forn.getTelefone(),
                forn.getDataCadastro()
            });

        }
    }//GEN-LAST:event_txtpesKeyReleased

    private void tblfornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblfornecedorMouseClicked
        if (evt.getClickCount() == 1) {
            DFrmAltFornecedor f = new DFrmAltFornecedor(null, rootPaneCheckingEnabled);

            f.lblcod.setText(tblfornecedor.getValueAt(tblfornecedor.getSelectedRow(), 0).toString());
            f.setVisible(true);

        }
    }//GEN-LAST:event_tblfornecedorMouseClicked

    private void btncadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncadActionPerformed
        new FrmCadFornecedor().setVisible(true);
        //this.dispose();
    }//GEN-LAST:event_btncadActionPerformed

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
            java.util.logging.Logger.getLogger(FrmGerenciamnetoFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGerenciamnetoFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGerenciamnetoFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGerenciamnetoFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmGerenciamnetoFornecedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncad;
    private javax.swing.JComboBox<String> cbpes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblfornecedor;
    private javax.swing.JTextField txtpes;
    // End of variables declaration//GEN-END:variables
}
