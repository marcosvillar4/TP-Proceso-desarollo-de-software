package Clases.Json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class JsonManager {
    public File checkFile(String filename){
        File jsonDB = new File(System.getProperty("user.dir") + "\\" +filename);
        if (jsonDB.exists()){
            System.out.println("Archivo existe, recuperando datos");
        } else {
            try {
                if (jsonDB.createNewFile()){
                    System.out.println("datos.json creado");
                };
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return jsonDB;
    }



    public boolean writeFile(Object m, File f){
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
