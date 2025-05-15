package Clases;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonManager {
    public File checkFile(String filename){
        File jsonDB = new File(System.getProperty("user.dir") + "\\" +filename);
        if (jsonDB.exists()){
            System.out.println("READ OP");
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

    public Object readObjectFromFile(String filename, Class c) throws IOException {
        if (checkFile(filename).exists()) {
            File file = new File(System.getProperty("user.dir") +"\\" +filename);
            System.out.println(Files.readString(file.toPath()));
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
        } else {
            return null;
        }

    }

    public boolean writeMenuFile(Menu m, File f){
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
