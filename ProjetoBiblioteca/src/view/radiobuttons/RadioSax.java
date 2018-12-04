/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.radiobuttons;

import java.io.File;
import util.AlgoritmoLeitura;
import xml.SAXHandler;

/**
 *
 * @author MiND
 */
public class RadioSax extends RadioAbstrato{

    public RadioSax(String titulo) {
        super(titulo);
    }

    @Override
    public AlgoritmoLeitura getAlgoritmo(File file) {
        SAXHandler xml = new SAXHandler(file);
        return xml;
    }
    
}
