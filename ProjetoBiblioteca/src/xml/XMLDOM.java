package xml;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import model.Obra;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLDOM {
    private File file;
    
    private Document writeDoc;
    private Element writeEle;
    
    public XMLDOM(File file){
        this.file = file;
    }
    
    public XMLDOM(File file, String rootElement){
        this.file = file;
        loadDocumentWrite(rootElement);
    }
    
    public List<Obra> readXML(){
        List<Obra> books = new ArrayList<>();
        Document document = loadDocumentRead();
        
        NodeList nodeList = document.getElementsByTagName("obra");
        for(int i = 0; i < nodeList.getLength(); i++){
            Obra b = new Obra();
            
            Element bookElement = (Element)nodeList.item(i);
            
            Element isbnElement = (Element)bookElement.getElementsByTagName("isbn").item(0);
            String isbn = isbnElement.getTextContent();
            b.setIsbn(isbn);
            
            Element titleElement = (Element)bookElement.getElementsByTagName("titulo").item(0);
            String title = titleElement.getTextContent();
            b.setTitulo(title);
            
            Element categoryElement = (Element)bookElement.getElementsByTagName("categoria").item(0);
            String category = categoryElement.getTextContent();
            b.setCategoria(category);
            
            Element dateElement = (Element)bookElement.getElementsByTagName("data").item(0);
            try{
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate date = LocalDate.parse(dateElement.getTextContent(), formatter);
                b.setDataPubl(date);
            }
            catch(DateTimeParseException ex){
                System.out.println("asdasd");
                b.setDataPubl(null);
            }
            
            Element editionElement = (Element)bookElement.getElementsByTagName("edicao").item(0);
            String edition = editionElement.getTextContent();
            try {
                b.setNroEdicao(Integer.parseInt(edition));
            } catch (NumberFormatException e) {
                b.setNroEdicao(0);
            }
            
            Element publisherElement = (Element)bookElement.getElementsByTagName("editora").item(0);
            String publisher = publisherElement.getTextContent();
            b.setEditora(publisher);
            
            NodeList authorsList = bookElement.getElementsByTagName("autor");
            String author;
            List<String> authors = new ArrayList<>();
            for(int j = 0; j < authorsList.getLength(); j++){
                Element authorElement = (Element)authorsList.item(j);
                author = authorElement.getTextContent();
                authors.add(author);
            }
            b.setAutores(authors);
            
            NodeList keywordsList = bookElement.getElementsByTagName("palavra-chave");
            String keyword;
            List<String> keywords = new ArrayList<>();
            for(int j = 0; j < keywordsList.getLength(); j++){
                Element keywordElement = (Element)keywordsList.item(j);
                keyword = keywordElement.getTextContent();
                keywords.add(keyword);
            }
            b.setPalavrasChaves(keywords);
            
            books.add(b);
            
        }
        
        return books;
    }
    
    private Document loadDocumentRead(){
        Document document = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //factory.setValidating(true);
        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(file);
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            ex.printStackTrace();
        }
        
        return document;
    }
    
    private void loadDocumentWrite(String root){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            writeDoc = builder.newDocument();
            this.writeEle = writeDoc.createElement(root);
            writeDoc.appendChild(writeEle);
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        }
    }
    
    public void writeXML(Obra obra){
        Element obraElement = writeDoc.createElement("obra");
        writeEle.appendChild(obraElement);
        
        criarElemento(obraElement,"isbn",obra.getIsbn());
        criarElemento(obraElement,"titulo",obra.getTitulo());
        criarElemento(obraElement,"categoria",obra.getCategoria());
        
        Element autoresElement = criarElemento(obraElement,"autores");
        List<String> autores = obra.getAutores();
        autores.forEach(a -> criarElemento(autoresElement,"autor",a));
        
        Element palavrasChaveElement = criarElemento(obraElement,"palavras-chave");
        List<String> palavrasChave = obra.getPalavrasChaves();
        palavrasChave.forEach(p -> criarElemento(palavrasChaveElement,"palavra-chave",p));
        
        if(obra.getDataPubl() != null){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            criarElemento(obraElement,"data",obra.getDataPubl().format(formatter));
        }
        else{
            criarElemento(obraElement,"data",null);
        }
        criarElemento(obraElement,"edicao",String.valueOf(obra.getNroEdicao()));
        criarElemento(obraElement,"editora",obra.getEditora());
        
        
        DOMSource source= new DOMSource(writeDoc);
        
        StreamResult result = new StreamResult(file);
        
        TransformerFactory tFactory = TransformerFactory.newInstance();
        try{
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");
            transformer.transform(source, result);
        } catch (TransformerException ex) {
            ex.printStackTrace();
        }
    }
    
    private void criarElemento(Element paiElement, String name, String value){
       Element filhoElement = writeDoc.createElement(name);
       filhoElement.setTextContent(value);
       paiElement.appendChild(filhoElement);
   }
    
   private Element criarElemento(Element paiElement, String name){
       Element filhoElement = writeDoc.createElement(name);
       paiElement.appendChild(filhoElement);
       return filhoElement;
   }


}
