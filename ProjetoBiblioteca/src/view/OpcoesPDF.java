/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.ButtonGroup;

/**
 *
 * @author gabrielstahlberg
 */
public class OpcoesPDF extends javax.swing.JFrame {

    /**
     * Creates new form OpcoesXML
     */
    public OpcoesPDF() {
        initComponents();
        this.group.add(this.opcaoPdfbox);
        this.group.add(this.opcaoItext);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        opcaoItext = new javax.swing.JRadioButton();
        opcaoPdfbox = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        buttonApiJSON = new javax.swing.JButton();
        buttonApiVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        opcaoItext.setSelected(true);
        opcaoItext.setText("API ITEXT");

        opcaoPdfbox.setText("API PDFBOX");

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(52, 19, 158));
        jLabel1.setText("OPÇÕES DE API");

        buttonApiJSON.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        buttonApiJSON.setForeground(new java.awt.Color(63, 187, 71));
        buttonApiJSON.setText("ESCOLHER");

        buttonApiVoltar.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        buttonApiVoltar.setForeground(new java.awt.Color(220, 52, 43));
        buttonApiVoltar.setText("VOLTAR");
        buttonApiVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonApiVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(buttonApiJSON)
                .addGap(35, 35, 35))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(opcaoPdfbox)
                            .addComponent(opcaoItext)
                            .addComponent(buttonApiVoltar))))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(opcaoItext)
                .addGap(39, 39, 39)
                .addComponent(opcaoPdfbox)
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonApiJSON)
                    .addComponent(buttonApiVoltar))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(260, 295));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonApiVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonApiVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonApiVoltarActionPerformed

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
            java.util.logging.Logger.getLogger(OpcoesPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OpcoesPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OpcoesPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OpcoesPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OpcoesPDF().setVisible(true);
            }
        });
    }
    
    private ButtonGroup group = new ButtonGroup();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonApiJSON;
    private javax.swing.JButton buttonApiVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton opcaoItext;
    private javax.swing.JRadioButton opcaoPdfbox;
    // End of variables declaration//GEN-END:variables
}
