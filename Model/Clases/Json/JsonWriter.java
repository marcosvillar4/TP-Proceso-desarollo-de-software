package Clases.Json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class JsonWriter {
    public static boolean writeFile(Object m, File f){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            objectMapper.writeValue(f, m);
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
