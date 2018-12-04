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
import model.ObraLista;
import view.radiobuttons.RadioAbstrato;

/**
 *
 * @author gabrielstahlberg
 */
public class OpcoesXML extends javax.swing.JFrame {
    private boolean isImportacao;
    /**
     * Creates new form OpcoesXML
     */
    public OpcoesXML(boolean isImportacao) {
        initComponents();
        fileEscolhida = null;
        this.group.add(this.opcaoDom);
        this.group.add(this.opcaoSax);
        this.group.add(this.opcaoJaxb);
        this.isImportacao = isImportacao;
        configuraJanela();
    }

    public OpcoesXML() {
    }
    
    
    private void configuraJanela(){
        if(!this.isImportacao){
            this.buttonApiXML.setText("SALVAR");
            this.buttonProcurarArquivo.setText("SALVAR EM:");
            this.opcaoSax.setEnabled(false);
            
            // Verificar possibilidade de escolher onde salvar
            this.buttonProcurarArquivo.setEnabled(false);
            this.fieldCaminhoArquivo.setEnabled(false);
            this.barraProgresso.setVisible(false);
            this.labelQuantidade.setVisible(false);
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

        opcaoSax = new view.radiobuttons.RadioSax("API SAX");
        opcaoDom = new view.radiobuttons.RadioDOM("API DOM");
        opcaoJaxb = new view.radiobuttons.RadioJAXB("API JAXB",ObraLista.class);
        jLabel1 = new javax.swing.JLabel();
        buttonApiXML = new javax.swing.JButton();
        buttonApiVoltar = new javax.swing.JButton();
        buttonProcurarArquivo = new javax.swing.JButton();
        fieldCaminhoArquivo = new javax.swing.JTextField();
        barraProgresso = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        labelQuantidade = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        opcaoSax.setSelected(true);
        opcaoSax.setText("API SAX");

        opcaoDom.setText("API DOM");

        opcaoJaxb.setText("API JAXB");

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(52, 19, 158));
        jLabel1.setText("OPÇÕES DE API");

        buttonApiXML.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        buttonApiXML.setForeground(new java.awt.Color(63, 187, 71));
        buttonApiXML.setText("CONFIRMAR");
        buttonApiXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonApiXMLActionPerformed(evt);
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
                .addContainerGap()
                .addComponent(buttonProcurarArquivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fieldCaminhoArquivo)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(opcaoSax)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(opcaoDom)
                .addGap(27, 27, 27)
                .addComponent(opcaoJaxb)
                .addGap(39, 39, 39))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(188, 188, 188)
                            .addComponent(jLabel2)
                            .addContainerGap())
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(buttonApiVoltar)
                                .addGap(38, 38, 38)
                                .addComponent(buttonApiXML)
                                .addGap(69, 69, 69))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(107, 107, 107))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(barraProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelQuantidade)
                        .addGap(75, 75, 75))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(opcaoSax)
                            .addComponent(opcaoDom)
                            .addComponent(opcaoJaxb))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonProcurarArquivo)
                            .addComponent(fieldCaminhoArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonApiVoltar)
                            .addComponent(buttonApiXML))
                        .addGap(18, 18, 18)
                        .addComponent(barraProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelQuantidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(21, 21, 21))
        );

        setSize(new java.awt.Dimension(360, 316));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonApiVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonApiVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonApiVoltarActionPerformed

    private void buttonApiXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonApiXMLActionPerformed
        if(fileEscolhida == null){
           JOptionPane.showMessageDialog(null, "Escolha um arquivo !", null, 1);
        }
        else{
            RadioAbstrato rA = null;
            if(opcaoSax.isSelected()){
                rA = (RadioAbstrato)opcaoSax;
            }
            else if(opcaoDom.isSelected()){
                rA = (RadioAbstrato)opcaoDom;
            }
            else if(opcaoJaxb.isSelected()){
                rA = (RadioAbstrato)opcaoJaxb;
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
                
            }
        }
    }//GEN-LAST:event_buttonApiXMLActionPerformed

    private void buttonProcurarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProcurarArquivoActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Procurar arquivo");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("XML", "xml");
        
        fileChooser.setFileFilter(filter);
        int retorno = fileChooser.showOpenDialog(this);
        
        if(retorno == JFileChooser.APPROVE_OPTION){
            fileEscolhida = fileChooser.getSelectedFile();
            this.fieldCaminhoArquivo.setText(fileEscolhida.getPath());
        }
    }//GEN-LAST:event_buttonProcurarArquivoActionPerformed

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
            java.util.logging.Logger.getLogger(OpcoesXML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OpcoesXML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OpcoesXML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OpcoesXML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OpcoesXML().setVisible(true);
            }
        });
    }
    
    private ButtonGroup group = new ButtonGroup();
    private File fileEscolhida;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraProgresso;
    private javax.swing.JButton buttonApiVoltar;
    private javax.swing.JButton buttonApiXML;
    private javax.swing.JButton buttonProcurarArquivo;
    private javax.swing.JTextField fieldCaminhoArquivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelQuantidade;
    private javax.swing.JRadioButton opcaoDom;
    private javax.swing.JRadioButton opcaoJaxb;
    private javax.swing.JRadioButton opcaoSax;
    // End of variables declaration//GEN-END:variables
}
