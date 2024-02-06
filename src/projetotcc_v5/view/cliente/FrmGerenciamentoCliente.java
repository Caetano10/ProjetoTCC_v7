/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetotcc_v5.view.cliente;

import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import projetotcc_v5.DAO.ClienteDAO;
import projetotcc_v5.modelo.Cliente;

/**
 *
 * @author lab
 */
public class FrmGerenciamentoCliente extends javax.swing.JFrame {

    /**
     * Creates new form FrmGerenciamentoCliente
     */
    public FrmGerenciamentoCliente() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblcliente = new javax.swing.JTable();
        cbpes = new javax.swing.JComboBox<>();
        txtpes = new javax.swing.JTextField();
        txtpes.requestFocus(true);
        jButton1 = new javax.swing.JButton();
        btnRel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblcliente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tblcliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nome", "CPF", "Telefone", "Celular", "Data de Nascimento", "Data do Cadastro"
            }
        ));
        tblcliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblclienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblcliente);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 720, 95));

        cbpes.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        cbpes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome" }));
        getContentPane().add(cbpes, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 11, 89, -1));

        txtpes.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtpes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpesKeyReleased(evt);
            }
        });
        getContentPane().add(txtpes, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 11, 404, -1));

        jButton1.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 136, -1));

        btnRel.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        btnRel.setText("Gerar Relatório");
        btnRel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelActionPerformed(evt);
            }
        });
        getContentPane().add(btnRel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetotcc_v5/imagens/fundoTCC.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 220));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new FrmCadCliente().setVisible(true);
        //this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtpesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpesKeyReleased
        ClienteDAO cdao = new ClienteDAO();
        Cliente c = new Cliente();
        String campo = null;
        if (cbpes.getSelectedIndex() == 0) {
            campo = "nome";
        } else if (cbpes.getSelectedIndex() == 1) {
            campo = "telefone";

        } else if (cbpes.getSelectedIndex() == 2) {
            campo = "endereco";
        } else if (cbpes.getSelectedIndex() == 3) {
            campo = "email";
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
        List<Cliente> clientes = cdao.listar(campo, txtpes.getText());
        DefaultTableModel model = (DefaultTableModel) tblcliente.getModel();
        model.setNumRows(0);
        for (Cliente cli : clientes) {
            model.addRow(new Object[]{
                cli.getIdCliente(),
                cli.getNome(),
                cli.getCpf(),
                cli.getTelefone(),
                cli.getCelular(),
                cli.getDataNascimento(),
                cli.getDtcadastro()
            });

        }

    }//GEN-LAST:event_txtpesKeyReleased

    private void tblclienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblclienteMouseClicked
        if (evt.getClickCount() == 1) {
            DFrmAltCliente f = new DFrmAltCliente(null, rootPaneCheckingEnabled);
            f.lblid.setText(tblcliente.getValueAt(tblcliente.getSelectedRow(),0).toString());
            f.setVisible(true);
           
        }
    }//GEN-LAST:event_tblclienteMouseClicked

    private void btnRelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelActionPerformed
        ClienteDAO c = new ClienteDAO();
        try{
        String rel = JOptionPane.showInputDialog(null, "Digite o CPF do Cliente");
        c.gerarRelCli(rel);
        } catch(Exception e){
            throw new RuntimeException(e);
        }
        
    }//GEN-LAST:event_btnRelActionPerformed

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
            java.util.logging.Logger.getLogger(FrmGerenciamentoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGerenciamentoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGerenciamentoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGerenciamentoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmGerenciamentoCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRel;
    private javax.swing.JComboBox<String> cbpes;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblcliente;
    private javax.swing.JTextField txtpes;
    // End of variables declaration//GEN-END:variables
}
