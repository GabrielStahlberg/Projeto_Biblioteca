package ifsp.dsi.xml;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DataAdapter extends XmlAdapter<String,LocalDate>{
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    @Override
    public LocalDate unmarshal(String v) throws Exception {
        LocalDate ret = LocalDate.parse(v, formatter);
        return ret;
    }

    @Override
    public String marshal(LocalDate v) throws Exception {
        String ret = v.format(formatter);
        return ret;
    }
    
}
