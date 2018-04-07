package Projekt1;

import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Helper {

    public static String readFile(String fileName) throws IOException{
        StringBuilder contentBuilder = new StringBuilder();
        Stream<String> stream = Files.lines( Paths.get(fileName), StandardCharsets.UTF_8);

        stream.forEach(s -> contentBuilder.append(s).append("\n"));
        return contentBuilder.toString();
    }


    public static void updateFile(String FILE, JsonObject jsonObject){
        try {
            FileWriter fileWriter = new FileWriter(new File(FILE));
            fileWriter.write(jsonObject.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
