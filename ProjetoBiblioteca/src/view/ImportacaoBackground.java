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
public class ImportacaoBackground extends SwingWorker<Integer,Object>{

    private RadioAbstrato botao;
    private File xmlFile;
    private JLabel label;
    private int total;
    private List<Obra> books;
    
    public ImportacaoBackground(RadioAbstrato botao, File xmlFile, JLabel label){
        this.botao = botao;
        this.xmlFile = xmlFile;
        this.label = label;
        
        fazImportacao();        
    }
    
    private void fazImportacao(){
        AlgoritmoLeitura algoritmo = botao.getAlgoritmo(xmlFile);
        ObraLista lista = algoritmo.read();
        
        this.books = lista.getObraList();
        this.total = books.size();
        
        System.out.println(botao.getText()); //A proposito de teste, será removido
        this.books.forEach(System.out::println);
    }
    
    @Override
    protected Integer doInBackground() throws Exception {
        ObrasDAO obrasDAO = new ObrasDAO();
        try{        
            for(int i=0; i<this.total; i++){
                String codigo = obrasDAO.buscarCategoriasObraCod(this.books.get(i).getCategoria());
                this.books.get(i).setCategoria(codigo);
                obrasDAO.salvar(this.books.get(i));
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
