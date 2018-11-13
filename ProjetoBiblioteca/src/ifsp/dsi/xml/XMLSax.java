/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsp.dsi.xml;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import model.Obra;

/**
 *
 * @author MiND
 */
public class XMLSax extends DefaultHandler{
    
    private List<Obra> books;
    private String value;
    private Obra b;
    
    public List<Obra> getBooks(){
        return books;
    }
    
    @Override
    public void startDocument() throws SAXException{
        books = new ArrayList<>();
    }
    
    @Override
    public void endDocument() throws SAXException{
    }
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
        if(qName.equals("obra")){
            b = new Obra();
            books.add(b);
        }
        else if(qName.equals("autores")){
            List<String> authors = new ArrayList<>();
            b.setAutores(authors);
        }
        else if(qName.equals("palavras-chave")){
            List<String> keywords = new ArrayList<>();
            b.setPalavrasChaves(keywords);
        }
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException{
        if(qName.equals("isbn")){
            b.setIsbn(value);
        }
        else if(qName.equals("titulo")){
            b.setTitulo(value);
        }
        else if(qName.equals("categoria")){
            b.setCategoria(value);
        }
        else if(qName.equals("autor")){
            List<String> authors = b.getAutores();
            authors.add(value);
        }
        else if(qName.equals("palavra-chave")){
            List<String> keywords = b.getPalavrasChaves();
            keywords.add(value);
        }
        else if(qName.equals("data")){
            try{
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate date = LocalDate.parse(value, formatter);
                b.setDataPubl(date);
            }
            catch(DateTimeParseException ex){
                b.setDataPubl(null);
            }
        }
        else if(qName.equals("edicao")){
            try {
                b.setNroEdicao(Integer.parseInt(value));
            } catch (NumberFormatException e) {
                b.setNroEdicao(0);
            }
        }
        else if(qName.equals("editora")){
            b.setEditora(value);
        }
    }
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException{
        value = String.valueOf(ch,start,length);
    }
}
