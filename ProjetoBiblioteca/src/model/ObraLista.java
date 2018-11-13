package model;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "obras")

public class ObraLista {
    @XmlElement(name = "obra")
    private List<Obra> obraList;

    public List<Obra> getObraList() {
        return obraList;
    }

    public void setObraList(List<Obra> obraList) {
        this.obraList = obraList;
    }
}
