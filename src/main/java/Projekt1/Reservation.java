package Projekt1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.stream.Stream;

public class Reservation {

    public static String FILENAME = "reservations.json";

    Customer customer;
    Room room;
    LocalDate from_date;
    LocalDate to_date;
    LocalTime reservation_time;

    public Reservation(){}
    public Reservation(Customer customer, Room room, LocalDate from_date, LocalDate to_date, LocalTime reservation_time) {
        if (reservation_time.getMinute() != 0 || reservation_time.getMinute() != 30)
            throw new IllegalArgumentException("Rezerwacje tylko o pełnych godzinach lub 30 po");

        // check if room is avaliable
        if (!room.isAvaliable())
            throw new IllegalArgumentException("Pokój jest zajęty.");

        this.customer = customer;
        this.room = room;
        this.from_date = from_date;
        this.to_date = to_date;
        this.reservation_time = reservation_time;


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

}
