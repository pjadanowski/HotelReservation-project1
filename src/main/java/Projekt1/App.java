package Projekt1;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * Hotel Reservation System
 * @author Pawel Jadanowski
 */
public class App 
{
    public static void main( String[] args )
    {
        Customer c1 = new Customer("Kazik", "Jakistam", "kjakistam@ss.ss");
        Room r100 = new Room(100, true);
        Room r101 = new Room(101, true);
        Room r102 = new Room(102, true);
//        r100.markRoomAsUnavaliable();

//        Reservation reservation = new Reservation(c1, r101, LocalDate.of(2018 ,4,1),
//                LocalDate.of(2018 ,4,10), LocalTime.of(10,0));


//        c1.printReservedRooms();
//                Reservation reservation = new Reservation(c1, r102, LocalDate.of(2018 ,4,7),
//                LocalDate.of(2018 ,4,10), LocalTime.of(10,0));

//        c1.printReservedRooms();
        String FILE = "src/main/resources/rooms.json";
        File file = new File(FILE);
//        JsonObject fromFileObject = new Gson().fromJson(r100.readFile(FILE), JsonObject.class);
//        r100.setAvaliable(true);
//        r100.updateFile(fromFileObject);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        System.out.println(sdf.format(file.lastModified()));
    }
}
