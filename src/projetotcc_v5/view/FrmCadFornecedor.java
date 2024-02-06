/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetotcc_v5.view;

/**
 *
 * @author lab
 */
public class FrmCadFornecedor extends javax.swing.JFrame {

    /**
     * Creates new form FrmCadFornecedor
     */
    public FrmCadFornecedor() {
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

        btncadastrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtcnpj = new javax.swing.JFormattedTextField();
        txttel = new javax.swing.JTextField();
        lbltel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        try {
            javax.swing.text.MaskFormatter msk = new javax.swing.text.MaskFormatter("???-####");
            txtBairro = new javax.swing.JFormattedTextField(msk);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        txtCidade = new javax.swing.JTextField();
        txtLogradouro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        txtestado = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtcomplemento = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtcep = new javax.swing.JFormattedTextField();
        lblcep = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btncadastrar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btncadastrar.setText("Cadastrar");
        btncadastrar.setBorder(new javax.swing.border.SoftBevelBorder(0));
        btncadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btncadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 376, -1, -1));

        jLabel2.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        jLabel2.setText("CNPJ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        jLabel3.setText("Nome do Fornecedor");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 60, -1, -1));

        txtNome.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 85, 226, -1));

        try {
            txtcnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtcnpj, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 85, 114, -1));
        getContentPane().add(txttel, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 153, 112, -1));

        lbltel.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        lbltel.setText("Telefone");
        getContentPane().add(lbltel, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 123, -1, -1));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setText("Cadastrar Fornecedor");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 11, -1, -1));

        jLabel4.setFont(new java.awt.Font("Felix Titling", 0, 18)); // NOI18N
        jLabel4.setText("Endereço");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 200, -1, -1));

        jLabel6.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        jLabel6.setText("Número");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 292, -1, -1));
        getContentPane().add(txtBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 259, 113, -1));
        getContentPane().add(txtCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 259, 113, -1));
        getContentPane().add(txtLogradouro, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 315, 85, -1));

        jLabel5.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        jLabel5.setText("Bairro");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 229, -1, -1));

        jLabel7.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        jLabel7.setText("Cidade");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 229, -1, -1));

        jLabel10.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        jLabel10.setText("Rua");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 229, -1, -1));
        getContentPane().add(txtRua, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 259, 105, -1));

        txtestado.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        getContentPane().add(txtestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 319, 100, 20));

        jLabel11.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        jLabel11.setText("Estado");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 289, -1, -1));
        getContentPane().add(txtcomplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 319, 120, -1));

        jLabel14.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        jLabel14.setText("Complemento");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 289, -1, -1));

        try {
            txtcep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtcep, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 259, 110, -1));

        lblcep.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        lblcep.setText("CEP");
        getContentPane().add(lblcep, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 239, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetotcc_v5/imagens/fundoTCC.png"))); // NOI18N
        jLabel8.setText("jLabel8");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncadastrarActionPerformed
        
    }//GEN-LAST:event_btncadastrarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCadFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadFornecedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncadastrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblcep;
    private javax.swing.JLabel lbltel;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtLogradouro;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtRua;
    private javax.swing.JFormattedTextField txtcep;
    private javax.swing.JFormattedTextField txtcnpj;
    private javax.swing.JTextField txtcomplemento;
    private javax.swing.JTextField txtestado;
    private javax.swing.JTextField txttel;
    // End of variables declaration//GEN-END:variables
}
