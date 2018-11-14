/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.ObrasDAO;
import java.util.List;

/**
 *
 * @author gabrielstahlberg
 */
public class TelaExemplares extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaExemplares
     */
    public TelaExemplares() {
        initComponents();
        buscaObras();
    }
    
    private void buscaObras(){
        ObrasDAO obrasDAO = new ObrasDAO();
        List<String> listaObras = obrasDAO.buscarObras();
        for(int i=0; i<listaObras.size(); i++){
            this.comboObras.addItem(listaObras.get(i));
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

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboObras = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fieldQtdeExemplares = new javax.swing.JTextField();
        buttonAdicionarExemplares = new javax.swing.JButton();

        jLabel4.setFont(new java.awt.Font("Noto Sans", 2, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(52, 19, 158));
        jLabel4.setText("CADASTRO");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel5.setFont(new java.awt.Font("Noto Sans", 2, 45)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(52, 19, 158));
        jLabel5.setText("CADASTRO DE EXEMPLARES");

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLabel1.setText("Selecione a Obra:");

        jLabel2.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLabel2.setText("Informe a quantidade de exemplares que deseja adicionar:");

        buttonAdicionarExemplares.setBackground(new java.awt.Color(254, 254, 254));
        buttonAdicionarExemplares.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        buttonAdicionarExemplares.setForeground(new java.awt.Color(63, 187, 71));
        buttonAdicionarExemplares.setText("ADICIONAR");
        buttonAdicionarExemplares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAdicionarExemplaresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboObras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(fieldQtdeExemplares, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(buttonAdicionarExemplares)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel5)
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboObras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(74, 74, 74)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAdicionarExemplares)
                    .addComponent(fieldQtdeExemplares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        setBounds(0, 0, 608, 493);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAdicionarExemplaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAdicionarExemplaresActionPerformed

    }//GEN-LAST:event_buttonAdicionarExemplaresActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdicionarExemplares;
    private javax.swing.JComboBox<String> comboObras;
    private javax.swing.JTextField fieldQtdeExemplares;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
