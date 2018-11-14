/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.ObrasDAO;
import xml.XMLDOM;
import xml.XMLJAXB;
import xml.XMLSax;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.swing.JLabel;
import javax.swing.SwingWorker;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import model.Obra;
import model.ObraLista;
import org.xml.sax.SAXException;

/**
 *
 * @author MiND
 */
public class ImportacaoBackground extends SwingWorker<Integer,Object>{

    private int selected;
    private File xmlFile;
    private JLabel label;
    private int total;
    private List<Obra> books;
    
    public ImportacaoBackground(int selected, File xmlFile, JLabel label){
        this.selected = selected;
        this.xmlFile = xmlFile;
        this.label = label;
        
        fazImportacao();        
    }
    
    private void fazImportacao(){
        if(selected == 1){
            withSAX();
        }
        else if(selected == 2){
            withDOM();
        }
        else if(selected == 3){
            withJAXB();
        }
    }
    
    @Override
    protected Integer doInBackground() throws Exception {
        ObrasDAO obrasDAO = new ObrasDAO();
        try{        
            for(int i=0; i<this.total; i++){
                String codigo = obrasDAO.buscarCategoriasObraCod(this.books.get(i).getCategoria());
                this.books.get(i).setCategoria(codigo);
                obrasDAO.salvar(this.books.get(i));
                
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
    
    private void withSAX(){
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try(InputStream input = new FileInputStream(xmlFile);){
            SAXParser parser = factory.newSAXParser();
            XMLSax reader = new XMLSax();
            parser.parse(input,reader);
            this.books = reader.getBooks();
            this.total = books.size();
            
            System.out.println("SAX"); //A proposito de teste, será removido
            this.books.forEach(System.out::println);
        }
        catch(ParserConfigurationException | SAXException erro){
            erro.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void withDOM(){
        XMLDOM dom = new XMLDOM(xmlFile);
        this.books = dom.readXML();
        this.total = books.size();
        
        System.out.println("DOM"); //A proposito de teste, será removido
        books.forEach(System.out::println);
    }
    
    private void withJAXB(){
        XMLJAXB jax = new XMLJAXB(xmlFile);
        ObraLista bookL = (ObraLista)jax.readXML(ObraLista.class);
        this.books = bookL.getObraList();
        this.total = books.size();
        
        System.out.println("JAXB"); //A proposito de teste, será removido
        this.books.forEach(System.out::println);
    }
    
}
