package ifsp.dsi.xml;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XMLJAXB {
    private File file;
    
    public XMLJAXB(File file){
        this.file = file;
    }
    
    public Object readXML(Class... clazz){
        Object o = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            
            Unmarshaller unmarshaller = context.createUnmarshaller();
            
            o = unmarshaller.unmarshal(file);
            
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
        return o;
    }
    
    public void writeXML(Object o, File fileSave, Class... clazz){
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(o, fileSave);
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }
}
