package Projekt1;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;


public class Room {

    private static String FILE = "src/main/resources/rooms.json";
    private int roomNumber;
    private boolean avaliable;


    public Room(int roomNumber, boolean avaliable) {
        this.roomNumber = roomNumber;
        this.avaliable = avaliable;
    }

    public int getRoomNumber() {
        return roomNumber;
    }



    public void setAvaliable(boolean avaliable) throws IOException {

        JsonObject fromFileObject = new Gson().fromJson(Helper.readFile(FILE), JsonObject.class);
        JsonArray mainObject = fromFileObject.getAsJsonArray("rooms");

        for (JsonElement room : mainObject) {
            if (room.isJsonObject()) {
                JsonObject r = room.getAsJsonObject();
                if (Integer.parseInt(r.get("roomNumber").getAsString()) == this.getRoomNumber()) {
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

        for (JsonElement room : mainObject) {
            if (room.isJsonObject()) {
                JsonObject r = room.getAsJsonObject();
                if (r.get("roomNumber").getAsInt() == this.getRoomNumber()) {
                    isAvaliable = Boolean.parseBoolean(r.get("avaliable").getAsString());
                }
            }
        }
        return isAvaliable;
    }


    public boolean checkIfRoomExistsInJson() throws IllegalArgumentException {
        try {
            JsonObject fromFileObject = new Gson().fromJson(Helper.readFile(FILE), JsonObject.class);
            JsonArray mainObject = fromFileObject.getAsJsonArray("rooms");

            for (JsonElement room : mainObject) {
                if (room.isJsonObject()) {
                    JsonObject r = room.getAsJsonObject();
                    if (r.get("roomNumber").getAsInt() == this.getRoomNumber()) {
                        throw new IllegalArgumentException("Pokój jest już na liście.");
                    }
                }
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    public void saveRoomToJson() {

        checkIfRoomExistsInJson();
        try {
            // open existing file
            JsonObject fromFileObject = null;
            try {
                fromFileObject = new Gson().fromJson(Helper.readFile(FILE), JsonObject.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            JsonArray mainObject = fromFileObject.getAsJsonArray("rooms");

            // Rooms to json
            String reservation = new Gson().toJson(this);
            JsonObject r = new Gson().fromJson(reservation, JsonObject.class);
            mainObject.add(r);
            // save it to file
            Helper.updateFile(FILE, fromFileObject);
        } catch (IllegalArgumentException | IOException e) {
            e.printStackTrace();
        }
    }
}
