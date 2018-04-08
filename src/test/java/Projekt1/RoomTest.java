package Projekt1;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {

    @Test
    void setAvaliableTest() throws IOException {
        Room r110 = new Room(110, false);
        r110.setAvaliable(true);
        assertTrue(r110.isAvaliable());
    }

    @Test
    void getRoomNumberTest() {
        Room r110 = new Room(110, false);
        assertThat(r110.getRoomNumber(), is(110));
    }

    @Test
    void jsonObjectFromFileTest() throws IOException {
        String FILE = "src/main/resources/rooms.json";
        JsonObject fromFileObject = new Gson().fromJson(Helper.readFile(FILE), JsonObject.class);

        assertTrue(fromFileObject.isJsonObject());
    }

    @Test
    void jsonArrayFromFileTest() throws IOException {
        String FILE = "src/main/resources/rooms.json";
        JsonObject fromFileObject = new Gson().fromJson(Helper.readFile(FILE), JsonObject.class);
        JsonArray mainObject = fromFileObject.getAsJsonArray("rooms");
        assertTrue(mainObject.isJsonArray());
    }

    @Test
    void readFileNoSuchFileException() {
        assertThrows(NoSuchFileException.class,
                () -> Helper.readFile("nie_ma_takiego_pliku.json"));
    }


    @Test
    void checkIfRoomExistsInJsonTest() {

        Room r100 = new Room(100, true);
        assertThrows(IllegalArgumentException.class,
                () -> r100.checkIfRoomExistsInJson());
    }
}
