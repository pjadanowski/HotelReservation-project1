package Projekt1;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Room {

    private static  String FILE = "src/main/resources/rooms.json";
    private int roomNumber;
    private boolean avaliable;


    public Room(int roomNumber , boolean avaliable) {
        this.roomNumber = roomNumber;
        this.avaliable = avaliable;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setAvaliable(boolean avaliable) {
        this.avaliable = avaliable;
    }

    public boolean isAvaliable(){
        boolean isAvaliable = false;
        JsonObject fromFileObject = new Gson().fromJson(readFile(FILE), JsonObject.class);
        JsonArray mainObject = fromFileObject.getAsJsonArray("rooms");

        for (JsonElement room: mainObject) {
            if (room.isJsonObject())
            {
                JsonObject r = room.getAsJsonObject();
                if (Integer.parseInt(r.get("room").getAsString()) == this.getRoomNumber()){
                    isAvaliable = Boolean.parseBoolean(r.get("avaliable").getAsString());
                }
            }
        }
        return isAvaliable;
    }

    public String readFile(String fileName){

        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines( Paths.get(fileName), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }

    public void markRoomAsUnavaliable(){
//        Room[] rooms = new Gson().fromJson(this.readFile(FILE), Room[].class);
        JsonObject fromFileObject = new Gson().fromJson(readFile(FILE), JsonObject.class);
        JsonArray mainObject = fromFileObject.getAsJsonArray("rooms");

        for (JsonElement room: mainObject) {
            if (room.isJsonObject())
            {
                JsonObject r = room.getAsJsonObject();
                if (Integer.parseInt(r.get("room").getAsString()) == this.getRoomNumber()){
                    r.remove("avaliable");
                    r.addProperty("avaliable", false);
                }
            }
        }
        updateFile(fromFileObject);
//        System.out.println(fromFileObject.toString());
    }

    public void updateFile(JsonObject jsonObject){
        try {
            FileWriter fileWriter = new FileWriter(new File(FILE));
            fileWriter.write(jsonObject.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
