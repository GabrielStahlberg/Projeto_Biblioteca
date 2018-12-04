/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.ObrasDAO;
import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.swing.JLabel;
import javax.swing.SwingWorker;
import model.Obra;
import model.ObraLista;
import util.AlgoritmoLeitura;
import view.radiobuttons.RadioAbstrato;

/**
 *
 * @author MiND
 */
public class ExportacaoBackground extends SwingWorker<Integer,Object>{
    
    private RadioAbstrato botao;
    private File xmlFile;
    private JLabel label;
    private int total;
    private List<Obra> books;
    
    public ExportacaoBackground(RadioAbstrato botao, File xmlFile, JLabel label){
        this.botao = botao;
        this.xmlFile = xmlFile;
        this.label = label;
        
        fazExportacao();        
    }
    
    private void fazExportacao(){
        AlgoritmoLeitura algoritmo = botao.getAlgoritmo(xmlFile);
        ObrasDAO oDAO = new ObrasDAO();
        ObraLista lista = new ObraLista();
        this.books = oDAO.realizarRelatorioCompleto();
        this.total = books.size();
        
        lista.setObraList(books);
        algoritmo.write(lista);
    }
    
    @Override
    protected Integer doInBackground() throws Exception {
        try{        
            for(int i=0; i<this.total; i++){
                publish(i);
                setProgress(100 * (i+1) / total);
            }
        }catch(Exception erro){
            erro.printStackTrace();
        }
        return this.total;
    }
    
    @Override
    protected void done() {
        try {
            label.setText(get().toString());
        } catch (InterruptedException | ExecutionException erro) {
            erro.printStackTrace();
        }
    }

    @Override
    protected void process(List<Object> lista) {
        lista.forEach(o -> System.out.println(o));
    }
}
