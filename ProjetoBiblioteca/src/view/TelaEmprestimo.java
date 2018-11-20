/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bd.ConexaoBD;
import dao.LeitoresDAO;
import dao.AutoresDAO;
import dao.EmprestimoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author gabrielstahlberg
 */
public class TelaEmprestimo extends javax.swing.JInternalFrame {
    private String obraIsbn;
    private int exemplarId;
    private String obraTitulo;
    private List<String> autores;
    private String obraEditora;
    private String obraCategoria;
    private int emprestimoConfirmado;
    /**
     * Creates new form TelaEmprestimo
     */
    public TelaEmprestimo() {
        initComponents();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String data = LocalDate.now().format(formatter);
        this.fieldDataAtual.setText(data);
    }
    
    private void buscarObrasPorTituloFiltrando(){
        // PRECISEI FAZER A QUERY AQUI PARA PODER UTILIZA A API
        String sql = "select o.obra_titulo Título, k.cat_obra_desc Categoria, o.obra_editora Editora, o.obra_isbn ISBN, e.exemplar_id as ID_Exemplar"
                + " from obras o, categoria_obra k, exemplares e"
                + " where upper(o.obra_titulo) like upper(?)"
                + " and o.cat_obra_cod = k.cat_obra_cod"
                + " and o.obra_isbn = e.obra_isbn"
                + " and e.exemplar_status = 'Disponivel'";
        try(                
                Connection con = ConexaoBD.getInstance().getConnection();
                PreparedStatement pStat = con.prepareStatement(sql))
        { 
            pStat.setString(1, this.fieldObraPesquisada.getText() + "%");
            ResultSet rs = pStat.executeQuery();
            
            this.tableObras.setModel(DbUtils.resultSetToTableModel(rs));            
            
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
    
    private void recuperaObraSelecionada(){
        int obraSelecionada = this.tableObras.getSelectedRow();
        
        this.obraTitulo = this.tableObras.getModel().getValueAt(obraSelecionada, 0).toString();
        this.obraCategoria = this.tableObras.getModel().getValueAt(obraSelecionada,1).toString();
        this.obraEditora = this.tableObras.getModel().getValueAt(obraSelecionada, 2).toString();
        this.obraIsbn = this.tableObras.getModel().getValueAt(obraSelecionada, 3).toString();
        this.exemplarId = Integer.parseInt(this.tableObras.getModel().getValueAt(obraSelecionada, 4).toString());
    }
    
    private boolean validaCampos(){
        boolean retorno = true;
        int funcionarioValido;
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
        
        if(this.fieldProntuario.getText().equals("") ||
           this.fieldTipoLeitor.getText().equals("") ||
           this.fieldIdFuncionario.getText().equals(""))
        {
            retorno = false;
        }else if(!this.fieldIdFuncionario.getText().equals("")){
            funcionarioValido = emprestimoDAO.verificaFuncionario(Integer.parseInt(this.fieldIdFuncionario.getText()));
            if(funcionarioValido == 0){
                JOptionPane.showMessageDialog(null, "Funcionário não encontrado.", null, 0);
                retorno = false;
            }
        }
        return retorno;
    }
    
    private void confirmaEmprestimo(){
        if(validaCampos()){
            StringBuffer sb = new StringBuffer();
            AutoresDAO autoresDAO = new AutoresDAO();

            this.autores = autoresDAO.buscar(this.obraIsbn);

            sb.append("Confirmar empréstimo da obra: \n\n  - Título: ");
            sb.append(this.obraTitulo);
            sb.append("\n  - Autor(es): ");
            sb.append(this.autores.toString());
            sb.append("\n  - Categoria: ");
            sb.append(this.obraCategoria);
            sb.append("\n  - ISBN: ");
            sb.append(this.obraIsbn);
            sb.append("\n  - Editora: ");
            sb.append(this.obraEditora);
            sb.append("\n  - ID Exemplar: ");
            sb.append(this.exemplarId);
            sb.append("\n\n  - ID Funcionário: ");
            sb.append(this.fieldIdFuncionario.getText());
            sb.append("\n  - Prontuário: ");
            sb.append(this.fieldProntuario.getText());
            
            this.emprestimoConfirmado = JOptionPane.showConfirmDialog(null, sb.toString(), null, JOptionPane.YES_NO_OPTION);
            
            if(this.emprestimoConfirmado == JOptionPane.YES_OPTION){
                LeitoresDAO lDAO = new LeitoresDAO();
                int idLeitor = lDAO.getID(fieldProntuario.getText());
                int diasPrev = lDAO.getDias(fieldProntuario.getText());
                EmprestimoDAO eDAO = new EmprestimoDAO();
                eDAO.realizarEmprestimo(exemplarId, idLeitor, Integer.parseInt(fieldIdFuncionario.getText()), diasPrev);
            }            
        }else{
            JOptionPane.showMessageDialog(null, "Preencha o(s) campo(s) corretamente", null, 2);
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

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        fieldProntuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fieldTipoLeitor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fieldObraPesquisada = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fieldDataAtual = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableObras = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        buttonConfirmarEmp = new javax.swing.JButton();
        buttonAnterior = new javax.swing.JButton();
        buttonProximo = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        buttonAddPront = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        fieldIdFuncionario = new javax.swing.JTextField();

        jFormattedTextField1.setText("jFormattedTextField1");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Empréstimos");
        setPreferredSize(new java.awt.Dimension(600, 493));

        jLabel1.setText("Informe o prontuário:");

        jLabel2.setText("Tipo leitor:");

        fieldTipoLeitor.setEditable(false);

        jLabel3.setText("Informe o título da obra:");

        fieldObraPesquisada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldObraPesquisadaKeyReleased(evt);
            }
        });

        jLabel4.setText("Data:");

        fieldDataAtual.setEditable(false);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/search.png"))); // NOI18N

        tableObras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título", "Categoria", "Editora", "ISBN", "ID Exemplar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableObras.setAutoscrolls(false);
        tableObras.getTableHeader().setReorderingAllowed(false);
        tableObras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableObrasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableObras);
        tableObras.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jLabel6.setFont(new java.awt.Font("Noto Sans", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(192, 49, 63));
        jLabel6.setText("*Quantidade de empréstimo(s) que ainda pode realizar: ");

        buttonConfirmarEmp.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        buttonConfirmarEmp.setForeground(new java.awt.Color(63, 187, 71));
        buttonConfirmarEmp.setText("CONFIRMAR");
        buttonConfirmarEmp.setEnabled(false);
        buttonConfirmarEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConfirmarEmpActionPerformed(evt);
            }
        });

        buttonAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/previous.png"))); // NOI18N

        buttonProximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/next.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Noto Sans", 1, 16)); // NOI18N
        jLabel7.setText("2");

        buttonAddPront.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/add.png"))); // NOI18N
        buttonAddPront.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddProntActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel8.setText("Selecione a obra escolhida:");

        jLabel9.setText("ID Funcionário:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldProntuario, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldDataAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonAnterior)
                        .addGap(170, 170, 170)
                        .addComponent(buttonConfirmarEmp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonProximo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(218, 218, 218)
                                .addComponent(buttonAddPront, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldObraPesquisada, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fieldTipoLeitor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldIdFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))))
                    .addComponent(jLabel8))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fieldProntuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(fieldTipoLeitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(fieldDataAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAddPront))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(fieldIdFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(fieldObraPesquisada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonAnterior)
                    .addComponent(buttonProximo)
                    .addComponent(buttonConfirmarEmp, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(31, 31, 31))
        );

        setBounds(0, 0, 608, 493);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonConfirmarEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConfirmarEmpActionPerformed
        this.buttonConfirmarEmp.setEnabled(false);
        confirmaEmprestimo();
    }//GEN-LAST:event_buttonConfirmarEmpActionPerformed

    private void buttonAddProntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddProntActionPerformed
        if(this.fieldProntuario.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Preencha o campo corretamente", null, 2);
        }else{
            LeitoresDAO leitoresDAO = new LeitoresDAO();
            String prontuario = this.fieldProntuario.getText();
            
            if(leitoresDAO.totalPeloProntuario(prontuario) == 0){
                JOptionPane.showMessageDialog(null, "Prontuário não encontrado.", null, 2);
                this.fieldProntuario.setText(null);
            }else{
                String tipoLeitor = leitoresDAO.buscaTipoLeitor(prontuario);
                this.fieldTipoLeitor.setText(tipoLeitor);
            }
        }
    }//GEN-LAST:event_buttonAddProntActionPerformed

    private void fieldObraPesquisadaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldObraPesquisadaKeyReleased
        buscarObrasPorTituloFiltrando();
    }//GEN-LAST:event_fieldObraPesquisadaKeyReleased

    private void tableObrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableObrasMouseClicked
        this.buttonConfirmarEmp.setEnabled(true);
        recuperaObraSelecionada();
    }//GEN-LAST:event_tableObrasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAddPront;
    private javax.swing.JButton buttonAnterior;
    private javax.swing.JButton buttonConfirmarEmp;
    private javax.swing.JButton buttonProximo;
    private javax.swing.JTextField fieldDataAtual;
    private javax.swing.JTextField fieldIdFuncionario;
    private javax.swing.JTextField fieldObraPesquisada;
    private javax.swing.JTextField fieldProntuario;
    private javax.swing.JTextField fieldTipoLeitor;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableObras;
    // End of variables declaration//GEN-END:variables
}
