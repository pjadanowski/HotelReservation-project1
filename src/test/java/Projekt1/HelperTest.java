package Projekt1;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.assertj.core.api.Assertions.*;

public class HelperTest {

    @Test
    void readFileTest() throws IOException {

        String FILE = "src/main/resources/reservations.json";
        String fileContent = Helper.readFile(FILE);

        // assertJ
        assertThat(fileContent).contains("{");

    }

    @Test
    void readFileIOExceptionTest()  {

        // assertJ
        assertThatExceptionOfType(IOException.class)
                .isThrownBy(() -> { Helper.readFile("niematakiegopliku"); });
    }


    @Test
    void updateFileTest() {
        String file = "src/main/resources/updateTestFile.json";
        JsonObject object = new JsonObject();
        object.addProperty("Test", true);
        try {
            Helper.updateFile(file, object);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            JsonObject afterAdding = new Gson().fromJson(Helper.readFile(file), JsonObject.class);
            assertThat(afterAdding.toString()).isEqualTo(object.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    @Test
    void updateFileExceptionTest() {
        // assertJ
        assertThatExceptionOfType(IOException.class)
                .isThrownBy(() -> { Helper.updateFile("niematakiegopliku", new JsonObject()); })
                .withMessageContaining("plik nie istnieje");
    }
}
