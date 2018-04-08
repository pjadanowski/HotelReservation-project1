package Projekt1;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {


    @Test
    void defaultConstructorTest() {
        Reservation reservation = new Reservation();
//        assertThat(reservation, is(not(empty())));
    }

    @Test
    void customConstructorTest() throws IOException {
        Customer c1 = new Customer("Kazik", "Jakistam", "kjakistam@ss.ss");
        Room r100 = new Room(100, true);
        r100.setAvaliable(true);
        Reservation reservation = new Reservation(
                c1, r100,
                LocalDate.of(2018, 5, 1),
                LocalDate.of(2018, 5, 10),
                LocalTime.of(10, 0)
        );

        // if any exception
        assertTrue(true);
    }

    @Test
    void wrongHourTest() throws IOException {

        assertThrows(IllegalArgumentException.class,
                () -> {
                    Customer c1 = new Customer("Kazik", "Jakistam", "kjakistam@ss.ss");
                    Room r100 = new Room(100, true);
                    r100.setAvaliable(true);
                    Reservation reservation = new Reservation(
                            c1, r100,
                            LocalDate.of(2018, 5, 1),
                            LocalDate.of(2018, 5, 10),
                            LocalTime.of(10, 3)
                    );
                });
    }

    @Test
    void roomUnavaliableTest() throws IOException {

        assertThrows(IllegalArgumentException.class,
                () -> {
                    Customer c1 = new Customer("Kazik", "Jakistam", "kjakistam@ss.ss");
                    Room r100 = new Room(100, true);
                    r100.setAvaliable(false);
                    Reservation reservation = new Reservation(
                            c1, r100,
                            LocalDate.of(2018, 5, 1),
                            LocalDate.of(2018, 5, 10),
                            LocalTime.of(10, 0)
                    );
                });
    }


    @Test
    void uuidTest() {
        Reservation reservation = new Reservation();
        assertThat(reservation.uuid().length(), is(5));

    }

    @Test
    void checkWorkingDaysExpiredTest(){
        Reservation reservation = new Reservation();

        // assertJ
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> { reservation.checkWorkingDays(LocalDate.of(2018,1,1)); })
                .withMessageContaining("dzień już minął");
    }

    @Test
    void checkWorkingDaysNotAWorkingDayTest(){
        Reservation reservation = new Reservation();

        // assertJ
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> { reservation.checkWorkingDays(LocalDate.of(2018,4,20)); })
                .withMessageContaining("W tym dniu hotel jest nieczynny");
    }
}