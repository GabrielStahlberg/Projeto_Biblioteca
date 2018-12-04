/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import model.Obra;
import model.ObraLista;
import org.xml.sax.SAXException;
import util.AlgoritmoLeitura;

/**
 *
 * @author MiND
 */
public class SAXHandler implements AlgoritmoLeitura{
    File arquivo;
    
    public SAXHandler(File arquivo) {
        this.arquivo = arquivo;
    }
    
    @Override
    public ObraLista read(){
        ObraLista o = new ObraLista();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try(InputStream input = new FileInputStream(arquivo);){
            List<Obra> books = new ArrayList<>();
            SAXParser parser = factory.newSAXParser();
            XMLSax reader = new XMLSax();
            parser.parse(input,reader);
            books = reader.getBooks();
            
            o.setObraList(books);
        }
        catch(ParserConfigurationException | SAXException erro){
            erro.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return o;
    }
    
    public void write(ObraLista o){
        System.out.println("Should not be called.");
    }
}
