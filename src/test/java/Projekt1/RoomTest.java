package Projekt1;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.text.SimpleDateFormat;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;

public class RoomTest {

    @Test
    void setAvaliableTest() {
       Room r110 = new Room(110, false);

        try {
            r110.setAvaliable(true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            assertFalse(r110.isAvaliable());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getRoomNumberTest(){
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
    void updateFileTest() throws IOException {
        Room r110 = new Room(110, false);

        String FILE = "src/main/resources/rooms.json";
        JsonObject fromFileObject = new Gson().fromJson(Helper.readFile(FILE), JsonObject.class);
        r110.setAvaliable(true);
        Helper.updateFile(FILE, fromFileObject);

        // open file
        JsonObject fromFileAfter = new Gson().fromJson(Helper.readFile(FILE), JsonObject.class);

        for (JsonElement room:fromFileAfter.get("rooms").getAsJsonArray() ) {
//            if (room.getAsJsonObject().get("room"))
        }
        // check if updated contains room updated
//        assertThat(fromFileAfter.getAsString(), contains(""));
    }

}
