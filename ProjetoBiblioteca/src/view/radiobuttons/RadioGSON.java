/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.radiobuttons;

import java.io.File;
import json.JsonGSON;
import util.AlgoritmoLeitura;

/**
 *
 * @author MiND
 */
public class RadioGSON extends RadioAbstrato{

    public RadioGSON(String titulo) {
        super(titulo);
    }

    @Override
    public AlgoritmoLeitura getAlgoritmo(File file) {
        JsonGSON json = new JsonGSON(file);
        return json;
    }
    
}
