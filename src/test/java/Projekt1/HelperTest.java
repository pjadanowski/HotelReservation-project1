package Projekt1;

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

    }

    @Test
    void updateFileExceptionTest() {
        // assertJ
        assertThatExceptionOfType(IOException.class)
                .isThrownBy(() -> { Helper.updateFile("niematakiegopliku", new JsonObject()); })
                .withMessageContaining("plik nie istnieje");
    }
}
