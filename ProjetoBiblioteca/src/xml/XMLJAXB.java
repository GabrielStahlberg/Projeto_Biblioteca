package xml;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import model.ObraLista;
import util.AlgoritmoLeitura;

public class XMLJAXB implements AlgoritmoLeitura{
    private File file;
    private Class[] clazzes;
    
    public XMLJAXB(File file){
        this.file = file;
    }
    
    public void setFile(File file){
        this.file = file;
    }
    
    public void setClazzes(Class... clazzes){
        this.clazzes = clazzes;
    }
    
    public ObraLista read(){
        ObraLista o = new ObraLista();
        try {
            JAXBContext context = JAXBContext.newInstance(clazzes);
            
            Unmarshaller unmarshaller = context.createUnmarshaller();
            
            o = (ObraLista)unmarshaller.unmarshal(file);
            
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
        return o;
    }
    
    public void write(ObraLista o){
        try {
            JAXBContext context = JAXBContext.newInstance(clazzes);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(o, file);
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }
}
