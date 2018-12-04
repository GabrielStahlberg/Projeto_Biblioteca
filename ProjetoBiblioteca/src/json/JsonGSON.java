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

/**
 *
 * @author MiND
 */
public class JsonGSON {
    private File arquivo;
    
    public JsonGSON(File arquivo){
        this.arquivo = arquivo;
    }
    
    public void setArquivo(File arquivo){
        this.arquivo = arquivo;
    }
    
    public <T extends Object>T ler(Class<T> clazz){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.registerTypeAdapter(LocalDate.class, new DataAdapterJsonGson()).create();
        T ret = null;
        
        try(Reader r = new FileReader(arquivo)){
            ret = gson.fromJson(r, clazz);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return ret;
    }
    
    public void gravar(Object o){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.registerTypeAdapter(LocalDate.class, new DataAdapterJsonGson()).setPrettyPrinting().create();
        try(Writer w = new FileWriter(arquivo)){
            gson.toJson(o, w);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
