package Clases.Json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class JsonReader {
    public static Object readObjectFromFile(File file, Class c) throws IOException {
        //System.out.println(Files.readString(file.toPath())); // Funcion para imprimir JSON completo en CMD, PARA DEBUGING
        ObjectMapper om = new ObjectMapper();
        try {
            Object ob  = om.readValue(Files.readString(file.toPath()), c);
            System.out.println("Lectura exitosa");
            return ob;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
