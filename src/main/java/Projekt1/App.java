package Projekt1;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Customer c1 = new Customer("Kazik", "Jakistam", "kjakistam@ss.ss");
        Room r100 = new Room(100, true);
        r100.markRoomAsUnavaliable();

        Reservation reservation = new Reservation();
        String reservationFile = reservation.readFile("src/main/resources/reservations.json");
    }
}
