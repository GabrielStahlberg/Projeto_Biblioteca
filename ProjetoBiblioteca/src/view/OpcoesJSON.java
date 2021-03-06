/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.File;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import view.radiobuttons.RadioAbstrato;

/**
 *
 * @author gabrielstahlberg
 */
public class OpcoesJSON extends javax.swing.JFrame {

    /**
     * Creates new form OpcoesXML
     */
    public OpcoesJSON(boolean isImportacao) {
        initComponents();
        this.group.add(this.opcaoGson);
        this.group.add(this.opcaoJackson);
        this.isImportacao = isImportacao;
        configuraJanela();
    }
    
    public OpcoesJSON() {
    }

    private void configuraJanela(){
        if(!this.isImportacao){
            this.buttonApiJSON.setText("SALVAR");
            this.buttonProcurarArquivo.setText("SALVAR EM:");
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        opcaoJackson = new view.radiobuttons.RadioJackson("API JACKSON");
        opcaoGson = new view.radiobuttons.RadioGSON("API GSON");
        jLabel1 = new javax.swing.JLabel();
        buttonApiJSON = new javax.swing.JButton();
        buttonApiVoltar = new javax.swing.JButton();
        buttonProcurarArquivo = new javax.swing.JButton();
        fieldCaminhoArquivo = new javax.swing.JTextField();
        barraProgresso = new javax.swing.JProgressBar();
        labelQuantidade = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        opcaoJackson.setSelected(true);
        opcaoJackson.setText("API JACKSON");

        opcaoGson.setText("API GSON");

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(52, 19, 158));
        jLabel1.setText("OPÇÕES DE API");

        buttonApiJSON.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        buttonApiJSON.setForeground(new java.awt.Color(63, 187, 71));
        buttonApiJSON.setText("ESCOLHER");
        buttonApiJSON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonApiJSONActionPerformed(evt);
            }
        });

        buttonApiVoltar.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        buttonApiVoltar.setForeground(new java.awt.Color(220, 52, 43));
        buttonApiVoltar.setText("VOLTAR");
        buttonApiVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonApiVoltarActionPerformed(evt);
            }
        });

        buttonProcurarArquivo.setText("PROCURAR");
        buttonProcurarArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProcurarArquivoActionPerformed(evt);
            }
        });

        fieldCaminhoArquivo.setEditable(false);

        labelQuantidade.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(opcaoGson)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(opcaoJackson)
                .addGap(53, 53, 53))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(buttonProcurarArquivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldCaminhoArquivo)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(barraProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelQuantidade))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(buttonApiVoltar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(buttonApiJSON)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(opcaoGson)
                    .addComponent(opcaoJackson))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonProcurarArquivo)
                    .addComponent(fieldCaminhoArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonApiVoltar)
                    .addComponent(buttonApiJSON))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(barraProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelQuantidade))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(360, 320));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonApiVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonApiVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonApiVoltarActionPerformed

    private void buttonProcurarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProcurarArquivoActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Procurar arquivo");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON", "json");

        fileChooser.setFileFilter(filter);
        int retorno = fileChooser.showOpenDialog(this);

        if(retorno == JFileChooser.APPROVE_OPTION){
            fileEscolhida = fileChooser.getSelectedFile();
            this.fieldCaminhoArquivo.setText(fileEscolhida.getPath());
        }
    }//GEN-LAST:event_buttonProcurarArquivoActionPerformed

    private void buttonApiJSONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonApiJSONActionPerformed
        if(fileEscolhida == null){
           JOptionPane.showMessageDialog(null, "Escolha um arquivo !", null, 1);
        }
        else{
            RadioAbstrato rA = null;
            if(opcaoGson.isSelected()){
                rA = (RadioAbstrato)opcaoGson;
            }
            else if(opcaoJackson.isSelected()){
                rA = (RadioAbstrato)opcaoJackson;
            }
            if(this.isImportacao){
                ImportacaoBackground importacao = new ImportacaoBackground(rA,fileEscolhida, this.labelQuantidade);
                importacao.addPropertyChangeListener(e -> {
                    if(e.getPropertyName().equals("progress")){
                        this.barraProgresso.setValue((Integer)e.getNewValue());
                    }
                });
                importacao.execute();
            }else{
                ExportacaoBackground exportacao = new ExportacaoBackground(rA,fileEscolhida, this.labelQuantidade);
                exportacao.addPropertyChangeListener(e -> {
                    if(e.getPropertyName().equals("progress")){
                        this.barraProgresso.setValue((Integer)e.getNewValue());
                    }
                });
                exportacao.execute();
            }
        }
    }//GEN-LAST:event_buttonApiJSONActionPerformed

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
            java.util.logging.Logger.getLogger(OpcoesJSON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OpcoesJSON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OpcoesJSON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OpcoesJSON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OpcoesJSON().setVisible(true);
            }
        });
    }
    
    private boolean isImportacao;
    private ButtonGroup group = new ButtonGroup();
    private File fileEscolhida;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraProgresso;
    private javax.swing.JButton buttonApiJSON;
    private javax.swing.JButton buttonApiVoltar;
    private javax.swing.JButton buttonProcurarArquivo;
    private javax.swing.JTextField fieldCaminhoArquivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelQuantidade;
    private javax.swing.JRadioButton opcaoGson;
    private javax.swing.JRadioButton opcaoJackson;
    // End of variables declaration//GEN-END:variables
}
