/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.radiobuttons;

import java.io.File;
import javax.swing.JRadioButton;
import util.AlgoritmoLeitura;

/**
 *
 * @author MiND
 */
public abstract class RadioAbstrato extends JRadioButton{
    public RadioAbstrato(String titulo){
        super(titulo);
    }
    
    public abstract AlgoritmoLeitura getAlgoritmo(File file);
}
