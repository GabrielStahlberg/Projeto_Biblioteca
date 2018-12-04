/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.radiobuttons;

import java.io.File;
import util.AlgoritmoLeitura;
import xml.XMLDOM;

/**
 *
 * @author MiND
 */
public class RadioDOM extends RadioAbstrato{

    public RadioDOM(String titulo) {
        super(titulo);
    }

    @Override
    public AlgoritmoLeitura getAlgoritmo(File file) {
        XMLDOM xml = new XMLDOM(file);
        xml.setRootElement("obras");
        return xml;
    }
    
}
