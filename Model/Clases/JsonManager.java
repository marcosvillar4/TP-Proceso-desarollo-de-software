package Clases;

import java.io.File;
import java.io.IOException;

public class JsonManager {
    public File getJson(){
        File jsonDB = new File(System.getProperty("user.dir") + "\\datos.json");
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
}
