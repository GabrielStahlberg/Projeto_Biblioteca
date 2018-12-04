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
import model.ObraLista;
import util.AlgoritmoLeitura;

/**
 *
 * @author MiND
 */
public class JsonJackson implements AlgoritmoLeitura{
    private File arquivo;
    
    public JsonJackson(File arquivo){
        this.arquivo = arquivo;
    }
    
    public void setArquivo(File arquivo){
        this.arquivo = arquivo;
    }
    
    
    @Override
    public ObraLista read(){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            SimpleModule sM = new SimpleModule();
            sM.addDeserializer(LocalDate.class, new DataDeserializerJackson());
            objectMapper.registerModule(sM);
            return objectMapper.readValue(arquivo, ObraLista.class);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    
    @Override
    public void write(ObraLista o){
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
