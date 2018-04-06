package Projekt1;

import java.time.LocalDate;
import java.time.LocalTime;

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
//        r100.markRoomAsUnavaliable();

        Reservation reservation = new Reservation(c1, r101, LocalDate.of(2018 ,4,1),
                LocalDate.of(2018 ,4,10), LocalTime.of(10,0));


        String reservationFile = reservation.readFile("src/main/resources/reservations.json");
    }
}
