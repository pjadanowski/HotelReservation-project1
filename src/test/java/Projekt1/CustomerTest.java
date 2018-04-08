package Projekt1;


import org.assertj.core.api.filter.NotFilter;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.empty;


import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.*;

public class CustomerTest {

    @Test
    void firstnameTest() {
        Customer c1 = new Customer("Kazik", "Jakistam", "kjakistam@ss.ss");
        assertEquals("Kazik", c1.getFirstname());
    }
    @Test
    void lastnameTest() {
        Customer c1 = new Customer("Kazik", "Jakistam", "kjakistam@ss.ss");
        assertEquals("Jakistam", c1.getLastname());
    }


    @Test
    void reservedRoomsTest() {
        Customer c1 = new Customer("Kazik", "Jakistam", "kjakistam@ss.ss");
        assertThat(c1.reservedRooms(), hasSize(3));
    }



}
