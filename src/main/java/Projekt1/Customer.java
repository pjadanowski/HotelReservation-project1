package Projekt1;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.ArrayList;

public class Customer {

    private String FILE = "src/main/resources/customers.json";

    private String firstname;
    private String lastname;
    private String email;

    public Customer(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }


    public String getLastname() {
        return lastname;
    }


    public ArrayList<Room> reservedRooms() throws NullPointerException {
        ArrayList<Room> rooms = new ArrayList<>();
        JsonObject fromFileObject = null;
        try {
            fromFileObject = new Gson().fromJson(Helper.readFile("src/main/resources/reservations.json"), JsonObject.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert fromFileObject != null;
        JsonArray mainObject = fromFileObject.getAsJsonArray("reservations");

        for (JsonElement reserv : mainObject) {
            if (reserv.isJsonObject()) {
                JsonObject reservation = reserv.getAsJsonObject();
                JsonObject customer = reservation.getAsJsonObject("customer");
                if (customer.get("firstname").getAsString().equalsIgnoreCase(this.getFirstname())
                        &&
                        (customer.get("lastname").getAsString().equalsIgnoreCase(this.getLastname()))) {
                    JsonObject room = (JsonObject) reservation.get("room");
                    Room room1 = new Room(room.get("roomNumber").getAsInt(), room.get("avaliable").getAsBoolean());
                    rooms.add(room1);
                }
            }
        }

        return rooms;
    }

//    public void printReservedRooms(){
//        this.reservedRooms().forEach(room -> System.out.print(room.getRoomNumber()+", "));
//    }


}
