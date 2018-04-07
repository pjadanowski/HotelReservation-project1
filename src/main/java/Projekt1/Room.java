package Projekt1;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;


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

    public static String getFILE() {
        return FILE;
    }


    public void setAvaliable(boolean avaliable) throws IOException {

            JsonObject fromFileObject = new Gson().fromJson(Helper.readFile(FILE), JsonObject.class);
            JsonArray mainObject = fromFileObject.getAsJsonArray("rooms");

            for (JsonElement room: mainObject) {
                if (room.isJsonObject())
                {
                    JsonObject r = room.getAsJsonObject();
                    if (Integer.parseInt(r.get("room").getAsString()) == this.getRoomNumber()){
                        r.remove("avaliable");
                        r.addProperty("avaliable", avaliable);
                    }
                }
            }
            Helper.updateFile(FILE, fromFileObject);
    }

    public boolean isAvaliable() throws IOException {
        boolean isAvaliable = false;
        JsonObject fromFileObject = new Gson().fromJson(Helper.readFile(FILE), JsonObject.class);
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




}
