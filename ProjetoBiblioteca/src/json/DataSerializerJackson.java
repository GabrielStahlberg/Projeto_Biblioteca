/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.gson.JsonPrimitive;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author MiND
 */
public class DataSerializerJackson extends JsonSerializer<LocalDate>{
    private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    @Override
    public void serialize(LocalDate t, JsonGenerator jg, SerializerProvider sp) throws IOException {
        String data = t.format(format);
        jg.writeString(data);
    }
    
}
