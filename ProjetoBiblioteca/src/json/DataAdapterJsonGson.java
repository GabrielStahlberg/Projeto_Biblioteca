/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author MiND
 */
public class DataAdapterJsonGson implements JsonSerializer<LocalDate>,JsonDeserializer<LocalDate>{
    private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public JsonElement serialize(LocalDate t, Type type, JsonSerializationContext jsc) {
        String data = t.format(format);
        return new JsonPrimitive(data);
    }

    @Override
    public LocalDate deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        LocalDate data = LocalDate.parse(je.getAsString(), format);
        return data;
    }
}
