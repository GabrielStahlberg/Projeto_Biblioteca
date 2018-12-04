/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;

/**
 *
 * @author MiND
 */
public class JsonJackson {
    private File arquivo;
    
    public JsonJackson(File arquivo){
        this.arquivo = arquivo;
    }
    
    public void setArquivo(File arquivo){
        this.arquivo = arquivo;
    }
    
    
    public <T extends Object>T ler(Class<T> clazz){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            SimpleModule sM = new SimpleModule();
            sM.addDeserializer(LocalDate.class, new DataDeserializerJackson());
            objectMapper.registerModule(sM);
            return objectMapper.readValue(arquivo, clazz);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    
    public void gravar(Object o) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        SimpleModule sM = new SimpleModule();
        sM.addSerializer(LocalDate.class, new DataSerializerJackson());
        objectMapper.registerModule(sM);
        try(Writer w = new FileWriter(arquivo)){
            objectMapper.writeValue(w, o);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
