/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import dao.ExemplaresDAO;
import dao.ObrasDAO;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Obra;

/**
 *
 * @author gabrielstahlberg
 */
public class TelaRelatorio extends javax.swing.JInternalFrame {
    private DefaultTableModel modelDepart;
    private int inicio;
    private int fim;
    
    private static final int MAX = 10;
    /**
     * Creates new form TelaRelatorio
     */
    public TelaRelatorio() {
        initComponents();
        this.inicio = 1;
        this.fim = MAX;
        this.modelDepart = (DefaultTableModel) tableAcervo.getModel();
        this.buttonProximo.setEnabled(false);
        this.buttonAnterior.setEnabled(false);
        this.buttonJSON.setEnabled(false);
        this.buttonPDF.setEnabled(false);
        this.buttonXML.setEnabled(false);
    }

    private void populaTabela(List<Obra> lista){        
        ExemplaresDAO exemplaresDAO = new ExemplaresDAO();
        modelDepart.setRowCount(0);
        
        for(int i=0; i<lista.size(); i++){
            StringBuffer sbAutores = new StringBuffer();
            StringBuffer sbPalavras = new StringBuffer();
            String titulo = lista.get(i).getTitulo();
            List<String> autores = lista.get(i).getAutores();
            for(int a=0; a<autores.size(); a++){
                sbAutores.append(autores.get(a));
                sbAutores.append(",");
            }
            List<String> palavras = lista.get(i).getPalavrasChaves();
            for(int p=0; p<palavras.size(); p++){
                sbPalavras.append(palavras.get(p));
                sbPalavras.append(",");
            }
            String isbn = lista.get(i).getIsbn();
            LocalDate dataPubl = lista.get(i).getDataPubl();
            String editora = lista.get(i).getEditora();
            String categoria = lista.get(i).getCategoria();
            int nroEdicao = lista.get(i).getNroEdicao();
            int totalExemplares = exemplaresDAO.totalExemplares(isbn);
            int totalDisponivel = exemplaresDAO.totalDisponiveis(isbn);
            
            Object[] line = new Object[]{titulo, sbAutores.toString(), sbPalavras.toString(), isbn, dataPubl, editora, categoria, nroEdicao, totalExemplares, totalDisponivel};
            modelDepart.addRow(line);
        }
    }
    
    private void gerarPDF(){
        List<Obra> listaCompleta;
        ObrasDAO obrasDAO = new ObrasDAO();
        listaCompleta = obrasDAO.realizarRelatorioCompleto();
        
        Document document = new Document();
            
        try {
            PdfWriter.getInstance(document, new FileOutputStream("acervo.pdf"));
                
            document.open();
                
            document.addCreationDate();
            document.addTitle("Relatório completo do acervo");
            document.add(new Paragraph("\t\tRELATÓRIO COMPLETO DO ACERVO\n\n"));
                
            for(int i=0; i<listaCompleta.size(); i++){
                document.add(new Paragraph(listaCompleta.get(i).formataSaida()));
            }
                
        } catch (FileNotFoundException | DocumentException erro) {
            erro.printStackTrace();
        }finally{
            document.close();
        }
            
        try {
            Desktop.getDesktop().open(new File("acervo.pdf"));
        } catch (IOException erro) {
            erro.printStackTrace();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tableAcervo = new javax.swing.JTable();
        buttonAnterior = new javax.swing.JButton();
        buttonProximo = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        buttonAcervo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        buttonXML = new javax.swing.JButton();
        buttonPDF = new javax.swing.JButton();
        buttonJSON = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        tableAcervo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título", "Autor", "Palavra Chave", "ISBN", "Data Publ.", "Editora", "Categoria", "Nº Edição", "Total Exemplares", "Total Disp."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableAcervo.setAutoscrolls(false);
        tableAcervo.setColumnSelectionAllowed(true);
        tableAcervo.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableAcervo);
        tableAcervo.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        buttonAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/previous.png"))); // NOI18N
        buttonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAnteriorActionPerformed(evt);
            }
        });

        buttonProximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/next.png"))); // NOI18N
        buttonProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProximoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Noto Sans", 2, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(52, 19, 158));
        jLabel7.setText("RELATÓRIO DO ACERVO");

        buttonAcervo.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        buttonAcervo.setForeground(new java.awt.Color(63, 187, 71));
        buttonAcervo.setText("GERAR RELATÓRIO");
        buttonAcervo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAcervoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLabel1.setText("Exportar como:");

        buttonXML.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/xml.png"))); // NOI18N
        buttonXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonXMLActionPerformed(evt);
            }
        });

        buttonPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/pdf.png"))); // NOI18N
        buttonPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPDFActionPerformed(evt);
            }
        });

        buttonJSON.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/json.png"))); // NOI18N
        buttonJSON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonJSONActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(buttonAnterior)
                                .addGap(149, 149, 149)
                                .addComponent(buttonAcervo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonProximo))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(buttonXML)
                .addGap(28, 28, 28)
                .addComponent(buttonJSON)
                .addGap(27, 27, 27)
                .addComponent(buttonPDF)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonProximo)
                    .addComponent(buttonAnterior)
                    .addComponent(buttonAcervo))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonPDF)
                    .addComponent(buttonXML)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1))
                    .addComponent(buttonJSON))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        setBounds(0, 0, 608, 493);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonXMLActionPerformed
        OpcoesXML opcoesXML = new OpcoesXML(false);
        opcoesXML.setVisible(true);
    }//GEN-LAST:event_buttonXMLActionPerformed

    private void buttonJSONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonJSONActionPerformed
        OpcoesJSON opcoesJSON = new OpcoesJSON(false);
        opcoesJSON.setVisible(true);
    }//GEN-LAST:event_buttonJSONActionPerformed

    private void buttonPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPDFActionPerformed
        gerarPDF();
    }//GEN-LAST:event_buttonPDFActionPerformed

    private void buttonAcervoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAcervoActionPerformed
        this.inicio = 1;
        this.fim = MAX;
        this.buttonAcervo.setEnabled(false);
        this.buttonProximo.setEnabled(true);
        this.buttonAnterior.setEnabled(true);
        fazerRelatorio();
        this.buttonJSON.setEnabled(true);
        this.buttonPDF.setEnabled(true);
        this.buttonXML.setEnabled(true);
    }//GEN-LAST:event_buttonAcervoActionPerformed

    private void buttonProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProximoActionPerformed
        inicio += MAX;
        fim += MAX;
        if(!fazerRelatorio()){
            inicio -= MAX;
            fim -= MAX;
            buttonProximo.setEnabled(false);
        }
        if(!buttonAnterior.isEnabled()){
            buttonAnterior.setEnabled(true);
        }
    }//GEN-LAST:event_buttonProximoActionPerformed

    private void buttonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAnteriorActionPerformed
        inicio -= MAX;
        fim -= MAX;
        if(!fazerRelatorio()){
            inicio += MAX;
            fim += MAX;
            buttonAnterior.setEnabled(false);
        }
        if(!buttonProximo.isEnabled()){
            buttonProximo.setEnabled(true);
        }
    }//GEN-LAST:event_buttonAnteriorActionPerformed

    private boolean fazerRelatorio(){
        ObrasDAO oDAO = new ObrasDAO();
        List<Obra> obras = oDAO.realizarRelatorio(inicio, fim);
        if(obras.isEmpty()){
            //JOptionPane.showMessageDialog(null, "A pagina em que você quer navegar não foi encontrada", "Pagina não existe", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            populaTabela(obras);
            this.buttonAcervo.setEnabled(false);
            return true;
        }
    }
    
    private String arrumarLists(List<String> lista){
        StringBuilder build = new StringBuilder();
        lista.forEach(s -> build.append(String.format("%s,",s)));
        return build.toString();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAcervo;
    private javax.swing.JButton buttonAnterior;
    private javax.swing.JButton buttonJSON;
    private javax.swing.JButton buttonPDF;
    private javax.swing.JButton buttonProximo;
    private javax.swing.JButton buttonXML;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableAcervo;
    // End of variables declaration//GEN-END:variables
}
