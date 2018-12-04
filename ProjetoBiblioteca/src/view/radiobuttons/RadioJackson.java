/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.radiobuttons;

import java.io.File;
import json.JsonJackson;
import util.AlgoritmoLeitura;

/**
 *
 * @author MiND
 */
public class RadioJackson extends RadioAbstrato{

    public RadioJackson(String titulo) {
        super(titulo);
    }

    @Override
    public AlgoritmoLeitura getAlgoritmo(File file) {
        JsonJackson json = new JsonJackson(file);
        return json;
    }
    
}
