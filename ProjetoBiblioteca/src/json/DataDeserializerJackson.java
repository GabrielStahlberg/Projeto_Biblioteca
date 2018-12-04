/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author MiND
 */
public class DataDeserializerJackson extends JsonDeserializer<LocalDate>{
    private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public LocalDate deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
        LocalDate data = LocalDate.parse(jp.getText(),format);
        return data;
    }


    
}
