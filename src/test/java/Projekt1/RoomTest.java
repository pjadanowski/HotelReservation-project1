package Projekt1;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;

public class RoomTest {

    @Test
    void setAvaliableTest() {
       Room r110 = new Room(110, false);

       r110.setAvaliable(true);

       assertFalse(r110.isAvaliable());
    }

    @Test
    void getRoomNumberTest(){
        Room r110 = new Room(110, false);
        assertThat(r110.getRoomNumber(), is(110));
    }

    @Test
    void jsonObjectFromFileTest(){
        Room r110 = new Room(110, false);
        String FILE = "src/main/resources/rooms.json";
        JsonObject fromFileObject = new Gson().fromJson(r110.readFile(FILE), JsonObject.class);

        assertTrue(fromFileObject.isJsonObject());
    }

    @Test
    void jsonArrayFromFileTest(){
        Room r110 = new Room(110, false);
        String FILE = "src/main/resources/rooms.json";
        JsonObject fromFileObject = new Gson().fromJson(r110.readFile(FILE), JsonObject.class);
        JsonArray mainObject = fromFileObject.getAsJsonArray("rooms");
        assertTrue(mainObject.isJsonArray());
    }

    @Test
    void readFileNoSuchFileException() {
        Room r110 = new Room(110, false);
        assertThrows(NoSuchFileException.class,
                () -> r110.readFile("nie_ma_takiego_pliku.json"));
    }

}
