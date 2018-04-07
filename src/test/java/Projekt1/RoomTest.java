package Projekt1;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;

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

        assertFalse(r110.isAvaliable());

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
    void updateFileTest() throws IOException, IllegalArgumentException {
        String FILE = "src/main/resources/rooms.json";

        JsonObject fromFileBefore = new Gson().fromJson(Helper.readFile(FILE), JsonObject.class);

        try {
            Room r110 = new Room(110, false);
            r110.setAvaliable(true);

            // open file after
            JsonObject fromFileAfter = new Gson().fromJson(Helper.readFile(FILE), JsonObject.class);

            boolean ava = fromFileAfter.equals(fromFileBefore);

            // check if updated contains room updated
            assertThat(ava, is(false));
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }

    }

}
