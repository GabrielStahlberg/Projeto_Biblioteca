/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.radiobuttons;

import java.io.File;
import util.AlgoritmoLeitura;
import xml.XMLJAXB;

/**
 *
 * @author MiND
 */
public class RadioJAXB extends RadioAbstrato{
    private Class[] clazzes;

    public RadioJAXB(String titulo,Class... clazzes) {
        super(titulo);
        this.clazzes = clazzes;
    }

    @Override
    public AlgoritmoLeitura getAlgoritmo(File file) {
        XMLJAXB xml = new XMLJAXB(file);
        xml.setClazzes(clazzes);
        return xml;
    }
    
}
