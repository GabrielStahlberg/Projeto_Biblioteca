/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.EmprestimoDAO;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Pendencia;

/**
 *
 * @author gabrielstahlberg
 */
public class TelaConsulta extends javax.swing.JInternalFrame {
    private DefaultTableModel modelDepart;
    private int inicio;
    private int fim;

    /**
     * Creates new form TelaConsulta
     */
    public TelaConsulta() {
        initComponents();
        this.inicio = 1;
        this.fim = 10;
        this.modelDepart = (DefaultTableModel) tablePendentes.getModel();
        this.buttonProximo.setEnabled(false);
        this.buttonAnterior.setEnabled(false);
    }
    
    private void fazConsulta(){
        modelDepart.setRowCount(0);
        Date temp = this.fieldData.getDate();
        Instant instant = temp.toInstant();
        ZonedDateTime dt = instant.atZone(ZoneId.systemDefault());
        LocalDate data = dt.toLocalDate();
        EmprestimoDAO dao = new EmprestimoDAO();
        List<Pendencia> lista = dao.consultaPorData(data);
        
        for(int i=0; i<lista.size(); i++){
            StringBuffer sb = new StringBuffer();
            List<Integer> listaId = lista.get(i).getIdExemplares();
            for(int k=0; k<listaId.size(); k++){
                sb.append(listaId.get(k).toString());
                sb.append(", ");
            }
            LocalDate dataEmp = lista.get(i).getDataEmp();
            LocalDate dataPrev = lista.get(i).getDataPrev();
            String titulo = lista.get(i).getTitulo();
            int nroEdicao = lista.get(i).getNroEdicao();
            String nomeLeitor = lista.get(i).getNomeLeitor();
            String catLeitor = lista.get(i).getCatLeitor();
            
            Object[] line = new Object[]{dataEmp, dataPrev, titulo, nroEdicao, sb.toString(), nomeLeitor, catLeitor};
            modelDepart.addRow(line);
        }
    }
    
    // FALTA FAZER A PAGINAÇÃO

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePendentes = new javax.swing.JTable();
        buttonAnterior = new javax.swing.JButton();
        buttonProximo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        buttonConsulta = new javax.swing.JButton();
        fieldData = new com.toedter.calendar.JDateChooser();

        jLabel6.setFont(new java.awt.Font("Noto Sans", 2, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(52, 19, 158));
        jLabel6.setText("DEVOLUÇÃO");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Devoluções Pendentes");

        tablePendentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data Emprestimo", "Data prevista", "Título", "Nº Edição", "Identificação", "Nome Leitor", "Cat. Leitor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePendentes.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tablePendentes);
        tablePendentes.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        buttonAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/previous.png"))); // NOI18N

        buttonProximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/next.png"))); // NOI18N

        jLabel3.setText("Informe a data:");

        jLabel7.setFont(new java.awt.Font("Noto Sans", 2, 40)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(52, 19, 158));
        jLabel7.setText("DEVOLUÇÕES PENDENTES");

        buttonConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/search.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(buttonAnterior)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonProximo))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(buttonConsulta)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel7)
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonConsulta, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fieldData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonProximo)
                    .addComponent(buttonAnterior))
                .addGap(45, 45, 45))
        );

        setBounds(0, 0, 608, 493);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAnterior;
    private javax.swing.JButton buttonConsulta;
    private javax.swing.JButton buttonProximo;
    private com.toedter.calendar.JDateChooser fieldData;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePendentes;
    // End of variables declaration//GEN-END:variables
}
