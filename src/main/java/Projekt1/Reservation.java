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
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.stream.Stream;
import java.util.UUID;

public class Reservation {

    public static String FILE = "src/main/resources/reservations.json";

    String reservation_id;
    Customer customer;
    Room room;
    LocalDate from_date;
    LocalDate to_date;
    LocalTime reservation_time;

    public Reservation(){}

    public Reservation(Customer customer, Room room, LocalDate from_date, LocalDate to_date, LocalTime reservation_time) {
        if (!(reservation_time.getMinute() == 0 || reservation_time.getMinute() == 30))
            throw new IllegalArgumentException("Rezerwacje tylko o pełnych godzinach lub 30 po");

        // check if room is avaliable
        if (!room.isAvaliable())
            throw new IllegalArgumentException("Pokój jest zajęty.");

        this.reservation_id = uuid();
        this.customer = customer;
        this.room = room;
        this.from_date = from_date;
        this.to_date = to_date;
        this.reservation_time = reservation_time;


        // open existing file
        JsonObject fromFileObject = new Gson().fromJson(readFile(FILE), JsonObject.class);
        JsonArray mainObject = fromFileObject.getAsJsonArray("reservations");

        // Reservation to json
        String reservation  = new Gson().toJson(this);
        JsonObject r = new Gson().fromJson(reservation, JsonObject.class);
        mainObject.add(r);
        // save it to file
        updateFile(fromFileObject);

        // set reserved room as unavaliable
        room.setAvaliable(false);
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

    public void writeToFile(String filename, boolean overwritten){

    }


    public String uuid(){
//        String uuid = UUID.randomUUID().toString();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String substr = uuid.substring(0,5);
        return substr;
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

    public void checkDays(LocalDate date) throws IllegalArgumentException{
        // first check if given date is >= today
        if(date.isBefore(LocalDate.now()))
            throw new IllegalArgumentException("Podany dzień już minął");

        // check if is hotel working day
        JsonObject fromFileObject = new Gson().fromJson(readFile("src/main/resources/freeDays.json"), JsonObject.class);
        JsonArray mainObject = fromFileObject.getAsJsonArray("freeDays");

        for (JsonElement day: mainObject) {
            if (date.isEqual(LocalDate.parse(day.getAsString())))
                throw new IllegalArgumentException("W tym dniu hotel jest nieczynny.");
        }
    }
}
