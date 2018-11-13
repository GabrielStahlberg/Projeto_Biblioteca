/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ifsp.dsi.xml.XMLDOM;
import ifsp.dsi.xml.XMLJAXB;
import ifsp.dsi.xml.XMLSax;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
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
public class ImportacaoBackground extends SwingWorker<Integer,String>{

    private int selected;
    private File xmlFile;
    
    public ImportacaoBackground(int selected, File xmlFile){
        this.selected = selected;
        this.xmlFile = xmlFile;
    }
    
    @Override
    protected Integer doInBackground() throws Exception {
        if(selected == 1){
            withSAX();
        }
        else if(selected == 2){
            withDOM();
        }
        else if(selected == 3){
            withJAXB();
        }
        
        return 1;
    }
    
    private void withSAX(){
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try(InputStream input = new FileInputStream(xmlFile);){
            SAXParser parser = factory.newSAXParser();
            XMLSax reader = new XMLSax();
            parser.parse(input,reader);
            List<Obra> works = reader.getBooks();
            System.out.println("SAX"); //A proposito de teste, será removido
            works.forEach(System.out::println);
        }
        catch(ParserConfigurationException | SAXException erro){
            erro.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void withDOM(){
        XMLDOM dom = new XMLDOM(xmlFile);
        List<Obra> books = dom.readXML();
        System.out.println("DOM"); //A proposito de teste, será removido
        books.forEach(System.out::println);
    }
    
    private void withJAXB(){
        XMLJAXB jax = new XMLJAXB(xmlFile);
        ObraLista bookL = (ObraLista)jax.readXML(ObraLista.class);
        List<Obra> books = bookL.getObraList();
        System.out.println("JAXB"); //A proposito de teste, será removido
        books.forEach(System.out::println);
    }
    
}
