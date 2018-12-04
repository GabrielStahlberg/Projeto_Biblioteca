/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import model.ObraLista;

/**
 *
 * @author MiND
 */
public interface AlgoritmoLeitura {
    public abstract ObraLista read();
    public abstract void write(ObraLista o);
}
