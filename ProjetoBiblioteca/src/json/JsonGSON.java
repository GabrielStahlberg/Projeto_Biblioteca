/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDate;
import model.ObraLista;
import util.AlgoritmoLeitura;

/**
 *
 * @author MiND
 */
public class JsonGSON implements AlgoritmoLeitura{
    private File arquivo;
    
    public JsonGSON(File arquivo){
        this.arquivo = arquivo;
    }
    
    public void setArquivo(File arquivo){
        this.arquivo = arquivo;
    }
    
    @Override
    public ObraLista read(){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.registerTypeAdapter(LocalDate.class, new DataAdapterJsonGson()).create();
        ObraLista ret = null;
        
        try(Reader r = new FileReader(arquivo)){
            ret = gson.fromJson(r, ObraLista.class);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return ret;
    }
    
    @Override
    public void write(ObraLista o){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.registerTypeAdapter(LocalDate.class, new DataAdapterJsonGson()).setPrettyPrinting().create();
        try(Writer w = new FileWriter(arquivo)){
            gson.toJson(o, w);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
